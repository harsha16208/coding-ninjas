import java.util.* ;
import java.io.*; 

class Node {
  Node[] nodes;
  boolean flag;

  public Node() {
    nodes = new Node[26];
  }

  boolean contains(char ch) {
    return nodes[ch - 'a'] != null;
  }

  void put(char ch) {
    nodes[ch - 'a'] = new Node();
  }

  Node get(char ch) {
    return nodes[ch - 'a'];
  }

  void setFlag() {
    flag = true;
  }

  boolean getFlag() {
    return flag;
  }
}

class Trie {
  Node root;

  public Trie() {
    root = new Node();
  }

  void insert(String word) {
    Node cursor = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!cursor.contains(ch)) {
        cursor.put(ch);
      }
      cursor = cursor.get(ch);
    }
    cursor.setFlag();
  }

  boolean search(String word) {
    Node cursor = root;
    boolean flag = true;
    for (int i = 0; i < word.length() && flag; i++) {
      char ch = word.charAt(i);
      if (cursor.contains(ch)) {
        cursor = cursor.get(ch);
        flag = cursor.getFlag();
      } else {
        return false;
      }
    }
    return flag;
  }

  boolean checkIfPrefixExists(String word) {
    Node cursor = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!cursor.contains(ch)) return false;
      cursor = cursor.get(ch);
      if (!cursor.getFlag()) return false;
    }
    return cursor.getFlag();
  }
}

class Solution {

  public static String completeString(int n, String[] a) {
    // Write your code here.
    Trie trie = new Trie();
    for (String w : a) {
      trie.insert(w);
    }

    String longest = "";
    for (String w : a) {
      boolean prefixExists = trie.checkIfPrefixExists(w);
      if (prefixExists) {
        if (w.length() > longest.length())
          longest = w;
        else if (w.length() == longest.length() && w.compareTo(longest) < 0) {
          longest = w;
        }
      }
    }
    return longest.length() == 0 ? "None" : longest;
  }
}
