import java.util.Arrays;

public final class ClassStringBuilder {

	private transient char[] value;
	private int count;

	public ClassStringBuilder() {
		value = new char[16];
	}

	ClassStringBuilder(String str) {
		if (str == null)
			value = new char[16];
		else
			append(str);
	}

	public ClassStringBuilder append(String str) {		
		if (str != null) {
			ensureCapacityAvilable(count + str.length());
			str.getChars(0, str.length() - 1, value, count);
			count = count + str.length();
		}

		return this;
	}

	int capacity() {
		return value.length;
	}

	int length() {
		return count;
	}

	void ensureCapacityAvilable(int minCapacity) {
		if (minCapacity - capacity() > 0) {
			expandCapacity(minCapacity);
		}

	}

	void expandCapacity(int minCapacity) {
		int newCapacity = value.length * 2 + 2;

		if (newCapacity - minCapacity < 0) {
			newCapacity = minCapacity;
		}

		if (newCapacity < Integer.MAX_VALUE - 8) {
			value = Arrays.copyOf(value, newCapacity);
		}

	}

	@Override
	public String toString() {
		char[] toSrtChars = Arrays.copyOfRange(value, 0, count);
		return new String(toSrtChars);
	}
}
