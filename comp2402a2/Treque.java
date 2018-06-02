package comp2402a2;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import comp2402a2.Factory;
/**
 */
public class Treque<T> extends AbstractList<T> {
	/**
	 * The class of objects stored in this structure
	 */
	protected comp2402a2.Factory<T> f;

	/**
	 * the front "half" of the deque
	 */
	protected List<T> front;

	/**
	 * the back "half" of the deque
	 */
	protected List<T> back;

	/**
	 * Create a new empty List data structure.
	 *
	 * Subclasses should override this if they want to use
	 * different structures for front and back.
	 * @return
	 */
	protected List<T> newStack() {
		return new comp2402a2.DualArrayDeque<T>();
	}

	/**
	 * Constructor
	 * @param t0 the class of the objects stored in this list
	 */
	public Treque(Class<T> t) {
	    f = new Factory<T>(t);
		front = newStack();
		back = newStack();
	}
	public Treque() {
		//	f = new Factory<T>(t);
		front = newStack();
		back = newStack();
	}

	public T get(int i) {
		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
		if (i < front.size()) {
			return front.get(i);
		} else {
			return back.get(i-front.size());
		}
	}

	public T set(int i, T x) {
		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
		if (i < front.size()) {
			return front.set(i, x);

		} else {
			return back.set(i-front.size(), x);
		}
	}

	public void add(int i, T x) {
		if (i < 0 || i > size()) throw new IndexOutOfBoundsException();
		if (i < front.size()) {
			front.add(i, x);
		} else {
			back.add(i-front.size(), x);
		}
		balance();
	}

	/**
	 * Rebalance the elements between front and back
	 * if necessary
	 */
	protected void balance() {
		if(front.size()+2 ==  back.size()){
				front.add(front.size(),back.remove(0));
		}
		else if(back.size()+2 == front.size() ){
			back.add(0,front.remove(front.size()-1));
		}
	}

	public T remove(int i) {
		T x;
		if (i < front.size()) {
			x = front.remove(front.size()-i-1);
		} else {
			x = back.remove(i-front.size());
		}
		balance();
		return x;
	}

	public int size() {
		return front.size() + back.size();
	}

	public void clear() {
		front.clear();
		back.clear();
	}
}
