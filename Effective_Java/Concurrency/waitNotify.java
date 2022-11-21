public class waitNotify
{
	//concurrent canonicalizing map atop ConcurrentMap - not optimal
	private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<String, String();

	public static String intern(String s)
	{
		String previousValue = map.putIfAbsent(s, s);
		return previousValue == null ? s : previousValue;
	}

	//Concurrent canonicalizing map atop ConcurrentMap - faster!
	//use concurrentHashMap in preference to Collections.synchronizedMap or Hashtable
	public static String intern(String s)
	{
		String result = map.get(s);

		if(result == null)
		{
			result = map.putIfAbsent(s, s);

			if(result == null)
			{
				result = s;
			}
		}
	}

	public static long time(Executor executor, int concurrency, final Runnable action) 
		throws InterruptedException {
		final CountDownLatch ready = new CountDownLatch(concurrency);
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch done = new CountDownLatch(concurrency);

		for(int i = 0; i < concurrency; i++)
		{
			executor.execute(new Runnable() {
				public void run()
				{
					ready.countDown(); //tells timer when ready

					try
					{
						start.await(); //tail till others are ready
						action.run();
					} catch(InterruptedException e) 
					{
						Thread.currentThread().interrupt();
					} finally {
						done.countDown(); //tells timer done
					}
				}
			} );
		}

		ready.await(); //waits for all to be ready
		long startNanos = System.nanoTime();
		start.countDown();
		done.await();
		return System.nanoTime() - startNanos;
	}

	//for interval timing
	//always use System.nanoTime in preference to System.currentTimeMillis
	
	//Standard idiom for using the wait method
	synchronized(obj)
	{
		while (<condition doesnt hold>)
			obj.wait(); // Releases loc and reacquires on wakeup)
				   //perform action appropriate to condition
	}
	//always use the wait loop idiom to invoke the wait method;
	//never invoke it outside of a loop


	public static void main(String[] args)
	{
		//given the difficulty of using wait and notify correctly
		//use higher level concurrency utilities instead
		//its impossible to exclue concurrent activity from concurrent collection
		//locking it will have no effect:w
	}
}
