package ej06;

import TDAArbol.InvalidOperationException;
import TDAArbol.Tree;
import ej05.ArbolImprimirNiveles;
import exception.BoundaryViolationException;
import exception.EmptyTreeException;
import exception.InvalidPositionException;
import position.Position;

public class Ejercicio06g {
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

			System.out.println(profundidad(a,tr)+" Resultado esperado (0)");
			System.out.println(profundidad(b,tr)+" Resultado esperado (1)");
			System.out.println(profundidad(c,tr)+" Resultado esperado (1)");
			System.out.println(profundidad(d,tr)+" Resultado esperado (1)");
			System.out.println(profundidad(h,tr)+" Resultado esperado (2)");
			System.out.println(profundidad(f,tr)+" Resultado esperado (2)");
			System.out.println(profundidad(e,tr)+" Resultado esperado (2)");
			System.out.println(profundidad(l,tr)+" Resultado esperado (2)");
			System.out.println(profundidad(z,tr)+" Resultado esperado (2)");
			System.out.println(profundidad(k,tr)+" Resultado esperado (3)");
			System.out.println(profundidad(g,tr)+" Resultado esperado (3)");
			System.out.println(profundidad(m,tr)+" Resultado esperado (3)");
			System.out.println(profundidad(p,tr)+" Resultado esperado (4)");
			
			
			
			
			
		} catch (InvalidOperationException | EmptyTreeException | InvalidPositionException e2) {

			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	
	public static <E> int profundidad(Position<E> N, Tree<E> A) {
		return profundidadRec(N,N,A);
	}
	private static <E> int profundidadRec(Position<E> N, Position<E> pos, Tree<E> A) {
		int profundidad = 0;
		try {
			if(pos == N) {
				Position<E> aux = pos;
				while(aux != A.root()) {
					profundidad++;
					aux = A.parent(aux);
				}
			}else {
				for(Position<E> hijo:A.children(pos)) {
					profundidad = profundidadRec(N,hijo,A);
				}
			}
		}catch(InvalidPositionException | EmptyTreeException | BoundaryViolationException e) {
			e.printStackTrace();
		}
		return profundidad;
	}
}
