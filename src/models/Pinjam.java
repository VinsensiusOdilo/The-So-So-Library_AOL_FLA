package models;

import java.time.LocalDate;

import state.NotAvailableState;
import state.PinjamState;

public class Pinjam {
	
	private String pinjamId;
	private String memberId;
	private String bookId;
	private LocalDate borrowDate;
	private LocalDate returnedDate;
	private PinjamState status;

	public Pinjam(String pinjamId, String memberId, String bookId, LocalDate borrowDate, LocalDate returnedDate) {		
		this.pinjamId = pinjamId;
		this.memberId = memberId;
		this.bookId = bookId;
		this.borrowDate = borrowDate;
		this.returnedDate = returnedDate;
		this.status = new NotAvailableState();
	}
	
	public String getPinjamId() {
		return pinjamId;
	}
	
	public void setPinjamId(String pinjamId) {
		this.pinjamId = pinjamId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public PinjamState getStatus() {
		return status;
	}

	public void setStatus(PinjamState status) {
		this.status = status;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}
	
	public void nextState() {
		this.status.nextState(this);
	}
	
}
