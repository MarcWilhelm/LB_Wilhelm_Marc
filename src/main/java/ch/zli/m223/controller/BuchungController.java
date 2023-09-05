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
    @Operation(summary = "Gets all Bookings.", description = "Returns a list of all Bookings and their Users")
    public List<Buchung> index() {
        return buchungsService.findAll();
    }

    @GET
    @Path("/{id}/status")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets the Booking State.", description = "Returns the Bookings State as a String")
    public String idBuchungen(@RestPath Long id) {
        return buchungsService.findID(id);
    }

    @Path("/newTermin")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new Booking.", description = "Creates a new Booking and returns the newly added Booking.")
    public Buchung create(Buchung buchung) {
        return buchungsService.createBuchung(buchung);
    }

    @Path("/{Id}")
    @DELETE
    @Operation(summary = "Delete a Booking", description = "Delets a Bookging")
    public void delete(@RestPath Long Id) {
        buchungsService.deleteBuchung(Id);
    }

    @Path("/{entryId}")
    @PUT
    @Operation(summary = "Update a Booking", description = "Updates a Booking")
    public void update(@RestPath Long entryId, Buchung buchung) {
        if (entryId == buchung.getId()) {
            buchungsService.updateBuchung(entryId, buchung);
        } else {
            throw new BadRequestException();
        }
    }

}
