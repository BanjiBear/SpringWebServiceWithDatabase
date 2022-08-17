package com.tommy.service.web.store.book.Application.Service;

import com.tommy.service.web.store.book.Application.Entity.BookInformation;
import com.tommy.service.web.store.book.Application.Status.ResponseFactory;

public interface BookInformationService{
	
	public ResponseFactory getAllBook();
		
	public ResponseFactory findByISBN(String isbn);
	
	public ResponseFactory saveBookInformation(BookInformation book);
	
	public ResponseFactory updateBookInformation(String isbn, BookInformation book);
		
	public ResponseFactory deleteByISBN(String isbn);
	
}