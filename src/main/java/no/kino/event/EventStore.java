package no.kino.event;

import no.kino.projections.Projection;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EventStore {
    private ArrayList<Event> eventStorage;
    private ArrayList<Projection> listeningProjections;

    public EventStore(){
        eventStorage = new ArrayList<>();
        listeningProjections = new ArrayList<>();
    }

    public  void addListeningProjection(Projection projection) {
        listeningProjections.add(projection);
    }

    public void addEvent(Event incomingEvent) {
        eventStorage.add(incomingEvent);
        for (Projection projection: listeningProjections) {
            projection.eventAdded(incomingEvent);
        }
    }

    public int size() {
        return eventStorage.size();
    }

}
