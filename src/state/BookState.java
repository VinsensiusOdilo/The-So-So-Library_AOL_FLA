package state;

import models.Book;

public abstract class BookState {
	
	protected String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public abstract void nextState(Book book);

}
