package no.kino.event;


import no.kino.event.EventStore;
import no.kino.event.ForestillingOpprettet;
import no.kino.event.SeterReservert;
import no.kino.projections.ForestillingProjeksjon;
import org.junit.Assert;
import org.junit.Test;


public class EventStoreBootstrapTest {

    @Test
    public void testAtEtEventKanLeggesTilFoerProjeksjonerLeggesTil() {
        EventStore eventStorage = new EventStore();
        eventStorage.addEvent(new ForestillingOpprettet("Forestilling",1));
        ForestillingProjeksjon forestillingProjeksjon = new ForestillingProjeksjon();
        eventStorage.addListeningProjection(forestillingProjeksjon);
        Integer antallLedigeSeter = forestillingProjeksjon.antallLedigeSeter("Forestilling");
        Assert.assertEquals(1, antallLedigeSeter.intValue());
    }

    @Test
    public void testAtFlereEventerKanLeggesTilFoerProjeksjonerLeggesTil() {
        EventStore eventStorage = new EventStore();
        eventStorage.addEvent(new ForestillingOpprettet("Forestilling",10));
        eventStorage.addEvent(new SeterReservert("Forestilling",1));
        ForestillingProjeksjon forestillingProjeksjon = new ForestillingProjeksjon();
        eventStorage.addListeningProjection(forestillingProjeksjon);
        Integer antallLedigeSeter = forestillingProjeksjon.antallLedigeSeter("Forestilling");
        Assert.assertEquals(9, antallLedigeSeter.intValue());
    }
}
