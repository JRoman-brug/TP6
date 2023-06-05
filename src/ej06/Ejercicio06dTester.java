package ej06;

import exception.*;
import TDAArbol.InvalidOperationException;
import TDAArbol.Tree;
import ej05.ArbolImprimirNiveles;
import position.Position;

public class Ejercicio06dTester {
	public static void main(String[] args) {
		Ejercicio06d<Character> tr = new Ejercicio06d<Character>();

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
			d = tr.addLastChild(a, 'b');

			h = tr.addLastChild(b,'h');
			f = tr.addLastChild(b,'b');

			k = tr.addLastChild(h,'k');
			g = tr.addLastChild(h,'b');

			e = tr.addLastChild(c,'b');

			l = tr.addLastChild(d,'b');
			z = tr.addLastChild(d,'z');

			m = tr.addLastChild(l,'b');
			p = tr.addLastChild(m,'b');
			
			for(Character elem:tr) {
				System.out.println(elem);
			}
			
			System.out.println();
			tr.eliminarNodo('b');
			
			for(Character elem:tr) {
				System.out.println(elem);
			}
			
		} catch (InvalidOperationException | EmptyTreeException | InvalidPositionException e2) {

			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}


}
