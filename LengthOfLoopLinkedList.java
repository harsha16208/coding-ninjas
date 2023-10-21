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

import java.util.*;

public class Solution
{

    static Node findEntry(Node head) {
        if (head != null){
        Node fast = head;
                Node slow = head;
                boolean hasCycle = false;

                while (fast.next != null && fast.next.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                    if (fast == slow) {
                        hasCycle = true;
                        break;
                    }
                }

                if (hasCycle) {
                    slow = head;
                    while (slow!=fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow;
                }
        }
        
        return null;
    }

    public static int lengthOfLoop(Node head) {
        // Write your code here
        /**
        * Find entry point of the loop and count
        */
        Node entry = findEntry(head);
        if (entry != null) {
            int len = 0;
            Set<Node> set = new HashSet<>();
            Node cursor = entry;
            while(set.add(cursor)) {
                cursor = cursor.next;
                len++;
            }
            return len;
        }
        return 0;
    }
}
