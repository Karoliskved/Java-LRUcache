package lruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUcacheMap
{
	private static int capacity;
	private Map<Integer, CacheEntry> cache;
	private int maxPopularity;

	private class CacheEntry
	{
		int value;
		int popularity;

		public CacheEntry(int value, int popularity)
		{
			this.value = value;
			this.popularity = popularity;
		}

		public int hashCode()
		{
			return value;
		}

		public int getPop()
		{
			return popularity;
		}

		public void increasePopularity()
		{
			popularity++;
		}
	}

	public static void main(String[] args)
	{
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

	public LRUcacheMap(int capacity)
	{
		this.capacity = capacity;
		this.cache = new HashMap<Integer, CacheEntry>();
	}

	public Integer get(int key)
	{
		cache.get(key).increasePopularity();
		if (cache.get(key).getPop() > maxPopularity)
			maxPopularity = cache.get(key).getPop();

		return cache.get(key).hashCode();
	}

	public void put(int key, int value)
	{
		Integer minKey = null;
		int min = maxPopularity;
		if (cache.size() >= capacity)
		{

			for (Integer cacheKey : cache.keySet())
			{
				if (cache.get(cacheKey).getPop() <= min)
				{
					min = cache.get(cacheKey).getPop();
					minKey = cacheKey;
				}
			}
			cache.remove(minKey);
		}
		cache.put(key, new CacheEntry(value, maxPopularity));
	}

}
