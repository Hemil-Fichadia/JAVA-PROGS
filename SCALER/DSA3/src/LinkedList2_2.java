import java.util.*;
import java.lang.*;

/*The class is declared in LinkedList1 file, it will be recognized all over files of DSA3 project and
still if you want, declare it inside the main class, so it becomes static now but the program won't be
affected.
*/

class LinkedList2_2 {

    //The LinkedList basic building block.
//    static class ListNode{
//        int data;
//        ListNode next;
//        ListNode(int x){
//            data = x;
//            next = null;
//        }
//    }
    static void printLinkedList(ListNode head){
        if(head == null){
            System.out.println("LinkedList empty");
            return;
        }
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    static ListNode reverseLinkedList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode reverseHead = null;
        ListNode temp = head;
        while(head != null){
            head = head.next;
            temp.next = reverseHead;
            reverseHead = temp;
            temp = head;
        }
        return reverseHead;
    }

    static ListNode findIntersection(ListNode headA, ListNode headB){
        if(headA == null){
            return null;
        }
        if(headB == null){
            return null;
        }
        ListNode end = headA;
        while(end.next != null){
            end = end.next;
        }
        //establishing cycle
        end.next = headB;
        boolean isCycle = false;
        ListNode slow = headA;
        ListNode fast = headA;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        if(isCycle){
            ListNode p1 = headA;
            ListNode p2 = slow;
            while(p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            end.next = null;
            return p1;
        }
        return null;
    }

    static boolean checkPalindrome(ListNode head){
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        ListNode temp = head;
        while(temp != null){
            int num = temp.data;
            if(freqMap.containsKey(num)){
                int value = freqMap.get(num);
                freqMap.put(num, value+1);
            }
            else{
                freqMap.put(num, 1);
            }
            temp = temp.next;
        }
        int odd = 0;
        for(int num : freqMap.keySet()){
            int freq = freqMap.get(num);
            System.out.println(num+" "+freq);
            if(freq % 2 != 0){
                odd++;
            }
        }
        if(odd > 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        //******************************************************************************
        //Intersection of linked lists
        /* Here is what the intersection looks like 
            
                    1 -> 2 -> 3 -> 4 -> 5
                                        |
                                        v
                                        10 -> 11 -> 12 -> 13
                                        ^
                                        |
                         6 -> 7 -> 8 -> 9 
        So we have to find that intersection point where two lists are meeting each other and
        for that there is a simple idea connect the main end of the intersected list to the another
        head here it is like 13 is connected to 6 so it will form a cycle and now apply the logic
        of cycle detection and then initialize a pointer p2 at s==f point and pointer p1 at head
        now iterate forward and the point at which they meet will be the intersection point of both
        list and return that node.
        */
//        int[] A = {1, 2, 3, 4, 5, 10, 11, 12, 13};
//        ListNode headA = new ListNode(A[0]);
//        ListNode temp = headA;
//        ListNode intersection = null;
//        int count = 1;
//        for(int i = 1; i < A.length; i++){
//            temp.next = new ListNode(A[i]);
//            temp = temp.next;
//            count++;
//            if(count == 6){
//                intersection = temp;
//            }
//        }
//        int[] B = {6, 7, 8, 9};
//        ListNode headB = new ListNode(B[0]);
//        temp = headB;
//        for(int i = 1; i < B.length; i++){
//            temp.next = new ListNode(B[i]);
//            temp = temp.next;
//        }
//        //comment this line to avoid intersection
//        temp.next = intersection;
//
//        //Testing intersection is established or not
//        // ListNode temp1 = headA;
//        // ListNode temp2 = headB;
//        // while(temp1 != null){
//        //     System.out.println(temp1.data);
//        //     temp1 = temp1.next;
//        // }
//        // System.out.println();
//        // while(temp2 != null){
//        //     System.out.println(temp2.data);
//        //     temp2 = temp2.next;
//        // }
//        ListNode ansNode = findIntersection(headA, headB);
//        if(ansNode != null){
//            System.out.println("Intersection node : "+ansNode.data);
//        }
//        else{
//            System.out.println("No Intersection");
//        }

        //*******************************************************************************
        //Q1 Palindrome list
        /* We have to check whether the given linked list is palindrome or not. A simple idea
        is of counting the elements with odd frequency if that exceeds 1 that means it is not
        palindrome.
        */
        int[] A = {1, 2, 3, 2, 1};
        ListNode head = new ListNode(A[0]);
        ListNode temp = head;
        for(int i = 1; i < A.length; i++){
            temp.next = new ListNode(A[i]);
            temp = temp.next;
        }
        System.out.println(checkPalindrome(head));
    }
}