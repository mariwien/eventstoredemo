package no.kino.spring;

import no.kino.domain.ForestillingAggregate;
import no.kino.event.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {
        "no.kino.event",
        "no.kino.projections",
        "no.kino.web",
        "no.kino.command",
        "no.kino.domain"})
public class SpringConfig {

    public @Bean ForestillingAggregate forestillingAggregate() {
        EventStore eventStore = getEventStore();
        ForestillingAggregate forestillingAggregate = new ForestillingAggregate();
        eventStore.addListeningProjection(forestillingAggregate);
        return forestillingAggregate;
    }

    public @Bean EventStore getEventStore() {
        EventStore eventStore = new EventStore();
        return eventStore;
    }
}
