/**
 * 
 */
/**
 * @author sophiagannon
 *
 */

package threadsExecutorsRunnables;

	public class executorsRunnable {
		public static void main (String args[]){
			
			runnableThread rta = new runnableThread("Thread 1");
			rta.starting();
			rta.runnable();
			
			runnableThread rtb = new runnableThread("Thread 2");
			rtb.starting();
		}
	}
	
	class runnableThread implements Runnable {
		private Thread tr;
		private String threadName;
		
		runnableThread (String Name) {
			threadName = Name;
			System.out.println("Creates thread: " + threadName);	
	}
	public void runnable() {
		System.out.print("Running - " + threadName);
		try {
			for(int i = 10; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread: " +threadName + " - interrupted.");
		}
		System.out.println("Thread, " + threadName + " - existing");
	}	
	public void starting() {
			System.out.println("Starting " + threadName);
			if (tr ==null)
			{
				tr = new Thread (this, threadName);
				tr.start ();
			}
			
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	}
