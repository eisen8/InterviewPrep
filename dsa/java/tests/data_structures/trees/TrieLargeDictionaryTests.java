package data_structures.trees;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrieLargeDictionaryTests {

    public static Trie trie;

    @BeforeAll
    public static void constructTrie() throws IOException {
        trie = new Trie();
        String myCurrentDir = System.getProperty("user.dir");
        Path path = FileSystems.getDefault().getPath(myCurrentDir + "\\tests\\data_structures\\test-data\\words\\english_words.txt");
        List<String> words = Files.readAllLines(path);
        for (String word : words) {
            trie.insert(word);
        }
    }


    @Test
    public void wordsWithPrefix_MaxTwoResults_ReturnsTwoResults() {
        String prefix = "app";

        List<String> result = trie.wordsWithPrefix(prefix, 2);

        assertEquals(2, result.size());
        for (String word : result) {
            assertTrue(word.startsWith(prefix));
        }
    }

    @Test
    public void wordsWithPrefix_MaxTenResults_ReturnsTenResults() {

        String prefix = "ba";

        List<String> result = trie.wordsWithPrefix(prefix, 10);

        assertEquals(10, result.size());
        for (String word : result) {
            assertTrue(word.startsWith(prefix));
        }
    }

    @Test
    public void wordsWithPrefix_AllWords_ReturnsAllWords() {

        String prefix = "z";

        List<String> result = trie.wordsWithPrefix(prefix);

        assertEquals(101, result.size());
        for (String word : result) {
            assertTrue(word.startsWith(prefix));
        }
    }
}
