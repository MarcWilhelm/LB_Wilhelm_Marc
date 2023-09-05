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

    public List<ApplicationUser> findAllSubscriber() {
        var query = entityManager.createQuery("FROM ApplicationUser WHERE newsleter = true ", ApplicationUser.class);
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

    @Transactional
    public String signIn(ApplicationUser applicationUser) {
        ApplicationUser userByUsername = entityManager.find(ApplicationUser.class, applicationUser.geteMail());
        if (userByUsername.getPasswort() == applicationUser.getPasswort()) {
            return "Loged In";
        } else {
            return "Unauthorized";
        }
    }

    @Transactional
    public void updateSubscription(Long Id, ApplicationUser applicationUser, Boolean state) {
        applicationUser.setNewsleter(state);
        entityManager.merge(applicationUser);
    }
}
