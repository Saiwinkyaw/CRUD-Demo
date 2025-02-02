package com.jdc.sai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.sai.dao.Books;
import com.jdc.sai.repo.BooksRepository;

@Service
public class BooksService {
	
	@Autowired
	BooksRepository booksRepository;
	
	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<Books>();
		booksRepository.findAll().forEach(books1 -> books.add(books1));
		return books;
	}
	
	public Books getBookById(int id) {
		return booksRepository.findById(id).get();
	}
	
	public void saveBook(Books books) {
		booksRepository.save(books);
	}
	
	public void deleteBook(int id) {
		booksRepository.deleteById(id);
	}
	
//	public void saveOrUpdate(Books books, int bookid) {
//		booksRepository.save(books);
//	}
	
	public void saveOrUpdateBook(Books books, int bookid) {
		Optional<Books> bookOptional = booksRepository.findById(bookid);
		
		if (bookOptional.isPresent()) {
			Books book = bookOptional.get();
			book.setBookname(books.getBookname());
			book.setAuthor(books.getAuthor());
			book.setPrice(books.getPrice());
			booksRepository.save(books);
		} else {
			throw new RuntimeException("Book not found with id " + bookid);
		}
		
	}

}
