package model;

public interface Iterator<E> {
	E next();
	boolean hasNext();
	boolean remove();
}