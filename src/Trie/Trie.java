package Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!currentNode.containsKey(currentChar)) {
                currentNode.put(currentChar, new TrieNode());
            }
            currentNode = currentNode.get(currentChar);
        }

        currentNode.setEndOfWord();
    }

    public boolean search(String word) {
        TrieNode result = searchPrefix(word);
        return result != null && result.isEndOfWord();
    }

    public boolean startsWith(String word) {
        TrieNode result = searchPrefix(word);
        return result != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (currentNode.containsKey(currentChar)) {
                currentNode = currentNode.get(currentChar);
            } else {
                return null;
            }
        }

        return currentNode;
    }
}
