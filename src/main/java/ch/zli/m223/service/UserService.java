package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.ApplicationUser;

@ApplicationScoped
public class UserService {
    @Inject
    private EntityManager entityManager;

    public List<ApplicationUser> findAll() {
        var query = entityManager.createQuery("FROM ApplicationUser", ApplicationUser.class);
        return query.getResultList();
    }

    @Transactional
    public ApplicationUser createUser(ApplicationUser applicationUser) {
        entityManager.persist(applicationUser);
        return applicationUser;
    }

    @Transactional
    public void deleteApplication(Long Id, ApplicationUser applicationUser) {
        ApplicationUser userById = entityManager.find(ApplicationUser.class, Id);
        entityManager.remove(userById);
    }

    @Transactional
    public void updateApplication(Long Id, ApplicationUser applicationUser) {
        entityManager.merge(applicationUser);
    }
}
