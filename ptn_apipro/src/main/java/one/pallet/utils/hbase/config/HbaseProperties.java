package one.pallet.utils.hbase.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.data.hbase")
public class HbaseProperties {

    private String quorum;

    private String port;

    private String rootDir;

    private String nodeParent;

    public String getQuorum() {
        return quorum;
    }

    public void setQuorum(String quorum) {
        this.quorum = quorum;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    public String getNodeParent() {
        return nodeParent;
    }

    public void setNodeParent(String nodeParent) {
        this.nodeParent = nodeParent;
    }
}
