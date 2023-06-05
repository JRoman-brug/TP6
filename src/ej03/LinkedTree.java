package ej03;

import java.util.Iterator;

import TDAArbol.InvalidOperationException;
import TDAArbol.TNode;
import TDAArbol.Tree;
import TDALista.PositionList;
import exception.*;
import listaDE.DoubleLinkedList;
import position.Position;

public class LinkedTree<E> implements Tree<E>{

	protected int size;
	protected TNode<E> raiz;

	public LinkedTree() {
		size = 0;
		raiz = null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Iterator<E> iterator() {
		PositionList<E> lista = new DoubleLinkedList<E>();
		if(size>0) {			
			recPreOrden(raiz,lista);
		}
		return lista.iterator();
	}

	private void recPreOrden(TNode<E> p, PositionList<E> lista) {
		lista.addLast(p.element());
		for(TNode<E> elem:p.getHijos()) {
			recPreOrden(elem,lista);
		}
	}

	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> list = new DoubleLinkedList<Position<E>>();
		if(size>0)
			recPreOrdenPos(raiz,list);

		return list;
	}
	private void recPreOrdenPos(TNode<E> r, PositionList<Position<E>> l) {
		l.addLast(r);
		for(TNode<E> p:r.getHijos())
			recPreOrdenPos(p,l);
	}
	public E replace(Position<E> v, E e) throws InvalidPositionException {
		E toReturn = null;
		TNode<E> aux = checkPosition(v);
		toReturn = aux.element();
		aux.setElement(e);
		return toReturn;
	}

	public Position<E> root() throws EmptyTreeException {
		if(isEmpty()) throw new EmptyTreeException("Arbol vacio");
		return raiz;
	}

	//No tiene errores de momento 
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		//InvalidPositionException
		TNode<E>aux = checkPosition(v);
		if(aux == raiz) throw new BoundaryViolationException("Queres acceder al padre del nodo raiz");

