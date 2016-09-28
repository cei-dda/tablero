package tablero;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Stream;

public class Tablero<T> implements Collection<T> {

	private Node<T> first;
	private Node<T> last;
	private int size;

	@Override
	public Iterator<T> iterator() {

		Iterator<T> iterator = new Iterator<T>() {
			private Node<T> currentNode = first;

			@Override
			public boolean hasNext() {
				return currentNode != null && currentNode.next != null;
			}

			@Override
			public T next() {
				currentNode = currentNode.next;
				return currentNode.value;
			}
		};

		return iterator;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public boolean contains(Object o) {
		Optional<T> find = this.stream().filter(
				item -> item.equals(o)).findFirst();
		return find != null;
	}

	@Override
	public Object[] toArray() {
		Object elements[] = new Object[size];
		Node<T> currentNode = first;

		for (int i = 0; i < size; i++) {
			elements[i] = currentNode.value;
			currentNode = first.next;
		}

		return elements;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(T e) {
		Node<T> newNode = new Node<T>(e);

		if (first == null) {
			first = newNode;
			last = first;
		} else {
			last.next = newNode;
			last = newNode;
		}

		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		first = null;
	}

	public T getValueFromNextPositionCell(T value, int positions) {
		Node<T> node = first;
		Node<T> found = null;
		int counter = 0;
		boolean hasNext = false;

		do {
			if (node != null) {
				node = node.next;
				if (node.value != null && !node.value.equals(value)) {
					hasNext = node.next != null;
				} else if (node != null) {
					if (counter == positions) {
						found = node;
					} else {
						found = node.next;
						counter++;
					}
				}
			}
		} while (hasNext && found == null);

		return found != null ? found.value : null;
	}

	@SuppressWarnings("hiding")
	private class Node<T> {

		private T value;
		private Node<T> next;

		public Node() {
		}

		public Node(T value) {
			this();
			this.value = value;
		}
	}
}
