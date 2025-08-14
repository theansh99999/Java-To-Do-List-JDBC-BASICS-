package toDo;

import java.util.Scanner;

public class maini {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username");
		String user = sc.nextLine();

		System.out.println("Enter password");
		String pass = sc.nextLine();
		admin ad = new admin();
		ad.insert(user, pass);
		sc.close();
	}

}
