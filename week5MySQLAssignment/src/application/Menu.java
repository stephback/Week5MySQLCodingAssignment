package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.PieDao;
import entity.Pie;

public class Menu {
	
	private PieDao pieDao = new PieDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Pies", 
			"Display a Pie", 
			"Create Pie", 
			"Delete Pie"
			);
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
		
			try {
				if(selection.equals("1")) {
					displayPies();
				} else if (selection.equals("2")) {
					displayPie();
				} else if (selection.equals("3")) {
					createPie();
				} else if (selection.equals("4")) {
					deletePie();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			System.out.println("Press Enter to Continue....");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n---------------------------------------- ");
		for(int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayPies() throws SQLException {
		List<Pie> pies = pieDao.getPies();
		for (Pie pie : pies) {
			System.out.println(pie.getPieId() + ": " + pie.getPieType());
		}
	}
	
	private void displayPie() throws SQLException {
		System.out.print("Enter Pie ID: ");
		int pieId = Integer.parseInt(scanner.nextLine());
		Pie pie = pieDao.getPieById(pieId);
		System.out.println(pie.getPieId() + ": " + pie.getPieType());
	}
	
	private void createPie() throws SQLException {
		System.out.print("Enter new pie type:");
		String pieType = scanner.nextLine();
		pieDao.createNewPie(pieType);
	}
	
	private void deletePie() throws SQLException {
		System.out.print("Enter pie ID to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		pieDao.deletePieById(id);
	}

}
