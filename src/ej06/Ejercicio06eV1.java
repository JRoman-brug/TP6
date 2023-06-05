package ej06;

import TDAArbol.InvalidOperationException;
import TDAArbol.Tree;
import TDALista.PositionList;
import TDAPila.Stack;
import ej05.ArbolImprimirNiveles;
import exception.BoundaryViolationException;
import exception.EmptyStackException;
import exception.EmptyTreeException;
import exception.InvalidPositionException;
import listaDE.DoubleLinkedList;
import pilaEnlazada.PilaConEnlaces;
import position.Position;

public class Ejercicio06eV1 {

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

			for(Character elem: ancestroComun(p,h,tr)) {
				System.out.print(elem+"-");
			}
			
		} catch (InvalidOperationException | EmptyTreeException | InvalidPositionException e2) {

			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	public static PositionList<Character> ancestroComun(Position<Character> p1, Position<Character> p2, Tree<Character> t){
		Stack<Position<Character>> pila1 = new PilaConEnlaces<Position<Character>>();
		Stack<Position<Character>> pila2 = new PilaConEnlaces<Position<Character>>();
		
		PositionList<Character> camino = new DoubleLinkedList<Character>();
		Position<Character> aux = p1;
		
		try {			
			do {
				pila1.push(aux);
				aux = t.parent(aux);
			}while(aux != t.root());

			aux = p2;

			do {
				pila2.push(aux);
				aux = t.parent(aux);
			}while(aux != t.root());

			while(!pila1.isEmpty() && !pila2.isEmpty() && pila1.top() == pila2.top()) {
				aux = pila1.pop();
				pila2.pop();
			}
			camino.addLast(aux.element());
			while(!pila1.isEmpty()) {
				camino.addLast(pila1.pop().element());
			}
			while(!pila2.isEmpty()) {
				camino.addFirst(pila2.pop().element());
			}
		}catch(EmptyStackException | InvalidPositionException | BoundaryViolationException | EmptyTreeException e) {
			e.printStackTrace();
		}

		return camino;
	}
}