		return aux.getPadre();
	}
	//Ni este
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
		//InvalidPositonException
		TNode<E> aux = checkPosition(v);
		//Consultar
		PositionList<Position<E>> toReturn = new DoubleLinkedList<Position<E>>();
		for(TNode<E> elem:aux.getHijos()) {
			toReturn.addLast(elem);
		}
		return  toReturn;
	}

	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		//InvalidPositionException
		TNode<E> aux = checkPosition(v);

		//Un nodo es interno si tiene uno o mas hijos
		return aux.getHijos().size() >=1;
	}

	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		//InvalidPositionException
		TNode<E> aux = checkPosition(v);

		//Un nodo es externo si no tiene hijos
		return aux.getHijos().size() == 0;
	}

	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		TNode<E> aux = checkPosition(v);

		return aux == raiz;
	}

	public void createRoot(E e) throws InvalidOperationException {
		if(raiz != null) throw new InvalidOperationException("Ya existe el nodo raiz");
		size++;
		raiz = new TNode<E>(e);
	}
	//No es este
	public Position<E> addFirstChild(Position<E> p, E e) throws InvalidPositionException {
		TNode<E> toReturn = null;
		//InvalidPositonException
		TNode<E> aux = checkPosition(p);
		if(isEmpty()) throw new InvalidPositionException("Arbol vacio");
		toReturn = new TNode<E>(e,aux);
		aux.getHijos().addFirst(toReturn);
		size++;
		return toReturn;
	}

	//Ni este
	public Position<E> addLastChild(Position<E> p, E e) throws InvalidPositionException {
		TNode<E> toReturn = null;
		//InvalidPositonException
		TNode<E> aux = checkPosition(p);
		if(isEmpty()) throw new InvalidPositionException("Arbol vacio");

		toReturn = new TNode<E>(e,aux);
		aux.getHijos().addLast(toReturn);
		size++;
		return toReturn;
	}


	public Position<E> addBefore(Position<E> p, Position<E> rb, E e) throws InvalidPositionException {
		if(isEmpty()) {
			throw new InvalidPositionException("Arbol vacio.");
		}
		TNode<E> padre = checkPosition(p);
		TNode<E> rigthBro = checkPosition(rb);
		TNode<E> toInsert = new TNode<>(e,padre);

		if(padre != rigthBro.getPadre()) throw new InvalidPositionException("P no es el padre de rb");

		PositionList<TNode<E>> hijos = padre.getHijos();
		boolean encontre = false;
		try {
			if(hijos.isEmpty()) { // si hijos isEmpty es xq rigthBro no es hijo de p
				throw new InvalidPositionException("p no tiene hijos.");
			}
			Position<TNode<E>> pos = hijos.first();
			while (pos != null && !encontre) {
				if(rigthBro == pos.element()) encontre = true;
				else pos = (pos != hijos.last() ? hijos.next(pos) : null);
			}
			if(!encontre) {
				throw new InvalidPositionException("p no es padre de rb");
			}
			hijos.addBefore(pos, toInsert);
			size++;

		} catch (EmptyListException | BoundaryViolationException | InvalidPositionException e1) {
			e1.printStackTrace();
		}

		return toInsert;
	}

	public Position<E> addAfter(Position<E> p, Position<E> lb, E e) throws InvalidPositionException {
		//InvalidPositonException
		//Valido si las posiciones son validas
		TNode<E> nodoPadre = checkPosition(p);
		TNode<E> nodoHermanoIzquierdo = checkPosition(lb);
		TNode<E> toReturn = null;
		
		if(isEmpty()) throw new InvalidPositionException("Arbol vacio");
		
		//Busco el si rb esta en la lista de hijos
		boolean encontre = false;
		Iterator<Position<TNode<E>>> it = nodoPadre.getHijos().positions().iterator();
		Position<TNode<E>> aux = null;

		while(it.hasNext() && !encontre) {
			aux = it.next();
			if(aux.element() == nodoHermanoIzquierdo) {
				encontre = true;
			}
		}
		if(!encontre) throw new InvalidPositionException("P no es padre de lb");
		
		toReturn = new TNode<E>(e,nodoPadre);
		nodoPadre.getHijos().addAfter(aux, toReturn);

		size++;
		return toReturn;
	}
	//Nodos externos no tienen hijos 
	public void removeExternalNode(Position<E> p) throws InvalidPositionException {
		TNode<E> posEliminar = checkPosition(p);

		if(isEmpty()) throw new InvalidPositionException("Arbol vacio");
		if(!isExternal(p)) throw new InvalidPositionException("P no es un nodo externo");

		boolean encontre = false;
		if(posEliminar != raiz) {
			TNode<E> padre = posEliminar.getPadre();
			Position<TNode<E>> posAux = null;

			Iterator<Position<TNode<E>>> it = padre.getHijos().positions().iterator();
			while(it.hasNext() && !encontre) {
				posAux = it.next();
				if(posAux.element() == posEliminar) {
					encontre = true;
				}
			}
			padre.getHijos().remove(posAux);			
		}else {
			raiz = null;
		}
		size--;
	}


	public void removeInternalNodeMati(Position<E>p) throws InvalidPositionException{
		if(isEmpty()) throw new InvalidPositionException("Arbol vacio.");
		TNode<E> toRem = checkPosition(p);
		if( toRem.getHijos().isEmpty() ) throw new InvalidPositionException("p no es un nodo interno");
		TNode<E> padre = toRem.getPadre();
		PositionList<TNode<E>> hermanosP = toRem.getHijos();
		try {
			if(toRem == raiz) {
				if(hermanosP.isEmpty()){
					raiz = null;
				}else {
					if(hermanosP.size() > 1){
						throw new InvalidPositionException("No es posible eliminar el nodo raiz (tiene mas de 1 hijo).");
					}
					TNode<E> hijo = hermanosP.remove(hermanosP.first());
					hijo.setPadre(null);
					raiz = hijo;
				}
			}
			else {
				boolean encontre = false;
				Position<TNode<E>> posP = null; // va a almacenar la posición de n en la lista de hijos de su padre
				Iterable<Position<TNode<E>>> posiciones = hermanosP.positions();
				Iterator<Position<TNode<E>>> it = posiciones.iterator();
				while( it.hasNext() && !encontre ) { // Para cada posición pp de la lista de hijos del padre de n
					posP = it.next(); // Pido la siguiente posición de nodo
					if( posP.element() == toRem ) encontre = true; // Testeo si pp es la posición de n
					System.out.println("hola");
				}
				if(posP == null) {
					throw new InvalidPositionException("P es una posicion invalida.");
				}
				while (!hermanosP.isEmpty()) {
					TNode<E> hijo = hermanosP.remove(hermanosP.first());
					hijo.setPadre(padre);
					hermanosP.addBefore(posP,hijo);
				}
				hermanosP.remove(posP);
			}
			toRem.setPadre(null);
			toRem.setElement(null);
			size--;
		} catch (InvalidPositionException | EmptyListException e) {
			e.printStackTrace();
		}
	}

	public void removeInternalNode(Position<E> p) throws InvalidPositionException {

		TNode<E> posCheck = checkPosition(p);
		TNode<E> aux = null;

		if(!isInternal(posCheck)) throw new InvalidPositionException("No es un nodo interno");
		if(isEmpty()) throw new InvalidPositionException("Queres eliminar un nodo de un arbol vacio"); 
		//Caso que es padre
		if(isRoot(posCheck)) {//raiz == posCheck
			//Caso que es la raiz y tiene un hijo
			if(posCheck.getHijos().size() == 1) {
				try {
					raiz.setElement(null);
					raiz = raiz.getHijos().first().element();	
					posCheck.setPadre(null);
				}catch(EmptyListException e) {
					e.printStackTrace();
				}
				//Caso que no tiene hijo
			}else if(posCheck.getHijos().size() == 0){
				raiz = null;
				//Caso que tiene mas de 1 hijo (error) 	
			}else {
				throw new InvalidPositionException("No se puede eliminar el nodo porque es nodo padre con mas de un hijo");
			}
			//caso que no es padre 
		}else {
			//Busco la posicion
			PositionList<TNode<E>> hijosPadre = posCheck.getPadre().getHijos();
			Position<TNode<E>> posAux = null;
			boolean encontre = false;
			
			//Busco la posicion
			Iterator<Position<TNode<E>>> it = hijosPadre.positions().iterator();
			while(it.hasNext() && !encontre) {
				posAux = it.next();
				if(posAux.element() == posCheck) encontre = true;
			}

			aux = posCheck.getPadre();

			for(TNode<E> elem:posCheck.getHijos()) {
				elem.setPadre(posCheck.getPadre());
				hijosPadre.addBefore(posAux, elem);
			}

			hijosPadre.remove(posAux);
		}
		size--;
	}
	public void removeNode(Position<E> p) throws InvalidPositionException {

		if(isExternal(p)) removeExternalNode(p);
		if(isInternal(p)) removeInternalNode(p);
	}

	//Metodos auxiliares
	protected TNode<E> checkPosition(Position<E> p) throws InvalidPositionException{
		try {
			if(p == null) throw new InvalidPositionException("Posicion NULA");
			if(p.element() == null) throw new InvalidPositionException("Posicion eliminada previamente");

			return (TNode<E>)p;
		}catch(ClassCastException e) {
			throw new InvalidPositionException("p no es un nodo de un arbol");
		}
	}
}
