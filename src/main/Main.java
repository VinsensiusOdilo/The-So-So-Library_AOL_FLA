package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import controller.AuthController;
import controller.BookController;
import controller.MemberController;
import controller.PinjamController;
import models.Book;
import models.Member;
import models.Pinjam;

public class Main {
	
	private Scanner sc = new Scanner(System.in);
	private AuthController auth = new AuthController();
	private BookController bookController = new BookController();
	private MemberController memberController = new MemberController();
	private PinjamController pinjamController = new PinjamController();
	private Member activeUser;
	private ArrayList<Member> memberList = new ArrayList<>();
	private ArrayList<Book> bookList = new ArrayList<>();
	private ArrayList<Pinjam> pinjamList = new ArrayList<>();
	
	// Auth Methods
	private void authMenu() {
		System.out.println("=== The So-So Library ===");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
	}
	
	private int authUser() {
		// Utility variable
		int opsiLoginMenu;

		// Member data
		String memberName, memberRole = null, uReg, passReg;
		
		// Authorization variables
		String username, password;
		
		do {
			authMenu();
			System.out.print(">> ");
			opsiLoginMenu = sc.nextInt();
			sc.nextLine();
			
			if(opsiLoginMenu == 1) {
				
				do {
					System.out.print("Input username: ");
					username = sc.nextLine();
					System.out.print("Input password: ");
					password = sc.nextLine();
				}while(!(auth.validateUserLogin(username, password)));
				
				activeUser = auth.getActiveUser(username, password);
				
				return 1;
			}
			else if(opsiLoginMenu == 2) {
				
				do {

					System.out.print("Input Name [must be 6 to 15 charters long]: ");
					memberName = sc.nextLine();
					
					memberRole = "Member";
					
					System.out.print("Input username [must be 6 or more characters long]: ");
					uReg = sc.nextLine();
					
					System.out.print("Input password [must be 5 or more characters long]: ");
					passReg = sc.nextLine();
					

				}while(!(auth.validateRegisterData(memberName, memberRole, uReg, passReg)));
				
				System.out.println("Register Success, Proceed to login");
				System.out.println("");
				
				return 2;
			}
			else {
				return 3;
			}
			
		}while(opsiLoginMenu != 3);
		
	}
	
	// Main methods
	private void memberMenu() {
		System.out.println("=== The So-So Library ===");
		System.out.println("Role: Member");
		tableBuku();
		System.out.println("");
		System.out.println("Actions: ");
		System.out.println("1. Borrow book");
		System.out.println("2. Return book");
		System.out.println("3. Logout");
	}
	
	private void adminMenu() {
		System.out.println("=== The So-So Library ===");
		System.out.println("Role: Admin");
		System.out.println("");
		tableBuku();
		System.out.println("");
		System.out.println("");
		tableMember();
		System.out.println("");
		System.out.println("Actions: ");
		System.out.println("1. Add book");
		System.out.println("2. Update book title");
		System.out.println("3. Update book author");
		System.out.println("4. Delete book");
		System.out.println("5. Delete member");
		System.out.println("6. View Pinjam Table");
		System.out.println("7. Logout");
	}
	
	private void menu() {
		
		// format data row
//		System.out.println(String.format("%s %2s %2s %50s %10s %25s %5s %15s %5s", "|", id1, "|", bookTitle1, "|", author1, "|", status1, "|"));
		
		System.out.println("=== The So-So Library ===");
		System.out.println("Role: Guest");
		tableBuku();
		System.out.println("");
		System.out.println("Note: ");
		System.out.println("You are not a member yet, become a member if you want to borrow book");
		
	}
	
	private void tableBuku() {
		System.out.println("=========================================================================================================================================");
		System.out.println(String.format("%s %77s %57s", "|", "TABEL BUKU", "|"));
		System.out.println("");
		System.out.println("=========================================================================================================================================");
		System.out.println(String.format("%s %2s %2s %5s %7s %50s %10s %25s %5s %15s %5s", "|", "No", "|", "idx", "|", "Book Title", "|", "Author", "|", "Status", "|"));
		System.out.println("=========================================================================================================================================");
		
		bookList = bookController.getAllBooks();
		
		if(bookList.isEmpty()) {
			System.out.println(String.format("%s %77s %57s", "|", "Book data not available", "|"));
		}
		else {
			int i = 0;
			for(Book b : bookList) {
				System.out.println(String.format("%s %2s %2s %5s %5s %50s %10s %25s %5s %15s %5s", "|", i, "|", b.getBookId(), "|", b.getBookTitle(), "|", b.getBookAuthor(), "|", b.getStatus().getState(), "|"));							
				i++;
			}
			
		}
		
		System.out.println("=========================================================================================================================================");
		
	}
	
