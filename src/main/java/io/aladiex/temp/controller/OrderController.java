package io.aladiex.temp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.aladiex.temp.entity.Order;
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
    
    public OrderController(OrderService orderService, WalletService walletService, RoundService roundService) {
		// TODO Auto-generated constructor stub
    	this.orderService = orderService;
    	this.walletService = walletService;
    	this.roundService = roundService;
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
    	return order;
	}
	
}
