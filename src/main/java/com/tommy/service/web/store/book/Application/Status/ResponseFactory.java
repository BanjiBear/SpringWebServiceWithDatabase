package com.tommy.service.web.store.book.Application.Status;

import java.util.List;
import com.tommy.service.web.store.book.Application.Entity.BookInformation;

public class ResponseFactory {
	
	private Status status;
	private int status_code;
	//private String status_message;
	private List<BookInformation> book;
	
	public ResponseFactory(){}
	
	public void setStatus(Status status){ this.status = status; }
	public Status getStatus(){ return this.status; }
	
	public void setStatus_code(){ this.status_code = this.getStatus().getStatus_code(); }
	public int getStatus_code(){ return this.status_code; }
	
	//public void setStatus_message(){ this.status_message = this.getStatus().getStatus_message(); }
	//public String getStatus_message(){ return this.status_message; }
	
	public void setBook(List<BookInformation> book){ this.book = book; }
	public List<BookInformation> getBook(){ return this.book; }
	
}