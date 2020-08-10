package reflect;

import java.util.concurrent.Callable;

/**
 * @Auther: qulingxiao
 * @Date: 2020/8/5 09:56
 * @Description:
 */
public interface SimpleCache<K, V> {

    /**
     * 放入缓存
     * @param key
     * @param value
     */
    public void put(K key, V value);


    /**
     * 从缓存中取数据
     * @param key
     * @return 对应的value
     */
    public V get(K key);

    /**
     * 如果取到数据直接返回，如果没取到则通过valueLoader.call()进行回调，此处可以直接模拟一个数据返回。
     * @param key
     * @param valueLoader
     * @return 对应的value，或者回调的结果
     */
    public V get(K key, Callable<V> valueLoader);

}
