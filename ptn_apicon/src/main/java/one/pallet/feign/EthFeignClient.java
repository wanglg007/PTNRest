package one.pallet.feign;

import feign.hystrix.FallbackFactory;
import one.pallet.config.FeignConfiguration;
import one.pallet.entity.EthBlock;
import one.pallet.entity.EthTrans;
import one.pallet.entity.RegIndx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "ptn-apipro", url = "http://ptn-apipro:8764", configuration = FeignConfiguration.class, fallbackFactory = EthFeignClientFallbackFactory.class)
public interface EthFeignClient {

    /****************************************(0)测试信息****************************************/
    /****************************************(1)查找区块****************************************/
    /**
     * 通过区块标号和哈希得到区块信息
     */
    @RequestMapping(value = "/eth/get0/{height}", method = RequestMethod.POST)
    public EthBlock getEthBlockByHeight(@PathVariable("height") Long height);

    /**
     * 通过区块标号和哈希得到区块信息
     */
    @RequestMapping(value = "/eth/get1/{hash}/{num}", method = RequestMethod.POST)
    public EthBlock getBlockByRowkey(@PathVariable("hash") String hash, @PathVariable("num") Long num);

    /**
     * 通过哈希得到区块信息
     */
    @RequestMapping(value = "/eth/get2/{hash}", method = RequestMethod.POST)
    public EthBlock getBlockByHash(@PathVariable("hash") String hash);

    /****************************************(2)查找交易****************************************/
    /**
     * 通过交易哈希得到交易信息
     */
    @RequestMapping(value = "/eth/get3/{hash}", method = RequestMethod.POST)
    public EthTrans getTransByHash(@PathVariable("hash") String hash);

    /**
     * 通过区块号码得到交易信息
     */
    @RequestMapping(value = "/eth/get4/{num}", method = RequestMethod.POST)
    public List<EthTrans> getTransByNum(@PathVariable("num") Long num);

    /****************************************(3)查找索引****************************************/
    /**
     * 通过发送地址得到交易信息
     */
    @RequestMapping(value = "/eth/get5/{address}", method = RequestMethod.POST)
    public List<RegIndx> getRegIndxBySendAddress(@PathVariable("address") String address);

    /**
     * 通过发送地址得到交易信息
     */
    @RequestMapping(value = "/eth/get6/{address}", method = RequestMethod.POST)
    public List<RegIndx> getRegIndxByRecvAddress(@PathVariable("address") String address);
}

@Component
class EthFeignClientFallbackFactory implements FallbackFactory<EthFeignClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(EthFeignClientFallbackFactory.class);

    @Override
    public EthFeignClient create(Throwable throwable) {
        return new EthFeignClient() {
            @Override
            public EthBlock getEthBlockByHeight(Long height) {
                EthFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }

            @Override
            public EthBlock getBlockByRowkey(String hash, Long num) {
                //日志最好放在各个fallback方法中，而不要直接放在create方法中；否则在引用启动时，就会打印该日志。
                EthFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }

            @Override
            public EthBlock getBlockByHash(String hash) {
                EthFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }

            @Override
            public EthTrans getTransByHash(String hash) {
                EthFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }

            @Override
            public List<EthTrans> getTransByNum(Long num) {
                EthFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }

            @Override
            public List<RegIndx> getRegIndxBySendAddress(String address) {
                EthFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }

            @Override
            public List<RegIndx> getRegIndxByRecvAddress(String address) {
                EthFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }


        };
    }
}