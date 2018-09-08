package model;

import java.util.ArrayList;

public class HashTableOpen<K, T> implements IHashTable<K, T> {

	private int m;
	private ArrayList<NodeKey<K, T>> table;
	private int prime;

	/**
	 * Creates the hash table
	 * 
	 * @param m
	 *            The number of elements in the table. m must be a prime number.
	 */
	public HashTableOpen(int m) {
		this.m = m;
		table = new ArrayList<>(m);
		prime = findPrime();
	}

	@Override
	public void insert(K key, T value) throws HashTableException {
		for (int i = 0; i < m; i++) {
			int hash = hash(key, i);
		}
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

	private int hash(K key, int index) {
		return (hash1(key) + index * hash2(key)) % m;
	}

	private int hash1(K key) {
		return key.hashCode() % m;
	}

	private int hash2(K key) {
		return prime - key.hashCode() % prime;
	}

	private int findPrime() {
		int prime = 1;
		boolean found = false;
		for (int i = m - 1; i > 2 && !found; i++) {
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
