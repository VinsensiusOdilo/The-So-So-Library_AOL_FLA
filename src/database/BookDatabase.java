package database;

import java.util.ArrayList;
import java.util.Iterator;

import models.Book;

public class BookDatabase implements Iterable<Book>{
	
	private ArrayList<Book> bookList;
	private static BookDatabase instance;
	private Book book;
	
	private BookDatabase() {
		bookList = new ArrayList<>();
	}
	
	public void addBook(Book newBook) {
		bookList.add(newBook);
	}

	public static BookDatabase getInstance() {
		if(instance == null) {
			instance = new BookDatabase();
		}
		
		return instance;
	}
	
	public ArrayList<Book> getAllBooks(){
		return bookList;
	}
	
	public Book getBookByIndex(int idx) {
		return bookList.get(idx);
	}
	
	public Book getBookById(String bookId) {
		for(Book b: bookList) {
			if(b.getBookId().equals(bookId)) {
				return b;
			}
		}
		
		return null;
	}
	
	public void removeBook(int id) {
		bookList.remove(id);
	}
	
	public void updateBookTitle(int idx, String newTitle) {
		book = bookList.get(idx);
		book.setBookTitle(newTitle);
		
	}
	
	public void updateBookAuthor(int idx, String newAuthor) {
		book = bookList.get(idx);
		book.setBookAuthor(newAuthor);
		
	}

	public int getBookListSize() {
		return bookList.size();
	}

	@Override
	public Iterator<Book> iterator() {
		return bookList.iterator();
	}

}
