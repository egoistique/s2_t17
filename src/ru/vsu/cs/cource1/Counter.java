package ru.vsu.cs.cource1;

public class Counter {
    static SimpleLinkedList<Integer> list1 = new SimpleLinkedList<>();
    private static SimpleLinkedList.SimpleLinkedListNode head = null;  // first, top
    private static SimpleLinkedList.SimpleLinkedListNode tail = null;

    private class SimpleLinkedListNode {
        public int value;
        public SimpleLinkedList.SimpleLinkedListNode next;

        public SimpleLinkedListNode(int value, SimpleLinkedList.SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(int value) {
            this(value, null);
        }
    }

//    public static SimpleLinkedList fillingInTheList(int n){
//        list1.addFirst(1);
//        for (int i = 1; i < n; i++){
//            if (list1.size == 0) {
//                head = tail = new SimpleLinkedList.SimpleLinkedListNode(i + 1);
//            } else {
//                tail.next = new SimpleLinkedList.SimpleLinkedListNode(i + 1);
//                tail = tail.next;
//            }
////            list1.addLast(i + 1);
//
//            tail = head;
//        }
////        tail = head;
//        System.out.println(head.value + " " + tail.value);
//        return list1;
//    }

//    public static int search(int k, SimpleLinkedList list) throws SimpleLinkedList.SimpleLinkedListException {
//
//        while (list.size() > 1){
//            SimpleLinkedList.SimpleLinkedListNode curr = head;
//            for (int i = 0; i <= k; i++) {
//                if (curr != null) {
//                    curr = curr.next;
//                } else curr = head;
//                if (i == k) {
//                    int index = (int) curr.value;
//                    list.remove(index);
////                    if (list.size() == 1) {
////                        return (int) head.value;
////                    }
//                    break;
//                }
//            }
//        }
//        return (int) head.value;
//    }
}










