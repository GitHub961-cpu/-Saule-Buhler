package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.*;

/**
 * Deque is a doubly-linked list of items.
 * It is designed as a practice opportunity to
 * learn how to manipulate linked structures.
 * @author Saule & Jonas
 * Distribution 50% & 50%
 */
public class Deque<Item> implements Iterable<Item> {
	Node first;
	Node last;
	int n;
	
	/**
	 * Node of dequelist that stores the item and a
	 * single reference to the next and previous nodes.
	 */
	private class Node {
		private Item value;
		private Node next;
		private Node prev;
	}
	
	public Deque() { // construct an empty deque
		first = null;
		last = null;
		n = 0;
	}
	
	/** 
	 * Determines whether the list is empty or not.
	 * @return true if there are no elements in the list.
	 */
	public boolean isEmpty() {
		// is the deque empty?
		return n == 0;
	}
	
	/**
	 * Returns the number of elements in the list
	 * @return the number of elements
	 */
	public int size() {
		// return the number of items on the deque
		return n;
	}
	
	/** 
	 * Adds a node containing the new item at the
	 * start of the list.
	 * @param item
	 */
	public void addFirst(Item item) {
		// insert the item at the front
		if(item == null) {
			throw new NullPointerException("Cannot add null");
		}
		
		Node newNode = new Node();
		newNode.value = item;
		
		if(isEmpty()) {
			last = newNode;
		} else {
			newNode.next = first;
			first.prev = newNode;
		}
		
		first = newNode;
		n++;
	}
	
	/** 
	 * Adds a node containing the new item at the
	 * end of the list.
	 * @param item
	 */
	public void addLast(Item item) {
		// insert the item at the end
		// insert the item at the front
		if(item == null) {
			throw new NullPointerException("Cannot add null");
		}
		
		Node newNode = new Node();
		newNode.value = item;
		
		if(isEmpty()) {
			first = newNode;
		} else {
			newNode.prev = last;
			last.next = newNode;
		}
		
		last = newNode;
		n++;
	}
	
	/** 
	 * Removes the first item at the
	 * start of the list.
	 * @return value
	 */
	public Item removeFirst() {
		// delete and return the item at the front
		if(isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		
		Node remove = first;
		
		if(n == 1) {
			first = null;
			last = null;
		} else {
			first = first.next;
			first.prev = null;
		}
		
		n--;
		
		return remove.value;
	}
	
	/** 
	 * Removes the last item at the
	 * edn of the list.
	 * @return value
	 */
	public Item removeLast() {
		// delete and return the item at the end
		if(isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		
		Node remove = last;
		
		if(n == 1) {
			first = null;
			last = null;
		} else {
			last = last.prev;
			last.next = null;
		}
		
		n--;
		
		return remove.value;
	}
	
	public Iterator<Item> iterator() { // return an iterator over items in order from front to end
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item> {
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if(!hasNext()) {
				throw new NoSuchElementException("No more objects");
			}
			
			Item value = current.value;
			current = current.next;
			
			return value;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Cannot remove");
		}
		
	}
	//testing
	public static void main(String[] args) {
		Deque<String> deque = new Deque<String>();
		printDequeInfo(deque);
		
		deque.addFirst("dog");
		deque.addLast("cat");
		deque.addLast("bat");
		printDequeInfo(deque);
		
		System.out.println("Remove First: "+deque.removeFirst());
		System.out.println("Remove Last: "+deque.removeLast());
		printDequeInfo(deque);
		
		deque.addFirst("ant");
		deque.addLast("rat");
		deque.addLast("cow");
		deque.addFirst("pig");
		printDequeInfo(deque);
		
	}
	//testing
	private static void printDequeInfo(Deque<String> deque) {
		System.out.println("Is Empty: "+deque.isEmpty());
		System.out.println("Size: "+deque.size());
		System.out.print("Contents: ");
		for(String str : deque) {
			System.out.print(str +" ");
		}
		System.out.println("\n");
	}
}