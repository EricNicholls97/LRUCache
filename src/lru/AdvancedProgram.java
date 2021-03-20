package lru;

import java.util.*;

//Do not edit the class below except for the insertKeyValuePair,
//getValueFromKey, and getMostRecentKey methods. Feel free
//to add new properties and methods to the class.
class AdvancedProgram {
	static class LRUCache {
		int maxSize;

		public LRUCache(int maxSize) {
			this.maxSize = maxSize > 1 ? maxSize : 1;
		}

		public void insertKeyValuePair(String key, int value) {
			// Write your code here.
		}

		public LRUResult getValueFromKey(String key) {
			// Write your code here.
			return null;
		}

		public String getMostRecentKey() {
			// Write your code here.
			return null;
		}
	}
	
	static class LRUResult {
		boolean found;
		int value;
		
		public LRUResult(boolean found, int value) {
			this.found = found;
			this.value = value;
		}
	}
}
	