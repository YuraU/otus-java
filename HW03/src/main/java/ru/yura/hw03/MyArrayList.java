package ru.yura.hw03;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E> {

    private static final int defaultSize = 10;
    private static final int delta = 2;

    private int size;
    private Object[] list;

    public MyArrayList() {
        this(defaultSize);
        size = 0;
    }

    public MyArrayList(int size) {
        list = new Object[size];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    public Iterator<E> iterator() {
        return new MyListIterator(this);
    }

    public Object[] toArray() {
        if (list.length == size - 1) {
            return list;
        }

        Object[] objects = new Object[size];
        System.arraycopy(list, 0, objects, 0, size);

        return objects;
    }

    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    public boolean add(E e) {
        if (list.length == size) {
            expandArray();
        }
        list[size] = e;
        size++;
        return true;
    }

    private void expandArray() {
        Object[] list_new = new Object[size * delta];
        System.arraycopy(list, 0, list_new, 0, size);
        list = list_new;
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] objects = c.toArray();
        if (size + objects.length >= list.length) {
            Object[] new_list = new Object[list.length + (objects.length / defaultSize  + 1) * defaultSize];
            System.arraycopy(list, 0, new_list, 0, list.length);
            System.arraycopy(objects, 0, new_list, size, objects.length);
            list = new_list;
            size = size + objects.length;
        } else {
            System.arraycopy(objects, 0, list, size, objects.length);
        }

        return true;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        list = new Object[defaultSize];
    }

    public E get(int index) {
        return (E) list[index];
    }

    public E set(int index, E element) {
        list[index] = element;
        return element;
    }

    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public E remove(int index) {
        E element = get(index);

        System.arraycopy(list, index+1, list, index, size-index-1);
        size--;
        list[size] = null;

        return element;
    }

    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<E> listIterator() {
        return new MyListIterator(this);
    }

    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private class MyListIterator implements ListIterator<E> {

        private MyArrayList<E> list;
        private int index;

        public MyListIterator(MyArrayList list) {
            this.list = list;
            index = -1;
        }

        public boolean hasNext() {
            if (list.size() > index + 1) {
                return true;
            }

            return false;
        }

        public E next() {
            return list.get(++index);
        }

        public boolean hasPrevious() {
            if (index == 0) {
                return false;
            }
            return true;
        }

        public E previous() {
            return list.get(--index);
        }

        public int nextIndex() {
            return index + 1;
        }

        public int previousIndex() {
            if (index == 0 || index == -1) {
                return -1;
            }
            return index - 1;
        }

        public void remove() {
            list.remove(index);
        }

        public void set(E e) {
            list.set(index, e);
        }

        public void add(E e) {
            list.add(e);
        }
    }
}
