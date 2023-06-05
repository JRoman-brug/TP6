package linkedQueue;

import TDACola.EmptyQueueException;
import TDACola.Queue;

public class LinkedQueue<E> implements Queue<E>{
	
	protected Node<E> head,tail;
	protected int size;
	
	public LinkedQueue() {
		head = tail = null;
		size=0;
	}
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	
	public E front() throws EmptyQueueException{
		if(isEmpty()) throw new EmptyQueueException("Cola vacia");
		return head.getElement();
	}
	
	public void enqueue(E element) {
		Node<E> aux = new Node<E>(element);
		if(isEmpty()) {
			head = aux;
		}
		else {
			tail.setNext(aux);
		}
		tail = aux;
		size++;
	}
	
	public E dequeue() throws EmptyQueueException{
		if(isEmpty()) throw new EmptyQueueException("Cola vacia");
		
		Node<E> aux = head;
		head = head.getNext();
		size--;
		return aux.getElement();
		
	}
	
	

	
}
