package no.kino.event;

/**
 * Created by mariwien on 22/02/14.
 */

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Kino {
    private String kinonavn;

    public Kino(String navn) {
        this.kinonavn=navn;
    }

    public String getKinonavn(){
        return kinonavn;
    }

}
