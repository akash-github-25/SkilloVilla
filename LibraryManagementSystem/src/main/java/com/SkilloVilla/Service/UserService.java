package com.SkilloVilla.Service;

import java.time.LocalDate;

import com.SkilloVilla.Exception.BookException;
import com.SkilloVilla.Exception.UserException;
import com.SkilloVilla.bean.Book;
import com.SkilloVilla.bean.User;

public interface UserService {
	
	public LocalDate borrowBook(Book book,User user)throws BookException,UserException;
	public Book returnBook(User user,Book book)throws BookException,UserException;
	public User addUser(User user);

}
