package com.jdc.sai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.sai.dao.Books;
import com.jdc.sai.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BooksService booksService;
	
	@GetMapping("/getAllBooks")
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}
	
	@GetMapping("/getBookById/{bookid}")
	private Books getBookById(@PathVariable("bookid") int bookid) {
		return booksService.getBookById(bookid);
	}
	
	@DeleteMapping("/deleteBook/{bookid}")
	private void deleteBook(@PathVariable("bookid")int bookid) {
		booksService.deleteBook(bookid);
	}
	
	@PostMapping("/saveBook")
	private int saveBook(@RequestBody Books books) {
		booksService.saveBook(books);
		return books.getBookid();
	}
	
	@PutMapping("/updateBook/{bookid}")
	private Books saveOrUpdateBook(@RequestBody Books books, @PathVariable("bookid")int bookid) {
		booksService.saveOrUpdateBook(books, bookid);
		return books;
	}
	
	
	
}
