import java.util.*;
import java.lang.*;

/*The class is declared in LinkedList1 file, it will be recognized all over files of DSA3 project and
still if you want, declare it inside the main class, so it becomes static now but the program won't be
affected.
*/

class LinkedList2_1 {
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

    static ListNode mergerTwoSortedLists(ListNode head1, ListNode head2){
        ListNode head = null;
        ListNode temp = null;
        if(head1.data < head2.data){
            head = head1;
            temp = head1;
            head1 = head1.next;
        }
        else{
            head = head2;
            temp = head2;
            head2 = head2.next;
        }

        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        if(head1 != null){
            temp.next = head1;
        }
        else{
            temp.next = head2;
        }
        return head;
    }

    static ListNode rearrange(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        ListNode reverseHead = reverseLinkedList(head2);
        ListNode forwardHead = head;

        ListNode temp = forwardHead; //Inintialize temp to forwardHead
        while(forwardHead != null && reverseHead != null){
            forwardHead = forwardHead.next; //Move forwardHead one step ahead
            temp.next = reverseHead; //point temp block to reverseHead
            reverseHead = reverseHead.next; //move reverseHead one step ahead
            temp = temp.next; //move temp to its next block
            temp.next = forwardHead; //point temp next to current forwardHead
            temp = temp.next; // move temp to next point
        }

        return head;
    }

    static ListNode breakCycle(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        if(isCycle){
            ListNode p2 = slow;
            ListNode p1 = head;
            while(p2.next != p1){
                p1 = p1.next;
                if(p2.next == p1){
                    break;
                }
                p2 = p2.next;
            }

            p2.next = null;
        }
        return head;
    }

    public static void main(String[] args) {

        //********************************************************************************
        //Q1 Merge two sorted LinkedLists
        /* Here we have to merger two given LinkedLists into single sorted one so we can use
        the logic of two pointers that we used in merge sort. The smallest element among them
        at start will be our main head and head1 and head2 will be of two lists and we will
        use another temp variable which will keep track of the latest node attached to the main
        list head.
        */
        // int[] A = {1, 3, 5, 7, 9};
        // ListNode head1 = new ListNode(A[0]);
        // ListNode temp = head1;
        // for(int i = 1; i < A.length; i++){
        //     temp.next = new ListNode(A[i]);
        //     temp = temp.next;
        // }
        // int[] B = {2, 4, 6, 8, 10};
        // ListNode head2 = new ListNode(B[0]);
        // temp = head2;
        // for(int i = 1; i < B.length; i++){
        //     temp.next = new ListNode(B[i]);
        //     temp = temp.next;
        // }
        // ListNode ansHead = mergerTwoSortedLists(head1, head2);
        // printLinkedList(ansHead);

        //*******************************************************************************
        //Q2 Reorder List
        /* Here we have to reorder the given list. If it is given like this
        1->2->3->4->5->6->-7>8 ----------> 1->8->2->7->3->6->4->5 so it is like connecting first
        and last then 2nd and second last in the same way. Now here is problem like we cannot use
        two pointers logic of moving pointers close to centere while starting from extreme edges
        as we can go forward in terms of p1 but we cannot go in back direction as the nodes are
        connected in forward direction. Now here comes a unique idea of achieveing the arrangement
        first find the center of the list using fast and slow pointer then split list into two halves
        one from start to center and other from mid+1 to end now reverse the later part so the
        result would be like this 1->2->3->4  8->7->6->5 now connect 1 to 8 2 to 7 and so on this
        will generate the desired result. In order to achieve it first usnig slow and fast pointer
        slow will be the mid now make node head2 as slow.next as the starting of the next half and
        detach it from slow by making slow.next=null now reverse the head2 and store the reverse
        list head in reverseHead node and make forwardHead=head in order to preserve the main head
        of the list now make a temp node that will hold the value of the latest node in rearrangment
        now assign temp to forwardHead before iterating now move forwardHead ahead then point temp
        block to reverseHead move reverseHead ahead take temp to next block now again point temp
        to forwardHead take temp to next block repeat this steps and return head.
        */
        // int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        // ListNode head = new ListNode(A[0]);
        // ListNode temp = head;
        // for(int i = 1; i < A.length; i++){
        //     temp.next = new ListNode(A[i]);
        //     temp = temp.next;
        // }
        // ListNode ansHead = rearrange(head);
        // printLinkedList(ansHead);

        //************************************************************************************
        //Remove loop from LinkedList
        /* This is what a cycle looks like in linked list the only thing we have is start

             1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 ---> 9
                                      ^                |
                                      |                v
                                      15               10
                                      ^                |
                                      |                v
                                      14<- 13 <- 12 <- 11
        the end of the list is connected to some intermediate node so there is no end actually,
        and we have to detach the intermediate connection of the last node and return head, so
        it is a bit trickier problem.
        First we have to use slow and fast pointer to detect if there is cycle or not like if the
        slow and fast meet at some point there exist a cycle now initialize pointer p2 at s=f point
        and initialize p1 at head now increase p1 and p2 till they meet at a point and the point would
        be that intermediate now initialize a temp at s=f now iterate till temp.next = p1 and
        at the end make temp.next = null return head.
        */
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int count = 1;
        ListNode head = new ListNode(A[0]);
        ListNode temp = head;
        ListNode intermediate = null;
        for(int i = 1; i < A.length; i++){
            temp.next = new ListNode(A[i]);
            temp = temp.next;
            count++;
            if(count == 6){
                intermediate = temp;
            }
        }
        temp.next = intermediate;
        //To cyclic nature of LinkedList
        // int iterations = 1;
        // ListNode temp1 = head;
        // while(iterations < 26){
        //     System.out.println(temp1.data);
        //     temp1 = temp1.next;
        //     iterations++;
        // }
        ListNode flatList = breakCycle(head);
        printLinkedList(flatList);
    }
}