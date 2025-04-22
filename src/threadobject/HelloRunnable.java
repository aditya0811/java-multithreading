package threadobject;

/**
 * Using implements Runnable is one way to spin up thread, as compared to extends Thread alternative
 * <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html">...</a>
 */
public class HelloRunnable implements Runnable{

  @Override
  public void run() {
    System.out.println("This is thread using runnable : " +Thread.currentThread().getName());
  }
}
