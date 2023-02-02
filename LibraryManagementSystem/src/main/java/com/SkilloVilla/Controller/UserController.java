package com.SkilloVilla.Controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SkilloVilla.Exception.BookException;
import com.SkilloVilla.Exception.UserException;
import com.SkilloVilla.Repository.BookRepo;
import com.SkilloVilla.Repository.UserRepo;
import com.SkilloVilla.Service.UserService;
import com.SkilloVilla.bean.Book;
import com.SkilloVilla.bean.User;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BookRepo bookRepo;
	

	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.OK);
	}
	
   @PostMapping("/borrowBook/{bookId}/{userId}")
	public ResponseEntity<LocalDate> borrowBook(@PathVariable("bookId") Integer bookId,@PathVariable("userId") Integer userId) throws BookException, UserException {
	   Optional<Book> bookOpt = bookRepo.findById(bookId);
	   if(bookOpt.isEmpty()) 	throw new BookException("Provide proper BookId");
	   Book book = bookOpt.get();
	   User user = userRepo.findById(userId).get();
	   return new ResponseEntity<LocalDate>(userService.borrowBook(book,user), HttpStatus.OK);
   }
   
   @PostMapping("/returnBook/{bookId}/{userId}")
   public ResponseEntity<Book> returnBook(@PathVariable("bookId") Integer bookId,@PathVariable("userId") Integer userId) throws BookException, UserException {   
	   Optional<Book> bookOpt = bookRepo.findById(bookId);
	   if(bookOpt.isEmpty()) 	throw new BookException("Provide proper BookId");
	   Book book = bookOpt.get();
	   User user = userRepo.findById(userId).get();
	   return new ResponseEntity<Book>(userService.returnBook(user, book), HttpStatus.OK);	  
   }
	
}
