package state;

import models.Pinjam;

public class ReturnedState extends PinjamState{

	public ReturnedState() {
		setState("Returned");
	}
	
	@Override
	public void nextState(Pinjam pinjam) {
		pinjam.setStatus(new ReturnedState());
	}

}
