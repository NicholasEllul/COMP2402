package comp2402a2;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import comp2402a2.DualArrayDeque;
import comp2402a2.Factory;
import comp2402a2.RootishArrayStack;
/**
 */
public class RootishArrayDeque<T> extends AbstractList<T> {
	/**
	 * You decide on the instance variables you need.
	 */
	 	Factory<T> f;

	/**
	 * the front "half" of the deque
	 */
	protected List<T> front;

	/**
	 * the back "half" of the deque
	 */
	protected List<T> back;


	protected RootishArrayStack<T> newStack() {
		return new RootishArrayStack<T>(f.type());
	}

	public RootishArrayDeque(Class<T> t) {
		f = new Factory<T>(t);
		front = newStack();
		back = newStack();
	}

	protected static int i2b(int i) {
 		double db = (-3.0 + Math.sqrt(9 + 8*i)) / 2.0;
 		int b = (int)Math.ceil(db);
 		return b;
 	}

	public T get(int i) {
		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
		if (i < front.size()) {
			return front.get(front.size()-i-1);
		} else {
			return back.get(i-front.size());
		}
	}

	public T set(int i, T x) {
		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
		if (i < front.size()) {
			return front.set(front.size()-i-1, x);

		} else {
			return back.set(i-front.size(), x);
		}
	}

	public void add(int i, T x) {
		if (i < 0 || i > size()) throw new IndexOutOfBoundsException();
		if (i < front.size()) {
			front.add(front.size()-i, x);
		} else {
			back.add(i-front.size(), x);
		}
		balance();
	}

	protected void balance() {
		if(front.size()+back.size() > 1) {
			int n = size();
			if (3 * front.size() < back.size()) {
				int s = n / 2 - front.size();
				List<T> l1 = newStack();
				List<T> l2 = newStack();
				l1.addAll(back.subList(0, s));
				Collections.reverse(l1);
				l1.addAll(front);
				l2.addAll(back.subList(s, back.size()));
				front = l1;
				back = l2;
			} else if (3 * back.size() < front.size()) {
				int s = front.size() - n / 2;
				List<T> l1 = newStack();
				List<T> l2 = newStack();
				l1.addAll(front.subList(s, front.size()));
				l2.addAll(front.subList(0, s));
				Collections.reverse(l2);
				l2.addAll(back);
				front = l1;
				back = l2;
			}
		}
	}

	public T remove(int i) {
		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
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
		// Put your own code here
		return front.size() + back.size();
	}
}
