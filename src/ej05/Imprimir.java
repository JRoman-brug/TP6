package ej05;

import TDAArbol.InvalidOperationException;
import TDAArbol.TNode;
import TDAArbol.Tree;
import exception.EmptyTreeException;
import exception.InvalidPositionException;
import position.Position;

public class Imprimir {

	public static void main(String[] args) {
		ArbolImprimirNiveles<Character> tr = new ArbolImprimirNiveles<Character>();

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
			
			tr.iroden();
//			
//			((ArbolImprimirNiveles<Character>) tr).printLeves();
		} catch (InvalidOperationException | EmptyTreeException | InvalidPositionException e2) {
			
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}

}
