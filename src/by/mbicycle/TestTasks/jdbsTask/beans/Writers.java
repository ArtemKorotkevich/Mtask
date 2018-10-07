package by.mbicycle.TestTasks.jdbsTask.beans;

public class Writers {
  private int idWriter;
  private String lastName;
  private String firstName;
  private String birthday;

  public int getIdWriter() {
    return idWriter;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getBirthday() {
    return birthday;
  }

  public Writers setIdWriter(int idWriter) {
    this.idWriter = idWriter;
    return this;
  }

  public Writers setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Writers setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Writers setBirthday(String birthday) {
    this.birthday = birthday;
    return this;
  }

  public Writers() {
    super();
  }

  public Writers(int idWriter, String lastName, String firstName, String birthday) {
    super();
    this.idWriter = idWriter;
    this.lastName = lastName;
    this.firstName = firstName;
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return "Writers [idWriter=" + idWriter + ", lastName=" + lastName + ", firstName=" + firstName
        + ", birthday=" + birthday + "]";
  }
}
