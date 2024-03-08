/********************************************************************

 Following is the class structure of the Node class:

 class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;

     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 };

 ********************************************************************/
import java.util.*;
public class Solution {

    static boolean isLeaf(BinaryTreeNode root) {
        if (root.left == null && root.right == null) return true;
        return false;
    }

    static void dfs(BinaryTreeNode root, List<Integer> nodes, List<String> res) {
        if (root == null) return;
        nodes.add(root.data);

        if (isLeaf(root)) {
            String path = "";
            for (int i = 0; i < nodes.size(); i++) {
                if (i == nodes.size() - 1) {
                    path += nodes.get(i);
                } else {
                    path += nodes.get(i) + " ";
                }
            }
            res.add(path);
        } else {
            dfs(root.left, nodes, res);
            dfs(root.right, nodes, res);
        }
        nodes.remove(nodes.size() - 1);
    }

    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
        List<String> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res);
        return res;
    }
}
