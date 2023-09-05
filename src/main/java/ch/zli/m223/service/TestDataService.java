package ch.zli.m223.service;

import java.sql.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.StartupEvent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Buchung;
import ch.zli.m223.model.Newsletter;

@ApplicationScoped
public class TestDataService {

    @Inject
    EntityManager entityManager;

    @Transactional

    public void generateTestData(@Observes StartupEvent event) {

        ApplicationUser user1 = createApplicationUser("Müller", "Saskia", "saskia@example.com", "passwort123",
                "Mitglied", false);

        ApplicationUser user2 = createApplicationUser("Wilhelm", "Felix", "felix@example.com", "passwort456",
                "Admin", true);

        Buchung buchung1 = createBuchungen("Vormitag", new Date(0), "Rejected", user1);

        Buchung buchung2 = createBuchungen("Nachmitag", new Date(0), "Accepted", user1);

        Buchung buchung3 = createBuchungen("GanzerTag", new Date(0), "Pending", user2);

        Newsletter newsletter1 = createNewsletter("Versicherungs Treff sind nur Versicherungsmittarbeiter erlaubt",
                new Date(0), "versicherungs Treff");
        Newsletter newsletter2 = createNewsletter("Neues Büro in Winterthur", new Date(0), "Neues Büro");

        entityManager.persist(user1);
        entityManager.persist(user2);

        entityManager.persist(buchung1);
        entityManager.persist(buchung2);
        entityManager.persist(buchung3);

        entityManager.persist(newsletter1);
        entityManager.persist(newsletter2);
    }

    private ApplicationUser createApplicationUser(String nachname, String vorname, String email, String passwort,
            String rolle, Boolean newsletter) {

        ApplicationUser user = new ApplicationUser();
        user.setVorname(vorname);
        user.setNachname(nachname);
        user.seteMail(email);
        user.setPasswort(passwort);
        user.setRolle(rolle);
        user.setNewsleter(newsletter);
        user.setBuchung(null);
        return user;
    }

    private Buchung createBuchungen(String ganzTaegig, Date datum, String status, ApplicationUser applicationUser) {
        Buchung buchung = new Buchung();
        buchung.setGanztägig(ganzTaegig);
        buchung.setDatum(datum);
        buchung.setStatus(status);
        buchung.setUser(applicationUser);
        return buchung;
    }

    private Newsletter createNewsletter(String text, Date datum, String titel) {
        Newsletter newsLetter = new Newsletter();
        newsLetter.setText(text);
        newsLetter.setTitle(titel);
        newsLetter.setDatum(datum);
        return newsLetter;
    }
}
