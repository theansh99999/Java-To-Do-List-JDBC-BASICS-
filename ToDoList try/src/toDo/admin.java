package toDo;

import java.sql.*;
import java.util.*;

public class admin {
	public void insert(String user, String pass) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:mysql://localhost:3306/todolist";
			con = DriverManager.getConnection(url, user, pass);
			int choice = 0;
			do {
				System.out.println(
						"Enter your choice \n1. Insert\n2. Delete\n3. Update Status\n4. Update Description\n5. View Full\n6. View Duo");
				choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Enter name");
					String name = sc.nextLine();

					System.out.println("Enter priority");
					String priority = sc.nextLine();

					System.out.println("Enter create date");
					String createDate = sc.nextLine();

					System.out.println("Enter Due date");
					String dueDate = sc.nextLine();

					System.out.println("Enter description");
					String desc = sc.nextLine();

					System.out.println("Enter status");
					String status = sc.nextLine();

					ps = con.prepareStatement(query.insert);
					ps.setString(1, name);
					ps.setString(2, priority);
					ps.setString(3, createDate);
					ps.setString(4, dueDate);
					ps.setString(5, desc);
					ps.setString(6, status);
					ps.executeUpdate();
					break;
				case 2:
					System.out.println("Enter name");
					name = sc.nextLine();

					ps = con.prepareStatement(query.delete);
					ps.setString(1, name);

					ps.executeUpdate();
					break;
				case 3:
					System.out.println("enter name");
					name = sc.nextLine();

					System.out.println("enter status");
					status = sc.nextLine();

					ps = con.prepareStatement(query.updateStatus);
					ps.setString(1, status);
					ps.setString(2, name);
					ps.executeUpdate();
					break;
				case 4:
					System.out.println("enter name");
					name = sc.nextLine();

					System.out.println("enter desc");
					desc = sc.nextLine();

					ps = con.prepareStatement(query.updateDesc);
					ps.setString(1, desc);
					ps.setString(2, name);
					ps.executeUpdate();
					break;
				case 5:
					ps = con.prepareStatement(query.viewFull);
					rs = ps.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getString("name") + " | " + rs.getString("createDate") + " | "
								+ rs.getString("dueDate") + " | " + rs.getString("priority") + " | "
								+ rs.getString("status") + " | " + rs.getString("description") + " | ");
					}
					break;
				case 6:

					System.out.println("Enter your choice 1");
					String a = sc.nextLine();

					System.out.println("Enter your choice 2");
					String b = sc.nextLine();
					String q = "select " + a + "," + b + " from todo";
					ps = con.prepareStatement(q);
					rs = ps.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getString(a) + " | " + rs.getString(b) + " | ");
					}
					break;
				case 7:
					System.out.println("chalta hu malik");
					return;
				default:
					System.out.println("galat input dalre ho malik");
					break;

				}
			} while (choice != 7);

		} catch (Exception e) {
			System.out.println("Kuch glti  hui h malik 1");
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Kuch glti  hui h malik");
				e.printStackTrace();
			}

		}
	}
}
