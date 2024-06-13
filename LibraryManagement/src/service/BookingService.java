package service;

import Model.Book;
import Model.BookingDetails;
import dao.BookDao;
import dao.StudentDao;
import login.LoginService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookingService {

    BookService bookService =new BookService();
    Scanner sc = new Scanner(System.in);

    public  void getBbookingStatus(Connection conn) throws SQLException, ClassNotFoundException {
        BookingDetails bookingDetails = new BookingDetails();
        BookDao book = new BookDao();
        List<BookingDetails> bookArray = book.getAllStatus(conn);

        System.out.println("\t\t+----------------+--------------+---------------+----------------------+----------------+");
        System.out.println("\t\t|   Student ID   |    Book ID   |    Quantity   |     Rec. Date        |   Return Date  |");
        System.out.println("\t\t+----------------+--------------+---------------+----------------------+----------------+");

        for (BookingDetails bookingDetails1 : bookArray) {
            System.out.printf("\t\t|   %-10s   |   %-8s   |   %-9s   |   %-16s   |   %-7s   |\n", bookingDetails1.getStdId(),
                    bookingDetails1.getBookId(),bookingDetails1.getQty(),bookingDetails1.getDate(), bookingDetails1.getrDate());
            System.out.println("\t\t+----------------+--------------+---------------+----------------------+----------------+");
        }
        LoginService loginService = new LoginService();
        loginService.displayAdminMenu(conn);
    }

    public void checkOutBook(Connection conn) throws SQLException {
        StudentDao dao = new StudentDao();

        System.out.println("\t\tEnter Reg Number:");
        String regNum = sc.nextLine();

        boolean isExist = dao.getStudentByRegno(conn, regNum);



        if (!isExist) {
            System.out.println("\t\nStudent is not Registered. Please Registered Your ID.\n\n");
            return;
        }

        bookService.getAllBooks(conn);

        System.out.println("\t\tEnter Serial No of Book to be Checked Out.");
        int sNo = sc.nextInt();

        BookDao bookDao = new BookDao();
        Book book = bookDao.getBooksBySrno(conn, sNo);

        if (book == null) {
            System.out.println("\t\tBook is not available.");
            return;
        }

        book.setBookQty(book.getBookQty() - 1);

        int id = dao.getStudentByRegno_(conn, regNum);

        dao.saveBookingDetails(conn, id, book.getId(), 1);
        bookDao.updateBookQty(conn, book);
    }

    public void checkInBook(Connection conn) throws SQLException {
        StudentDao dao = new StudentDao();

        System.out.println("\t\tEnter Reg Number:");
        String regNum = sc.nextLine();

        boolean isExist = dao.getStudentByRegno(conn, regNum);

        if (!isExist) {
            System.out.println("\t\tStudent is not Registered. Get Registered First.");
            return;
        }

        int id = dao.getStudentByRegno_(conn, regNum);
        List<BookingDetails> bookingDetails = dao.getBookDetailsId(conn, id);

        /////////////////////////////////////////////////////////////////////////////////////////////////
/*
		bookingDetails.stream().forEach(bookig ->{
			LocalDate localDate= LocalDate.parse(bookig.getrDate());
			LocalDate localDate1 = LocalDate.now();
			int a= localDate.compareTo(localDate1);
			if (localDate == localDate1) {

			}

		} );
*/
        //////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\t\t+----------------+-------------------+------------+--------------------+-----------------+");
        System.out.println("\t\t|   Book ID      |      Book Name    |    Name    |     Rec. Date      |   Return Date   |");
        System.out.println("\t\t+----------------+-------------------+------------+--------------------+-----------------+");

        bookingDetails.stream().forEach(b -> System.out.println("|\t" +b.srNo + "\t\t\t\t" + b.bookName + "\t\t\t\t" + b.authorName+ "\t\t\t"
                +b.date+ "\t\t\t" +b.rDate+ "\t |\n+----------------+-------------------+------------+--------------------+-----------------+"));

        System.out.println("\t\tEnter Serial Number of Book to be Checked In:");
        int sNo = sc.nextInt();

        BookingDetails filterDetails = bookingDetails.stream().filter(b -> b.getSrNo() == sNo).findAny().orElse(null);

        BookDao bookDao = new BookDao();
        Book book = bookDao.getBooksBySrno(conn, sNo);
        book.setBookQty(book.getBookQty() + 1);

        bookDao.updateBookQty(conn, book);;
        dao.deleteBookingDetails(conn, filterDetails.getId());

    }
}
