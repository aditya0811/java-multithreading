import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Client {
  public static void main(String[] args) throws Exception {
    int count = 1000;
    Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGenerator(),count);
    System.out.println("This is set size:" + uniqueSequences.size());

    Set<Integer> uniqueSequencesWithSynchronizedKeyword =
        getUniqueSequences(new SequenceGeneratorUsingSynchronizedKeyword(),count);
    System.out.println("This is set size with synchronized keyword:" + uniqueSequencesWithSynchronizedKeyword.size());

  }

  private static Set<Integer> getUniqueSequences(SequenceGenerator sequenceGenerator, int count)
  throws Exception{
    Set<Integer> uniqueSequences = new LinkedHashSet<>();
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    sequenceGenerator.getNextSequence();
    List<Future<Integer>> futures = new ArrayList<>();
    for(int i=0;i<count;i++) {
      Future<Integer> future = executorService.submit(sequenceGenerator::getNextSequence);
      futures.add(future);
    }
    for(int i=0;i<count;i++) {
      uniqueSequences.add(futures.get(i).get());
    }
    executorService.awaitTermination(1, TimeUnit.SECONDS);
    executorService.shutdown();
    return uniqueSequences;

  }
}
