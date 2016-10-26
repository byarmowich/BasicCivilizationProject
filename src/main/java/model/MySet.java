package model;

public class MySet<E> implements SimpleSet<E> {
    private E[] items = (E[]) new Object[0];
    private int itemCount;

    public MySet() {
        itemCount = 0;
    }
/**
     * Adds the passed in element to the set.
     * @param e the element to be added to the set
     */
    public boolean add(E e) {
        itemCount += 1;
        items = incrementSize();
        items[itemCount - 1] = e;
        return true;
    }

    private E[] incrementSize() {
        E[] moreItems = (E[]) new Object[itemCount];
        for (int i = 0; i < items.length; i++) {
            moreItems[i] = items[i];
        }
        return moreItems;

    }

    /**
     * Removes the passed in element from the set if it is
     * contained in the set, then returns the removed element
     * otherwise throws as ElementDoesNotExistException
     * @param e the element to be removed
     * @return E the element that was removed
     */
    public E remove(E e) throws ElementDoesNotExistException {
        int marker = 0;
        if (!(this.contains(e))) {
            throw new ElementDoesNotExistException("screaming", e);
        }
        for (int i = 0; i < itemCount; i++) {
            if (items[i].equals(e)) {
                marker = i;
            }
        }
        items[marker] = items[itemCount - 1];
        itemCount -= 1;
        items = decrementItems();
        return e;
    }

    private E[] decrementItems() {
        E[] lessItems = (E[]) new Object[itemCount];
        for (int i = 0; i < itemCount; i++) {
            lessItems[i] = items[i];
        }
        return lessItems;
    }
    /**
     * Returns true if the passed in element is contained in
     * the set.
     * Returns false if the passed in element is not contained
     * in the set.
     * @param e the element to be checked
     * @return whether the passed in element is contained
     * in the set
     */
    public boolean contains(E e) {
        for (E lookAt : items) {
            if (lookAt.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * removes all the passed in elements from the set then returns them
     * throws a ElementDoesNotExistException if one of the passed in elements
     * is not in the set.
     * NOTE: this method should not remove ANY elements from the set
     * if it throws a ElementDoesNotExistException
     * @param e the elements to be removed from the set
     * @return E[] the elements that were removed from the set
     */
    public E[] removeAll(E[] e) throws ElementDoesNotExistException {
        for (int i = 0; i < e.length - 1; i++) {
            if (contains(e[i])) {
                throw new ElementDoesNotExistException("screaming", e[i]);
            }
        }
        for (int i = 0; i < e.length - 1; i++) {
            remove(e[i]);
        }
        return e;
    }

    /**
     * Removes all elements from the set.
     */
    public void clear() {
        E[] newitems = (E[]) new Object[0];
        this.items = newitems;
        itemCount = 0;
    }

    /**
     * Returns the number of elements contained in the set.
     * @return int the number of elements in the set
     */
    public int size() {
        return itemCount;
    }

    /**
     * Returns false if the set contains 1 or more elements and
     * returns true if the set contains no elements.
     * @return boolean whether the set contains any elements
     */
    public boolean isEmpty() {
        return (itemCount == 0);
    }

    /**
     * Returns a random element from the set.
     * NOTE: because the set has no ordering returning any element in the
     * set is effectively returning a "random" element
     * throws a ElementDoesNotExistException if there are no elements
     * in the set
     * HINT: you may import java.util.Random to help with this if
     * you want
     * @return E a random element from the set
     */
    public E getRandomElement() throws ElementDoesNotExistException {
        if (itemCount == 0) {
            throw new ElementDoesNotExistException("screaming");
        }
        return items[(int) (Math.random() * itemCount)];
    }

    /**
     * Returns an array of all the elements contained within the SimpleSet.
     * There should be no nulls in the array.
     * @return an array containing all the elements contained
     * within the set
     */
    public E[] toArray() {
        return items;
    }

    /**
     * Calculates and returns a String representation of this object.
     * Any String that shows each individual element's toString
     * is acceptable.
     * @return String the String representation of this object
     */
    @Override
    public String toString() {
        String arrayWords = "";
        for (int i = 0; i < itemCount - 1; i++) {
            arrayWords = items[i] + ", ";
        }
        return arrayWords;
    }

}