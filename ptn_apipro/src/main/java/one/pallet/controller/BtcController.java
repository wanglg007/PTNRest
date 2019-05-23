package one.pallet.controller;

import one.pallet.entity.BtcBlock;
import one.pallet.entity.BtcTrans;
import one.pallet.entity.RegIndx;
import one.pallet.service.BtcBlockService;
import one.pallet.service.BtcTransService;
import one.pallet.service.RegIndxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/btc")
public class BtcController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BtcBlockService btcBlockService;

    @Autowired
    private BtcTransService btcTransService;

    @Autowired
    private RegIndxService regIndxService;

    /****************************************(0)测试信息****************************************/

    /****************************************(1)查找区块****************************************/
    /**
     * 通过区块标号得到区块信息
     */
    @RequestMapping(value = "/get0/{height}",method={RequestMethod.GET,RequestMethod.POST})
    public BtcBlock getEthBlockByHeight(@PathVariable("height") Long height)  {
        List<BtcBlock> list = btcBlockService.getBtcBlockByNum(String.valueOf(height));
        logger.info("The number of blocks is obtained by the block labeling:" + list.size());
        return list.size() >=1 ? list.get(0) : null;
    }

    /**
     * 通过区块标号和哈希得到区块信息
     */
    @RequestMapping(value = "/get1/{hash}/{num}",method={RequestMethod.GET,RequestMethod.POST})
    public BtcBlock getBlockByRowkey(@PathVariable("hash") String hash,@PathVariable("num") Long num) {
        String rowkey =  new StringBuffer(hash).reverse().toString() + "_" + num + "#";       //区块哈希翻转_区块号#
        BtcBlock block = btcBlockService.getBtcBlock(rowkey);
        logger.info("区块信息：" + block);
        return block;
    }

    /**
     * 通过哈希得到区块信息
     */
    @RequestMapping(value = "/get2/{hash}",method={RequestMethod.GET,RequestMethod.POST})
    public BtcBlock getBlockByHash(@PathVariable("hash") String hash){
        String strHash = new StringBuffer(hash).reverse().toString() + "_";     //区块哈希的翻转_
        List<BtcBlock> blocklist = btcBlockService.getBtcBlockByHash(strHash);
        logger.info("The number of blocks is obtained by the block labeling:" + blocklist.size());
        return blocklist.size() >= 1 ? blocklist.get(0) : null;
    }

    /****************************************(2)查找交易****************************************/
    /**
     * 通过交易哈希得到交易信息
     */
    @RequestMapping(value = "/get3/{hash}",method={RequestMethod.GET,RequestMethod.POST})
    public BtcTrans getTransByHash(@PathVariable("hash") String hash){
        String strHash = new StringBuffer(hash).reverse().toString() + "_";     //交易哈希的翻转_
        List<BtcTrans> translist = btcTransService.getBtcTransByHash(strHash);
        logger.info("Transaction information is:" + translist.size());
        return translist.size() >= 1 ? translist.get(0) : null;
    }

    /**
     * 通过区块号码得到交易信息
     */
    @RequestMapping(value = "/get4/{num}",method={RequestMethod.GET,RequestMethod.POST})
    public List<BtcTrans> getTransByNum(@PathVariable("num")  Long num){
        List<BtcTrans> translist = btcTransService.getBtcTransByNum(String.valueOf(num));
        logger.info("The number of all transactions is:" + translist.size());
        return translist;
    }

    /****************************************(3)查找索引****************************************/
    /**
     * 通过发送地址得到索引信息
     */
    @RequestMapping(value = "/get5/{address}",method={RequestMethod.GET,RequestMethod.POST})
    public List<RegIndx> getRegIndxBySendAddress(@PathVariable("address") String address){
        List<RegIndx> regindxlist = regIndxService.getRegIndxByAddress("btc_index",true,address);
        return regindxlist;
    }

    /**
     * 通过接收地址得到索引信息
     */
    @RequestMapping(value = "/get6/{address}",method={RequestMethod.GET,RequestMethod.POST})
    public List<RegIndx> getRegIndxByRecvAddress(@PathVariable("address") String address){
        List<RegIndx> regindxlist = regIndxService.getRegIndxByAddress("btc_index",false,address);
        return regindxlist;
    }

    /**
     * 通过主键得到索引信息
     */
    @RequestMapping(value = "/get7/{rowkey}",method={RequestMethod.GET,RequestMethod.POST})
    public RegIndx getRegIndxByKey(@PathVariable("rowkey") String rowkey) {
        RegIndx regIndx = regIndxService.getRegIndxByKey("btc_index",rowkey);
        return regIndx;
    }
}
