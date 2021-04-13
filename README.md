# Spotify's Creepy Little Sister

## Introduction

## General Approach
1. Planned
2. Created Springboot Project and added Maven dependencies
3. Set up dev environment
4. Created Models
5. Figured out what endpoints we wanted to implement
6. Created Controllers, Services, and Repositories
7. Made the decision that items in the models can have the same name
9. Added JWTs allowing a user to register and log in


### Endpoints
| Request Type | URL| Request Body | Action | Access |
|--|--|--|--|--|
| GET | /songs | None | get all the songs | Private |
| GET | /songs/{songId} | None | get a single song | Private |
| POST | /artists/{artistId}/genres/{genreId}/songs | song info | creates a single song with an artist in a genre | Private |
| PUT | /songs/{songId} | song info | updates a single song | Private |
| DELETE | /songs/{songId} | None | delete a single song | Private |
| GET | /artists | None | get all artists | Private |
| GET | /artists/{artistId} | None | get a single artist | Private |
| GET | /artists/{artistId}/songs | None | gets all songs by an artist | Private |
| GET | /artists/{artistId}/songs/{songId} | None | gets a single song by an artist | Private |
| POST | /artists | artist info | creates a single artist | Private |
| POST | /labels/{labelId}/artists | artist info | creates a single artist with a label | Private |
| PUT | /artists/{artistId} | artist info | updates a single artist | Private |
| DELETE | /artists/{artistId} | None | deletes a single artist | Private |
| GET | /labels | None | Get all labels | Private |
| GET | /labels/{labelId} | None | Gets a single label | Private |
| GET | /labels/{labelId}/artists | None | Gets all artists in a label | Private |
| GET | /labels/{labelId}/artists/{artistId} | None | Gets a single artist in a label | Private |
| POST | /labels | Label info | Creates a new label | Private |
| PUT | /labels/{labelId} | Label info | Updates a label | Private |
| DELETE | /label/{labelId} | None | Deletes a label | Private |
| GET | /genres | None | gets all genres | Private |
| GET | /genres/{genreId} | None | gets a single genre | Private |
| GET | /genres/{genreId}/songs | None | gets all songs in a genre | Private |
| POST | /genres | genre info | creates a single genre | Private |
| PUT | /genres/{genreId} | genre info | updates a single genre | Private |
| DELETE | /genres/{genreId} | None | deletes a single genre | Private |
| POST | /auth/users/register | user info | registers a user | Public |
| POST | /auth/users/login  | user info | logs a user in | Public |

## Planning

### ER Diagram

![](SpotifyCreepyLittleSister_Diagram2.png)

### User Stories

#### Songs Model

- As a user, I should be able to create a song.
- As a user, I should be able to read a song.
- As a user, I should be able to update a song.
- As a user, I should be able to delete a song.

#### Artists Model

- As a user, I should be able to create an artist.
- As a user, I should be able to read an artist.
- As a user, I should be able to update an artist.
- As a user, I should be able to delete an artist.

#### Genres Model

- As a user, I should be able to create a genre.
- As a user, I should be able to read a genre.
- As a user, I should be able to update a genre.
- As a user, I should be able to delete a genre.

#### Labels Model

- As a user, I should be able to create a label.
- As a user, I should be able to read a label.
- As a user, I should be able to update a label.
- As a user, I should be able to delete a label.

### MVP

Our minimum viable product is a working database with four models: `Songs`, `Artists`, `Genres` and `Labels`.
The `Songs` model will have the four CRUD endpoints created using REST conventions. When invalid requests are made, the
user will be notified by error statement.

### Timeline

| Day 1 | Day 2 | Day 3 | Day 4 | Day 5 | 
| -- | -- | -- | -- | -- | 
| Set up Spring Boot and start creating models | Finish models and start CRUD operations | Finish CRUD operations and do exception handling | Bonus material | General clean up and presentation |

## Technology Used

## Installation Instructions
1. Fork and clone the repository.
2. Using postgres, create a database called `spotifycreepylittlesister`
3. Open the file `SpotifyCreepyLittleSister/src/main/resources/application-dev.properties` and change lines 4 and 5 to be
   your postgres username and password
4. Go into the  `SpotifyCreepyLittleSister` directory and run the application from your command line using `mvn spring-boot:run`
5. Open the url `localhost:9092/helloworld`.  If the screen says Hello World, you're good to go. 
6. Register a user through postgres and then log in 
