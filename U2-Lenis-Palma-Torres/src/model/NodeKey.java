package model;

public class NodeKey<K, T> extends Node<T> {

	private K key;

	public NodeKey(K key, T value) {
		super(value);
		this.key = key;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

}
