package no.kino;


import no.kino.event.Kino;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("kino")
public class KinoService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Kino foo(){
        return new Kino("Matrix");
    }
}
