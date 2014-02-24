    package no.kino.web;


import no.kino.projections.Film;
import no.kino.projections.ForestillingProjeksjon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Path("filmprogram")
public class Filmprogram {

    @Autowired
    public ForestillingProjeksjon forestillinger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Film> filmprogram(){
        if (forestillinger == null) {
            return null;
        }


        return null;
    }
}