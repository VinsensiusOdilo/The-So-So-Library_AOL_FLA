package models;

import state.AvailableState;
import state.BookState;

public class Book {
	
	private String bookId;
	private String bookTitle;
	private String bookAuthor;
	private BookState status;
	
	public Book(String bookId, String bookTitle, String bookAuthor) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.status = new AvailableState();
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public void setStatus(BookState status) {
		this.status = status;
	}
	
	public BookState getStatus() {
		return status;
	}
	
	public void nextState() {
		this.status.nextState(this);
	}
}
