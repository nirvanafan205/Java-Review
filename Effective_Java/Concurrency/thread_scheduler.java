//Any program that relies on the thread scheduler for correctness or performance is likely to be nonportable
//threads should not run if they aren't doing useful work
//awful countdownlatch implementation - busy-wwaits incessantly!

public class SlowCountDownLatch
{
	private int count;

	public SlowCountDownLatch(int count)
	{
		private int count;

		public SlowCountDownLatch(int count)
		{
			if(count < 0)
			{
				throw new IllegalArgumentException(count + " < 0");
			}

			this.count = count;
		}

		public void await()
		{
			while(true)
			{
				synchronized(this)
				{
					if(count == 0) return;
				}
			}
		}
	}

	public syncrhonized void countDown()
	{
		if(count != 0)
		{
			count--;
		}
	}
	//resist the temptation to "fix" the program by putting in calls to Thread.yeild
	//thread.yiueld has no testable semantics
	//thread priorities are among the least portable features of the Java platform
}
