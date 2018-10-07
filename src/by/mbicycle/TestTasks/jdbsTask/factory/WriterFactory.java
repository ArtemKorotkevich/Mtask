package by.mbicycle.TestTasks.jdbsTask.factory;

import by.mbicycle.TestTasks.jdbsTask.beans.Writers;
import by.mbicycle.TestTasks.jdbsTask.exception.DAOException;
import by.mbicycle.TestTasks.jdbsTask.interlayerDAO.DBWriter;
import by.mbicycle.TestTasks.jdbsTask.interlayerDAO.IDaoWriter;

public class WriterFactory {
  public static IDaoWriter getWriterDAO(String type)throws DAOException{
    switch (type) {
      case "db":
        return new DBWriter();
      default:
        throw new DAOException("Type of IDAOTaskImplementation is not found");
    }
    
  }
  
  public static Writers getWritersFromFactory(int idWriter, String lastName, String firstName, String birthday){
    return new Writers()
        .setIdWriter(idWriter)
        .setLastName(lastName)
        .setFirstName(firstName)
        .setBirthday(birthday);
        
    
  }

}
