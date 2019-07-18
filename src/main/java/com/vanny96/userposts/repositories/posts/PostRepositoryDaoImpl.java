package com.vanny96.userposts.repositories.posts;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.vanny96.userposts.models.Post;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile({"dev", "prod"})
public class PostRepositoryDaoImpl implements PostRepository {
  private EntityManagerFactory emf;

  @PersistenceUnit
  public void setEmf(EntityManagerFactory emf) {
    this.emf = emf;
  }

  @Override
  public List<Post> posts() {
    EntityManager em = emf.createEntityManager();
    List<Post> posts = em.createQuery("from Post", Post.class).getResultList();
    em.close();

    return posts;
  }

  @Override
  public Post getPost(Integer id) {
    EntityManager em = emf.createEntityManager();
    Post post = em.find(Post.class, id);
    em.close();
    return post;
  }

  @Override
  public Post savePost(Post post) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    Post savedPost = em.merge(post);
    
    em.getTransaction().commit();

    em.close();

    return savedPost;  
  }

  @Override
  public Post removePost(Integer id) {
  
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    Post removedPost = em.find(Post.class, id);
    em.remove(removedPost);

    em.getTransaction().commit();
    em.close();
    
    return removedPost;
  
  }

}