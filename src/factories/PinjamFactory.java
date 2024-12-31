package factories;

import java.time.LocalDate;
import java.util.Random;

import models.Pinjam;

public class PinjamFactory {
	
	private String pinjamId;
	private String CHAR_POOL = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Random rand = new Random();
	private int idx = 0;
	
	private String generateId() {
		String id = "P-";
		
		for(int i = 0; i < 5; i++) {
			idx = rand.nextInt(CHAR_POOL.length());
			id += CHAR_POOL.charAt(idx);
		}
		
		return id;
	}
	
	public Pinjam createPinjam(String memberId, String bookId, LocalDate borrowDate, LocalDate returnedDate) {
		pinjamId = generateId();
		return new Pinjam(pinjamId, memberId, bookId, borrowDate, returnedDate);
	}

}
