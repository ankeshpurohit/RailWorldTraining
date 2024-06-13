package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Book;
import Model.BookingDetails;

public class StudentDao {

	public boolean getStudentByRegno(Connection conn, String regNo) throws SQLException {
		String query = "select * from students where reg_num = ?";

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, regNo);

			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		}
	}
	
	public int getStudentByRegno_(Connection conn, String regNo) throws SQLException {
		String query = "select * from students where reg_num = ?";

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, regNo);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		}
		
		return 0;
	}
	
	public void saveStudent(Connection conn, String studentName, String regNo) throws SQLException {
		String query = "insert into students (std_name, reg_num) values (?, ?)";
		
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, studentName);
			ps.setString(2, regNo);
			
			int rows = ps.executeUpdate();
			
			if (rows > 0) {
				System.out.println("Student added successfully.");
			} else {
				System.out.println("Failed to add student.");
			}
		}
	}
	
	public void getAllStudents(Connection conn) throws SQLException {
		String query = "select * from students";

		System.out.println("\t\t+------------+--------------------+---------------+");
		System.out.println("\t\t| Id         | Student Name       | Reg No        |");
		System.out.println("\t\t+------------+--------------------+---------------+");

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					System.out.printf("\t\t| %-10s | %-18s | %-13s | \n", rs.getInt(1), rs.getString(2), rs.getString(3));
					System.out.println("\t\t+------------+--------------------+---------------+");
				}
			}
		}
	}

	public void saveBookingDetails(Connection conn, int stdId, int bookId, int qty) throws SQLException {
		String query = "INSERT INTO booking_details(std_id, book_id, qty,booking_date,return_date) VALUES(?, ?, ?, ?, ?)";

		LocalDate localDate = LocalDate.now();
		String date = String.valueOf(localDate);
		String date1 = String.valueOf(localDate.plusDays(7));
		try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setInt(1, stdId);
			preparedStatement.setInt(2, bookId);
			preparedStatement.setInt(3, qty);
			preparedStatement.setString(4,date);
			preparedStatement.setString(5,date1);

			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows > 0) {
				System.out.println("Booking details Added Successfully!!");
				System.out.println("Return Date : "+date1);
			} else {
				System.out.println("Failed to add Booking details.");
			}
		}
	}
	
	public List<BookingDetails> getBookDetailsId(Connection conn, int stdId) throws SQLException {
		String query = "SELECT * FROM booking_details bd " 
				+ "INNER JOIN books b ON b.id = bd.book_id " 
				+ "WHERE bd.std_id = ?";
		
		List<BookingDetails> bookingDetails = new ArrayList<>();

		try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setInt(1, stdId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BookingDetails bookingDetail = new BookingDetails();
				bookingDetail.setAuthorName(resultSet.getString("author_name"));
				bookingDetail.setBookId(resultSet.getInt("book_id"));
				bookingDetail.setBookName(resultSet.getString("name"));
				bookingDetail.setQty(resultSet.getInt("qty"));
				bookingDetail.setStdId(resultSet.getInt("std_id"));
				bookingDetail.setSrNo(resultSet.getInt("sr_no"));
				bookingDetail.setId(resultSet.getInt("id"));
				bookingDetail.setDate(resultSet.getString("booking_date"));
				bookingDetail.setrDate(resultSet.getString("return_date"));
				
				bookingDetails.add(bookingDetail);
			}
		}

		return bookingDetails;
	}
	
	public void deleteBookingDetails(Connection conn, int id) throws SQLException {
		String query = "delete from booking_details WHERE id = ? ";
		
		try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}
	}

	public void deleteStudent(Connection conn, int id) throws SQLException {
		String query = "delete from students WHERE reg_num = ? ";

		try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}
	}

	public void updateStudent(Connection conn, String srNo, String name, String id) throws SQLException {
		String query = "UPDATE students SET std_name = ?, reg_num = ? WHERE reg_num = ? ";

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, name);
			ps.setString(2,srNo);
			ps.setString(3,id);
			ps.executeUpdate();
		}
	}


}