	private void tableMember() {
		System.out.println("=========================================================================================================================================");
		System.out.println(String.format("%s %77s %57s", "|", "TABEL MEMBER", "|"));
		System.out.println("");
		System.out.println("=========================================================================================================================================");
		System.out.println(String.format("%s %2s %2s %5s %7s %50s %10s %25s %5s %15s %5s", "|", "No", "|", "idx", "|", "Member Name", "|", "Username", "|", "Password", "|"));
		System.out.println("=========================================================================================================================================");
		
		memberList = memberController.getAllMembers();
		
		if(memberList.isEmpty()) {
			System.out.println(String.format("%s %77s %57s", "|", "Member data not available", "|"));
		}
		else {
			int i = 0;
			for(Member m : memberList) {
				System.out.println(String.format("%s %2s %2s %5s %5s %50s %10s %25s %5s %15s %5s", "|", i, "|", m.getMemberId(), "|", m.getMemberName(), "|", m.getUsername(), "|", m.getPassword(), "|"));							
				i++;
			}
			
		}
		
		System.out.println("=========================================================================================================================================");
		
	}
	
	private void tablePinjam() {
		System.out.println("=============================================================================================================================");
		System.out.println(String.format("%s %71s %51s", "|", "TABEL PINJAM", "|"));
		System.out.println("");
		System.out.println("=============================================================================================================================");
		System.out.println(String.format("%s %2s %2s %5s %7s %5s %7s %5s %7s %10s %10s %10s %10s %15s %5s", "|", "No", "|", "idx", "|", "Member Id", "|", "Book Id", "|", "Borrow Date", "|", "Returned Date", "|", "Status", "|"));
		System.out.println("=============================================================================================================================");
		
		pinjamList = pinjamController.getAllData();
		
//		LocalDate date1 = LocalDate.now();
//		LocalDate date2 = LocalDate.now().plusDays(2);
//		LocalDate r_date1 = date1.plusDays(14);
//		LocalDate r_date2 = date1.plusDays(14);
//		
//		Pinjam pinjam = new Pinjam("P-ABCAC", "M-A87AG", "B-JUELC", date1, r_date1);
//		Pinjam pinjam2 = new Pinjam("P-LCHEA", "M-IOP12", "B-TGB4R", date2, r_date2);
//		
//		pinjamList.add(pinjam);
//		pinjamList.add(pinjam2);
		
		if(pinjamList.isEmpty()) {
			System.out.println(String.format("%s %71s %51s", "|", "Pinjam data not available", "|"));
		}
		else {
			int i = 0;
			for(Pinjam p : pinjamList) {
				System.out.println(String.format("%s %2s %2s %5s %5s %5s %9s %5s %7s %10s %11s %10s %13s %15s %5s", "|", i, "|", p.getPinjamId(), "|", p.getMemberId(), "|", p.getBookId(), "|", p.getBorrowDate(), "|", p.getReturnedDate(), "|", p.getStatus().getState(), "|"));							
				i++;
			}
			
		}
		
		System.out.println("=============================================================================================================================");
		
	}
	
