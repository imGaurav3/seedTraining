package spring.demo3.config.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK2")
public class Book {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "ISBN")
	private int isbn;
	
	@ManyToOne
	private Author author;
	
	public Book() {
		
	}

	public Book(int id, String title, int isbn) {
		this.id = id;
		this.title = title;
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

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", author=" + author + "]";
	}
	

}
