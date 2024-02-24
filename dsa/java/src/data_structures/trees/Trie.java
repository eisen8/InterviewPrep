package data_structures.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Trie {

    private final TrieNode _root;

    public Trie() {
        _root = new TrieNode('^', null);
    }

    /**
     * Inserts a new word into the trie.
     *
     * @param word The word to insert.
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null");
        }

        TrieNode currNode = _root;
        for (char c : word.toLowerCase().toCharArray()) {
            if (!isValidCharacter(c)) {
                throw new IllegalArgumentException(String.format("Invalid character '%c'", c));
            }

            int index = getChildIndex(c);

            if (currNode.children[index] == null) {
                currNode.children[index] = new TrieNode(c, currNode);
            }

            currNode = currNode.children[index];
        }

        currNode.isWord = true;
    }

    /**
     * Searches if a given word is in the trie.
     *
     * @param word The word to search.
     * @return True if the word exists. False if not.
     */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null");
        }


        TrieNode currNode = _root;
        for (char c : word.toLowerCase().toCharArray()) {
            if (!isValidCharacter(c)) {
                throw new IllegalArgumentException(String.format("Invalid character '%c'", c));
            }

            currNode = currNode.children[getChildIndex(c)];
            if (currNode == null) {
                return false;
            }

        }

        return currNode.isWord;
    }

    /**
     * Returns all words in the trie that start with the prefix (including if the prefix is a word).
     *
     * @param prefix The prefix.
     * @return All words that start with the prefix.
     */
    public List<String> wordsWithPrefix(String prefix) {
        return wordsWithPrefix(prefix, Integer.MAX_VALUE);
    }

    /**
     * Returns all words in the trie that start with the prefix (including if the prefix is a word).
     *
     * @param prefix        The prefix.
     * @param maxNumResults The maximum number of results
     * @return All words that start with the prefix.
     */
    public List<String> wordsWithPrefix(String prefix, int maxNumResults) {
        if (prefix == null || prefix.isEmpty()) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }

        // Traverse to the prefix
        List<String> matches = new ArrayList<>();
        TrieNode currNode = _root;
        for (char c : prefix.toLowerCase().toCharArray()) {
            if (!isValidCharacter(c)) {
                throw new IllegalArgumentException(String.format("Invalid character %c", c));
            }

            currNode = currNode.children[getChildIndex(c)];
            if (currNode == null) {
                return matches; // prefix doesn't exist, no matches
            }
        }

        // Get all subwords under the prefix
        matches.addAll(getAllSubWords(currNode, maxNumResults));

        return matches;
    }

    /**
     * Gets all words below the currentNode in the trie.
     */
    private List<String> getAllSubWords(TrieNode node, int maxNumResults) {
        List<String> words = new ArrayList<>();
        Stack<TrieNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty() && maxNumResults > 0) {
            TrieNode currNode = stack.pop();
            if (currNode.isWord) {
                words.add(getWord(currNode));
                maxNumResults--;
            }

            for (TrieNode child : currNode.children) {
                if (child == null) {
                    continue;
                }

                stack.push(child);
            }
        }

        return words;
    }

    /**
     * Retrieves the full string at a given TrieNode
     */
    private String getWord(TrieNode t) {
        TrieNode currNode = t;
        StringBuilder sb = new StringBuilder();
        while (currNode != _root) {
            sb.append(currNode.nodeChar);
            currNode = currNode.parent;
        }

        return sb.reverse().toString();
    }


    /**
     * Checks if the character is valid. We only allow english characters and hyphens.
     */
    private boolean isValidCharacter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else return c == '-';
    }

    private static final int NUM_VALID_CHARS = 27;

    private int getChildIndex(char c) {
        if (c == '-') { return 26; }

        return c-'a';
    }


    /**
     * A node in the trie
     */
    private static class TrieNode {
        public char nodeChar;

        /**
         * Use an array instead of hash map to avoid costly hashing. We also save space if there are a large
         * number of words as the default hashmap uses numbers of buckets to a power of 2 (min 16) with a load factor
         * of 0.75 (i.e. 16 if less than 12 mappings, 32 if less than 24, and 64 if more than 24.
         */
        public TrieNode[] children;
        public TrieNode parent;
        public boolean isWord;

        public TrieNode(char c, TrieNode parent) {
            nodeChar = c;
            children = new TrieNode[NUM_VALID_CHARS];
            isWord = false;
            this.parent = parent;
        }
    }
}
