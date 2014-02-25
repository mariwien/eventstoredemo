package no.kino.projections;

import no.kino.event.Event;

import java.util.ArrayList;
import java.util.HashMap;

public class ForestillingProjeksjon implements Projection {

    private final ArrayList<Event> events;
    private final HashMap<String,Film> filmer;

    public ForestillingProjeksjon() {
        events = new ArrayList<>();
        filmer = new HashMap<>();
    }

    public HashMap<String,Film> listAlleForestillinger() {
        return filmer;
    }

    public Integer antallLedigeSeter(String film){
        return filmer.get(film).getLedigeSeter();
    }

    @Override
    public void eventAdded(Event event) {
        events.add(event);

        if(filmer.get(event.getFilm())==null){
            filmer.put(event.getFilm(), new Film(event.getFilm(), event.getAntallSeter()));
        }else{
            Integer antallSeter = filmer.get(event.getFilm()).getLedigeSeter();
            filmer.put(event.getFilm(), new Film(event.getFilm(), antallSeter - event.getAntallSeter()));
        }
    }
}
