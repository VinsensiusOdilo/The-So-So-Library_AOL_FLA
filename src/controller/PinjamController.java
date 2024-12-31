package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import database.PinjamDatabase;
import factories.PinjamFactory;
import models.Member;
import models.Pinjam;
import state.LateState;
import state.ReturnedState;

public class PinjamController {
	
	private PinjamFactory pinjamFactory;
	private ArrayList<Pinjam> pinjamList = new ArrayList<>();
	private PinjamDatabase pinjamDb;
	private Pinjam pinjam;
	private Random rand = new Random();
	private String bookId, memberId;
	private LocalDate borrowDate, returnedDate;
	private BookController bookController = new BookController();
	
	public PinjamController() {
		pinjamDb = PinjamDatabase.getInstance();
		pinjamFactory = new PinjamFactory();
	}
	
	public void addPinjamData(int bookIdx, int lamaPinjam, Member activeUser) {
		
		bookId = bookController.getBookByIndex(bookIdx).getBookId();
		memberId = activeUser.getMemberId();
		
		borrowDate = LocalDate.now().plusDays(rand.nextInt(4));
		returnedDate = borrowDate.plusDays(lamaPinjam);
		
		pinjam = pinjamFactory.createPinjam(memberId, bookId, borrowDate, returnedDate);
		pinjamDb.addPinjam(pinjam);
		
	}
	
	public ArrayList<Pinjam> getAllData(){
		return pinjamDb.getAllData();
	}
	
	public void nextStateAllTablePinjam() {
	    Iterator<Pinjam> pinjamIterator = pinjamDb.iterator();

	    while (pinjamIterator.hasNext()) {
	        Pinjam currentPinjam = pinjamIterator.next();

	        // Jika status "Returned", update status buku dan hapus dari pinjamDb
	        if (currentPinjam.getStatus().getState().equals("Returned")) {
	            bookController.nextStateBookById(currentPinjam.getBookId());
	            pinjamIterator.remove();
	        } else {
	            // Jika tidak, pindahkan status ke langkah berikutnya
	            currentPinjam.nextState();
	        }
	    }
	}

	public void nextStateByIndex(int i) {
		pinjamList = pinjamDb.getAllData();
		
		pinjamList.get(i).nextState();
		
		if(pinjamList.get(i).getStatus().getState().equals("Returned")) {
			bookController.nextStateBookById(pinjamList.get(i).getBookId());
			pinjamList.remove(i);
		}
	}
	
}
