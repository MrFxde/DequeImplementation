public class CArrayDeque<T> {

	private T[] items;
	private int front; // is the index of the front entry
	private int back; // is the index of the back entry
	private int size; // the number of entries in the queue
	final static int CAPACITY = 10;

	// Default constructor
	public CArrayDeque() {
		items = (T[]) new Object[CAPACITY];
		size = 0;
		back = CAPACITY - 1;
		front = 0; // back == front - 1;

	}

	/**
	 * Sees whether this queue is empty.
	 *
	 * @return True if the queue is empty, or false if not.
	 */
	public boolean isEmpty() {
		return size <= 0;
	}

	/**
	 * Adds a new entry to this queue at front.
	 *
	 * @param newEntry The object to be added as a new entry.
	 * @return True if the addition is successful, or false if not.
	 */
	public boolean addFront(T newEntry) {
		if (size < CAPACITY) {
			front--;
			if (front == -1) {
				front = CAPACITY - 1;
				items[front] = newEntry;
				size++;
				return true;
			} else {
				items[front] = newEntry;
				size++;
				return true;
			}
		}
		//returns false if there isn't room
		return false;
	}

	/**
	 * Adds a new entry to this queue at back.
	 *
	 * @param newEntry The object to be added as a new entry.
	 * @return True if the addition is successful, or false if not.
	 */
	public boolean addBack(T newEntry) {
		if(size < CAPACITY) {
			back++;
			if (back == CAPACITY) {
				back = 0;
				items[0] = newEntry;
				size++;
				return true;
			}
			//not neccessary
//			else if (back == front) {
//				back--;
//				return false;

			else {
				items[back] = newEntry;
				size++;
				return true;
			}
		}
		return false;
		}

	/**
	 * Removes the entry at front from the queue, if possible.
	 *
	 * @return True if the removal was successful, or false if not.
	 */
	public boolean removeFront() {
		if (size == 0)
			return false;
		front++;
		if (front == CAPACITY) {
			items[CAPACITY - 1] = null;
			front = 0;
			size--;
			return true;
		} else {
			items[front - 1] = null;
			size--;
			return true;
		}
	}

	/**
	 * Removes the entry at back from the queue, if possible.
	 *
	 * @return True if the removal was successful, or false if not.
	 */
	public boolean removeBack() {
		if (size == 0)
			return false;

		if (back == 0) {
			items[0] = null;
			back = CAPACITY - 1;
			size--;
			return true;
		} else {
			items[back] = null;
			back--;
			size--;
			return true;
		}
	}

	/**
	 * Retrieve the entry at front in the queue, if possible.
	 *
	 * @return the front entry if the retrieve was successful, or null if not.
	 */
	public T retrieveFront() {
		return items[front];
	}

	/**
	 * Retrieve the entry at back in the queue, if possible
	 *
	 * @return the front entry if the retrieve was successful, or null if not.
	 */
	public T retrieveBack() {
		return items[back];
	}

	/**
	 * Retrieves all entries that are in this queue.
	 *
	 * @return A newly allocated array of all the entries in this queue.
	 */
	public T[] toArray() {
		return items;
	}
}

