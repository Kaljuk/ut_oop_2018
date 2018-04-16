package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {

  private String name;
  private List<String> customerNames = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addCustomer(String name) {
    customerNames.add(name);
  }

  public void removeCustomer(String name) {
    customerNames.remove(name);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Company other = (Company) o;
    return Objects.equals(name, other.name)
        && Objects.equals(customerNames, other.customerNames);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public String toString() {
    return String.format("Company{name='%s', customerNames=%s}", name, customerNames);
  }
}
