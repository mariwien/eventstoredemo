package no.kino.spring;

import no.kino.config.SpringConfig;
import org.junit.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class SpringTestContext {

    public final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

    @Before
    public void setUp() throws Exception {
        ctx.register(SpringConfig.class);
        ctx.refresh();
    }
}
