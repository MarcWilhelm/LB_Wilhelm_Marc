package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestPath;

import ch.zli.m223.model.Buchung;
import ch.zli.m223.service.BuchungService;

@Path("/termin")
@Tag(name = "Bookings", description = "Handling of Bookings")
public class BuchungController {

    @Inject
    BuchungService buchungsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets all Buchungen.", description = "Returns a list of all Buchungen")
    public List<Buchung> index() {
        return buchungsService.findAll();
    }

    @GET
    @Path("/{id}/status")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets the Buchung of the ID.", description = "Returns Buchungen")
    public String idBuchungen(@RestPath Long id) {
        return buchungsService.findID(id);
    }

}
