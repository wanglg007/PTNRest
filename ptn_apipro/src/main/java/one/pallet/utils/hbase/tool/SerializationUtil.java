package one.pallet.utils.hbase.tool;

import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TCompactProtocol;

public class SerializationUtil {

    public static byte [] serialize(TBase<?, ?> object) throws TException{
        TSerializer serializer = new TSerializer(new TCompactProtocol.Factory());
        return serializer.serialize(object);
    }
    public static void deserialize(byte[] byteData,TBase<?, ?> toObject) throws TException{
        TDeserializer deserializer = new TDeserializer(new TCompactProtocol.Factory());
        deserializer.deserialize(toObject, byteData);
    }

}
