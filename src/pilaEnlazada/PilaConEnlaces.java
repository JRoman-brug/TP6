package pilaEnlazada;

import java.util.EmptyStackException;

import TDAPila.Stack;

public class PilaConEnlaces<E> implements Stack<E>{
	
	protected Nodo<E> head;
	protected int tamanio;
	
	public PilaConEnlaces() {
		head = null;
		tamanio = 0;
	}
	
	public int size() {
		return tamanio;
	}

	
	public boolean isEmpty() {
		return head == null;
	}

	
	public E top() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		return head.getElemento();
	}

	
	public void push(E element) {
		head = new Nodo<E>(element,head);
		tamanio++;
		
	}


	public E pop() throws EmptyStackException {
		Nodo<E> aux = head;
		if(isEmpty())throw new EmptyStackException();
		else {
			head = head.getSiguente();
			tamanio--;
			
		}
		return aux.getElemento();
	}

}
