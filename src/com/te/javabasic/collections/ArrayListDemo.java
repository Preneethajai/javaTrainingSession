package com.te.javabasic.collections;

import java.util.Iterator;

public class ArrayListDemo implements Iterable {
	private Object[] array;
	private int position;

	public ArrayListDemo(int arraysize) {
		this.array = new Object[arraysize];
	}

	public void add(Object elements) {
		if (this.position >= this.array.length) {
			growArray();
		}
		this.array[position++] = elements;
	}

	public Object get(int index) {
		return this.array[index];
	}

	public int size() {
		return this.position;
	}

	private void growArray() {
		Object[] temp = new Object[this.array.length + 5];
		System.arraycopy(this.array, 0, temp, 0, this.array.length);
		array = temp;
	}

	@Override
	public String toString() {
		if (size() == 0) {
			return "[]";
		}
		String string = "[" + array[0];
		for (int i = 1; i < size(); i++) {
			string += "," + array[i];
		}
		string += "]";
		return string;
	}

	@Override
	public Iterator iterator() {

		return new MyItr();
	}

	private class MyItr implements Iterator {
		private int index;

		@Override
		public boolean hasNext() {

			return (index < position) ? true : false;
		}

		@Override
		public Object next() {

			return array[index++];
		}

	}

}
