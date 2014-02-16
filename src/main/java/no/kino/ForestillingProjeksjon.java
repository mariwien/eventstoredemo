package no.kino;

import no.kino.event.Event;
import no.kino.event.ForestillingOpprettet;

import java.util.ArrayList;
import java.util.HashMap;

public class ForestillingProjeksjon implements Projection {

    private final ArrayList<Event> events;
    private final HashMap<String,Integer> filmerOgAntall;

    public ForestillingProjeksjon() {
        events = new ArrayList<Event>();
        filmerOgAntall = new HashMap<String, Integer>();
    }

    public Integer antallLedigeSeter(String film){
        return filmerOgAntall.get(film);
    }

    @Override
    public void eventAdded(Event event) {
        events.add(event);

        if(filmerOgAntall.get(event.getFilm())==null){
            filmerOgAntall.put(event.getFilm(), event.getAntallSeter());
        }else{
            Integer antallSeter = filmerOgAntall.get(event.getFilm());
            filmerOgAntall.put(event.getFilm(), antallSeter + event.getAntallSeter());
        }
    }
}
