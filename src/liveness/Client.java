package liveness;

/**
 * <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html">...</a>
 */
public class Client {
  public static void main(String[] args)
      throws InterruptedException {
    final Deadlock.Friend jai = new Deadlock.Friend("Jai");
    final Deadlock.Friend veeru = new Deadlock.Friend("Veeru");
    Thread t1 = new Thread(() -> jai.bow(veeru));
    t1.start();
    //Avoiding deadlock, and making the main thread sleep.
//    Thread.sleep(1000);
    new Thread(()-> veeru.bow(jai)).start();
  }
}
