package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Buchung;
import ch.zli.m223.model.Newsletter;
import ch.zli.m223.service.NewsletterService;

@Path("/newsLetter")
@Tag(name = "Bookings", description = "Handling of Bookings")
public class NewsletterController {

    @Inject
    NewsletterService newsLetterService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets the Newsletter.", description = "Returns a list of all Newsletter")
    public List<Newsletter> index() {
        return newsLetterService.findAll();
    }

}
