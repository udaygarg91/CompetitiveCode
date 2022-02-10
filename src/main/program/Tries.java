package com.main.soroco;

public class Tries {

	TriesNode root = null;

	public Tries() {
		root = new TriesNode();
	}

	public int insert(String word) {
		TriesNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			if (curr.next(word.charAt(i)) == null) {
				curr.trieNodes[word.charAt(i) - 'a'] = new TriesNode();
			}
			curr = curr.next(word.charAt(i));
		}
		curr.isWord++;
		return curr.isWord;
	}

	public int find(String word) {
		TriesNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			if (curr == null) {
				System.out.print("Word not found ");
				return 0;
			}
			curr = curr.next(word.charAt(i));
		}
		if (curr.isWord == 0) {
			System.out.print("Word not found ");
		}
		return curr.isWord;
	}

	public void delete(String word) {
		TriesNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			if (curr == null) {
				System.out.print("Word not found ");
				return;
			}
			curr = curr.next(word.charAt(i));
		}
		if (curr == null || curr.isWord == 0) {
			System.out.print("Word not found ");
		} else {
			curr.isWord--;
			//System.out.println("Deleted");
		}
	}

	public int update(String old, String newWord) {
		delete(old);
		insert(newWord);
		return find(newWord);
	}

	public static void main(String[] args) {
		Tries t = new Tries();
		System.out.println(t.insert("abc"));
		System.out.println(t.insert("abc"));
		System.out.println(t.insert("abcd"));
		System.out.println(t.insert("babcde"));
		System.out.println(t.find("babcde"));
		t.delete("babcde");
		t.delete("babcde");
		System.out.println(t.find("babcde"));
		System.out.println(t.update("abc", "abcde"));
//		System.out.println(t.find("abc"));
		System.out.println(t.update("abc", "abcde"));
		System.out.println(t.find("abc"));
	}
}

class TriesNode {
	int isWord;
	TriesNode[] trieNodes = new TriesNode[26];

	public TriesNode next(char c) {
		return trieNodes[c - 'a'];
	}

}
