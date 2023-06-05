package ej04;

import static org.junit.Assert.*;

import org.junit.Test;

import TDAArbol.*;
import ej03.LinkedTree;
import exception.*;
import position.Position;

public class CloneTest {

	@Test
	public void test() {
		ArbolClone<Integer> tr1 = new ArbolClone<Integer>(); 
		Tree<Integer> tr2 = null; 
		Position<Integer> padre;
		Position<Integer> aux;
		try {
			
			tr1.createRoot(1);
			padre = (TNode<Integer>) tr1.root();
			
			tr1.addLastChild(padre, 2);
			aux = tr1.addLastChild(padre, 3);
			tr1.addLastChild(padre, 4);
			
			tr1.addLastChild(aux, 5);
			tr1.addLastChild(aux, 6);
			
			
			tr2 = tr1.clone();
		}catch(  InvalidOperationException | EmptyTreeException | InvalidPositionException e) {
			e.printStackTrace();
		}
		for(Integer elem:tr1) {
			System.out.println(elem+"\n");
		}
		System.out.println("---------------\n");
		for(Integer elem:tr2) {
			System.out.println(elem+"\n");
		}
		
	}

}
