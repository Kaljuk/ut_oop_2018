package task2;

public class Newspaper {

  private final String name;
  private final int yearOfFounding;
  private final int registrationCode;

  public Newspaper(String name, int yearOfFounding, int registrationCode) {
    this.name = name;
    this.registrationCode = registrationCode;
    this.yearOfFounding = yearOfFounding;
  }

  public int getRegistrationCode() {
    return registrationCode;
  }

  public int getYearOfFounding() {
    return yearOfFounding;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Newspaper newspaper = (Newspaper) o;
    if (yearOfFounding != newspaper.yearOfFounding)
      return false;
    if (registrationCode != newspaper.getRegistrationCode()) {
      return false;
    }
    return name != null ? name.equals(newspaper.name) : newspaper.name == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + yearOfFounding;
    return result;
  }
}
