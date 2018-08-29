import java.util.Arrays;

public class ClassList<E> {

	int size = 0;
	int DEFAULT_SIZE = 10;
	private Object[] elements;

	public ClassList() {
		elements = new Object[DEFAULT_SIZE];
	}

	public ClassList(int capacity) {
		elements = new Object[capacity];
	}

	public void add(E e) {
		if (size == elements.length) {
			expandCapcity();
		}
		elements[size++] = e;
	}

	private void expandCapcity() {
		elements = Arrays.copyOf(elements, size * 2);
	}

	public Object get(int indx) {

		if (indx >= size || indx < 0) {
			throw new ArrayIndexOutOfBoundsException(" My ClassList has index out of bound exception !! ");
		}

		return (E)elements[indx];
	}
	
	public int size() {
		
		return size;
		//return elements.length;
	}

}
