package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import dao.StudentDao;

public class StudentService {

	Scanner sc = new Scanner(System.in);
	StudentDao studentDao = new StudentDao();

	public void addStudent(Connection conn) throws SQLException {
		System.out.println("\t\tEnter Student Name:");
		String studentName = sc.nextLine();

		System.out.println("\t\tEnter Registration No:");
		String regNo = sc.nextLine();

		StudentDao dao = new StudentDao();
		boolean isStdExist = dao.getStudentByRegno(conn, regNo);

		if (isStdExist) {
			System.out.println("\t\tStudents details exist into our system.");
			return;
		}

		dao.saveStudent(conn, studentName, regNo);
	}

	public void getAllStudents(Connection conn) throws SQLException {
		StudentDao dao = new StudentDao();
		dao.getAllStudents(conn);
	}

	public void updateStudent(Connection conn)throws SQLException {
		System.out.println("\t\tEnter Student Reg. No. :");
		String id = sc.nextLine();


		System.out.println("\t\tEnter new Reg. No.: ");
		String srNo = sc.nextLine();
		System.out.println("\t\tEnter new name: ");
		String name = sc.nextLine();


		studentDao.updateStudent(conn,srNo,name,id);
		System.out.println("\t\tSuccessfully Updated Students:");
	}

	public void deleteStudent(Connection conn) throws SQLException {
		System.out.println("\t\tEnter Student Reg. No. :");
		int id = sc.nextInt();
		studentDao.deleteStudent(conn,id);
		System.out.println("\t\tSuccessfully Deleted Students:");
	}

}
