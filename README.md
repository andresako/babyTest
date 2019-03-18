
## About
This app is a simple project.
The app have two screens, as follows:

1. Screen contain a list of posts. Tapping on a cell in the list, should take you to the second screen. 

2. Screen is the detail screen for the selected post. Details to be shown about each post are:
* Post title
* Post body
* User name
* Number of comments


## Structure 

Below is a description of the different packages and classes in the app code:

### `api` package
Contains all `API` classes related to network app data.
* `ApiService` - `GET` and `POST` calls

#### `api.dto` package
Contain all `Dto` classes responsible to fetch data from the network.
* `CommentsDto` Api response for the Comment object
* `PostsDto` Api response for the Post object
* `UsersDto` Api response for the Users object

### `di` package
Contain all classes related with Dependency Injection (Koin)
* `AppComponent`      List of `Module` for DI
* `RepositoryModule`  List of `Repository` -- Connector between `Dto` and `Dao` classes
* `ServiceModule` List of `Service` -- Retrofit instance and `Dto` classes
* `StorageModule` List of `Storage` location -- Room instance and `Dao` classes
* `ViewModelModule` List of `ViewModel`
* `RepositoryModule`

### `repository` package
Contain all `Repository` classes responsible to get the data from `Service`
Convert `Dao` or `Dto` into `Entity` classes
* `CommentsRepository` - Related to `Comment` endpoint 
* `PostsRepository` - Related to `Post` endpoint 
* `UsersRepository` - Related to `User` endpoint 

### `room` package
* `AppDatabase` - Class for the database (Room)

#### `room.dao` package
Contain all `Dao` classes responsible to fetch data from the database.
* `CommentsDao` - Database `Query` for `Comment` object
* `PostsDao` - Database `Query` for `Post` object
* `UsersDao` - Database `Query` for `User` object

#### `room.entities` package
Contain all `Entity` classes
* `CommentsEntity` - Database object for `Comment`
* `PostsEntity` - Database object for `Posts`
* `UsersEntity` - Database object for `User`

### `ui` package
Contain all classes related to the Views
#### `ui.activities` package
* `MainActivity` - First screen of the project
* `SecondActivity` - Second screen of the project
#### `ui.viewmodels` package
Contain all `ViewModel` classes 
* `MainActivityViewModel`
* `SecondActivityViewModel`
