package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestPath;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Entry;
import ch.zli.m223.service.UserService;

@Path("/users")
@Tag(name = "Entries", description = "Handling of entries")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets all Users.", description = "Returns a list of all Users and all Information.")
    public List<ApplicationUser> index() {
        return userService.findAll();
    }

    @Path("/newUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new User.", description = "Creates a new User and returns the newly added User.")
    public ApplicationUser create(ApplicationUser applicationUser) {
        return userService.createUser(applicationUser);
    }

    @Path("/{entryId}")
    @DELETE
    @Operation(summary = "Delete an User", description = "Delets an User")
    public void delete(@RestPath Long entryId, ApplicationUser applicationUser) {
        userService.deleteApplication(entryId, applicationUser);
    }

}
