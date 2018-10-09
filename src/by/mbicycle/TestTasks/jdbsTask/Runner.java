package by.mbicycle.TestTasks.jdbsTask;

import java.sql.SQLException;
import java.util.Scanner;
import by.mbicycle.TestTasks.jdbsTask.beans.Books;
import by.mbicycle.TestTasks.jdbsTask.beans.Writers;
import by.mbicycle.TestTasks.jdbsTask.connectionDB.HelperDB;
import by.mbicycle.TestTasks.jdbsTask.interlayerDAO.DBBooks;
import by.mbicycle.TestTasks.jdbsTask.interlayerDAO.DBWriter;

public class Runner {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    HelperDB helperDB = new HelperDB();
    DBWriter dbWriter = new DBWriter();
    DBBooks dbBooks = new DBBooks();
    Writers writers = new Writers();
    Books books = new Books();
    boolean flag = true;
    System.out.println("menu: \n1.ShowWriter \n2. ShowBoks \n3. search by author \n4 add writer \n5 add book \n0 exit");
    while(flag){
      Scanner scanner = new Scanner(System.in);
      int num = scanner.nextInt();
      switch(num){
        case 1:
          dbWriter.getWriters();
          break;

        case 2:
           dbBooks = new DBBooks();
          dbBooks.getBooks();
          break;

        case 3:
          System.out.println("entering Last name writer:");
          String LastName = scanner.next();
          dbBooks = new DBBooks();
          dbBooks.getBooksWriter(LastName);
          break;

        case 4:
          writers = DBWriter.returnWriters();
          dbWriter.addWriter(writers);
          break;

        case 5:
          books = DBBooks.returnBooks();
          dbBooks.addBooks(books);
          break;

        case 0: flag = false; break;
      }
    }
  }
}
