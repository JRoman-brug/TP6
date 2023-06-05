package ej06;

import exception.*;
import listaDE.DoubleLinkedList;
import pilaEnlazada.PilaConEnlaces;

import java.util.Iterator;

import TDAArbol.InvalidOperationException;
import TDAArbol.Tree;
import TDALista.PositionList;
import TDAPila.Stack;
import ej05.ArbolImprimirNiveles;
import position.Position;

public class Ejercicio06eV2 {
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

			for(Character elem:camino(p,g,tr)) {
				System.out.print(elem+"-");
			}
			
		} catch (Exception e2) {

			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	private static <E> PositionList<E> camino(Position<E> N1, Position<E> N2, Tree<E> A){
		PositionList<E> toReturn = new DoubleLinkedList<E>();
		Stack<E> caminoN1 = new PilaConEnlaces<E>();
		Stack<E> caminoN2 = new PilaConEnlaces<E>();
		E aux = null;
		caminoRec(N1,N1,A,caminoN1);
		caminoRec(N2,N2,A,caminoN2);

		try {
			while(!caminoN1.isEmpty() && !caminoN2.isEmpty() && caminoN1.top() == caminoN2.top()) {
				aux = caminoN1.pop();
				caminoN2.pop();
			}
			//aca esta el problema
			toReturn.addLast(aux);
			while(!caminoN1.isEmpty()) {

				toReturn.addLast(caminoN1.pop());
			}
			while(!caminoN2.isEmpty()) {
				toReturn.addFirst(caminoN2.pop());
			}
			
		
		}catch( Exception  e) {
			e.printStackTrace();
		}
		
		
		return toReturn;
	}
	private static<E> void caminoRec(Position<E> N1, Position<E> pos, Tree<E> A, Stack<E> camino) {
		try {
			if(pos == N1) {
				Position<E> aux = pos;
				while(aux != A.root()) {
					camino.push(aux.element());
					aux = A.parent(aux);
				}
				camino.push(A.root().element());
			}else if(A.isInternal(pos)){
				for(Position<E> elem:A.children(pos)) {
					caminoRec(N1, elem, A, camino);
				}
			}
		}catch(BoundaryViolationException | InvalidPositionException | EmptyTreeException e) {
			e.printStackTrace();
		}


	}
}
