
This is a Library Management Application where a user will be able to borrow  books 
and can also return it.If a user is using a certain book then it will be available to the 
other user only after the first user returns it.

* You can add the user and books through application or you can also insert these by using
  query in the database. 

* In order to test my Api's I have used Swagger.

ASSUMPTIONS->
 Fine_Per_Day = RS 2.
 User should return the book within five days.


FLOW-> i> ADD  USERS IN THE DATABASE.
       ii> ADD BOOKS IN THE DATABASE.
       iii> BORROW BOOKS FOR A USER.USER CAN HAVE ATMOST  FIVE BOOKS.
       iv> RETURN BOOK WITHIN FIVE DAYS OTHERWISE GIVE FINE OF RS 2 PER DAY.
       
DATABASE DETAILS->
 I am using MySql database.
 I have used port 8320 , and the name of my database is "Library" with three tables namely -
 book , user , user_borrowed_books .


API_USED -

 1> ADD_USER -

 http://localhost:8320/addUser
 request body ->
 {
  "userId": 8,
  "savingAmount": 100,
  "name": "A"
 }

 2> ADD_BOOK

 http://localhost:8320/addBook
 request body ->
 {
  "author": "string 5",
  "bookId": 0,
  "borrowingAmount": 50,
  "issued": false,
  "title": "string 5"
 }

 3> BORROW_BOOK

  http://localhost:8320/borrowBook/{bookId}/{userId}
* User won't be able to add more than five books.

 4> RETURN_BOOK

  http://localhost:8320/returnBook/{bookId}/{userId}
* User should return within a span of five days otherwise there is a fine of Rs 2 per day.




TESTING-

 addUserTest()-
 This method will test weather the addUser() method is returning the same user.

 addBookTest()-
 This method will test weather the addBook() method is returning the same book.

 borrowBookTest()-
 This method will test if a user is adding more than 5 books it should give an Exception.

 returnBookTest()-
 This method will test if a user  tries to return some other book then method should give 
 some Exception.





