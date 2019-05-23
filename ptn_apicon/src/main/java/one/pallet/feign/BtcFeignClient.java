package one.pallet.feign;

import feign.hystrix.FallbackFactory;
import one.pallet.config.FeignConfiguration;
import one.pallet.entity.BtcBlock;
import one.pallet.entity.BtcTrans;
import one.pallet.entity.RegIndx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "ptn-apipro", url = "http://ptn-apipro:8764", configuration = FeignConfiguration.class, fallbackFactory = BtcFeignClientFallbackFactory.class)
public interface BtcFeignClient {

    /****************************************(1)查找区块****************************************/
    /**
     * 通过区块标号和哈希得到区块信息
     */
    @RequestMapping(value = "/btc/get0/{height}", method = RequestMethod.POST)
    public BtcBlock getEthBlockByHeight(@PathVariable("height") Long height);

    /**
     * 通过区块标号和哈希得到区块信息
     */
    @RequestMapping(value = "/btc/get1/{hash}/{num}", method = RequestMethod.POST)
    public BtcBlock getBlockByRowkey(@PathVariable("hash") String hash, @PathVariable("num") Long num);

    /**
     * 通过哈希得到区块信息
     */
    @RequestMapping(value = "/btc/get2/{hash}", method = RequestMethod.POST)
    public BtcBlock getBlockByHash(@PathVariable("hash") String hash);

    /****************************************(2)查找交易****************************************/
    /**
     * 通过交易哈希得到交易信息
     */
    @RequestMapping(value = "/btc/get3/{hash}", method = RequestMethod.POST)
    public BtcTrans getTransByHash(@PathVariable("hash") String hash);

    /**
     * 通过区块号码得到交易信息
     */
    @RequestMapping(value = "/btc/get4/{num}", method = RequestMethod.POST)
    public List<BtcTrans> getTransByNum(@PathVariable("num") Long num);

    /****************************************(3)查找索引****************************************/
    /**
     * 通过发送地址得到交易信息
     */
    @RequestMapping(value = "/btc/get5/{address}", method = RequestMethod.POST)
    public List<RegIndx> getRegIndxBySendAddress(@PathVariable("address") String address);

    /**
     * 通过发送地址得到交易信息
     */
    @RequestMapping(value = "/btc/get6/{address}", method = RequestMethod.POST)
    public List<RegIndx> getRegIndxByRecvAddress(@PathVariable("address") String address);
}

@Component
class BtcFeignClientFallbackFactory implements FallbackFactory<BtcFeignClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BtcFeignClientFallbackFactory.class);

    @Override
    public BtcFeignClient create(Throwable throwable) {
        return new BtcFeignClient() {
            @Override
            public BtcBlock getEthBlockByHeight(Long height) {
                //日志最好放在各个fallback方法中，而不要直接放在create方法中；否则在引用启动时，就会打印该日志。
                BtcFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }

            @Override
            public BtcBlock getBlockByRowkey(String hash, Long num) {
                BtcFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }

            @Override
            public BtcBlock getBlockByHash(String hash) {
                BtcFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }

            @Override
            public BtcTrans getTransByHash(String hash) {
                BtcFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }

            @Override
            public List<BtcTrans> getTransByNum(Long num) {
                BtcFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }

            @Override
            public List<RegIndx> getRegIndxBySendAddress(String address) {
                BtcFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }

            @Override
            public List<RegIndx> getRegIndxByRecvAddress(String address) {
                BtcFeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                return null;
            }
        };
    }
}