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

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.service.UserService;

@Path("/users")
@Tag(name = "Users", description = "Handling of Users")
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
    @Operation(summary = "Delete an User", description = "Delets an User ")
    public void delete(@RestPath Long entryId) {
        userService.deleteApplication(entryId);
    }

    @Path("/{entryId}")
    @PUT
    @Operation(summary = "Update a User", description = "Update a User")
    public ApplicationUser update(@RestPath Long entryId, ApplicationUser applicationUser) {
        if (entryId == applicationUser.getId()) {
            return userService.updateApplication(entryId, applicationUser);
        } else {
            throw new BadRequestException();
        }
    }

    @Path("/signIn")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Sign In", description = "Sign in")
    public String signIn(ApplicationUser applicationUser) {
        return userService.signIn(applicationUser);
    }

    @Path("/newsletter")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets all Users who subscribed the Newsletter.", description = "Returns a list of all Users that subscribed the Newsletter.")
    public List<ApplicationUser> findAllSubscriber() {
        return userService.findAllSubscriber();
    }

    @Path("/newsletter/subscribe/{userId}/{state}")
    @PUT
    @Operation(summary = "Subscribe/Unsubscribe an User", description = "Subscribe/Unsubscribe an User")
    public ApplicationUser subscribeNewsletter(@RestPath Long userId, @RestPath Boolean state) {

        return userService.updateSubscription(userId, state);

    }

}
