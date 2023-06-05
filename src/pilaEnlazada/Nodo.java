package pilaEnlazada;

public class Nodo<E> {
	private E elemento;
	private Nodo<E> siguente;
	
	public Nodo(E item, Nodo<E> sig) {
		elemento = item;
		siguente = sig;
	}
	public Nodo(E item) {
		this(item,null);
	}
	
	public E getElemento() {
		return elemento;
	}
	public void setElemento(E elemento) {
		this.elemento = elemento;
	}
	
	public Nodo<E> getSiguente() {
		return siguente;
	}
	public void setSiguente(Nodo<E> siguente) {
		this.siguente = siguente;
	}
}
