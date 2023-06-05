package ej06;

import java.util.Iterator;

import TDAArbol.InvalidOperationException;
import TDAArbol.Tree;
import TDALista.PositionList;
import ej05.ArbolImprimirNiveles;
import exception.EmptyTreeException;
import exception.InvalidPositionException;
import listaDE.DoubleLinkedList;
import position.Position;

public class Ejercicio06a {
	public static void main(String[] args) {
		Tree<Character> tr = new ArbolImprimirNiveles<Character>();

		Position<Character> a = null;
		Position<Character> b = null;
		Position<Character> c = null;
		Position<Character> d = null;
		Position<Character> e = null;
		Position<Character> f = null;
		Position<Character> g = null;
		Position<Character> h = null;
		Position<Character> k = null;
		Position<Character> l = null;
		Position<Character> m = null;
		Position<Character> p = null;
		Position<Character> z = null;


		try {
			tr.createRoot('a');
			a =  tr.root();
			b = tr.addLastChild(a, 'b');
			c = tr.addLastChild(a, 'c');
			d = tr.addLastChild(a, 'd');

			h = tr.addLastChild(b,'h');
			f = tr.addLastChild(b,'f');

			k = tr.addLastChild(h,'k');
			g = tr.addLastChild(h,'g');

			e = tr.addLastChild(c,'e');

			l = tr.addLastChild(d,'l');
			z = tr.addLastChild(d,'z');

			m = tr.addLastChild(l,'m');
			p = tr.addLastChild(m,'p');
			
			Iterable<Position<Character>> extremosIzquierdos = extremoIzquierdo(tr);
			
			for(Position<Character> elem: extremosIzquierdos) {
				System.out.println(elem.element());
			}
		} catch (InvalidOperationException | EmptyTreeException | InvalidPositionException e2) {

			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	public static <E> Iterable<Position<E>> extremoIzquierdo(Tree<E> A){
		PositionList<Position<E>> toReturn = new DoubleLinkedList<Position<E>>();
		try {
			if(!A.isEmpty()) {
				extremoIzquierdoRec(A.root(),A,toReturn);			
			}			
		}catch(EmptyTreeException e) {
			e.printStackTrace();
		}

		return toReturn;
	}
	private static <E> void extremoIzquierdoRec(Position<E> nodo, Tree<E> A, PositionList<Position<E>> lista) {
		try {
			Iterator<Position<E>> it = A.children(nodo).iterator();
			Position<E> aux = null;
			//Pregunto si es extremo izquierdo y si no tiene hijos
			if(it.hasNext()) {
				aux = it.next();
				if(A.isInternal(aux)) {
					lista.addLast(aux);
				}
			}
			for(Position<E> hijo:A.children(nodo)) {
				extremoIzquierdoRec(hijo,A,lista);
			}

		}catch(InvalidPositionException e) {
			e.printStackTrace();
		}
	}
}
