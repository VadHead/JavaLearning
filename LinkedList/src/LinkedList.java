public class LinkedList<T> {
	
	private Element<T> first;
	
	public void addFirst(T value) {
		Element<T> element = new Element<>(value);
		element.setNext(first);
		first = element;
	}
	
	public void addLast(T value) {
		if (first == null) {
			addFirst(value);
		}
		else {
			Element<T> element = first;
			while (element.getNext() != null) {
				element = element.getNext();
			}
			element.setNext(new Element<>(value));
			
		}
	}
	
	public int firstIndexOf(T value) {
		Element<T> element = first;
		int index = 0;
		while (element != null) {
			if (element.getValue().equals(value)) {
				return index;
			}
			index++;
			element = element.getNext();
		}
		return -1;
	}
	
	public int lastIndexOf(T value) {
		Element<T> element = first;
		int index = -1;
		int count = 0;
		while (element != null) {
			if (element.getValue().equals(value)) {
				index = count;
			}
			count++;
			element = element.getNext();
		}
		return index;
	}
	
	public T getFirst() {
		if (first == null) {
			return null;
		}
		return first.getValue();
	}
	
	public T getLast() {
		if (first == null) {
			return null;
		}
		Element<T> element = first;
		while (element.getNext() != null) {
			element = element.getNext();
		}
		return element.getValue();
	}
	
	public T getValueOf(int index) {
		Element<T> element = this.getElement(index);
		if (element != null) {
			return element.getValue();
		}
		else {
			return null;
		}
	}
	
	public boolean set(int index, T newValue) {
		Element<T> element = this.getElement(index);
		if (element != null) {
			element.setValue(newValue);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean remove(int index) {
		Element<T> element = this.getElement(index - 1);
		if (element != null) {
			if (element.getNext() != null) {
				element.setNext(element.getNext().getNext());
				return true;
			}
			else {
				return false;
			}
		}
		else {
			first = first.getNext();
			return true;
		}
	}
	
	public boolean removeFirst() {
		if (first != null) {
			first = first.getNext();
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeLast() {
		if (first == null) {
			return false;
		}
		Element<T> element = first;
		Element<T> next = null;
		while (element.getNext() != null) {
			next = element.getNext();
			if (next.getNext() == null) {
				element.setNext(null);
				return true;
			}
			else {
				element = element.getNext();
			}
		}
		return this.removeFirst();
	}
	
	public boolean removeFirstOf(T value) {
		int index = this.firstIndexOf(value);
		return this.remove(index);
	}
	
	public boolean removeLastOf(T value) {
		int index = this.lastIndexOf(value);
		return this.remove(index);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Element<T> element = first;
		while (element != null) {
			sb.append(" | ").append(element.getValue());
			element = element.getNext();
		}
		return "Linked Elements:" + sb + " |";
	}
	
	private Element<T> getElement(int index) {
		if (index < 0) {
			return null;
		}
		int count = 0;
		Element<T> element = first;
		while (count < index) {
			if (element == null) {
				return null;
			}
			count++;
			if (element.getNext() == null) {
				return null;
			}
			element = element.getNext();
		}
		return element;
	}
	
	private static class Element<T> {
		
		private T value;
		private Element<T> next;
		
		public void setValue(T value) {
			this.value = value;
		}
		
		public void setNext(Element<T> next) {
			this.next = next;
		}
		
		private Element(T value) {
			this.value = value;
		}
		
		public T getValue() {
			return value == null ? null : value;
		}
		
		public Element<T> getNext() {
			return next == null ? null : next;
		}
		
	}
	
}
