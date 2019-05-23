package one.pallet.utils.hbase.service;

import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;

import java.util.List;
import java.util.Map;

/**
 * Hbase Base Class
 */
public interface HbaseService {
    <T> List<T> findByExample(Map<String, CompareOp[]> filter, Object t, Class<T> classz);

    <T> List<T> findByExample(Scan scan, Class<T> classz);

    <T> void save(T t, Class<T> classz);
}
