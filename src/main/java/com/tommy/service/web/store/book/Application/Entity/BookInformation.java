package com.tommy.service.web.store.book.Application.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookInformation{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "book_name", updatable = true)
	private String book_name;
	
	@Column(name = "author", updatable = true)
    private String author;
	
	@Column(name = "publish_date", updatable = true)
    private String publish_date;
	
	@Column(name = "isbn", updatable = true)
    private String isbn;
	
	@Column(name = "price", updatable = true)
    private String price;

    public BookInformation(){}

    public void setBook_name(String book_name){ this.book_name = book_name; }
    public String getBook_name(){ return this.book_name; }

    public void setAuthor(String author){ this.author = author; }
    public String getAuthor(){ return this.author; }

    public void setPublish_date(String publish_date){ this.publish_date = publish_date; }
    public String getPublish_date(){ return this.publish_date; }

    public void setISBN(String isbn){ this.isbn = isbn; }
    public String getISBN(){ return this.isbn; }

    public void setPrice(String price){ this.price = price; }
    public String getPrice(){ return this.price; }
    
}