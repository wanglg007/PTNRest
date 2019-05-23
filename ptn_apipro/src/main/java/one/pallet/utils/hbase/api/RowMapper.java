package one.pallet.utils.hbase.api;
import org.apache.hadoop.hbase.client.Result;

/**
 * Callback for mapping rows of a {@link ResultScanner} on a per-row basis.
 * Implementations of this interface perform the actual work of mapping each row to a result object, but don't need to worry about exception handling.
 */
public interface RowMapper<T> {

    T mapRow(Result result, int rowNum) throws Exception;
}
