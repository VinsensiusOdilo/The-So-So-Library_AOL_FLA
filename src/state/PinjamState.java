package state;

import models.Pinjam;

public abstract class PinjamState {
	
	protected String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public abstract void nextState(Pinjam pinjam);

}
