//given:2-1-3-4
//return:1-2-4-3

public class swapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;


        while(current.next!=null&&current.next.next!=null){
            ListNode first=current.next;
            ListNode second=current.next.next;

            //swap
            //current->second->first
            first.next=second.next;
            second.next=first;
            current.next=second;

            //move pointer forward
            current=first;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = swapPairs(head);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
