package one.pallet.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import one.pallet.entity.EthBlock;
import one.pallet.entity.EthTrans;
import one.pallet.entity.RegIndx;
import one.pallet.feign.EthFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EthController.class);

    @Autowired
    private EthFeignClient ethFeignClient;

    /****************************************(0)测试信息****************************************/

    /****************************************(1)查找区块****************************************/
    /**
     * 通过区块编号得到区块信息
     * @param height 区块编号
     * 备注：测试成功
     * (1) http://124.251.111.61:8766/api/eth0/9983
     * (2) 在K8S上测试失败，需要去掉HystrixCommand。在单机测试时可以打开HystrixCommand
     */
    @RequestMapping(value="/eth0/{height}",method={RequestMethod.GET,RequestMethod.POST})
//    @HystrixCommand(fallbackMethod = "defaultEthBlock",threadPoolProperties = {
//            @HystrixProperty(name="coreSize",    value = "10000"),        //并发执行的最大线程数
//            @HystrixProperty(name="maxQueueSize",value = "10000")         //BlockingQueue的最大队列数
//    })
    public EthBlock getEthBlockByHeight(@PathVariable("height") Long height) {
        return this.ethFeignClient.getEthBlockByHeight(height);
    }

    /**
     * 通过区块标号和哈希得到区块信息
     * @param hash  区块哈希
     * @param num   区块编号
     * 备注：测试成功
     * (1)http://124.251.111.61:8766/api/eth1/0x19963bddcb2caf627b6aaba3b771948f7c1d2c26a2496ed6b1420d2be5642e33/1342
     * (2)数据库中的哈希带0x
     */
    @RequestMapping(value="/eth1/{hash}/{num}",method={RequestMethod.GET,RequestMethod.POST})
    public EthBlock getBlockByRowkey(@PathVariable("hash") String hash,@PathVariable("num") Long num){
        String strHash = hash.startsWith("0X") || hash.startsWith("0x") ? "0x" + hash.substring(2) : "0x" + hash;
        return this.ethFeignClient.getBlockByRowkey(strHash,num);
    }


    /**
     * 通过哈希得到区块信息
     * @param hash 区块哈希
     * 备注：测试成功
     * (1) http://124.251.111.61:8766/api/eth2/0x19963bddcb2caf627b6aaba3b771948f7c1d2c26a2496ed6b1420d2be5642e33
     */
    @RequestMapping(value="/eth2/{hash}",method={RequestMethod.GET,RequestMethod.POST})
    public EthBlock getBlockByHash(@PathVariable("hash") String hash){
        String strHash = hash.startsWith("0X") || hash.startsWith("0x") ? "0x" + hash.substring(2) : "0x" + hash;
        return this.ethFeignClient.getBlockByHash(strHash);
    }

    /****************************************(2)查找交易****************************************/
    /**
     * 通过交易哈希得到交易信息
     * @param hash 交易哈希
     * 备注：测试成功
     * (1) http://124.251.111.61:8766/api/eth3/0xdb9ee3ac4c044a443cfdf2e7184a426de695a58a1731171ca6717e050a2ac891
     */
    @RequestMapping(value="/eth3/{hash}",method={RequestMethod.GET,RequestMethod.POST})
    public EthTrans getTransByHash(@PathVariable("hash") String hash){
        String strHash = hash.startsWith("0X") || hash.startsWith("0x") ? "0x" + hash.substring(2) : "0x" + hash;
        return this.ethFeignClient.getTransByHash(strHash);
    }

    /**
     * 通过区块号码得到交易信息
     * @param num
     * @return
     * 备注：测试成功
     * (1) http://124.251.111.61:8766/api/eth4/6243
     */
    @RequestMapping(value="/eth4/{num}",method={RequestMethod.GET,RequestMethod.POST})
    public List<EthTrans> getTransByNum(@PathVariable("num")  Long num){
        return this.ethFeignClient.getTransByNum(num);
    }

    /****************************************(3)查找索引****************************************/
    /**
     * 通过发送地址得到交易信息
     * @param address
     * @return
     * 备注：测试成功
     * (1) http://124.251.111.61:8766/api/eth5/0x004355941066a10e81641d660e0b7082176dfdc0
     */
    @RequestMapping(value="/eth5/{address}",method={RequestMethod.GET,RequestMethod.POST})
    public List<RegIndx> getRegIndxBySendAddress(@PathVariable("address") String address){
        String strAddress = address.startsWith("0X") || address.startsWith("0x") ? "0x" + address.substring(2) : "0x" + address;
        return this.ethFeignClient.getRegIndxBySendAddress(strAddress);
    }

    /**
     * 通过发送地址得到交易信息
     * @param address
     * @return
     * 备注：测试成功
     * (1) http://124.251.111.61:8766/api/eth6/0x0000000000000000000000000000000000000043
     */
    @RequestMapping(value="/eth6/{address}",method={RequestMethod.GET,RequestMethod.POST})
    public List<RegIndx> getRegIndxByRecvAddress(@PathVariable("address") String address){
        String strAddress = address.startsWith("0X") || address.startsWith("0x") ? "0x" + address.substring(2) : "0x" + address;
        return this.ethFeignClient.getRegIndxByRecvAddress(strAddress);
    }
    /****************************************(4)回退信息****************************************/
    /**
     * Hytrix回退方法
     */
    public EthBlock defaultEthBlock(@PathVariable Long num){
        EthBlock block = new EthBlock();
        block.setHash("0X0000000000000000000000000000000000000000000000000000000000000000");
        block.setNumber("-1");
        LOGGER.error("暂时得不到区块信息:" + block);
        return block;
    }

}
