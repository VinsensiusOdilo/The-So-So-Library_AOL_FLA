package state;

import models.Book;

public class BorrowedState extends BookState{

	public BorrowedState() {
		setState("Borrowed");
	}
	
	@Override
	public void nextState(Book book) {
		book.setStatus(new AvailableState());
	}

}
