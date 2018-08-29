package com.myjava.prog;

public class ClassMapEntry<K, V> {
	private K key;
	private V value;

	public ClassMapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {

		return this.key;
	}

	public V getValue() {

		return this.value;
	}

	public void setValue(V value) {
		this.value = value;		
	}
}