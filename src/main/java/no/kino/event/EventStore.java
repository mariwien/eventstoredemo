package no.kino.event;

import no.kino.projections.Projection;

import java.util.ArrayList;

public class EventStore {
    private ArrayList<Event> eventStorage;
    private ArrayList<Projection> listeningProjections;

    public EventStore(){
        eventStorage = new ArrayList<>();
        listeningProjections = new ArrayList<>();
    }

    public  void addListeningProjection(Projection projection) {
        listeningProjections.add(projection);
        spillAvHistoriskeEventer(projection);
    }

    private void spillAvHistoriskeEventer(Projection projection) {
        for (Event event : eventStorage) {
            projection.eventAdded(event);
        }
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
