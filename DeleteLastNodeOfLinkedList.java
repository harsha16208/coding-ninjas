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
    public static Node deleteLast(Node list){
        // Write your code here
        Node curr = list;
        Node prev = null;
        if (list == null) return null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        if (prev != null) prev.next = null;
        return list;
    }
}
