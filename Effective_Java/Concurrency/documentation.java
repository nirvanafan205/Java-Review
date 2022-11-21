public class documentation
{
	public static void main(String[] args)
	{
		/*
			The presence of the synchronized modifier in a method declaration is an implementation detail
			not a part of its exported API

			To eneable safe concurrent use, a class must clearly document what level of thread safety it supports


			immutable- instanfces of this class appear constant. No external synchronization is necessary. Example include String, Long, and BigInteger
			
			unconditionally thread-safe - instances of this class are mutable, but the class has sufficient internal synchronization that its instances
			can be used concurrently without the need for any external synchronization. Exzmls include Random and ConcurrentHashMap

			conditionally thread-safe - like unconditionally thread-safe, except that some methods require external synchronization for safe concurrent use.
			Examples include collections returned by the Collections.synchronized wrappers, whose iterators require external synchronization

			not thread-safe -- Instances of this calss are mutable. To use them concurrently, clients mus surround each method invocation (or invocation sequence) 
			with external syncrhonization of the clients choosing. Examples include general-purpose collection implementations, such as ArrayList and HasMap

			thread-hostile -- this class is not safe for concurrent use even if all method invocations are surrounded by external synchronization. Thread hostility
			usually results from modifying static data without synchronization. No one writes a thread-hostile class on purpose; such classes result from the failure to consider concurrency
			Luckily there are very few thread-hostile classes or methods in the java libraries. The System.runFinalizersOnExit method is thread-hostile and has been deprecated
		*/

		Map<K, V> m = Collections.synchronizedMap(new HashMap<K, V>() );

		Seet<K> s = m.keySet(); //needn't be in synchronized block

		synchronized(m) //synchronizing on m, not s!
		{
			for(K key : s)
			{
				key.f();
			}
		}

		//private lock object idiom - thwarts denila-of=service attack
		private final Object lock = new Object();

		public void foo()
		{
			synchronized(lock)
			{
				...
			}
		}
	}
}
