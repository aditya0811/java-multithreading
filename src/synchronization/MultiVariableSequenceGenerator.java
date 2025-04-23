package synchronization;

/**
 *
 *   Here if we want to have separate locks for each variable, we can create multiple mutex,
 *   and encourage concurrency. However, we need to make sure that we are ok with threads interleaving
 *   while accessing two variables. If not, we can use one single lock for both, or this keyword with synchronized
 */
public class MultiVariableSequenceGenerator {
  private long c1 = 0;
  private long c2 = 0;
  private Object lock1 = new Object();
  private Object lock2 = new Object();

  public void inc1() {
    synchronized(lock1) {
      c1++;
    }
  }

  public void inc2() {
    synchronized(lock2) {
      c2++;
    }
}
}
