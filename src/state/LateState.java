package state;

import models.Pinjam;

public class LateState extends PinjamState{

	public LateState() {
		setState("Late");
	}
	
	@Override
	public void nextState(Pinjam pinjam) {
		pinjam.setStatus(new ReturnedState());
	}

}
