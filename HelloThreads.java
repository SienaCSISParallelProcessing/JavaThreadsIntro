/**
   Java Threads Hello, World!

   @author Jim Teresco
   @version Fall 2021
*/

public class HelloThreads {

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

	// construct the correct number of threads, overriding its run
	// method with the code we want the thread to execute and
	// calling its start method to launch the thread
	for (int i = 0; i < n; i++) {

	    new Thread() {
		@Override
		public void run() {
		    System.out.println("Hello from thread!");
		}
	    }.start();
	}
	System.out.println("End of main");
    }
}
