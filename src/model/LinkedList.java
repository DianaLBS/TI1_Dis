package model;

public class LinkedList<E> {

	private Node<E> element;
	private int size;
	
	public LinkedList() {
		
	}
	 public Node<E> getHead() {
	        return element;
	    }
	 public boolean isEmpty() {
	        return (element == null) ? true : false;
	    }
	 public int indexOf(E e) {
	        return indexOf(e, element, 0);
	    }

	    private int indexOf(E e, Node<E> temp, int contador) {
	        if (e.equals(temp.getElement())) {
	            return contador;

	        } else {
	            return indexOf(e, temp.getNext(), contador + 1);

	        }
	    }

	    public E get(int index) {

	        return get(index, element);

	    }

	    private E get(int index, Node<E> temp) {

	        if (index == 0) {
	            return temp.getElement();

	        } else {
	            return get(index - 1, temp.getNext());

	        }

	    }
	    public void add(E e) {

	        Node<E> node = new Node<E>(e);


	        if (element==null){
	            element=node;
	        }else{
	            Node<E> aux=element;
	       
	            while (aux.getNext()!=null) {
	                aux=aux.getNext();
	            }
	    
	            aux.setNext(node);
	        }
	       

	        size += 1;
	    }
	    
	   
	    public int size() {
	        return size;
	    }
}
