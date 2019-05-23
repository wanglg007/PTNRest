package one.pallet.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import one.pallet.entity.BtcBlock;
import one.pallet.entity.BtcTrans;
import one.pallet.entity.RegIndx;
import one.pallet.feign.BtcFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BtcController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BtcController.class);

    @Autowired
    private BtcFeignClient btcFeignClient;

    /****************************************(0)测试信息****************************************/

    /****************************************(1)查找区块****************************************/
    /**
     * 通过区块编号得到区块信息
     * @param height 区块编号
     * 备注：测试成功
     * (1)http://124.251.111.61:8766/api/btc0/143
     * (2)在K8S上测试失败，需要去掉HystrixCommand。在单机测试时可以打开HystrixCommand
     */
    @RequestMapping(value="/btc0/{height}",method={RequestMethod.GET,RequestMethod.POST})
//    @HystrixCommand(fallbackMethod = "defaultBtcBlock",threadPoolProperties = {
//            @HystrixProperty(name="coreSize",    value = "10000"),        //并发执行的最大线程数
//            @HystrixProperty(name="maxQueueSize",value = "10000")         //BlockingQueue的最大队列数
//    })
    public BtcBlock getEthBlockByHeight(@PathVariable("height") Long height) {
        return this.btcFeignClient.getEthBlockByHeight(height);
    }

    /**
     * 通过区块标号和哈希得到区块信息
     * @param hash 区块哈希
     * @param num  区块编号
     * @return
     * 备注：测试成功
     * (1)http://124.251.111.61:8766/api/btc1/0000000035c96651a7dc7a99a9c959a8add21d3cc978c3127a6eecb9c56c2548/143
     * (2)数据库里面的哈希不带0x
     */
    @RequestMapping(value="/btc1/{hash}/{num}",method={RequestMethod.GET,RequestMethod.POST})
    public BtcBlock getBlockByRowkey(@PathVariable("hash") String hash,@PathVariable("num") Long num){
        String strHash = hash.startsWith("0X") || hash.startsWith("0x") ? hash.substring(2) : hash;
        return this.btcFeignClient.getBlockByRowkey(strHash,num);
    }

    /**
     * 通过区块哈希得到区块信息
     * @param hash
     * @return
     * 备注：
     * (1) http://124.251.111.61:8766/api/btc2/0000000035c96651a7dc7a99a9c959a8add21d3cc978c3127a6eecb9c56c2548
     */
    @RequestMapping(value="/btc2/{hash}",method={RequestMethod.GET,RequestMethod.POST})
    public BtcBlock getBlockByHash(@PathVariable("hash") String hash){
        String strHash = hash.startsWith("0X") || hash.startsWith("0x") ? hash.substring(2) : hash;
        return this.btcFeignClient.getBlockByHash(strHash);
    }

    /****************************************(2)查找交易****************************************/
    /**
     * 通过交易哈希得到交易信息
     * @param hash
     * 备注：测试成功
     * (1) http://124.251.111.61:8766/api/btc3/72d4fc43ac576a4b2f1f35e1b310a2d83a1012a36fdc7813ec237646950233cf
     */
    @RequestMapping(value="/btc3/{hash}",method={RequestMethod.GET,RequestMethod.POST})
    public BtcTrans getTransByHash(@PathVariable("hash") String hash){
        String strHash = hash.startsWith("0X") || hash.startsWith("0x") ? hash.substring(2) : hash;
        return this.btcFeignClient.getTransByHash(strHash);
    }

    /**
     * 通过区块号码得到交易信息
     * @param num
     * 备注：测试成功
     * (1) http://124.251.111.61:8766/api/btc4/143
     */
    @RequestMapping(value="/btc4/{num}",method={RequestMethod.GET,RequestMethod.POST})
    public List<BtcTrans> getTransByNum(@PathVariable("num")  Long num){
        return this.btcFeignClient.getTransByNum(num);
    }

    /****************************************(3)查找索引****************************************/
    /**
     * 通过发送地址得到交易信息
     * @param address
     * 备注:测试成功
     * (1) http://124.251.111.61:8766/api/btc5/2MsTETuB86u73ijx7gLAULyGQzh9GEDmG88
     */
    @RequestMapping(value="/btc5/{address}",method={RequestMethod.GET,RequestMethod.POST})
    public List<RegIndx> getRegIndxBySendAddress(@PathVariable("address") String address){
        String strAddress = address.startsWith("0X") || address.startsWith("0x") ? address.substring(2) : address;
        return this.btcFeignClient.getRegIndxBySendAddress(strAddress);
    }

    /**
     * 通过发送地址得到交易信息
     * @param address
     * 备注：测试成功
     * (1)http://124.251.111.61:8766/api/btc5/2MsTETuB86u73ijx7gLAULyGQzh9GEDmG88
     */
    @RequestMapping(value="/btc6/{address}",method={RequestMethod.GET,RequestMethod.POST})
    public List<RegIndx> getRegIndxByRecvAddress(@PathVariable("address") String address){
        String strAddress = address.startsWith("0X") || address.startsWith("0x") ? address.substring(2) : address;
        return this.btcFeignClient.getRegIndxByRecvAddress(strAddress);
    }

    /****************************************(4)回退信息****************************************/
    /**
     * Hytrix回退方法
     */
    public BtcBlock defaultBtcBlock(@PathVariable Long num){
        BtcBlock block = new BtcBlock();
        block.setHash("0X0000000000000000000000000000000000000000000000000000000000000000");
        block.setHeight("-1");
        LOGGER.error("暂时得不到区块信息:" + block);
        return block;
    }

}
