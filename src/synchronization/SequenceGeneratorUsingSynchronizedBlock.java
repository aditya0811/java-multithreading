package synchronization;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;



public class SequenceGeneratorUsingSynchronizedBlock extends SequenceGenerator {

  private final Object mutex = new Object();
  private final Object mutex2 = new ReentrantLock();

  //Semaphore allows 3 threads at max to access
  private final Object mutex3 = new Semaphore(3);
  @Override
  public int getNextSequence() {
    synchronized (mutex) {
      return super.getNextSequence();
    }

  }
}
