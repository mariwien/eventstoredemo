package no.kino;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import no.kino.event.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EventStoreTest {

    private ForestillingProjeksjon forestillingProjeksjon;
    private EventStore eventStorage;

    @Before
    public void setUp() throws Exception {
        eventStorage = new EventStore();
        forestillingProjeksjon = new ForestillingProjeksjon();
        eventStorage.addListeningProjection(forestillingProjeksjon);
    }

    @Test
    public void testOpprettingAvForestillingGirAntallSeterTilgjengelig() throws Exception {
        ForestillingService forestillingService = new ForestillingService(eventStorage);
        String film = "Donnie Darko";
        forestillingService.opprettForestilling(film, 100);

        Integer antallLedigeSeter = forestillingProjeksjon.antallLedigeSeter(film);

        assertEquals(antallLedigeSeter.intValue(), 100);

    }

    @Test
    public void testOpprettingAvForestillingOgEnReservasjonGirAntallSeterTilgjengelig() throws Exception {
        ForestillingService forestillingService = new ForestillingService(eventStorage);
        String film = "Donnie Darko";
        forestillingService.opprettForestilling(film, 100);
        forestillingService.reserverSeter(film, 3);

        Integer antallLedigeSeter = forestillingProjeksjon.antallLedigeSeter(film);

        assertEquals(antallLedigeSeter.intValue(), 97);

    }

    @Test
    public void testOpprettingAvForestillingOgToReservasjonGirAntallSeterTilgjengelig() throws Exception {
        ForestillingService forestillingService = new ForestillingService(eventStorage);
        String film = "Donnie Darko";
        forestillingService.opprettForestilling(film, 100);
        forestillingService.reserverSeter(film, 3);
        forestillingService.reserverSeter(film, 2);

        Integer antallLedigeSeter = forestillingProjeksjon.antallLedigeSeter(film);

        assertEquals(antallLedigeSeter.intValue(), 95);

    }
}
