package state;

import models.Book;

public class AvailableState extends BookState{

	public AvailableState() {
		setState("Available");
	}
	
	@Override
	public void nextState(Book book) {
		book.setStatus(new BorrowedState());
	}

}
