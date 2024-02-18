package trees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTests {

    @Test
    public void Insert_SeveralWords() {
        Trie CUT = new Trie();

        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");
    }

    @Test
    public void Search_SeveralWordsThatExist_ReturnsTrue() {
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
    public void Search_SeveralWordsThatDontExist_ReturnsFalse() {
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
    public void startsWith_NoPrefixs_ReturnsEmpty() {
        Trie CUT = new Trie();
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");

        assertTrue(CUT.startsWith("b").isEmpty());
        assertTrue(CUT.startsWith("applieds").isEmpty());
        assertTrue(CUT.startsWith("zapple").isEmpty());
    }

    @Test
    public void startsWith_JustTheWord_ReturnsTheWord() {
        Trie CUT = new Trie();
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");

        List<String> result = CUT.startsWith("application");

        assertEquals(1, result.size());
        assertEquals("application", result.getFirst());
    }

    @Test
    public void startsWith_APrefixThatMatchesAll_ReturnsAllTheWords() {
        Trie CUT = new Trie();
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");

        List<String> result = CUT.startsWith("a");

        assertEquals(4, result.size());
        assertTrue(result.contains("a"));
        assertTrue(result.contains("apple"));
        assertTrue(result.contains("application"));
        assertTrue(result.contains("applied"));
    }

    @Test
    public void startsWith_APrefixThatMatchesSome_ReturnsAllTheWordsMatching() {
        Trie CUT = new Trie();
        CUT.insert("a");
        CUT.insert("apple");
        CUT.insert("applied");
        CUT.insert("application");

        List<String> result = CUT.startsWith("app");

        assertEquals(3, result.size());
        assertTrue(result.contains("apple"));
        assertTrue(result.contains("application"));
        assertTrue(result.contains("applied"));
    }
}
