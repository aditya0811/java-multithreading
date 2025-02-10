public class SequenceGeneratorUsingSynchronizedKeyword extends SequenceGenerator{

  @Override
  public synchronized int getNextSequence() {
    return super.getNextSequence();
  }
}
