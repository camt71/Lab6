package lab6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}
	// creates an array of double-size if the array of
	// elements is full

	public void growSize() {
		if (size >= elements.length) {
			int newSize = elements.length * 2;
			E[] growLength = (E[]) new Object[newSize];
			for (int i = 0; i < size; i++) {
				growLength[i] = elements[i];
			}
			elements = growLength;
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return elements.length;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds Exception");
		} else
			return elements[i];
	}

	// Replaces the element at index i with e, and
	// returns the replaced element.
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds Exception");
		} else
			return elements[i] = e;
	}
	// It is used to append the specified element at the
	// end of a list.

	public boolean add(E e) {
		if (size >= elements.length)
			growSize();
		elements[size] = e;
		size++;
		return true;
	}

	// Inserts element e to be at index i, shifting all
	// subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds Exception");
		} else {
			growSize();
			for (int j = size; j > i; j--) {
				elements[j] = elements[j - 1];
			}
			elements[i] = e;
			size++;
		}
	}

	// Removes and returns the element at index i,
	// shifting subsequent elements earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds Exception");
		} else {
			for (int j = i; j < size; j++) {
				elements[j] = elements[j + 1];
			}
			size--;
		}
		return elements[i];// tra ve phan tu bi xoa
	}

	// It is used to clear all elements in the list.
	public void clear() {
		size = 0;
	}

	// It is used to return the index in this list of the
//	last occurrence
//	of the
//	specified element, or-1 if
//	the list
//	does not contain this element.

	public int lastIndexOf(Object o) {
		for (int i = size; i > -1; i--) {
			if (elements[i] == o)
				return i;
		}
		return -1;
	}

	// It is used to return an array containing all of the
	// elements in this list in the correct order.
	public E[] toArray() {
		E[] sortedArray = Arrays.copyOf(elements, size);
		Arrays.sort(sortedArray);
		return sortedArray;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> arrayCopy = new MyArrayList<>();
		for (int i = 0; i < size; i++) {
			arrayCopy.add(elements[i]);
		}
		return arrayCopy;

	}

	// It returns true if the list contains the specified
	// element
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == o)
				return true;
		}
		return false;
	}

	// It is used to return the index in this list of the
	// first occurrence of the specified element, or -1 if the
	// List does not contain this element.
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == o)
				return i;
		}
		return -1;
	}

	// It is used to remove the first occurrence of the
	// specified element.
	public boolean remove(E e) {
		if (indexOf(e)==-1)
			return false;
		else
			for (int i = indexOf(e); i < size-1; i++) {
				elements[i] = elements[i + 1];
			}
		size--;
		return true;
	}

	// It is used to sort the elements of the list on the
	// basis of specified comparator.

	public void sort(Comparator<E> c) {
		if (size > 0) {
			Arrays.sort(elements, 0, size, c);
		}
	}

	public String toString() {
		String a = "";
		for (int i = 0; i < size; i++) {
			String b = "";
			b = elements[i] + "  ";
			a = a + b;
		}
		return a;
	}

	public static void main(String[] args) {
		MyArrayList<Integer> arrayList = new MyArrayList<>();

		arrayList.add(3);
		arrayList.add(5);
		arrayList.add(8);
		System.out.println(arrayList.indexOf(3));
	}
}
