package ej06;

import TDAArbol.TNode;
import ej03.LinkedTree;
import TDAArbol.InvalidOperationException;
import exception.BoundaryViolationException;
import exception.EmptyTreeException;
import exception.InvalidPositionException;
import position.Position;

public class Ejercicio06h<E> extends LinkedTree<E>{

	public int alturaRotulo(E r) {
		int altura = alturaRotuloRec(r, raiz);
		return altura;
	}
	private int alturaRotuloRec(E r, TNode<E> nodo) {
		int altura = 0;
		//Encontre el nodo
		if(nodo.element() == r) {
			altura = buscarHoja(nodo);
		}else {
			for(TNode<E> hijo:nodo.getHijos()) {
				altura = alturaRotuloRec(r,hijo);
			}
		}
		return altura;
	}
	private int buscarHoja(TNode<E> nodo) {
		int pasosHastaHoja = 0;
		int aux = 0;
		
		

		
		return pasosHastaHoja;
	}
}