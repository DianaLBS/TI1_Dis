package model;

import java.util.Comparator;

public class Min_PriorityQueue<E> {
private int size;
	
	private Object Node[];
	
	private Comparator<E> comparator;
	
	public Min_PriorityQueue(int maxSize) {
		Node=new Object[maxSize];
	}
	
	public E parent(int i) {
		return (E) Node[(i-1)/2];
	}
	public E leftChildren(int i) {
		return (E) Node[2*i+1];
	}
	public E rightChildren(int i) {
		return (E) Node[2*i+2];
	}
	
	
	public boolean lessorEqual(E e1,E e2) {
		if(comparator!=null) {
			return comparator.compare(e1, e2)<=0;
		}
		else {
			return ((Comparable<E>)e1).compareTo(e2)<=0;
		}
	}
	public boolean bigger(E e1,E e2) {
		if(comparator!=null) {
			return comparator.compare(e1, e2)>0;
		}
		else {
			return ((Comparable<E>)e1).compareTo(e2)>0;
		}
	}
	public E get(int i) {
		return (E) Node[i];
	}
	
	public void add(E element) {
		if(size>=Node.length) {
			System.out.println("FULL");
		}else {
			Node[size]=(E)element;
			changeUp(size);
			size++;
		}
	}
	public void changeUp(int i) {
		while(i>0 & lessorEqual(get(i),parent(i))) {
			{
				swap(i,(i-1)/2);
				i=(i-1)/2;
			}
		}
	}
	public void swap(int i,int j) {
		E temp=get(i);
		Node[i]=get(j);
		Node[j]=temp;
	}
	public E peek() {
		if(size==0) {
			return null;
		}else {
		return get(0);
		}
	}
	
	public E poll() {
		if(size==0) {
			return null;
		}
		else {
			E resultPoll=get(0);
			Node[0]=Node[size-1];
			size--;
			MinHeapify(0);
			return resultPoll;
		}
	}
	public void MinHeapify(int i) {
		int index=i;
		if ((2 * i + 1) <= size-1 && (bigger(get(index), leftChildren(i)))){
           index = 2 * i + 1;
		}
        if (((2 * i + 2) <= size-1) && (bigger(get(index), rightChildren(i)))) {
           index = 2 * i + 2;
        }
        if (i != index)
        {
            swap(i, index);
            MinHeapify(index);
        }
	}
	public void remove(E e) {
		for(int i=0;i<size;i++) {
			if(e==Node[i]) {
				Node[i]=Node[size-1];
				break;
			}
		}
		size--;
		MinHeapify(0);
	}
	
	
	public int size() {
		return size;
	}
	public boolean contains(E e) {
		boolean flag=false;
		for(int i=0;i<size;i++) {
			if(Node[i]==e) {
				flag=true;
				break;
			}
		}
		return flag;
	}
	public void clear() {
		size=0;
		poll();
	}
      
}
