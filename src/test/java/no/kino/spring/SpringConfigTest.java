package no.kino.spring;

import no.kino.config.SpringConfig;
import no.kino.event.EventStore;
import no.kino.web.Filmprogram;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringConfigTest {

    @Test
    public void sjekkAtSpringConfigFungerer () {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SpringConfig.class);
        ctx.refresh();

        Assert.assertNotNull(ctx.getBean(Filmprogram.class));
        Assert.assertNotNull(ctx.getBean(EventStore.class));

    }

}
