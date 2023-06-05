package ej06;

import TDAArbol.InvalidOperationException;
import TDAArbol.Tree;
import ej05.ArbolImprimirNiveles;
import exception.EmptyTreeException;
import exception.InvalidPositionException;
import position.Position;

public class Ejericicio06hTester {

	public static void main(String[] args) {
		Ejercicio06h<Character> tr = new Ejercicio06h<Character>();

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
			System.out.println(tr.alturaRotulo(a.element())+" Resultado esperado (4)");
			System.out.println(tr.alturaRotulo(b.element())+" Resultado esperado (2)");
			System.out.println(tr.alturaRotulo(c.element())+" Resultado esperado (1)");
			System.out.println(tr.alturaRotulo(d.element())+" Resultado esperado (3)");
			System.out.println(tr.alturaRotulo(h.element())+" Resultado esperado (1)");
			System.out.println(tr.alturaRotulo(f.element())+" Resultado esperado (0)");
			System.out.println(tr.alturaRotulo(e.element())+" Resultado esperado (0)");
			System.out.println(tr.alturaRotulo(l.element())+" Resultado esperado (2)");
			System.out.println(tr.alturaRotulo(z.element())+" Resultado esperado (0)");
			System.out.println(tr.alturaRotulo(k.element())+" Resultado esperado (0)");
			System.out.println(tr.alturaRotulo(g.element())+" Resultado esperado (0)");
			System.out.println(tr.alturaRotulo(m.element())+" Resultado esperado (1)");
			System.out.println(tr.alturaRotulo(p.element())+" Resultado esperado (0)");
			
			
			
			
			
		} catch (InvalidOperationException | EmptyTreeException | InvalidPositionException e2) {

			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}
