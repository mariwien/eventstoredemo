package no.kino.projections;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Forestilling {
    private String navn;
    private int ledigeSeter;

    public Forestilling() {
    }

    public Forestilling(String navn, int ledigeSeter) {
        this.navn=navn;
        this.ledigeSeter=ledigeSeter;
    }

    public String getNavn(){


        return navn;
    }

    public int getLedigeSeter() {
        return ledigeSeter;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setLedigeSeter(int ledigeSeter) {
        this.ledigeSeter = ledigeSeter;
    }
}
