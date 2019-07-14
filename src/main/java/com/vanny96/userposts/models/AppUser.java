package com.vanny96.userposts.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "app_user")
public class AppUser{
  @Id
  @GeneratedValue(generator = "user_generator")
  @SequenceGenerator(name = "user_generator", sequenceName = "user_sequence")
  private Integer id;

  @Version
  @JsonIgnore
  private Integer version;

  @Column(name = "name")
  private String name;

  @Column(name = "email", unique = true)
  private String email;

  @OneToMany(mappedBy = "poster", orphanRemoval = true)
  @JsonIgnore
  private List<Post> posts;


  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }


  public List<Post> getPosts() {
    return this.posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  public void addPost(Post post){
    post.setPoster(this);
    this.posts.add(post);
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	AppUser other = (AppUser) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

@Override
public String toString() {
	return "AppUser [id=" + id + ", version=" + version + ", name=" + name + ", email=" + email + ", posts=" + posts
			+ "]";
}
  

}