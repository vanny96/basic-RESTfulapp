package com.vanny96.userposts.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User{
  @Id
  @GeneratedValue(generator = "user_generator")
  @SequenceGenerator(name = "user_generator", sequenceName = "user_sequence")
  private Integer id;

  private String name;

  @Column(unique = true)
  private String email;


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

  @Override
  public boolean equals(Object object){
    if(object.getClass().equals(User.class)){

      User compareUser = (User) object;

      if(this.email.equals(compareUser.email)){
        return true;
      }
    }

    return false;
  }

}