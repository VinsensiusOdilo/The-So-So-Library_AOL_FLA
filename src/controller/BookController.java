package controller;

import java.util.ArrayList;
import java.util.Iterator;

import database.BookDatabase;
import factories.BookFactory;
import models.Book;

public class BookController {
	
//	private ArrayList<Book> bookList = new ArrayList<>();
	private BookFactory bookFactory;
	private BookDatabase bookDb;
	private Book book;
	
	public BookController() {
		bookDb = BookDatabase.getInstance();
		bookFactory = new BookFactory();
	}
	
	public void addBook(String bookTitle, String bookAuthor) {
		book = bookFactory.createBook(bookTitle, bookAuthor);
		bookDb.addBook(book);
		
		System.out.println("The book has been added");
	}
	
	public void updateBookTitle(int idx, String bookTitle) {
		
		bookDb.updateBookTitle(idx, bookTitle);
		System.out.println("Book Title has been updated");
	}
	
	public void updateBookAuthor(int idx, String author) {
		
		bookDb.updateBookAuthor(idx, author);
		System.out.println("Book Author has been updated");
	}
	
	public void removeBook(int idx) {
		
		bookDb.removeBook(idx);
		System.out.println("The book has been removed");
	}
	
	public ArrayList<Book> getAllBooks(){
		return bookDb.getAllBooks();
	}
	
	public Book getBookById(String bookId) {
		return bookDb.getBookById(bookId);
	}
	
	public boolean validateBookTitle(String title) {
		return (title.length() >= 5 && title.length() <= 100);
	}

	public boolean validateBookAuthor(String author) {
		return (author.length() > 5 && author.length() < 50);
	}
	
	public Book getBookByIndex(int idx) {
		return bookDb.getBookByIndex(idx);
	}
	
	public int getBookListSize() {
		return bookDb.getBookListSize();
	}
	
	public void nextStateAllTableBook() {
		Iterator<Book> bookIterator = bookDb.iterator();
		
		while(bookIterator.hasNext()) {
			bookIterator.next().nextState();
		}
	}
	
	public void nextStateBookByIndex(int idx) {
		book = bookDb.getBookByIndex(idx);
		book.nextState();
	}
	
	public void nextStateBookById(String bookId) {
		book = bookDb.getBookById(bookId);
		book.nextState();
	}
}
