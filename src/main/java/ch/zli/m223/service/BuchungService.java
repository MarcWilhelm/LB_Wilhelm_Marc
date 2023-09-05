package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Buchung;

@ApplicationScoped
public class BuchungService {
    @Inject
    private EntityManager entityManager;

    public List<Buchung> findAll() {
        var query = entityManager.createQuery("FROM Buchung", Buchung.class);
        return query.getResultList();
    }

    public String findID(Long id) {
        Buchung buchungById = entityManager.find(Buchung.class, id);
        return buchungById.getStatus();
    }

    @Transactional
    public Buchung createBuchung(Buchung buchung) {
        entityManager.persist(buchung);
        return buchung;
    }

    @Transactional
    public void deleteBuchung(Long Id, Buchung buchung) {
        Buchung buchungById = entityManager.find(Buchung.class, Id);
        entityManager.remove(buchungById);
    }

    @Transactional
    public void updateBuchung(Long Id, Buchung buchung) {
        entityManager.merge(buchung);
    }
}