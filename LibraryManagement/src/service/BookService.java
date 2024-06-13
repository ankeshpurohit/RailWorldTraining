package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import Model.Book;

public class BookService {
	Scanner sc = new Scanner(System.in);
	BookDao bookDao = new BookDao();

	public void searchBook(Connection conn) throws SQLException {
		System.out.println("\t\t 1. Search with Book Serial No.");
		System.out.println("\t\t 2. Search with Book's Author Name.");

		System.out.println("\t\tPlease Enter your choice.");

		int choice = sc.nextInt();

		switch (choice) {
			case 1:
				searchBySrNo(conn);
				break;
			case 2:
				searchByAuthorName(conn);
		}
	}
	public void searchBySrNo(Connection conn) throws SQLException {
		System.out.println("\t\tEnter Serial No of Book:");
		int srNo = sc.nextInt();

		BookDao dao = new BookDao();
		Book book = dao.getBooksBySrno(conn, srNo);

		if (book != null) {
			System.out.println("======= Book Details ======");
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
			System.out.println("\t\t|   Book ID      |      Book Name       |    Author Name     |   Quantity   |");
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
			System.out.printf("\t\t|   %-10s   |   %-16s   |   %-14s   |   %-8s   | \n", book.getSrNo(), book.getBookName(),
					book.getAuthorName(), book.getBookQty());
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
		} else {
			System.out.println("\t\tNo Book for Serial No " + srNo + " Found.");
		}
	}

	public void searchByAuthorName(Connection conn) throws SQLException {
		System.out.println("\t\tEnter Author Name:");

		String authorName = sc.nextLine();

		BookDao dao = new BookDao();
		Book book = dao.getBooksByAuthorName(conn, authorName);

		if (book != null) {
			System.out.println("====== Book Details ======");
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
			System.out.println("\t\t|   Book ID      |      Book Name       |    Author Name     |   Quantity   |");
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
			System.out.printf("\t\t|   %-10s   |   %-16s   |   %-14s   |   %-8s   | \n", book.getSrNo(), book.getBookName(),
					book.getAuthorName(), book.getBookQty());
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
		} else {
			System.out.println("\t\tNo Book for Author Name " + authorName + " Found.");
		}
	}

	public void addBook(Connection conn) throws SQLException {
		System.out.println("\t\tEnter Serial No of Book:");
		int srNo = sc.nextInt();
		sc.nextLine();

		System.out.println("\t\tEnter Book Name:");
		String bookName = sc.nextLine();

		System.out.println("\t\tEnter Author Name:");
		String authorName = sc.nextLine();

		System.out.println("\t\tEnter Quantity of Books:");
		int qty = sc.nextInt();

		BookDao dao = new BookDao();
		Book book = dao.getBooksBySnoOrBookName(conn, authorName, srNo);

		if (book != null) {
			System.out.println("\t\tBook details exist into our system. Please save with other book.");
			return;
		}

		Book input = new Book();
		input.setAuthorName(authorName);
		input.setBookName(bookName);
		input.setBookQty(qty);
		input.setSrNo(srNo);

		dao.saveBook(conn, input);
	}

	public void updateBookQty(Connection conn) throws SQLException {
		System.out.println("\t\tEnter Serial No of Book:");
		int srNo = sc.nextInt();

		BookDao dao = new BookDao();
		Book book = dao.getBooksBySrno(conn, srNo);

		if (book == null) {
			System.out.println("\t\tBook not available.");
			return;
		}

		System.out.println("\t\tEnter No of Books to be Added:");
		int qty = sc.nextInt();

		Book input = new Book();
		input.setBookQty(book.getBookQty() + qty);
		input.setSrNo(srNo);

		dao.updateBookQty(conn, input);
	}


	public void getAllBooks(Connection conn) throws SQLException {
		BookDao dao = new BookDao();
		List<Book> books = dao.getAllBooks(conn);

		System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
		System.out.println("\t\t|   Book ID      |      Book Name       |    Author Name     |   Quantity   |");
		System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");

		for (Book book : books) {
			System.out.printf("\t\t|   %-10s   |   %-16s   |   %-14s   |   %-8s   | \n", book.getSrNo(), book.getBookName(),
					book.getAuthorName(), book.getBookQty());
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
		}
	}

	public void updateBook(Connection conn) {
	}

	public void deleteBook(Connection conn) throws SQLException {

		System.out.println("Enter Sr. No. of Book:");
		int id = sc.nextInt();
		bookDao.deleteBook(conn,id);
		System.out.println("Successfully Deleted Book:");

	}

}
