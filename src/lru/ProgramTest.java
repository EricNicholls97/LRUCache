package lru;

import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;

public class ProgramTest {
  @Test
  public void TestCase1() {
    Program.LRUCache lruCache = new Program.LRUCache(3);
    lruCache.insertKeyValuePair("b", 2);
    lruCache.insertKeyValuePair("a", 1);
    lruCache.insertKeyValuePair("c", 3);
    assertTrue(lruCache.getMostRecentKey() == "c");
    assertTrue(lruCache.getValueFromKey("a").value == 1);
    assertTrue(lruCache.getMostRecentKey() == "a");
    lruCache.insertKeyValuePair("d", 4);
    var evictedValue = lruCache.getValueFromKey("b");
    assertTrue(evictedValue == null || evictedValue.found == false);
    lruCache.insertKeyValuePair("a", 5);
    assertTrue(lruCache.getValueFromKey("a").value == 5);
  }
}