	// Admin methods
	private void fiturAdmin(int opsi) {
		
		String bookTitle, bookAuthor;
		String updateTitle, updateAuthor;
		int idxMember, idxBook, opsiMenuPinjam;
		
		switch(opsi) {
			case 1:
				do {
					
					System.out.print("Input book title [must be between 5 to 100 characters]: ");
					bookTitle = sc.nextLine();
					
				}while(!(bookController.validateBookTitle(bookTitle)));
				
				do {
									
					System.out.print("Input book author [must be between 5 to 50 characters]: ");
					bookAuthor = sc.nextLine();
					
				}while(!(bookController.validateBookAuthor(bookAuthor)));
				
				bookController.addBook(bookTitle, bookAuthor);
				
				break;
			case 2:
				
				tableBuku();
				
				System.out.println("");
				System.out.println("Update buku:");
				System.out.print("Input no buku: ");
				idxBook = sc.nextInt();
				sc.nextLine();
				System.out.print("Input title baru: ");
				updateTitle = sc.nextLine();
				
				bookController.updateBookTitle(idxBook, updateTitle);
				
				break;
			case 3:
				
				tableBuku();
				
				System.out.println("");
				System.out.println("Update buku:");
				System.out.print("Input no buku: ");
				idxBook = sc.nextInt();
				sc.nextLine();
				System.out.print("Input author baru: ");
				updateAuthor = sc.nextLine();
				
				bookController.updateBookAuthor(idxBook, updateAuthor);
				
				break;
			case 4:
				
				tableBuku();
				
				System.out.println("");
				System.out.println("Remove buku:");
				System.out.print("Input id buku: ");
				idxBook = sc.nextInt();
				sc.nextLine();
				
				bookController.removeBook(idxBook);
				
				break;
			case 5:
				
				tableMember();
				
				System.out.println("");
				System.out.println("Remove member:");
				System.out.print("Input no member: ");
				idxMember = sc.nextInt();
				sc.nextLine();
				
				memberController.removeMember(idxMember);
				
				break;
			case 6:
				
				tablePinjam();
				
				System.out.println("");
				System.out.println("Action");
				System.out.println("1. Refresh");
				System.out.println("2. Exit");
				System.out.print(">> ");
				opsiMenuPinjam = sc.nextInt();
				sc.nextLine();
				
				if(opsiMenuPinjam == 1) {
					pinjamController.nextStateAllTablePinjam();
				}
				
				break;
			case 7:
				break;

		}
		
	}
	
	private void fiturMember(int opsi) {
		
		int idxBook, lamaPinjam, returnBookIdx;
		
		switch(opsi) {
			case 1:
				
				tableBuku();
				
				do {
					do {
						System.out.print("Input no buku: ");
						idxBook = sc.nextInt();
						sc.nextLine();
					}while(!(idxBook < bookController.getBookListSize()));
					
					if(bookController.getBookByIndex(idxBook).getStatus().getState().equals("Borrowed")) {
						System.out.println("The book is borrowed by someone else at the moment");
					}
				}while(bookController.getBookByIndex(idxBook).getStatus().getState().equals("Borrowed"));
				
				do {
					System.out.print("Input berapa lama waktu pinjam [min 7 hari dan maks 14 hari]: ");
					lamaPinjam = sc.nextInt();
					sc.nextLine();
				}while(!(lamaPinjam <= 14 && lamaPinjam >= 7));
				
				pinjamController.addPinjamData(idxBook, lamaPinjam, activeUser);
				bookController.nextStateBookById(bookController.getBookByIndex(idxBook).getBookId());
				
				break;
			case 2:
				
				tablePinjam();
				
				System.out.print("Return book no: ");
				returnBookIdx = sc.nextInt();
				sc.nextLine();
				
				pinjamController.nextStateByIndex(returnBookIdx);
				
				break;
			case 3:
				break;
		}
		
	}
	
	private void app(String opsiGuest, int authResult) {
		// Auth success
		int opsiAdmin, opsiMember;
		
		while(authResult == 1 && opsiGuest.equals("Y")) {
			if(activeUser.getMemberRole().equals("Admin")) {
				do {
					adminMenu();
					System.out.print(">> ");
					opsiAdmin = sc.nextInt();
					sc.nextLine();
					
					fiturAdmin(opsiAdmin);
				}while(opsiAdmin != 7);
				
			}
			else if(activeUser.getMemberRole().equals("Member")){
				
				do {
					memberMenu();
					System.out.print(">> ");
					opsiMember = sc.nextInt();
					sc.nextLine();
					
					fiturMember(opsiMember);
				}while(opsiMember != 3);
			}
			break;
		}
	}
	
	public Main() {
		
		String opsiGuest = null;
		int authResult = 0;
		
		// Auth
		do {
			// Belum login atau udh login tapi logout lagi
			if(authResult == 0 || authResult == 1 || authResult == 2) {
				menu();
				System.out.print("Login [Y / N]: ");
				opsiGuest = sc.nextLine();
			}
			// udh beres auth dan milih exit
			else if(authResult == 3) {
				opsiGuest = "N";
				break;
			}
			
			if(opsiGuest.equals("Y")) {
				do {
					authResult = authUser();
					
					if(!(authResult != 1 || authResult != 2 || authResult != 3)) {
						System.out.println("Error not expected authResult value");
					}
					
					
				}while(!(authResult == 1 || authResult == 3));
				
				app(opsiGuest, authResult);
				
			}
			else if(opsiGuest.equals("N")){
				break;
			}
		}while(!(opsiGuest.equals("N")));
		
		// Auth done
		System.out.println("Program Exited");
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
