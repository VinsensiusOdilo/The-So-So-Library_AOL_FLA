package state;

import java.time.LocalDate;
import java.util.Random;

import models.Pinjam;

public class NotAvailableState extends PinjamState{

	private Random rand = new Random();
	
	public NotAvailableState() {
		setState("Borrowed");
	}
	
	@Override
	public void nextState(Pinjam pinjam) {	
		// variable int temp, 
		// kalo temp dirandom dpt 0 maka ceritanya member berhasil balikin buku tepat waktu
		// kalo temp dirandom dpt 1 maka ceritanya member telat balikin buku
		
		int temp = rand.nextInt(2);
		int minusDate = rand.nextInt(6);
		int plusDate = rand.nextInt(6);
		LocalDate today;
		
		// random today (seberapa jauh sama returned date baik kebelakang atau kedepan)
		// kalo hasil random temp ternyata telat maka today adalah returned date yang ditambah
		// kalo hasil random temp ternyata TIDAK telat maka today adalah returned date yang dikurang
		// ditambah atau dikurang paling jauh sebanyak 5 hari
		
		// tujuan variable today ditambah atau dikurang adalah agar logika next state nya bisa menggunakan perbandingan waktu
		if(temp == 0) {
			today = pinjam.getReturnedDate().minusDays(minusDate);
		}
		else {
			today = pinjam.getReturnedDate().plusDays(plusDate);
		}
		
		// Logika next state berdasarkan waktu hari ini dan waktu returned date
		if(today.isAfter(pinjam.getReturnedDate())) {
			pinjam.setStatus(new LateState());
		}
		else {
			pinjam.setStatus(new ReturnedState());
		}
		
	}
	
	

}
