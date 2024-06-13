package lruCache;

import java.util.ArrayList;
import java.util.Arrays;

public class LRUcache {

	private static int capacity;
	private ArrayList<ArrayList<Integer>> cache;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUcache lruCache = new LRUcache(2);
		lruCache.put(0, 1);
		lruCache.put(5, 7);
		lruCache.get(5);
		lruCache.get(5);
		lruCache.get(5);
		lruCache.get(5);
		lruCache.get(5);
		lruCache.put(2, 11);
		lruCache.put(2, 17);
		lruCache.get(2);
		System.out.println(lruCache.get(2));
	}
	public LRUcache(int capacity)
	{
		this.capacity = capacity;
		this.cache= new ArrayList<ArrayList<Integer>>();
	}

	public Integer get(int key) {
		for (ArrayList<Integer> element : cache) {
			if (element.get(0) == key) {
				element.set(2, element.get(2) + 1);
				return element.get(1);
			}
		}
		return null;
	}

	public void put(int key, int value) {

		Integer existingKeyIndex = getExistingKeyIndex(key);
		if (existingKeyIndex != null) {
			cache.set(existingKeyIndex, new ArrayList<Integer>(Arrays.asList(key, value, getMaxPopularity())));
		} else {
			if (cache.size() == capacity) {
				int min = cache.get(0).get(0);
				int minIndex = 0;
				int index = 0;
				for (ArrayList<Integer> element : cache) {
					if (element.get(2) < min) {
						min = element.get(2);
						minIndex = index;
					}
					index++;
				}
				cache.remove(minIndex);
				cache.add(new ArrayList<Integer>(Arrays.asList(key, value, getMaxPopularity())));

			} else {
				cache.add(new ArrayList<Integer>(Arrays.asList(key, value, getMaxPopularity())));
			}
		}

	}

	int getMaxPopularity() {
		int max = 0;
		for (ArrayList<Integer> element : this.cache) {
			if (element.get(2) > max) {
				max = element.get(2);
			}
		}
		return max;
	}

	Integer getExistingKeyIndex(int key) {
		int keyIndex = 0;
		for (ArrayList<Integer> element : this.cache) {
			if (key == element.get(0)) {
				return keyIndex;
			}
			keyIndex++;
		}
		return null;
	}
}
