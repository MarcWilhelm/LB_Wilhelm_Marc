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

import ch.zli.m223.model.Entry;
import ch.zli.m223.service.EntryService;

@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
public class EntryController {

    @Inject
    EntryService entryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Entries.", description = "Returns a list of all entries.")
    public List<Entry> index() {
        return entryService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new entry.", description = "Creates a new entry and returns the newly added entry.")
    public Entry create(Entry entry) {
        return entryService.createEntry(entry);
    }

    @Path("/{entryId}")
    @DELETE
    @Operation(summary = "Delete an Entry", description = "Delets an entry")
    public void delete(@RestPath Long entryId, Entry entry) {
        entryService.deleteEntry(entryId, entry);
    }

    @Path("/{entryId}")
    @PUT
    @Operation(summary = "Update an Entry", description = "Update an entry")
    public void update(@RestPath Long entryId, Entry entry) {
        if (entryId == entry.getId()) {
            entryService.updaEntry(entryId, entry);
        } else {
            throw new BadRequestException();
        }
    }
}