package by.mbicycle.TestTasks.jdbsTask.interlayerDAO;

import java.util.List;
import by.mbicycle.TestTasks.jdbsTask.beans.Writers;
import by.mbicycle.TestTasks.jdbsTask.exception.DAOException;

public interface IDaoWriter {
  public List<Writers> getWriters()throws DAOException;
  public  boolean addWriter(Writers writers)throws DAOException;
}
