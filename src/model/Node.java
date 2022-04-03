package model;

public class Node<E> implements Comparable<E>{

	 private E element;
	 private Node<E> next;
	 private Node<E> previous;
	   


	    public Node(E element) {
	       this.element= element;

	    }

	    public Node<E> getPrevious() {
	        return this.previous;
	    }

	    public void setPrevious(Node<E> previous) {
	        this.previous = previous;
	    }
	
	    public Node<E> getNext() {
	        return next;
	    }

	    public void setNext(Node<E> next) {
	        this.next = next;
	    }



	    @Override
	    public int compareTo(E o) {
	        return ((Comparable<E>) getElement()).compareTo(o);
	    }




	    public E getElement() {
			return element;
		}








		public void setElement(E element) {
			this.element = element;
		}








		@Override
	    public String toString() {
	        return "{"+getElement();
	    }


}
