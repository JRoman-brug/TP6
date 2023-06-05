package ej06;

import TDAArbol.TNode;
import ej03.LinkedTree;
import exception.InvalidPositionException;

public class Ejercicio06d<E> extends LinkedTree<E>{
	
	public void eliminarNodo(E r) {
		eliminarNodoRec(r, raiz);
	}
	private void eliminarNodoRec(E r, TNode<E> nodo) {
		if(nodo.element() == r) {
			try {
				removeNode(nodo);
			} catch (InvalidPositionException e) {
				e.printStackTrace();
			}
		}
		for(TNode<E> elem:nodo.getHijos()) {
			eliminarNodoRec(r,elem);
		}
	}
}
