package one.pallet.utils.hbase.config;

import one.pallet.utils.hbase.api.HbaseTemplate;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * desc： hbase auto configuration
 * date： 2016-11-16 11:11:27
 */
@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties(HbaseProperties.class)
@ConditionalOnClass(HbaseTemplate.class)
public class HbaseAutoConfiguration {

    private static final String HBASE_QUORUM = "hbase.zookeeper.quorum";
    private static final String HBASE_ROOTDIR = "hbase.rootdir";
    private static final String HBASE_ZNODE_PARENT = "zookeeper.znode.parent";

    @Autowired
    private Environment environment;

    @Autowired
    private HbaseProperties hbaseProperties;

    @Bean
    @ConditionalOnMissingBean(HbaseTemplate.class)
    public HbaseTemplate hbaseTemplate() {
        Configuration configuration = HBaseConfiguration.create();
        /*针对K8S进行修改*/
//        configuration.set(HBASE_QUORUM, this.hbaseProperties.getQuorum());
//        configuration.set(HBASE_ROOTDIR, hbaseProperties.getRootDir());
//        configuration.set(HBASE_ZNODE_PARENT, hbaseProperties.getNodeParent());
        configuration.set(HBASE_QUORUM, environment.getProperty("HBASE_SERVICE_QUORM"));
        configuration.set(HBASE_ROOTDIR, environment.getProperty("HBASE_SERVICE_ROOTDIR"));
        configuration.set(HBASE_ZNODE_PARENT, environment.getProperty("HBASE_SERVICE_NODEPARENT"));

        return new HbaseTemplate(configuration);
    }

    @Bean
    public Configuration configuration() {
        Configuration configuration = HBaseConfiguration.create();
        /*针对K8S进行修改*/
//        configuration.set(HBASE_QUORUM, this.hbaseProperties.getQuorum());
//        configuration.set(HBASE_ROOTDIR, this.hbaseProperties.getRootDir());
//        configuration.set(HBASE_ZNODE_PARENT, this.hbaseProperties.getNodeParent());
        configuration.set(HBASE_QUORUM, environment.getProperty("HBASE_SERVICE_QUORM"));
        configuration.set(HBASE_ROOTDIR, environment.getProperty("HBASE_SERVICE_ROOTDIR"));
        configuration.set(HBASE_ZNODE_PARENT, environment.getProperty("HBASE_SERVICE_NODEPARENT"));
        return  configuration;
    }

    //若要添加spring data hadoop，可以使用这个方法
//    @Bean
//    @Qualifier("originalHbaseTemplate")
//    org.springframework.data.hadoop.hbase.HbaseTemplate baseTemplate() {
//        Configuration conf = HBaseConfiguration.create();
//        conf.set(HBASE_QUORUM, this.hbaseProperties.getQuorum());
//        conf.set(HBASE_ROOTDIR, this.hbaseProperties.getRootDir());
//        conf.set(HBASE_ZNODE_PARENT, this.hbaseProperties.getNodeParent());
//        return new org.springframework.data.hadoop.hbase.HbaseTemplate(conf);
//    }
}
