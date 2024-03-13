
import java.util.ArrayList;

class Node {
	Node[] nodes;

	public Node() {
		this.nodes = new Node[26];
	}

	void put(char ch) {
		nodes[ch - 'a'] = new Node();
	}

	boolean contains(char ch) {
		return nodes[ch - 'a'] != null;
	}

	Node get(char ch) {
		return nodes[ch - 'a'];
	}
}

public class Solution 
{

	public static int countDistinctSubstrings(String s) 
	{
		//	  Write your code here.
		Node root = new Node();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			Node cursor = root;
			for (int j = i; j < s.length(); j++) {
				if (!cursor.contains(s.charAt(j))) {
					count++;
					cursor.put(s.charAt(j));
				}
				cursor = cursor.get(s.charAt(j));
			}
		}

		return count + 1;
	}
}
