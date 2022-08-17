package com.tommy.service.web.store.book.Application.Controller;

// Package dependencies
import com.tommy.service.web.store.book.Application.Entity.BookInformation;
import com.tommy.service.web.store.book.Application.Service.BookInformationService;
import com.tommy.service.web.store.book.Application.Status.ResponseFactory;

// Spring dependencies
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController{
	
	@Autowired
	BookInformationService bookInformationService;
	
	/* Testing purposes */
    @GetMapping("/test/{str}")
    //@ResponseBody is included in the @RestController annotation
    public String test(@PathVariable String str) {
    	String testStr = "The service is available, testing string: " + str;
		return testStr;
    }
	
	@GetMapping("/books")
	public ResponseFactory getBooks(){
		return bookInformationService.getAllBook();
	}
	
	@GetMapping("/books/{isbn}")
	public ResponseFactory updateBook(@PathVariable(name = "isbn") String isbn){
		return bookInformationService.findByISBN(isbn);
	}
	
	@PostMapping("/books")
	public ResponseFactory newBook(@RequestBody BookInformation newBook){
		return bookInformationService.saveBookInformation(newBook);
	}
	
	@PutMapping("/books/{isbn}")
	public ResponseFactory updateBook(
			@RequestBody BookInformation book, 
			@PathVariable(name = "isbn") String isbn){
		return bookInformationService.updateBookInformation(isbn, book);
	}
	
	@DeleteMapping("books/{isbn}")
	public ResponseFactory deleteBook(@PathVariable String isbn){
		return bookInformationService.deleteByISBN(isbn);
	}
	
}