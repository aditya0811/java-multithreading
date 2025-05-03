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

3) https://docs.oracle.com/javase/tutorial/essential/concurrency/threads.html
ALl the learnings are present in threadobject. Here we understood two ways for manual thread management.
How to start a thread/how to interrupt it/what is use case of join with interrupt and isAlive/what is thread name 


4) In synchronization package.
In java the reason we have synchronization is to avoid two problems when multiple threads are used.
Thread interference (one thread hogging other thread, resulting in other thread slowness, or completed suspension of task)
Second is, memory inconsistency errors, which is classic example of counter increment.
Fundamentally synchronized keyword establish happens-before relationship to mke sure, whenever we call a
method which has synchronized, each statement in the method, now has a happens before relationship
with statements in methods that are called in the subsequent method calls. This guarantees no thread interference
has occurred, and no memory consistency.


Reentrant synchronization is allowing single thread to access the resources again(re-lock) in the synchronized method
for which it has already lock access. 

Liveness of a concurrent application is a concept which makes it possible to execute task in timely manner.
Three problems comes with liveness, deadlock, starvation, livelock

a) In the Deadlock class, we have two methods with synchronized keyword, and following is the execution order
main thread calls new thread t1
t1 acquires lock in the method bow and bow back.
main also creates new thread t2, and executes t2
now during t1 bow execution, the bower.bowBack is the object which is waiting for the t2 to complete, which at the
same time is waiting for t1 bow back to complete.[CHECK]. This is deadlock. bowBack method is never executed. 

From docs
When Deadlock runs, it's extremely likely that both threads will block when they attempt to invoke bowBack. Neither block will ever end, because each thread is waiting for the other to exit bow.

[CHECK] Didnt get what these concepts are
b) Starvation : When a thread becomes greedy and locks object for too much time, because it is more frequently
calling a method, as compared to others.

c) Livelock : Similar to deadlock, only the threads, are able to talk to each other, but unable to resume flow
FixedThreadPool
It can accept INT_MAX tasks.
Here if a thread gets interrupted, then tasks fails, and the thread get replaced by another thread.
And subsequent tasks are executed. The threads will be active, until we do .shutdown

ArrayBlockingQueue can be used as an alternate, if we want to only take in specific number of tasks, and 
reject other tasks.