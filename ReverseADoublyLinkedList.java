/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{

    static int len(Node head) {
        Node cursor = head;
        int len = 0;
        while(cursor != null) {
            len++;
            cursor = cursor.next;
        }
        return len;
    }

    static Node findTail(Node head) {
        Node cursor = head;
        while(cursor.next != null) cursor = cursor.next;
        return cursor;
    }

    public static Node reverseDLL(Node head)
    {
        Node headRef = head;
        Node tail = findTail(head);
        int mid = (int)Math.ceil(len(head) / 2);
        int index = 0;
        while (index < mid) {
            int temp = head.data;
            head.data = tail.data;
            tail.data = temp;
            head = head.next;
            tail = tail.prev;
            index++;
        }

        return headRef;
    }
}
