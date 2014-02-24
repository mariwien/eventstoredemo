package no.kino.projections;

/**
 * Created by mariwien on 22/02/14.
 */

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Film {
    private String navn;
    private int ledigeSeter;

    public Film(String navn, int ledigeSeter) {
        this.navn=navn;
        this.ledigeSeter=ledigeSeter;
    }

    public String getNavn(){
        return navn;
    }

    public int getLedigeSeter() {
        return ledigeSeter;
    }
}
