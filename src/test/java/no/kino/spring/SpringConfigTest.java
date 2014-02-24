package no.kino.spring;

import no.kino.projections.ForestillingProjeksjon;
import no.kino.web.Filmprogram;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

/**
 * Created by mariwien on 24/02/14.
 */
public class SpringConfigTest {

    @Test
    public void sjekkAtSpringConfigFungerer () {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(SpringConfig.class);
        ctx.refresh();

        Filmprogram filmprogram = ctx.getBean(Filmprogram.class);

        //System.out.println(filmprogram.foo());

    }

}
