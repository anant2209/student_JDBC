import java.sql.*;
import java.util.*;

public class Student {

	public static void main(String[] args) throws Exception {

		String yn = "y";
		String url = "jdbc:mysql://localhost:3306/student";
		String uname = "root";
		String pass = "admin";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();

		while (yn != "n") {

			Scanner sc = new Scanner(System.in);
			Scanner s = new Scanner(System.in);
			System.out.println("Select  (+,Insert)");
			System.out.println("Select  (-,Remove)");
			System.out.println("Select  (*,Update)");
			String sym = sc.next();

			switch (sym) {
			case "+": {

				System.out.println("Enter Student Id");
				int student_id = sc.nextInt();
				System.out.println("Enter Student Name");
				String student_name = s.next();

				st.executeUpdate("insert into student_student(student_id, student_name) Values(" + student_id + ",'"
						+ student_name + "')");
				System.out.println("Record Inserted Successfully");
				break;
			}
			case "-": {
				System.out.println("Enter id of  student to remove");
				int student_id = sc.nextInt();

				st.executeUpdate("Delete From student_student WHERE student_id=" + student_id);

				System.out.println("Record Deleted Successfully");
			}

				break;

			case "*": {
				System.out.println("Enter id of  student to update");
				int student_id = sc.nextInt();
				System.out.println("Enter Student Name");
				String student_name = s.next();

				st.executeUpdate("Update student_student Set student_name='" + student_name + "'  where student_id="
						+ student_id);

				System.out.println("Record Updated Successfully");
			}
				break;

			}
			System.out.println("Press y for 'yes' and n for 'no");
			yn = s.next();
		}

		st.close();
		con.close();

	}
}
