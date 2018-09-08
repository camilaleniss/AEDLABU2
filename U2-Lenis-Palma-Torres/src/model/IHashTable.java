package model;

public interface IHashTable<K, T> {

	public void insert(K key, T value) throws HashTableException;

	public T search(K key);

	public void delete(K key);

}
