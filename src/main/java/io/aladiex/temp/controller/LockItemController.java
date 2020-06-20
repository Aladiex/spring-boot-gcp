package io.aladiex.temp.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
 * REST controller for managing {@link io.aladiex.common.domain.LockItem}.
 */
@CrossOrigin
@RestController(value = "LockItemController")
public class LockItemController{

    private final Logger log = LoggerFactory.getLogger(LockItemController.class);

    private static final String ENTITY_NAME = "LockItem";
    private final LockItemService lockItemService;
     
    public LockItemController(LockItemService lockItemService) {
		// TODO Auto-generated constructor stub
    	this.lockItemService = lockItemService;
	}
    

    @GetMapping(value = "/locked/roundid/{roundId}/assetid/{assetId}")
	public BigDecimal getLockedAmountAtRound(@PathVariable int roundId, @PathVariable Long assetId)
	{
    	return lockItemService.getLockedAmountAtRound(roundId, assetId);
	}
    
    
    @GetMapping(value = "/locked/assetid/{assetId}")
	public BigDecimal getLockedAmount( @PathVariable Long assetId)
	{
    	return lockItemService.getLockedAmount(assetId);
	}
}