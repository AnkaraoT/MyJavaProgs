package com.myjava.prog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClassMap<K, V> {
	int size = 0;
	int DEFAULT_SIZE = 10;
	private ClassMapEntry<K, V>[] elements;

	@SuppressWarnings("unchecked")
	public ClassMap() {
		elements = new ClassMapEntry[DEFAULT_SIZE];
	}

	@SuppressWarnings("unchecked")
	public ClassMap(int capacity) {
		elements = new ClassMapEntry[capacity];
	}

	public void put(K key, V value) {
		boolean setFlag = true;
		for (int i = 0; i <= size; i++) {
			if (elements[i]!=null && elements[i].getKey().equals(key)) {
				elements[i].setValue(value);
				setFlag = false;
				break;
			}
		}

		if (setFlag && size == elements.length) {
			expandCapcity();
			elements[size++] = new ClassMapEntry<K, V>(key, value);
		}

	}

	public void remove(K key) {
		for (int i = 0; i < size; i++) {
			if (elements[i].getKey().equals(key)) {
				elements[i] = null;
				size--;
				condenseArray(i);
			}
		}
	}

	private void condenseArray(int start) {
        for (int i = start; i < size; i++) {
        	elements[i] = elements[i + 1];
        }
    }

	
	private void expandCapcity() {
		elements = Arrays.copyOf(elements, size * 2);
	}

	public V get(K key) {
		for (int i = 0; i <= size; i++) {
			if (elements[i].getKey().equals(key)) {
				return elements[i].getValue();
			}
		}
		return null;
	}

	public int size() {

		return size;
		// return elements.length;
	}
	
	public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (int i = 0; i < size; i++) {
            set.add(elements[i].getKey());
        }
        return set;
    }

}
