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

@ApplicationScoped
public class TestDataService {

    @Inject
    EntityManager entityManager;

    @Transactional

    public void generateTestData(@Observes StartupEvent event) {

        ApplicationUser user1 = createApplicationUser("Max", "Mustermann", "max@example.com", "passwort123",
                "Mitglied", false);

        ApplicationUser user2 = createApplicationUser("Anna", "Musterfrau", "anna@example.com", "passwort456",
                "Mitglied", true);

        Buchung buchung1 = createBuchungen("Vormitag", new Date(0), "Rejected", user1);

        Buchung buchung2 = createBuchungen("Nachmitag", new Date(0), "Accepted", user1);

        Buchung buchung3 = createBuchungen("GanzerTag", new Date(0), "Pending", user2);

        entityManager.persist(user1);
        entityManager.persist(user2);

        entityManager.persist(buchung1);
        entityManager.persist(buchung2);
        entityManager.persist(buchung3);

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

}
