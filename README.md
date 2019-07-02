# basic-RESTfulapp

With this project I'm trying to make a very simple RESTfull web app in order to practice what I've learnt about spring until now. Every time I'll need to practice something I think I'll come here.

## Functionalities

The app is available at: https://peaceful-shelf-92856.herokuapp.com

There you will be able to add, delete and retrieve users and posts by using restful calls (using Postman for example)

## API Documentation

Path variables are distinguished by curly braces (e.g. `.../{id}`)

### Users

* `GET .../users` returns a list of all the users
* `GET .../user/{id}` returns a the user associated to the id
* `DELETE .../user/{id}` deletes the user associated to the id and returns it back
* `POST .../users` adds the user model described in the body (see below) to the database

#### User model

To add an user model to the database you will have to add a JSON body to the POST request formatted as follow.

JSON:
```JSON
{
  name: "Insert name",
  email: "Insert email"
}
```
### Posts

* `GET .../posts` returns a list of all the posts
* `GET .../post/{id}` returns a the user associated to the id
* `DELETE .../post/{id}` deletes the user associated to the id and returns it back
* `POST .../posts` adds the user model described in the body (see below) to the database

* `GET .../user/{id}/posts` returns all of the user's posts

#### Post model

To add an user model to the database you will have to add a JSON body to the POST request formatted as follow and since it is required for a post to be postd by an user, you will have to specify in a header the user id.

JSON:
```JSON
{
  title: "Insert title",
  body: "Insert body"
}
```

HEADER:
```HEADER
  userId = Insert Id
```



