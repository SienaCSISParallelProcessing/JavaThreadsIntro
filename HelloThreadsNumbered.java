/**
   Java Threads Hello, World! with joins and thread IDs

   @author Jim Teresco
   @version Fall 2021
*/

public class HelloThreadsNumbered {

    public static void main(String args[]) {

	if (args.length != 1) {
	    System.err.println("Usage: Java HelloThreads numThreads");
	    System.exit(1);
	}

	// how many threads?
	int n = Integer.parseInt(args[0]);

	if (n < 1) {
	    System.err.println("Must specify number of threads");
	    System.exit(1);
	}

	// an array of Thread references so we can wait for them
	// to finish
	Thread threads[] = new Thread[n];
	
	// construct the correct number of threads, overriding its run
	// method with the code we want the thread to execute and
	// calling its start method to launch the thread
	for (int i = 0; i < n; i++) {

	    // pass our loop index as the thread ID
	    threads[i] = new WorkerThread(i) {
		    @Override
		    public void run() {
			// we have access to the threadId here
			System.out.println("Hello from thread " + threadId + "!");
		    }
		};
	    threads[i].start();
	}

	// wait for each to finish
	for (int i = 0; i < n; i++) {

	    try {
		threads[i].join();
	    }
	    catch (InterruptedException e) {
		System.err.println(e);
	    }
	}

	
	System.out.println("End of main");
    }
}

/* our WorkerThread, which just adds an instance variable
   and a constructor to set it to the Thread class. */
class WorkerThread extends Thread {

    protected int threadId;

    public WorkerThread(int threadId) {

	this.threadId = threadId;
    }
}
