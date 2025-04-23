package synchronization;

/**
 * Here we don't need to add volatile to int, since by default all primitives except float and double
 * are atomic operations in java. We can use volatile keyword for non-primitives and float/double
 */
public class SequenceGenerator {
  private int currentValue = 0;
  public int getNextSequence() {
    currentValue = currentValue + 1;
    return currentValue;
  }
}
