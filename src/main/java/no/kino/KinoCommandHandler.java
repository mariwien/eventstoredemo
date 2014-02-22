package no.kino;

import no.kino.event.ForestillingOpprettet;


public class KinoCommandHandler {


    private final ForestillingAggregate forestillingAggregate = new ForestillingAggregate();
    private final EventStore eventStore = new EventStore();

    KinoCommandHandler(){
        eventStore.addListeningProjection(forestillingAggregate);
    }

    public boolean handle(OpprettNyForestilling opprettNyForestilling) {
        ForestillingOpprettet forestillingOpprettet = new ForestillingOpprettet(opprettNyForestilling.getNavnPaaForestilling(), opprettNyForestilling.getAntallPlasser());
        if(forestillingAggregate.kanForestillingOpprettes(forestillingOpprettet)) {
            eventStore.addEvent(forestillingOpprettet);
            return true;
        }
        return false;
    }
}
