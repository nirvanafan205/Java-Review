////to avoid liveness and safety failures,
//never cede control to the client within a synchronized method or block
//dont invoke a method that is desigend to be overridden
//or provided by a client in the form of a function object

//broken invokes alien method from synchronized block
public class ObservableSet<E> extends ForwardingSet<E>
{
	public ObservableSet(Set<E> set) { super(set); }

	private final List<SetObserver>> observers = new ArrayList<SetObserver<E>>();

	public void addObserver(SetObserver<E> observer)
	{
		synchronized(observers)
		{
			observers.add(observer);
		}
	}

	public boolean removeObserver(SetObserver<E> observer)
	{
		synchronized(observers)
		{
			return observers.remove(observer);
		}
	}

	private void notifyElementAdded(E element)
	{
		synchronized(observers)
		{
			for(SetObserver<E> observer : observers)
				observer.added(this, element);
		}
	}

	@Override public boolean add(E element)
	{
		boolean added = super.add(element);

		if(added)
		{
			notifyElementAdded(element);
			return added;
		}
	}

	@Override public boolean addAll(Collection<? extends E> c)
	{
		boolean result = false;

		for(E element : c)
		{
			result != add(element); //calls notifyElementAdded
			return result;
		}
	}

	//observers subscribe to notifications by invoking the 
	//addObserver method and unsubscribing by invoking the removeObserver method
	public interface SetObserver<E>
	{
		void added(ObservableSet<E> set, E element);
	}


	public static void main(String[] args)
	{
		ObservableSet<Integer> set = new ObservableSet<Integer>(new HashSet<Integer>() );

		set.addObserver(new SetObserver<Integer>()
				{
					public void added(ObservableSet<Integer> s, Integer e)
					{
						System.out.println(e);
					}
				} )'

		for(int i = 0; i < 100; i++)
		{
			set.add(i);
		}

		//observer is passed that prints integer value that was added to the set
		//and removes itself it the value is 23
		
		set.addObserver(new SetObserver<Integer>() 
				{
					public void added(observableSet<Integer> s, Integer e)
					{
						System.out.println(e);

						if(e == 23) s.removeObserver(this);
					}
				});
	}

	//Observer that uses a background thread needlessly
        // no exception, just deadlock	
	set.addObserver(new SetObserver<Integer>() 
			{
				public void added(final ObservableSet<Integer> s, Integer e)
				{
					System.out.println(e);

					if(e == 23)
					{
						ExecutorService executor = Executors.newSingleThreadExecutor();
						final SetObserver<Integer> observer = this;

						try
						{
							executor.submit(new Runnable() {
								public void run() 
								{
									s.removeObserver(observer);
								}
							}).get();
						} catch(ExecutionException ex) 
						{
							throw new AssertionError(ex.getCause() );
						} catch(InterruptedException ex)
						{
							throw new AssertionError(ex);
						} finally {
							executor.shutdown();
						}
					}
				}
			});
}

//alien method moved outside of synchroinzed block - open calls
private void notifyElementAdded(E element)
{
	List<SetObserver<E>> snapshot = null;

	synchronized(observers)
	{
		snapshot = new ArrayList<SetObserver<E>>(observers);
	}

	for(SetObserver<E> observer : snapshot)
	{
		observer.added(this, element);
	}
}

//thread-safe observable set with CopyOnWriteArrayList
private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<SetObserver<E>>();

public void addObserver(SetObserver<E> observer)
{
	observers.add(observer);
}

public boolean removeObserver(SetObserver<E> observer)
{
	return observers.remove(observer);
}

//alien invoked outside synchronized region is known as open call
//do little work as possible inside synchronized regions
private void notifyElementAdded(E element)
{
	for(SetObserver<E> observer : observers)
	{
		observer.added(this, element);
	}
}
