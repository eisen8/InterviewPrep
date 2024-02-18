package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    private final TrieNode _root;

    public Trie() {
        _root = new TrieNode(' ');
    }

    /**
     * Inserts a new word into the trie.
     * @param word The word to insert.
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null");
        }

        TrieNode currNode = _root;
        for (Character c : word.toLowerCase().toCharArray()) {
            if (!isValidCharacter(c)) {
                throw new IllegalArgumentException(String.format("Invalid character '%c'", c));
            }

            currNode.children.computeIfAbsent(c, TrieNode::new);
            currNode = currNode.children.get(c);
        }

        currNode.isWord = true;
    }

    /**
     * Searches if a given word is in the trie.
     * @param word The word to search.
     * @return True if the word exists. False if not.
     */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null");
        }


        TrieNode currNode = _root;
        for (Character c : word.toLowerCase().toCharArray()) {
            if (!isValidCharacter(c)) {
                throw new IllegalArgumentException(String.format("Invalid character '%c'", c));
            }

            currNode = currNode.children.get(c);
            if (currNode == null) {
                return false;
            }

        }

        return currNode.isWord;
    }

    /**
     * Returns all words in the trie that start with the prefix (including if the prefix is a word).
     * @param prefix The prefix.
     * @return All words that start with the prefix.
     */
    public List<String> startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }

        List<String> matches = new ArrayList<>();
        TrieNode currNode = _root;
        for (Character c : prefix.toLowerCase().toCharArray()) {
            if (!isValidCharacter(c)) {
                throw new IllegalArgumentException(String.format("Invalid character %c", c));
            }

            currNode = currNode.children.get(c);
            if (currNode == null) {
                return matches; // no prefix matches
            }
        }

        matches.addAll(getAllSubWords(currNode, prefix));

        return matches;
    }

    /**
     * Gets all words below the currentNode in the trie.
     */
    private List<String> getAllSubWords(TrieNode currNode, String currString) {
        List<String> allSubStrings = new ArrayList<>();
        if (currNode.isWord) {
            allSubStrings.add(currString);
        }

        for (Map.Entry<Character, TrieNode> child : currNode.children.entrySet()) {
            allSubStrings.addAll(getAllSubWords(child.getValue(), currString + child.getKey()));
        }

        return allSubStrings;
    }

    /**
     * Checks if the character is valid. Only allow english characters and hyphens.
     */
    private boolean isValidCharacter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c == '-') {
            return true;
        }

        return false;
    }


    /**
     * A node in the trie
     */
    private static class TrieNode {
        public char nodeChar;
        public Map<Character, TrieNode> children;
        public boolean isWord;

        public TrieNode(Character c) {
            nodeChar = c;
            children = new HashMap<>();
            isWord = false;
        }
    }
}
