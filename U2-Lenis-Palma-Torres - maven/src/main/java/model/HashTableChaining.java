package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashTableChaining<K, T> implements IHashTable<K, T> {

	private int m;
	private ArrayList<LinkedList<NodeKey<K, T>>> table;

	/**
	 * Creates the hash table
	 * 
	 * @param m
	 *            The number of elements in the table.
	 */
	public HashTableChaining(int m) {
		this.m = m;
		table = new ArrayList<>(m);
		for (int i = 0; i < m; i++) {
			table.set(i, new LinkedList<NodeKey<K, T>>());
		}
	}

	@Override
	public void insert(K key, T value) throws HashTableException {
		int hash = hash(key);
		NodeKey<K, T> toInsert = new NodeKey<>(key, value);
		table.get(hash).add(toInsert);
	}

	@Override
	public T search(K key) {
		int hash = hash(key);
		int index = table.get(hash).indexOf(new NodeKey<K, T>(key, null));
		T value = index == -1 ? null : table.get(hash).get(index).getValue();
		return value;
	}

	@Override
	public void delete(K key) {
		int hash = hash(key);
		table.get(hash).remove(new NodeKey<K, T>(key, null));
	}

	private int hash(K key) {
		return key.hashCode() % m;
	}

}
