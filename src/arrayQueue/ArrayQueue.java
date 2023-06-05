package arrayQueue;

import java.util.Iterator;

import TDACola.EmptyQueueException;
import TDACola.Queue;

public class ArrayQueue<E> implements Queue<E>{
	private E[] datos;
	private int f,r;
	
	public ArrayQueue(int max) {
		datos = (E[]) new Object[max];
		f=0;
		r=0;
	}
	public ArrayQueue() {
		this(20);
	}
	
	public int size() {
		return (datos.length-f+r)%datos.length;
	}
	public boolean isEmpty() {
		return f==r;
	}
	
	public E front() throws EmptyQueueException{
		if(isEmpty()) throw new EmptyQueueException("Cola vacia");
		return datos[f];
	}
	
	public E dequeue() throws EmptyQueueException{
		if(isEmpty())throw new EmptyQueueException("Cola vacia");
		
		E aux = datos[f];
		datos[f] = null;
		f = (f+1)%datos.length;
		return aux;
	}
	public void enqueue(E element) {
		// TODO Auto-generated method stub
		if(size()==datos.length-1) {
			E[] aux = copiar(f);
			r = size();
			f = 0;
			datos = aux;
		}
		datos[r]=element;
		r=(r+1)%datos.length;
	}
	
	private E[] copiar(int ini) {
		E[] toReturn = (E[]) new Object[datos.length*2];
		for(int i=0; i<size();i++) {
			toReturn[i] = datos[ini];
			ini = (ini+1) % datos.length;
		}
		return toReturn;
	}
}
