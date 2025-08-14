package toDo;

public class query {
	public static String insert = " INSERT INTO todo VALUES (?,?,?,?,?,?)";
	public static String delete = "delete from todo where name=?";
	public static String updateStatus = "update todo set status=? where name=?";
	public static String updateDesc = "update todo set description=? where name=?";
	public static String viewFull = "select * from todo";

	public static String viewDuo(String a, String b) {
		return "select" + a + "," + b + " from todo";
	}

}
