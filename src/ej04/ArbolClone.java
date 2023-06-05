package ej04;

import TDAArbol.InvalidOperationException;
import TDAArbol.TNode;
import TDAArbol.Tree;
import ej03.LinkedTree;
import exception.EmptyTreeException;
import exception.InvalidPositionException;
import position.*;

public class ArbolClone<E> extends LinkedTree<E>{
	public ArbolClone() {
		super();
	}
	
	public Tree<E> clone() {
		Tree<E> toReturn = new LinkedTree<E>();
	
		if(!isEmpty()) {
			try {
				
				toReturn.createRoot(raiz.element());
				auxClone(raiz,toReturn.root(), toReturn);
				
			} catch (InvalidOperationException | InvalidPositionException | EmptyTreeException   e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return toReturn;
	}
	private void auxClone(TNode<E> pos,Position<E> padreClone, Tree<E> atrClone) throws InvalidPositionException{
		TNode<E> posAux;
		//Llamo a los hijos de pos
		for(TNode<E> nodo: pos.getHijos()) {
			try {				
				posAux = (TNode<E>) atrClone.addLastChild(padreClone, nodo.element());
				
				auxClone(nodo, posAux, atrClone);
			} catch (InvalidPositionException e) {
				e.printStackTrace();
			}
		}
	}
}
