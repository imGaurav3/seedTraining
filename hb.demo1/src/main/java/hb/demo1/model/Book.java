package hb.demo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK1")
public class Book {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "ISBN")
	private int isbn;
	
	public Book() {
		
	}

	public Book(int id, String title, String author, int isbn) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	

}
