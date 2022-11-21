public class mutatable_data
{
	private static boolean stopRequested;

	public static void main(String[] args)
		//Synchroniztion is required for reliable communcation
		//between threads as well as for mutual exclusion
			throws InterruptedException
		{
			//program never terminates: background thread loops forever
			Thread backgroundThread = new Thread(new Runnable()
					{
						public void run()
						{
							int i = 0;
							while(!stopRequested)
								i++;
						}
					});
			backgroundThread.start();
			TimeUnit.SECONDS.sleep(1);
			stopRequested = true;
		}
}

//properly synchromized cooperative thread termination

public class StopThread
{
	private static boolean stopRequested;
	private static synchronized void requestStop()
	{
		stopRequested = true;
	}

	private static synchronized boolean stopRequested()
	{
		return stopRequested;
	}

	public static void main(String[] args)
			throws InterruptedException
		{
			Thread backgroundThread = new Thread(new Runnable() {
				public void run() 
				{
					int i = 0;
					while(!stopRequested() )
						i++;
				}
			});
			backgroundThread.start();

			TimeUnit.SECONDS.sleep(1);
			//synchronization has no effect unless both read and write operations are synchronized
			requestStop();
		}
}

public class StopThread
{
	private static volatile boolean stopRequested;

	//broken requieres synchronization
	private static volatile int nextSerialNumber = 0;

	//++ isnt attomic, performs two opperations
	//reads the value, then writes back a new value equal to the old value plus one
	public static int generateSerialNumber()
	{
		return nextSerialNumber++;
	}

	//use atomic to add the synchronized modifier to its declaration
	private static final AtomicLong nextSerialNum = new AtomicLong();

	public static long generateSerialNumber()
	{
		//confine mutatable data to a single thread
		return nextSerialNum.getAndIncrement();
	}

	private static synchronized void requestStop()
	{
		stopRequested = true;
	}

	private static synchronized boolean stopRequested()
	{
		return stopRequested;
	}

	public static void main(String[] args)
			throws InterruptedException
		{
			Thread backgroundThread = new Thread(new Runnable() {
				public void run() 
				{
					int i = 0;
					while(!stopRequested() )
						i++;
				}
			});
			backgroundThread.start();

			TimeUnit.SECONDS.sleep(1);
			//synchronization has no effect unless both read and write operations are synchronized
			requestStop();
		}
}

/*
	When multiple threads share mutatble data
	each thread that reads or writes the data must perform synchronization	
*/
