# Spotify's Creepy Little Sister

## Introduction

## General Approach

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

| Day 1 | Day 2 | Day 3 | Day 4 | Day 5 | | -- | -- | -- | -- | -- | | Set up Spring Boot and start creating models |
Finish models and start CRUD operations | Finish CRUD operations and do exception handling | Bonus material | General
clean up and presentation |

## Technology Used

## Installation Instructions
1. Fork and clone the repository.
2. Using postgres, create a database called `spotifycreepylittlesister`
3. Open the file `SpotifyCreepyLittleSister/src/main/resources/application-dev.properties` and change lines 4 and 5 to be
   your postgres username and password
4. Go into the  `SpotifyCreepyLittleSister` directory and run the application from your command line using `mvn spring-boot:run`
5. Open the url `localhost:9092/helloworld`.  If the screen says Hello World, you're good to go. 
