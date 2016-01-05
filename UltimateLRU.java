//A fucking great LRU (Least Recently Used)

import java.util.HashMap;

public class UltimateLRU {

	private DoubleLinkedList circularArrayQueue; // Contains the keys only
	private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
	int capacity;

	int size;

	public UltimateLRU(int capacity) {
		this.capacity = capacity;
		circularArrayQueue = new DoubleLinkedList(capacity);
	}

	public void insert(int key, int value) {
		DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
		// In case we get the same key again, we keep the most recent value
		if (map.containsKey(key)) {
			map.get(key).value = value;
		}
		map.put(key, node);
		DoubleLinkedListNode nodeToDelete = circularArrayQueue.insert(node);
		if (nodeToDelete != null && map.containsKey(nodeToDelete.key)) {
			map.remove(nodeToDelete.key);
		}
	}

	public void print() {
		circularArrayQueue.print();
	}

	public int getValue(int key) {
		DoubleLinkedListNode node = map.get(key);
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		circularArrayQueue.moveAtTheEnd(node);
		return node.value;
	}

	public static void main(String[] args) {
		UltimateLRU LRU = new UltimateLRU(3);
		LRU.insert(1, 111);
		LRU.print();
		LRU.getValue(1);
		LRU.print();
		LRU.insert(2, 222);
		LRU.print();
		LRU.insert(3, 333);
		LRU.print();
		LRU.insert(4, 444);
		LRU.print();
		LRU.insert(5, 555);
		LRU.print();
		LRU.getValue(4);
		LRU.print();
		LRU.insert(6, 666);
		LRU.print();
		LRU.getValue(5);
		LRU.print();
	}



public class DoubleLinkedList {

	// The item at root is the oldest one
	int size;
	int capacity;
	DoubleLinkedListNode root;
	DoubleLinkedListNode last;

	DoubleLinkedList(int capacity) {
		size = 0;
		this.capacity = capacity;
		root = null;
	}

	public DoubleLinkedListNode insert(DoubleLinkedListNode node) {
		DoubleLinkedListNode nodeToDelete = null;
		if (node == null || capacity <= 0) {
			return null;
		}
		if (root == null) {
			root = node;
			last = node;
			node.next = null;
			node.previous = null;
			size++;
			return null;
		}
		if (size >= capacity) {
			// delete first
			nodeToDelete = root;
			root = root.next;
			root.previous = null;
		}
		// add last
		node.previous = last;
		last.next = node;
		last = node;
		size++;
		return nodeToDelete;
	}

	public void print() {
		DoubleLinkedListNode current = root;
		while (current != null) {
			System.out.print("[" + current.key + "," + current.value + "] ");
			current = current.next;
		}
		System.out.println();
	}

	public void moveAtTheEnd(DoubleLinkedListNode node) {
		if (node == null || size <= 1) {
			return;
		}
		if (root == null) { // This should not happen
			root = node;
			last = node;
			node.next = null;
			node.previous = null;
			return;
		}

		if (node.next != null) {
			node.next.previous = node.previous;
		}
		if (node.previous != null) {
			node.previous.next = node.next;
		}
		if (node == root) {
			if (node.next != null) {
				root = node.next;
			}
		}
		if (node != last) {
			last.next = node;
			node.previous = last;
		}
		node.next = null;
		last = node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}






public class DoubleLinkedListNode {

	int key;
	int value;
	DoubleLinkedListNode previous;
	DoubleLinkedListNode next;
	
	DoubleLinkedListNode(int key, int value){
		this.key = key;
		this.value=value;
		this.previous = null;
		this.next = null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}





}
