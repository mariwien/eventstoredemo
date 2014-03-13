package no.kino.web;

import no.kino.event.Event;
import no.kino.event.ForestillingOpprettet;
import no.kino.event.SeterReservert;
import no.kino.projections.Projection;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

@Path("events")
public class SSEResource implements Projection {

    private SseBroadcaster broadcaster = new SseBroadcaster();


    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput attachToEventProjeksjon() {
        EventOutput eventOutput = new EventOutput();
        this.broadcaster.add(eventOutput);
        return eventOutput;
    }

    @Override
    public void eventAdded(Event event) {
        OutboundEvent.Builder eventBuilder = new OutboundEvent.Builder();
        OutboundEvent outboundEvent = null;

        if (event instanceof SeterReservert) {
            SeterReservert seterReservert = (SeterReservert) event;
            outboundEvent = eventBuilder.name("SeterReservert").data(seterReservert.getFilm()).build();
        } else if (event instanceof ForestillingOpprettet) {
            ForestillingOpprettet forestillingOpprettet = (ForestillingOpprettet) event;
            outboundEvent = eventBuilder.name("ForestillingOpprettet").data(forestillingOpprettet.getFilm()).build();
        }
        broadcaster.broadcast(outboundEvent);
    }
}
