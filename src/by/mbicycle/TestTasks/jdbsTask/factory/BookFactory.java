package by.mbicycle.TestTasks.jdbsTask.factory;

import by.mbicycle.TestTasks.jdbsTask.beans.Books;
import by.mbicycle.TestTasks.jdbsTask.beans.Writers;
import by.mbicycle.TestTasks.jdbsTask.exception.DAOException;
import by.mbicycle.TestTasks.jdbsTask.interlayerDAO.DBBooks;
import by.mbicycle.TestTasks.jdbsTask.interlayerDAO.IDaoBooks;

public class BookFactory {
  public static IDaoBooks getBooksDAO(String tupe){
    switch (tupe) {
      case "db":
        return new DBBooks();
      default:
        throw new DAOException("Type of IDAOTaskImplementation is not found");
      }
    }
    public static Books getBooksFromFactory(int idBook, int idWorker,String name,
        String printData,String printHouse,String description){
      return new Books()
          .setIdBook(idBook)
          .setWriters(idWorker)
          .setName(name)
          .setPrintData(printData)
          .setPrintHouse(printHouse)
          .setDescription(description);     
    }
  }
