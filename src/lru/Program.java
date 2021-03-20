package lru;

import java.util.*;

// Do not edit the class below except for the insertKeyValuePair,
// getValueFromKey, and getMostRecentKey methods. Feel free
// to add new properties and methods to the class.
class Program {
	
  static class LRUCache {
    int maxSize;
		
		DLL llist = new DLL();
		HashMap<String, Node> cache = new HashMap<>();

    public LRUCache(int maxSize) {
      this.maxSize = maxSize > 1 ? maxSize : 1;
    }

    public void insertKeyValuePair(String key, int value) {
		System.out.println("insert K+V: " + key + " " + value);
		if(cache.containsKey(key)){
			// need to put this node at front
			// which is why we need to be able to delete any node from reference
			
			// get node from cache by key
			Node n = cache.get(key);
			// delete node from llist
			llist.deleteNode(n);
			// create new node in cache
			cache.put(key, new Node(key, value));
			// insert this node to head of llist
			llist.addFirst(cache.get(key));
			
			display();
			return;
		}
		else if(cache.size() >= maxSize){
			String lastKey = llist.removeLast();
			cache.remove(lastKey);
		}
		cache.put(key, new Node(key, value));
		llist.addFirst(cache.get(key));
		display();
    }

    public LRUResult getValueFromKey(String key) {
			int x = -1;
			boolean b = cache.containsKey(key);
			if(b){
				Node n = cache.get(key);
				x = n.value;
				llist.deleteNode(n);
				llist.addFirst(n);
			}
			return new LRUResult(b, x);
    }

    public String getMostRecentKey() {
			return llist.head.key;
    }
	
		private void display(){
			System.out.print("DLL= ");
			Node cur = llist.head;
			while(cur != null){
				System.out.print(cur.value + " (" + cur.key + ")   ");
				cur = cur.next;
			}
			System.out.println();

			System.out.print("Cache= ");
			for(String k : cache.keySet()){
				System.out.print(k + ": " + cache.get(k).value + ", ");
			}
			System.out.println();
			System.out.println();
		}
	}
	
	
	static class DLL {
		Node head = null;
		Node tail = null;
		
		public void addFirst(Node n){
			if(head==null && tail==null){	// 0 elements
				head = n;
				tail = n;
				n.next = null;
				n.prev = null;
			}
			else if(head==tail){	// 1 element
				head = n;
				head.next = tail;
				tail.prev = head;
			}
			else { 	// 2+ elements
				n.next = head;
				head.prev = n;
				head = n;
			}			
		}
		
		public String removeLast(){
			if(tail==null){
				return null;
			}
			String key = tail.key;
			if(head==tail){
				head = tail = null;
			}
			else{
				tail = tail.prev;
				tail.next = null;
			}
			return key;
		}
		
		public void deleteNode(Node n){
			if(head==tail && head==n){
				head = tail = null;
				return;
			}
			if(n == head){
				head = n.next;
				head.prev = null;
				return;
			}
			if(n==tail){
				tail = tail.prev;
				tail.next = null;
				return;
			}
			n.prev.next = n.next;
			n.next.prev = n.prev;
		}
		
		public void printDLL(){
			Node cur = head;
			while(cur != null){
				System.out.println(cur.key + " / " + cur.value);
					cur = cur.next;
				}
			}
		}
		static class Node{
			String key;
			int value;
			Node next = null;
			Node prev = null;
			public Node (String key, int value) {
				this.key = key;
				this.value = value;
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

