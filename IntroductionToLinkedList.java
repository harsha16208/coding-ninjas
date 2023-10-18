/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };

 *****************************************************************/

public class Solution {
    public static Node constructLL(int []arr) {
        // Write your code here
        Node head = null;
        Node curr = null;
        for (Integer i : arr) {
            if (head == null) {
                head = new Node(i);
                curr = head;
            } else {
                curr.next = new Node(i);
                curr = curr.next;
            }
            
        }
        
        return head;
    }
}
