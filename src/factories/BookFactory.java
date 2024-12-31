package factories;

import java.util.Random;

import models.Book;

public class BookFactory {
	
	private String CHAR_POOL = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Random rand = new Random();
	private int idx = 0;
	
	private String generateBookId() {
		
		String id = "B-";
		
		for(int i = 0; i < 5; i++) {
			idx = rand.nextInt(CHAR_POOL.length());
			id += CHAR_POOL.charAt(idx);
		}
		
		return id;
	}
	
	public Book createBook(String bookTitle, String bookAuthor) {
		
		String bookId = generateBookId();
		return new Book(bookId, bookTitle, bookAuthor);
	}
}
