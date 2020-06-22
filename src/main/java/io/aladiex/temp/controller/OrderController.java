package io.aladiex.temp.controller;

import java.math.BigDecimal;
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
import io.aladiex.temp.entity.LockItem;
import io.aladiex.temp.entity.Order;
import io.aladiex.temp.entity.Round;
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
    
    public OrderController(OrderService orderService, WalletService walletService, RoundService roundService, LockItemService lockItemService) {
		// TODO Auto-generated constructor stub
    	this.orderService = orderService;
    	this.walletService = walletService;
    	this.roundService = roundService;
    	this.lockItemService = lockItemService;
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
    	
    	
    	
    	// vi du assetID cua ala la 1
//    	Long projectId = 1;
//    	String lockRate = roundService.getUnlockRate(projectId, "ACTIVE");
    	String fakeLockRate = "0,3,1.9,1.9,1.9,1.9,1.9,1.9,1.9,1.9,1.9,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,0,0,0,0,0,0,0,0,0,0,0,0";
    	
    	List<Double> convertedRankList = Stream.of(fakeLockRate.split(","))
    			  .map(String::trim)
    			  .map(Double::parseDouble)
    			  .collect(Collectors.toList());
    	
    	
    	for (int i = 0; i < convertedRankList.size(); i++) {
			LockItem item = new LockItem();
			item.setAssetId(1L);
			Double fakeAmount = 33333.3333;
			item.setAmount(new BigDecimal(fakeAmount*convertedRankList.get(i))); // SL bi lock tai vong thu i
			item.setRound(i);
			// insert lock to DB
			lockItemService.save(item);
		}
    	
    	// Xong viec insert vao Lockitem 
    	
    	// TODO:  getLockedAmountAtRound - done
//    	TODO:  getLockedAmount - done
//    	TODO: getBonus()
    	
    	return null;
	}
	
}
