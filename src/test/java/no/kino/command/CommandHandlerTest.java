package no.kino.command;

import no.kino.command.KinoCommandHandler;
import no.kino.command.OpprettNyForestilling;
import org.junit.Assert;
import org.junit.Test;


public class CommandHandlerTest {

    private static final String FORESTILLING = "Matrix";

    @Test
    public void OppretteNyForestillingSkalFungere() {
        OpprettNyForestilling opprettNyForestilling = new OpprettNyForestilling(FORESTILLING,10);
        KinoCommandHandler kinoCommandHandler = new KinoCommandHandler();
        Assert.assertTrue(kinoCommandHandler.handle(opprettNyForestilling));
    }


    @Test
    public void OppretteToLikeForestillingerSkalIkkeFungere() {
        OpprettNyForestilling opprettNyForestilling = new OpprettNyForestilling(FORESTILLING,10);
        OpprettNyForestilling opprettNyForestilling2 = new OpprettNyForestilling(FORESTILLING,10);
        KinoCommandHandler kinoCommandHandler = new KinoCommandHandler();
        kinoCommandHandler.handle(opprettNyForestilling);
        Assert.assertFalse(kinoCommandHandler.handle(opprettNyForestilling2));
    }

}
