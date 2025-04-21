What is here?

1) Example use case of how multiple thread accessing a variable can result in incorrect value. We used here 
ExecutorService to create fixed thread pool, which is unbounded queue. 
Future object will hold the result for executor.submit(f::m)
2) To avoid incorrect value, we can either wrap entire piece of code, under synchronised. This can
be done by mutex, using class object. 
OR
Every piece of code in a method can be forced to access by one thread by using synchronised keyword in the method.
We should use volatile variable, if we want to avoid CPU cache, and store the variable in main 
memory, so all threads see same value.



FixedThreadPool
It can accept INT_MAX tasks.
Here if a thread gets interrupted, then tasks fails, and the thread get replaced by another thread.
And subsequent tasks are executed. The threads will be active, until we do .shutdown

ArrayBlockingQueue can be used as an alternate, if we want to only take in specific number of tasks, and 
reject other tasks.