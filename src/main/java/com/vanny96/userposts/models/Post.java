package com.vanny96.userposts.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "post")
public class Post{
  @Id
  @GeneratedValue(generator = "post_generator")
  @SequenceGenerator(name = "post_generator", sequenceName = "post_sequence")
  private Integer id;

  @Version
  @JsonIgnore
  private Integer version;

  @Column(name = "title")
  private String title;

  @Column(name = "body", length = 500)
  private String body;

  @ManyToOne
  @JoinColumn(name = "poster_id", nullable = false)
  private AppUser poster;


  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public AppUser getPoster() {
    return this.poster;
  }

  public void setPoster(AppUser poster) {
    this.poster = poster;
  }


}