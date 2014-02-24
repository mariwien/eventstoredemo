package no.kino.projections;


import no.kino.command.KinoCommandHandler;
import no.kino.command.OpprettNyForestilling;
import no.kino.event.EventStore;
import no.kino.event.ForestillingOpprettet;
import no.kino.event.SeterReservert;
import no.kino.spring.SpringTestContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ForestillingProjeksjonTest extends SpringTestContext {

    private final String FORESTILLING = "Død snø";
    private ForestillingProjeksjon forestilling = null;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        forestilling = ctx.getBean(ForestillingProjeksjon.class);
    }

    @Test
    public void testAtAntallSeterErRiktigEtterOpprettetForestilling(){

        forestilling.eventAdded(new ForestillingOpprettet(FORESTILLING, 30));
        Integer antallLedigeSeter = forestilling.antallLedigeSeter(FORESTILLING);
        Assert.assertEquals(30, antallLedigeSeter.intValue());
    }

    @Test
    public void testAtAntallSeterErRiktigEtterBestillingAvSeter(){
        forestilling.eventAdded(new ForestillingOpprettet(FORESTILLING, 30));
        forestilling.eventAdded(new SeterReservert(FORESTILLING, 10));

        Integer antallLedigeSeter = forestilling.antallLedigeSeter(FORESTILLING);
        Assert.assertEquals(30-10, antallLedigeSeter.intValue());
    }


}
