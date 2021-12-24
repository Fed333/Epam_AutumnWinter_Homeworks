package com.company.collection;

import java.util.*;

public class NotRemovableArrayList<E> implements Iterable<E>, List<E> {

    private static final String EXCEPTION_REMOVE_MESSAGE = "removing isn't supported in NotRemovableArrayList collection";
    private int capacity = 10;
    private int size = 0;


    private Object[] array = new Object[capacity];

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl(0);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }

    @Override
    public boolean remove(Object o) throws UnsupportedOperationException{
        throw new UnsupportedOperationException(EXCEPTION_REMOVE_MESSAGE);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        requireIndexInSizeRange(index);
        return (E)array[index];
    }

    private void requireIndexInSizeRange(int index) {
        if (index >= size){
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        if (++size >= capacity){
            array = grow();
        }
        shift(index);
        array[index] = element;
    }

    private void shift(int index){
        requireIndexInSizeRange(index);
        for (int i = size; i > index ; i--) {
            array[i] = array[i-1];
        }
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException(EXCEPTION_REMOVE_MESSAGE);
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


    private Object[] grow(){
        capacity *= 1.5;
        return Arrays.copyOf(array, capacity);
    }

    private class IteratorImpl implements Iterator<E>{

        private int index;

        public IteratorImpl(int index) {
            if (index > size){
                throw new IndexOutOfBoundsException();
            }
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return (E)array[index++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (E el:this) {
            joiner.add(el.toString());
        }
        return joiner.toString();
    }
}
