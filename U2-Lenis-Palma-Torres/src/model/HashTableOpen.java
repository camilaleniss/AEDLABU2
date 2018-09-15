package model;

import java.util.ArrayList;

public class HashTableOpen<K, T> implements IHashTable<K, T> {

	private int m;
	private ArrayList<NodeKey<K, T>> table;
	private int prime;
	private NodeKey<K, T> deleted;

	/**
	 * Creates the hash table
	 * 
	 * @param m
	 *            The number of elements in the table.
	 */
	public HashTableOpen(int m) {
		this.m = m;
		table = new ArrayList<>(m);
		for (int i = 0; i < m; i++) {
			table.add(null);
		}
		prime = findPrime();
		deleted = new NodeKey<K, T>(null, null);
	}

	@Override
	public void insert(K key, T value) throws HashTableException {
		boolean inserted = false;
		for (int i = 0; i < m && !inserted; i++) {
			int hash = hash(key, i);
			if (table.get(hash) == null || table.get(hash) == deleted) {
				table.set(hash, new NodeKey<K, T>(key, value));
				inserted = true;
			}
		}
		if (!inserted) {
			throw new HashTableException("Hash table overflow");
		}
	}

	@Override
	public T search(K key) {
		T value = null;
		boolean stop = false;
		for (int i = 0; i < m && !stop; i++) {
			int hash = hash(key, i);
			if (table.get(hash) == null) {
				stop = true;
			} else if (table.get(hash).getKey() != null && table.get(hash).getKey().equals(key)) {
				value = table.get(hash).getValue();
				stop = true;
			}
		}
		return value;
	}

	@Override
	public void delete(K key) {
		boolean stop = false;
		for (int i = 0; i < m && !stop; i++) {
			int hash = hash(key, i);
			if (table.get(hash) == null) {
				stop = true;
			} else if (table.get(hash).getKey() != null && table.get(hash).getKey().equals(key)) {
				table.set(hash, deleted);
				stop = true;
			}
		}

	}

	private int hash(K key, int index) {
		return (hash1(key) + index * hash2(key)) % m;
	}

	private int hash1(K key) {
		return Math.abs(key.hashCode()) % m;
	}

	private int hash2(K key) {
		return prime - Math.abs(key.hashCode()) % prime;
	}

	private int findPrime() {
		int prime = 1;
		boolean found = false;
		for (int i = m - 1; i > 2 && !found; i--) {
			found = isPrime(i);
			if (found)
				prime = i;
		}
		return prime;
	}

	private boolean isPrime(int numb) {
		boolean isPrime = true;
		if (numb < 2) {
			isPrime = false;
		} else {
			for (int i = 2; i * i <= numb && isPrime; i++) {
				if (numb % i == 0) {
					isPrime = false;
				}
			}
		}
		return isPrime;
	}

}
