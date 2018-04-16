package task1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonTest {

  // this class should not be changed
  public static void main(String[] args) {
    Map<Person, String> personToEmployer = new HashMap<>();
    Map<Integer, Person> developerByBugsProduced = new HashMap<>();

    Person mart = new Person("mart", "bakhoff", 15);
    personToEmployer.put(mart, "zeroturnaround");
    developerByBugsProduced.put(3, mart);

    if (!"zeroturnaround".equals(personToEmployer.get(mart)))
      throw new IllegalStateException("should find employer");
    if (!mart.equals(developerByBugsProduced.get(3)))
      throw new IllegalStateException("mart should have developed 3 bugs");
    if (developerByBugsProduced.get(mart) != null)
      throw new IllegalStateException("no one should have developed mart bugs (wait what)");

    Person martin = new Person("martin", "bakhoff", 15); // changed my name
    if (!"zeroturnaround".equals(personToEmployer.get(martin)))
      throw new IllegalStateException("should not become unemployed");

    int robotCount = 100000;
    Set<Integer> uniqueHashcodes = new HashSet<>();
    for (int i = 0; i < robotCount; i += 1) {
      Person robotson = new Person("AI-" + i, "Robotson", i);
      uniqueHashcodes.add(robotson.hashCode());
    }
    if (uniqueHashcodes.size() < robotCount * 0.75)
      throw new IllegalStateException("different robots should not have similar hashcodes");
  }
}
