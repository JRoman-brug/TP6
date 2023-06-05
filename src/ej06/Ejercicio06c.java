package ej06;

import exception.*;
import TDAArbol.InvalidOperationException;
import TDAArbol.Tree;
import ej05.ArbolImprimirNiveles;
import position.Position;

public class Ejercicio06c {
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
			
			
			for(Character elem:tr) {
				System.out.println(elem);
			}
			System.out.println();
			
			eliminarHojas(tr);
			//K,G,F,E,P,Z
			for(Character elem:tr) {
				System.out.println(elem);
			}
			
		} catch (InvalidOperationException | EmptyTreeException | InvalidPositionException e2) {

			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	public static <E> void eliminarHojas(Tree<E> A) {
		try {
			eliminarHojasRec(A.root(), A);
		}catch(EmptyTreeException e) {
			e.printStackTrace();
		}
	}
	
	private static <E> void eliminarHojasRec(Position<E> nodo,Tree<E> A){
		try {
			if(A.isExternal(nodo)) {
				A.removeExternalNode(nodo);
			}
			for(Position<E> elem:A.children(nodo)) {
				eliminarHojasRec(elem,A);
			}
		}catch(InvalidPositionException e) {
			e.printStackTrace();
		}
	}
}
