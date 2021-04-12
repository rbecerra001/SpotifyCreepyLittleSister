# Spotify's Creepy Little Sister

## Introduction

## General Approach
1. Planned
2. Created Springboot Project and added Maven dependencies
3. Set up dev environment
4. Created Models
5. Figured out what endpoints we wanted to implement
6. Created Controllers, Services, and Repositories

### Endpoints
| Request Type | URL| Request Body | Action |
|--|--|--|--|
| GET | /songs | None | get all the songs
|--|--|--|--|
| GET | /songs/{songId} | None | get a single song
|--|--|--|--|
| POST | /artists/{artistId}/genres/{genreId}/songs | song info | creates a single song with an artist in a genre
|--|--|--|--|
| PUT | /songs/{songId} | song info | updates a single song
|--|--|--|--|
| DELETE | /songs/{songId} | None | delete a single song
|--|--|--|--|

| GET | /artists | None | get all artists
|--|--|--|--|
| GET | /artists/{artistId} | None | get a single artist
|--|--|--|--|
| GET | /artists/{artistId}/songs | None | gets all songs by an artist
|--|--|--|--|
| GET | /artists/{artistId}/songs/{songId} | None | gets a single song by an artist**
|--|--|--|--|
| POST | /artists | artist info | creates a single artist
|--|--|--|--|
| POST | /labels/{labelId}/artists | artist info | creates a single artist with a label**
|--|--|--|--|
| PUT | /artists/{artistId} | artist info | updates a single artist
|--|--|--|--|
| DELETE | /artists/{artistId} | None | deletes a single artist
|--|--|--|--|

| GET | /labels | None | Get all labels
|--|--|--|--|
| GET | /labels/{labelId} | None | Gets a single label
|--|--|--|--|
| GET | /labels/{labelId}/artists | None | Gets all artists in a label
|--|--|--|--|
| GET | /labels/{labelId}/artists/{artistId} | None | Gets a single artist in a label**
|--|--|--|--|
| POST | /labels | Label info | Creates a new label
|--|--|--|--|
| PUT | /labels/{labelId} | Label info | Updates a label
|--|--|--|--|
| DELETE | /label/{labelId} | None | Deletes a label
|--|--|--|--|

| GET | /genres | None | gets all genres
|--|--|--|--|
| GET | /genres/{genreId} | None | gets a single genre
|--|--|--|--|
| GET | /genres/{genreId}/songs | None | gets all songs in a genre
|--|--|--|--|
| POST | /genres | genre info | creates a single genre
|--|--|--|--|
| PUT | /genres|{genreId} | genre info | updates a single genre
|--|--|--|--|
| DELETE | /genres|{genreId} | None | deletes a single genre

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
