package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.model.Newsletter;

@ApplicationScoped
public class NewsletterService {
    @Inject
    private EntityManager entityManager;

    public List<Newsletter> findAll() {
        var query = entityManager.createQuery("FROM Newsletter", Newsletter.class);
        return query.getResultList();
    }

}
