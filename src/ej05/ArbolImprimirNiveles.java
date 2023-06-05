package ej05;

import java.util.Iterator;

import TDAArbol.TNode;
import TDACola.EmptyQueueException;
import TDACola.Queue;
import TDAPila.Stack;
import arrayQueue.ArrayQueue;
import ej03.LinkedTree;
import exception.EmptyListException;
import exception.EmptyStackException;
import exception.InvalidPositionException;
import pilaEnlazada.PilaConEnlaces;
import position.Position;

public class ArbolImprimirNiveles<E> extends LinkedTree<E>{
	public ArbolImprimirNiveles(){
		super();
	}

	public void printLeves() {
		Queue<TNode<E>> cola = new ArrayQueue<TNode<E>>();
		TNode<E> aux = null;
		try {
			cola.enqueue(raiz);
			cola.enqueue(null);
			while(!cola.isEmpty()) {
				aux = cola.dequeue();
				if(aux != null) {
					System.out.print(aux.element()+"-");

					for(TNode<E> elem: aux.getHijos()) {
						cola.enqueue(elem);
					}
				}else {
					System.out.println();
					if(!cola.isEmpty()) {
						cola.enqueue(null);
					}
				}
			}

		}catch(EmptyQueueException e) {
			e.printStackTrace();
		}
	}
	public void printLevelInversed() {
		Queue<TNode<E>> cola = new ArrayQueue<TNode<E>>();
		Queue<TNode<E>> imprimir = new ArrayQueue<TNode<E>>();
		Stack<TNode<E>> inverso = new PilaConEnlaces<TNode<E>>();

		TNode<E> aux = null;
		try {
			cola.enqueue(raiz);
			cola.enqueue(null);

			imprimir.enqueue(raiz);
			imprimir.enqueue(null);


			while(!cola.isEmpty()) {
				aux = cola.dequeue();
				if(aux != null) {

					for(TNode<E> elem: aux.getHijos()) {
						cola.enqueue(elem);
						imprimir.enqueue(elem);
					}
				}else {
					if(!cola.isEmpty()) {
						cola.enqueue(null);
						imprimir.enqueue(null);
					}
				}
			}

			while(!imprimir.isEmpty()) {
				inverso.push(imprimir.dequeue());				
			}
			while(!inverso.isEmpty()) {
				aux = inverso.pop();
				if(aux!=null) {
					System.out.print(aux.element());
				}else System.out.println();
			}
			

		}catch(EmptyQueueException | EmptyStackException e) {
			e.printStackTrace();
		}

	}
	public void iroden() {
		irodenRec(raiz);
	}
	private void irodenRec(TNode<E> pos) {
		// K H G B F A E C P M L D Z
		try {
			if(isExternal(pos))System.out.print(pos.element()+"-");
			else {
				Iterator<TNode<E>> it = pos.getHijos().iterator();
				TNode<E> w = pos.getHijos().first().element();
				irodenRec(w);
				System.out.print(pos.element()+"-");
				if(it.hasNext()) {
					it.next();
				}
				while(it.hasNext()) {
					w = it.next();
					irodenRec(w);
				}
				
			}
			
		}catch(InvalidPositionException | EmptyListException e) {
			e.printStackTrace();
		}
		
	}
}
