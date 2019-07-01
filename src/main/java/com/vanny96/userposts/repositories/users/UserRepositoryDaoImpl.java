package com.vanny96.userposts.repositories.users;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.vanny96.userposts.models.AppUser;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("persistent")
public class UserRepositoryDaoImpl implements UserRepository {
  private EntityManagerFactory emf;

  @PersistenceUnit
  public void setEmf(EntityManagerFactory emf) {
    this.emf = emf;
  }
  

  @Override
  public List<AppUser> usersList() {
    EntityManager em = emf.createEntityManager();

    List<AppUser> users = em.createQuery("from AppUser", AppUser.class).getResultList();

    em.close();

    return users;
  }

  @Override
  public AppUser getUser(Integer id) {
    EntityManager em = emf.createEntityManager();

    AppUser user = em.find(AppUser.class, id);

    em.close();

    return user;
  }

  @Override
  public AppUser saveOrUpdateUser(AppUser user) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    AppUser savedUser = em.merge(user);
    em.getTransaction().commit();

    em.close();

    return savedUser;
  }

  @Override
  public AppUser removeUser(Integer id) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    AppUser removedUser = em.find(AppUser.class, id);
    em.remove(removedUser);

    em.getTransaction().commit();
    em.close();
    
    return removedUser;
  }


}