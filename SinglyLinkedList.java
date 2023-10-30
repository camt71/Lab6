package lab6;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

	// Returns the number of elements in the list.
	public int size() {
		return size;
	}

	// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	// Returns (but does not remove) the first element in the list.

	public E first() {
		if (this.head == null) {
			throw new IndexOutOfBoundsException("Out Of Bounds Exception");
		} else
			return head.getData();
	}

	// Returns (but does not remove) the last element in the list.
	public E last() {
		if (head == null) {
			throw new IndexOutOfBoundsException("Out Of Bounds Exception");
		} else {
			Node<E> temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			return (E) temp.getData();
		}
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> headNode = new Node<E>(e, head);
		head = headNode;
		size++;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e);
		if (head == null) {// neu head = null thi newNode gan cho head
			head = newNode;
		} else {
			Node<E> lastNode = head;
			while (lastNode.getNext() != null) {
				lastNode = lastNode.getNext();
			}
			lastNode.setNext(newNode);// neu lastNode khong co phan tu ke tiep thi set newNode cho lastNode lam phan
										// tu cuoi;
		}
		size++;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (head == null) {
			throw new IndexOutOfBoundsException("Out Of Bounds Exception");
		} else {
			head = head.getNext();
			size--;
		}
		return (E) head;

	}

	public E removeLast() {
		if (head == null) {
			throw new IndexOutOfBoundsException("Out Of Bounds Exception");
		} else {
			Node<E> temp = head;
			while (temp.getNext().getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
			size--;
		}
		E temp = null;
		return temp;
	}

	@Override
	public String toString() {
		return "" + head + "";
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		linkedList.addFirst(2);
		linkedList.addFirst(3);
		linkedList.addLast(6);
		linkedList.addFirst(2);
		linkedList.addFirst(347);
		linkedList.addLast(612);
		linkedList.addFirst(25);
		linkedList.addFirst(347);
		linkedList.addLast(62);
		linkedList.addFirst(23);
		linkedList.addFirst(344);
		linkedList.addLast(68);
		System.out.println(linkedList);
	}
}
