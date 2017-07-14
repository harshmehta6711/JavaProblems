package com.java;

public class HashTest {
	// keeping the size of the bucket fixed to 500 for simplicity
	private Node[] list = new Node[500];
	private int hash;

	public HashTest() {	
	}

	public void putItem(Object key, Object value) {
		// keeping the hash key simple so that values can be 0-4
		hash = Math.abs(key.hashCode() % 500);
		Node entry = new Node(key, value);

		if (list[hash] == null) {
			list[hash] = entry;
		} else {
			Node current = list[hash];
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(entry);
		}
	}

//	Get the object based on key
	Object get(Object key) {
		hash = Math.abs(key.hashCode() % 500);
		Node current = list[hash];
		while (current.getNext() != null) {
			if (current.getKey() == key) {
				return current.getValue();
			}
			current = current.getNext();
		}
		return null;
	}

	class Node {
		private Object key;
		private Object value;
		private Node next;

		Node(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		public Object getKey() {
			return key;
		}

		public void setKey(Object key) {
			this.key = key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

}
