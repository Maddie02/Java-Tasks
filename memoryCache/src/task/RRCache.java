package task;

import java.util.HashMap;

public class RRCache<K, V> implements Cache<K, V> {
    private HashMap<K, V> cache = new HashMap<>();
    private long cacheHits = 0;
    private long cacheMiss = 0;

    @Override
    public V get(K key) {
        V value = cache.get(key);
        if (value != null) {
            cacheHits ++;
        } else {
            cacheMiss ++;
        }
        return value;
    }

    @Override
    public void set(K key, V value) {
        if (key == null && value == null) {
            return;
        }

        cache.put(key, value);
    }

    @Override
    public boolean remove(K key) {
        return cache.remove(key) != null;
    }

    @Override
    public long size() {
        return cache.size();
    }

    @Override
    public void clear() {
        cacheMiss = 0;
        cacheHits = 0;
        cache.clear();
    }

    @Override
    public double getHitRate() {
        if (cacheMiss == 0) {
            return 1;
        }
        return cacheHits / (double) cacheMiss;
    }

    @Override
    public int getUsesCount(Object key) {
        throw new UnsupportedOperationException();
    }
}
