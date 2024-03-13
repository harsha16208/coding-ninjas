import java.util.* ;
import java.io.*; 

class Node {
    Node[] nodes;
    int prefixCount;
    int endCount;

    public Node() {
        nodes = new Node[26];
    }

    boolean contains(char ch) {
        return nodes[ch - 'a'] != null;
    }

    void put(char ch) {
        nodes[ch - 'a'] = new Node();
    }

    void incrPrefix() {
        prefixCount++;
    }

    void incrEnd() {
        endCount++;
    }

    Node get(char ch) {
        return nodes[ch - 'a'];
    }

    void decrPrefix() {
        prefixCount--;
    }

    void decrEnd() {
        endCount--;
    }

    
}

public class Trie {

    Node root;

    public Trie() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node cursor = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cursor.contains(ch)) {
                cursor.put(ch);
            }
            cursor = cursor.get(ch);
            cursor.incrPrefix();
        }
        cursor.incrEnd();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node cursor = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cursor.contains(ch)) return 0;
            cursor = cursor.get(ch);
        }
        return cursor.endCount;
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node cursor = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cursor.contains(ch)) return 0;
            cursor = cursor.get(ch);
        }
        return cursor.prefixCount;
    }

    public void erase(String word) {
        // Write your code here.
        Node cursor = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cursor.contains(ch)) break;
            cursor = cursor.get(ch);
            cursor.decrPrefix();
        }
        cursor.decrEnd();
    }

}
