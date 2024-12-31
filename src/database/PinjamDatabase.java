package database;

import java.util.ArrayList;
import java.util.Iterator;

import models.Pinjam;

public class PinjamDatabase implements Iterable<Pinjam>{
	
	private ArrayList<Pinjam> pinjamList;
	private static PinjamDatabase instance;
	
	private PinjamDatabase() {
		pinjamList = new ArrayList<>();
	}
	
	public void addPinjam(Pinjam newData) {
		pinjamList.add(newData);
	}

	public static PinjamDatabase getInstance() {
		if(instance == null) {
			instance = new PinjamDatabase();
		}
		
		return instance;
	}
	
	public ArrayList<Pinjam> getAllData(){
		return pinjamList;
	}

	@Override
	public Iterator<Pinjam> iterator() {
		return pinjamList.iterator();
	}
	
	public void removeByObj(Pinjam p) {
		if(p == null) {
			return;
		}
		
		pinjamList.remove(p);
	}

	public Pinjam getDataByIndex(int idx) {
		return pinjamList.get(idx);
	}

	public void removeByIndex(int i) {
		pinjamList.remove(i);
	}
}
