package threadobject;

/**
 * In this package we will do concurrent programming, with java thread object only. Without
 * using Executor Service. Here we are controlling thread management, as we create our own thread, unlike
 * Executor service.
 */
public class Client {
  public static void main(String[] args) {
    String threadName = Thread.currentThread().getName();
    System.out.format("This is main client thread  : %s %n", threadName);

    Thread newThread = new Thread(new HelloRunnable());
    startThreadUsingRunnable(newThread);

    // Here we are handling thread interruption by catch block at client, we can have catch block around .sleep as well.
    try {
      makeCurrentThreadSleep();
    } catch (InterruptedException exception) {
      System.out.println("The thread got interrupted:" + exception.getStackTrace()[0]);
    }

    //Here we are checking periodically if the thread is interrupted
    if(Thread.interrupted()) {
      System.out.println("either return to client or throw exception");
    }

    //Here the amin thread will wait for newThread to finish for 10 seconds. Here the use case of
    // .join is we cannot wait indefinitely for another asynchronous task. If here, its taking
    // thread task more than 10 seconds, then we check if thread is alive, then we interrupt it.
    try {
      clientShouldWaitForThisThread(newThread);;
    } catch (InterruptedException exception) {
      System.out.println("The thread got interrupted even after main thread was waiting:" + exception.getStackTrace()[0]);
    }




  }

  private static void startThreadUsingRunnable(Thread newThread){

    newThread.start();
    boolean isNewThreadAlive = newThread.isAlive();
    boolean isNewThreadInterrupted = newThread.isInterrupted();
    System.out.format("New thread name : %s, is it alive? %b,  is it Interrupted? %b%n",
        newThread.getName(), isNewThreadAlive, isNewThreadInterrupted);
  }

  private static void clientShouldWaitForThisThread(Thread newThread)  throws InterruptedException{
    newThread.join(10000);
  }

  /**
   * InterruptedException will thrown when other thread interrupts this thread, during its sleep.
   * @throws InterruptedException
   */
  private static void makeCurrentThreadSleep() throws InterruptedException {
    for(int i=0;i<5;i++) {
      Thread.sleep(1000);
      System.out.println("This is time:" + System.currentTimeMillis());
    }
  }
}
