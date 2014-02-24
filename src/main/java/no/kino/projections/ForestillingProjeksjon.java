package no.kino.projections;

import no.kino.event.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class ForestillingProjeksjon implements Projection {

    private final ArrayList<Event> events;
    private final HashMap<String,Integer> filmerOgAntall;

    public ForestillingProjeksjon() {
        events = new ArrayList<>();
        filmerOgAntall = new HashMap<>();
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
