package data_structures.trees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTests {

    @Test
    public void insert_SeveralWords() {
        Trie CUT = new Trie();

        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");
    }

    @Test
    public void insert_DuplicateWords_OnlyCountOnce() {
        Trie CUT = new Trie();

        CUT.insert("a");
        CUT.insert("a");
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");
        CUT.insert("a");
        CUT.insert("a");
        CUT.insert("a");

        List<String> result = CUT.wordsWithPrefix("a");

        assertTrue(CUT.search("a"));
        assertEquals(4, result.size());
        assertTrue(result.contains("a"));
        assertTrue(result.contains("apple"));
        assertTrue(result.contains("application"));
        assertTrue(result.contains("applied"));
    }

    @Test
    public void search_SeveralWordsThatExist_ReturnsTrue() {
        Trie CUT = new Trie();
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");

        assertTrue(CUT.search("a"));
        assertTrue(CUT.search("apple"));
        assertTrue(CUT.search("applied"));
        assertTrue(CUT.search("application"));
    }

    @Test
    public void search_SeveralWordsThatDontExist_ReturnsFalse() {
        Trie CUT = new Trie();
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");

        assertFalse(CUT.search("b"));
        assertFalse(CUT.search("ba"));
        assertFalse(CUT.search("ab"));
        assertFalse(CUT.search("app"));
        assertFalse(CUT.search("applications"));
    }

    @Test
    public void wordsWithPrefix_NoPrefixs_ReturnsEmpty() {
        Trie CUT = new Trie();
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");

        assertTrue(CUT.wordsWithPrefix("b").isEmpty());
        assertTrue(CUT.wordsWithPrefix("applieds").isEmpty());
        assertTrue(CUT.wordsWithPrefix("zapple").isEmpty());
    }

    @Test
    public void wordsWithPrefix_JustTheWord_ReturnsTheWord() {
        Trie CUT = new Trie();
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");

        List<String> result = CUT.wordsWithPrefix("application");

        assertEquals(1, result.size());
        assertEquals("application", result.getFirst());
    }

    @Test
    public void wordsWithPrefix_APrefixThatMatchesAll_ReturnsAllTheWords() {
        Trie CUT = new Trie();
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");

        List<String> result = CUT.wordsWithPrefix("a");

        assertEquals(4, result.size());
        assertTrue(result.contains("a"));
        assertTrue(result.contains("apple"));
        assertTrue(result.contains("application"));
        assertTrue(result.contains("applied"));
    }

    @Test
    public void wordsWithPrefix_APrefixThatMatchesSome_ReturnsAllTheWordsMatching() {
        Trie CUT = new Trie();
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");

        List<String> result = CUT.wordsWithPrefix("app");

        assertEquals(3, result.size());
        assertTrue(result.contains("apple"));
        assertTrue(result.contains("application"));
        assertTrue(result.contains("applied"));
    }

    @Test
    public void wordsWithPrefix_MaxNumResults_ReturnsOnlySomeResults() {
        Trie CUT = new Trie();
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");

        List<String> result = CUT.wordsWithPrefix("app", 2);

        assertEquals(2, result.size());
    }

    @Test
    public void wordsWithPrefix_MaxOneResult_ReturnsOneResult() {
        Trie CUT = new Trie();
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");

        List<String> result = CUT.wordsWithPrefix("a", 1);

        assertEquals(1, result.size());
    }
}
