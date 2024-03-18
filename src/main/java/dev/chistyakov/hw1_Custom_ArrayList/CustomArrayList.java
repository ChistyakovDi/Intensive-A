package dev.chistyakov.hw1_Custom_ArrayList;

import java.util.Collection;
import java.util.Comparator;

public class CustomArrayList<E>  implements CustomList<E>{
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Метод добавления элемента по индексу
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Метод добавления всех элементов коллекции в список
    public void addAll(Collection<? extends E> c) {
        for (E element : c) {
            add(size, element);
        }
    }

    // Метод очистки списка
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Метод получения элемента по индексу
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    // Метод проверки списка на пустоту
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод удаления элемента по индексу
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    // Метод удаления элемента по значению
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    // Метод сортировки списка
    public void sort(Comparator<? super E> c) {
        mergeSort(0, size - 1, c);
    }

    // Приватный вспомогательный метод для реализации сортировки слиянием
    private void mergeSort(int low, int high, Comparator<? super E> c) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid, c);
            mergeSort(mid + 1, high, c);
            merge(low, mid, high, c);
        }
    }

    // Приватный вспомогательный метод для слияния отсортированных частей списка
    private void merge(int low, int mid, int high, Comparator<? super E> c) {
        Object[] temp = new Object[size];
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (c.compare((E) elements[i], (E) elements[j]) <= 0) {
                temp[k++] = elements[i++];
            } else {
                temp[k++] = elements[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = elements[i++];
        }
        while (j <= high) {
            temp[k++] = elements[j++];
        }
        for (k = low; k <= high; k++) {
            elements[k] = temp[k];
        }
    }

    // Приватный метод для увеличения емкости списка при необходимости
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    public int size() {
        return size;
    }
}
