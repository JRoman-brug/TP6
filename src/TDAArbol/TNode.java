package TDAArbol;

import TDALista.PositionList;
import listaDE.DoubleLinkedList;
import position.Position;

public class TNode<E> implements Position<E>{
	private E element;
	private TNode<E> padre;
	private PositionList<TNode<E>> hijos;
	
	public TNode(E e, TNode<E> p) {
		element = e;
		padre = p;
		hijos = new DoubleLinkedList<TNode<E>>();
	}
	
	public TNode(E element) {
		this(element, null);
	}
	
	public E element() {
		return element;
	}
	
	public PositionList<TNode<E>> getHijos(){
		return hijos;
	}
	
	public void setElement(E e) {
		element = e;
	}
	public TNode<E> getPadre(){
		return padre;
	}
	
	public void setPadre(TNode<E> p) {
		padre = p;
	}
	
}
