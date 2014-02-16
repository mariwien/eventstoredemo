package no.kino.event;


public class ForestillingOpprettet implements Event {


    private final String navn;
    private final Integer antallPlasser;

    public ForestillingOpprettet(String navn, Integer antallPlasser) {
        this.navn = navn;
        this.antallPlasser = antallPlasser;
    }

    public Integer getAntallPlasser() {
        return antallPlasser;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String getFilm() {
        return navn;
    }

    @Override
    public Integer getAntallSeter() {
        return antallPlasser;
    }
}
