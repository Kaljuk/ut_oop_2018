package task2;

import java.util.HashMap;
import java.util.Map;

public class NewspaperTest {

  // this class should not be changed
  public static void main(String[] args) {
    Map<Newspaper, Integer> newspaperToSubscriberCount = new HashMap<>();

    Newspaper dailyTasks = new Newspaper("Daily hometasks", 2018, 1);
    newspaperToSubscriberCount.put(dailyTasks, 25);

    if (newspaperToSubscriberCount.get(dailyTasks) != 25)
      throw new IllegalStateException("should have 25 subscribers");

    Newspaper dailyTasksClone = new Newspaper("Daily hometasks", 2018, 1);
    if (!newspaperToSubscriberCount.containsKey(dailyTasksClone))
      throw new IllegalStateException("newspaper clone should be as good as original");

    Newspaper unnamed = new Newspaper(null, 1999, 2);
    if (newspaperToSubscriberCount.get(unnamed) != null) {
      throw new IllegalStateException("subscriber info should not be available");
    }

    Newspaper dailyTasksNamesake = new Newspaper("Daily hometasks", 2018, 1111);
    if (newspaperToSubscriberCount.containsKey(dailyTasksNamesake))
      throw new IllegalStateException("same name doesn't mean same newspaper");
  }
}
