package no.kino.projections;

import no.kino.event.Event;
import no.kino.event.ForestillingOpprettet;
import no.kino.event.SeterReservert;

import java.util.HashMap;

public class ForestillingProjeksjon implements Projection {

    private final HashMap<String, Forestilling> filmer;

    public ForestillingProjeksjon() {
        filmer = new HashMap<>();
    }

    public HashMap<String, Forestilling> listAlleForestillinger() {
        return filmer;
    }

    public Integer antallLedigeSeter(String film) {
        return filmer.get(film).getLedigeSeter();
    }

    @Override
    public void eventAdded(Event event) {

        if (event instanceof ForestillingOpprettet) {
            ForestillingOpprettet forestillingOpprettet = (ForestillingOpprettet) event;
            filmer.put(forestillingOpprettet.getFilm(), new Forestilling(forestillingOpprettet.getFilm(), forestillingOpprettet.getAntallSeter()));

        } else if (event instanceof SeterReservert) {
            SeterReservert seterReservert = (SeterReservert) event;
            Integer antallSeter = filmer.get(seterReservert.getFilm()).getLedigeSeter();
            filmer.put(seterReservert.getFilm(), new Forestilling(seterReservert.getFilm(), antallSeter - seterReservert.getAntallSeter()));
        }
    }

}
