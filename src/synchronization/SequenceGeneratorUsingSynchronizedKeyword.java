package synchronization;

/**
 * Avoiding thread interference and memory inconsistency errors, by using happens before relationship
 * through synchronized keyword. Fundamentally, we have here intrinsic lock over object.
 * If the method is static, then its class level lock, not object level.
 */
public class SequenceGeneratorUsingSynchronizedKeyword extends SequenceGenerator{


  @Override
  public synchronized int getNextSequence() {
    return super.getNextSequence();
  }
}
