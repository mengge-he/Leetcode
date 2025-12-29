//You are given two non-empty linked lists representing two non-negative integers. Each digit is stored in reverse order, and each node contains only one digit.
//
//Add the two numbers and return a linked list representing the sum in the same form. You may assume that neither number starts with 0, except for the number 0 itself.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class addTwoNumbers {


    public ListNode  addTwoNumber(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {

    }
}
