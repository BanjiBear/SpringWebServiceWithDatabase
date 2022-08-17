package com.tommy.service.web.store.book.Application.Service;

import java.util.ArrayList;
import java.util.List;

import com.tommy.service.web.store.book.Application.Entity.BookInformation;
import com.tommy.service.web.store.book.Application.Repository.BookInformationRepository;
import com.tommy.service.web.store.book.Application.Status.ResponseFactory;
import com.tommy.service.web.store.book.Application.Status.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookInformationServiceImpl implements BookInformationService{
	
	private ResponseFactory responseFactory = new ResponseFactory();
	
	@Autowired
    private BookInformationRepository bookInformationRepository;

	@Override
	@Transactional
	public ResponseFactory getAllBook() {
		List<BookInformation> resultList = (List<BookInformation>) bookInformationRepository.findAll();
		return responseFormation(Status.CORRESPONDING_RESULT_FOUND, resultList);
	}
	
	@Override
	@Transactional
	public ResponseFactory findByISBN(String isbn) {
		ArrayList<BookInformation> resultList = new ArrayList<>();
		resultList.add(bookInformationRepository.findByISBN(isbn));
		return bookInformationRepository.findByISBN(isbn) == null? responseFormation(Status.BOOK_NOT_FOUND, null) : responseFormation(Status.CORRESPONDING_RESULT_FOUND, resultList);
	}

	@Override
	@Transactional
	public ResponseFactory saveBookInformation(BookInformation book){
		ArrayList<BookInformation> resultList = new ArrayList<>();
		resultList.add(book);
		if(bookInformationRepository.findByISBN(book.getISBN()) != null){
			return responseFormation(Status.BOOK_ISBN_EXIST, resultList);
		}
		bookInformationRepository.save(book);
		return responseFormation(Status.BOOK_CREATED, resultList);
	}
	
	@Override
	@Transactional
	public ResponseFactory updateBookInformation(String isbn, BookInformation book){
		ArrayList<BookInformation> resultList = new ArrayList<>();
		resultList.add(book);
		if(bookInformationRepository.findByISBN(isbn) == null) {
			return responseFormation(Status.BOOK_NOT_FOUND, null);
		}
		bookInformationRepository.deleteByISBN(isbn);
		bookInformationRepository.save(book);
		return responseFormation(Status.BOOK_UPDATED, resultList);
	}
	
	@Override
	@Transactional
	public ResponseFactory deleteByISBN(String isbn) {
		if(bookInformationRepository.findByISBN(isbn) == null) {
			return responseFormation(Status.BOOK_NOT_FOUND, null);
		}
		bookInformationRepository.deleteByISBN(isbn);
		return responseFormation(Status.BOOK_DELETED, null);
	}
	
	private ResponseFactory responseFormation(Status status, List<BookInformation> resultList){
		this.responseFactory.setStatus(status);
		this.responseFactory.setStatus_code();
		//this.response_factory.setStatus_message();
		this.responseFactory.setBook(resultList);
		return this.responseFactory;
	}
	
}