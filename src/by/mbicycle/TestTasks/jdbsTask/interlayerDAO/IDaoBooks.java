package by.mbicycle.TestTasks.jdbsTask.interlayerDAO;

import java.util.List;
import by.mbicycle.TestTasks.jdbsTask.beans.Books;
import by.mbicycle.TestTasks.jdbsTask.exception.DAOException;

public interface IDaoBooks {
  public List<Books> getBooks(Books books)throws DAOException;
  public boolean setBooks(Books books)throws DAOException;

}
