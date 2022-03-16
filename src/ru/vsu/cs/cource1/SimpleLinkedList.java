package ru.vsu.cs.cource1;

import java.util.Iterator;
//17. Считалочка. N ребят расположены по кругу. (Каждому присвоен номер по порядку).
//Начав отсчѐт от первого, удаляют каждого k-ого, смыкая при этом круг. Определить
//номер последнего, оставшегося в круге. (kN).
//Указание: для решения задачи использовать список, в котором ссылочное поле
//последнего элемента содержит ссылку на первый элемент.
public class SimpleLinkedList<T> implements Iterable<T> {

    public static class SimpleLinkedListException extends Exception {
        public SimpleLinkedListException(String message) {
            super(message);
        }
    }

    class SimpleLinkedListNode {
        public T value;
        public SimpleLinkedListNode next;

        public SimpleLinkedListNode(T value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, null);
        }
    }

    private SimpleLinkedListNode head = null;  // first, top
    private SimpleLinkedListNode tail = null;  // last
    int size = 0;

    //заполнение циклического списка
    public SimpleLinkedList<Integer> fillingInTheList(int size){
        SimpleLinkedList<Integer> list1 = new SimpleLinkedList<>();
        list1.addFirst(1);
        for (int i = 1; i < size; i++){
           list1.addLast(i + 1);
        }
        tail = head;
        return list1;
    }

    //Work
    public int searcher(int k, SimpleLinkedList list) throws SimpleLinkedList.SimpleLinkedListException {
        head = list.head;
        tail = list.tail;
        SimpleLinkedListNode temp = head;
        while (list.size() > 1){
            System.out.println(list.head.value);
            SimpleLinkedListNode curr = head;
            for (int i = 1; i <= k; i++) {
                if (i == k) {
                    list.remove(getIndex((Integer) curr.value, list));
                }
                curr = curr.next;
            }

            for (int i = 0; i < list.size(); i++) {
                System.out.print((i > 0 ? ", " : "") + list.get(i));
            }
            System.out.println();
            temp = curr;
        }

        assert temp != null;
        return (int) temp.value;
    }

    //получение индекса по значению
    public int getIndex(int value, SimpleLinkedList list) throws SimpleLinkedListException {
        for (int i = 0; i < list.size(); i++) {
            if (list.getNodeValue(i) == value){
                return i;
            }
        }
        return 1;
    }

    // O(1)
    public void addFirst(T value) {
        head = new SimpleLinkedListNode(value, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    // O(1)
    public void addLast(T value) {
        if (size == 0) {
            head = tail = new SimpleLinkedListNode(value);
        } else {
            tail.next = new SimpleLinkedListNode(value);
            tail = tail.next;
            tail.next = head;
        }
        size++;
    }

    private void checkEmptyError() throws SimpleLinkedListException {
        if (size == 0) {
            throw new SimpleLinkedListException("Empty list");
        }
    }

    // O(n)
    private SimpleLinkedListNode getNode(int index) {
        SimpleLinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    //получение value по индексу
    private int getNodeValue(int index) {
        SimpleLinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return (int) curr.value;
    }
    // O(1)
    public void removeFirst() throws SimpleLinkedListException {
        checkEmptyError();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
    }

    // O(n)
    public void removeLast() throws SimpleLinkedListException {
        checkEmptyError();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = getNode(size - 2);
            tail.next = null;
        }
        size--;
    }

    // O(n)
    public void remove(int index) throws SimpleLinkedListException {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new SimpleLinkedListException("Incorrect index");
        }
        if (index == 0) {
            removeFirst();
        } else {
            SimpleLinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
        }
    }

    // O(1)
    public int size() {
        return size;
    }

    // O(n)
    public T get(int index) throws SimpleLinkedListException {
        checkEmptyError();
        return getNode(index).value;
    }

    // O(1)
    public T getFirst() throws SimpleLinkedListException {
        checkEmptyError();
        return head.value;
    }

    // O(1)
    public T getLast() throws SimpleLinkedListException {
        checkEmptyError();
        return tail.value;
    }


    @Override
    public Iterator<T> iterator() {
        class SimpleLinkedListIterator implements Iterator<T> {
            SimpleLinkedListNode curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        }

        return new SimpleLinkedListIterator();
    }
}
