    package no.kino.web;


    import no.kino.command.KinoCommandHandler;
    import no.kino.command.OpprettNyForestilling;
    import no.kino.projections.Forestilling;
    import no.kino.projections.ForestillingProjeksjon;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import javax.ws.rs.*;
    import javax.ws.rs.core.MediaType;
    import java.util.ArrayList;
    import java.util.Collection;
    import java.util.Map;

@Service
@Path("filmprogram")
public class Filmprogram {

    @Autowired
    public ForestillingProjeksjon forestillinger;

    @Autowired
    public KinoCommandHandler kinoCommandHandler;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Forestilling> filmprogram(){
        ArrayList<Forestilling> filmer = new ArrayList<>();
        for (Map.Entry<String, Forestilling> stringFilmEntry : forestillinger.listAlleForestillinger().entrySet()) {
            filmer.add(stringFilmEntry.getValue());
        }
        return filmer;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void opprettFilm(Forestilling forestilling){
        if(forestilling !=null){
            kinoCommandHandler.handle(new OpprettNyForestilling(forestilling.getNavn(), forestilling.getLedigeSeter()));
        }
    }
}
