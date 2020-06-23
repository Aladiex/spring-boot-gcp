package io.aladiex.temp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.aladiex.temp.entity.Asset;
import io.aladiex.temp.entity.Bonus;
import io.aladiex.temp.entity.LockItem;
import io.aladiex.temp.entity.Order;
import io.aladiex.temp.entity.Round;
import io.aladiex.temp.service.BonusService;
import io.aladiex.temp.service.LockItemService;
import io.aladiex.temp.service.OrderService;
import io.aladiex.temp.service.RoundService;
import io.aladiex.temp.service.WalletService;

/**
 * REST controller for managing {@link io.aladiex.common.domain.Customer}.
 */
@CrossOrigin
@RestController(value = "OrderController")
public class OrderController{

    private final Logger log = LoggerFactory.getLogger(OrderController.class);

    private static final String ENTITY_NAME = "Order";
    private final OrderService orderService;
    private final WalletService walletService;
    private final RoundService roundService;
    private final LockItemService lockItemService;
    private final BonusService bonusService;
    
    public OrderController(OrderService orderService, WalletService walletService, RoundService roundService, LockItemService lockItemService, BonusService bonusService) {
		// TODO Auto-generated constructor stub
    	this.orderService = orderService;
    	this.walletService = walletService;
    	this.roundService = roundService;
    	this.lockItemService = lockItemService;
    	this.bonusService = bonusService;
	}
    
    @PostMapping(value = "/order/my")
	@ResponseBody
    public List<Order> getMyOrder()
    {
//    	fix ownerId = 2
    	//TODO: replace spring security on ownerId
    	return orderService.findOrdersByOwnerId(2L);
    }
    
    @PostMapping(value = "/order/{id}")
   	@ResponseBody
    public Order getyOrderById(@PathVariable Long id)
    {
    	return orderService.findOneByOrderId(id);
    }
    
    @PostMapping(value = "/order/create")
	@ResponseBody
	public Order createOrder(@RequestBody Order order)
	{
//    	suppose to be the case, current user is hoangdev.
//    	TODO: check id get tu token
//    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    	String currentPrincipalName = authentication.getName();
//    	System.out.println("currentPrincipalName: "+currentPrincipalName);
    	
    	

    	Long currentId = 2L;
//    	
//    	Wallet ethWallet = walletService.findOneByCustomerIdAndCurrencySymbol(customerId, "ETH").get();
//    	Wallet usdtWallet = walletService.findOneByCustomerIdAndCurrencySymbol(customerId, "USDT").get();
//    	BigDecimal ethBalance = ethWallet.getBalance();
//    	BigDecimal usdtBalance = usdtWallet.getBalance();
//    	Round round = roundService.findOne(roundId).get();
//    	BigDecimal fee = round.getFee();
//    	BigDecimal price = round.getPrice();
//    	int stock = round.getStock();
//    	if(ethBalance.compareTo(fee)>=0 && usdtBalance.compareTo(price)>=0)
//    	{
//    		if(stock>0)
//    		{
////    			TODO: send eth from user's eth address to admin
////    			TODO: send usdt from user's usdt address to admin
//    			order.setStatus("2");
//    			
//    		}
//    	}
//    	if()
    	
    	// gia su user mua ala = ma vong hien tai la vong 1 cofouder => gia ala va goi ...
    	
    	// gia su day laf order mua ala  tai vong cofounder gia ala la 0.3 usd 1 goi laf 10000 usdt => so luong ala phai tra la 33333.3333
    	//voi ty le lock tai cac vong la 
    	//0,3,1.9,1.9,1.9,1.9,1.9,1.9,1.9,1.9,1.9,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,0,0,0,0,0,0,0,0,0,0,0,0
    	
    	//Buoc 1 chuyen ala vao asset bang cach insert hoac update ( voi user da co ala ) va frozen toan bo 
    	// Buoc 2 chuyen ala vao kho lockitem bang cach select ra bang ty le giai bang trong bangr Round 
    	
    	
//    	TODO: insert into order, asset
    	Order ordered = orderService.save(order);
    	int slot = ordered.getSlot();
    	// vi du assetID cua ala la 1
//    	Long projectId = 1L;
//    	Round currentRound= roundService.getCurrentRound(projectId, "ACTIVE");
//    	String lockRate = currentRound.getUnlockRate();
//    	String bonusAmount = currentRound.getBonusAmount();
    	String fakeLockRate = "0,3,1.9,1.9,1.9,1.9,1.9,1.9,1.9,1.9,1.9,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,0,0,0,0,0,0,0,0,0,0,0,0";
    	String fakeBonusAmount = "0,0,0,33888.88889,22699.44444,52262.98519,91787.87935,158040.6288,291058.158,522051.1514,963498.0971,1226912.605";
    	
    	
    	
    	List<Double> convertedRankList = Stream.of(fakeLockRate.split(","))
    			  .map(String::trim)
    			  .map(Double::parseDouble)
    			  .collect(Collectors.toList());
    	
    	
    	for (int i = 0; i < convertedRankList.size(); i++) {
			LockItem item = new LockItem();
			item.setAssetId(1L);
//			BigDecimal tokenAmount = currentRound.getReward();
			Double fakeAmount = 33333.3333;
			item.setAmount(new BigDecimal(slot*fakeAmount*convertedRankList.get(i))); // SL bi lock tai vong thu i
			item.setRound(i);
			// insert lock to DB
			lockItemService.save(item);
		}
    	
    	List<Double> convertedBonusAmountList = Stream.of(fakeBonusAmount.split(","))
  			  .map(String::trim)
  			  .map(Double::parseDouble)
  			  .collect(Collectors.toList());
    	
    	for(int j=0;j<convertedBonusAmountList.size();j++)
    	{
    		if(convertedBonusAmountList.get(j)==0)continue;
    		for (int i = 0; i < convertedRankList.size(); i++) {
    			Bonus item = new Bonus();
    			item.setAssetId(1L);
    			Double bonusAmount = convertedBonusAmountList.get(j);
    			item.setAmount(new BigDecimal(slot*bonusAmount*convertedRankList.get(i))); // SL bi lock tai vong thu i
    			item.setRound(i);
    			item.setStatus("INACTIVE");
    			// insert bonus to DB - done
    			bonusService.save(item);
    		}
    	}
    	
    	
    	
    	// TODO:  getLockedAmountAtRound - done
//    	TODO:  getLockedAmount - done 
    	// TODO:  getLockedBonusAmountAtRound - done
//    	TODO:  getLockedBonusAmount - done 
    	
    	return null;
	}
	
}
