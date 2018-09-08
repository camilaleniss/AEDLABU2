package model;

import java.util.ArrayList;

public class HashTableOpen<K, T> implements IHashTable<K, T> {

	private int m;
	private ArrayList<NodeKey<K, T>> table;

	/**
	 * Creates the hash table
	 * 
	 * @param m
	 *            The number of elements in the table. m must be a prime number.
	 */
	public HashTableOpen(int m) {
		this.m = m;
		table = new ArrayList<>(m);
	}

	@Override
	public void insert(K key, T value) throws HashTableException {
		// TODO Auto-generated method stub

	}

	@Override
	public T search(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub

	}

	public int hash(K key, int index) {
		return (hash1(key) + index * hash2(key)) % m;
	}

	public int hash1(K key) {
		return key.hashCode() % m;
	}

	public int hash2(K key) {
	
		return 0;
	}

}
