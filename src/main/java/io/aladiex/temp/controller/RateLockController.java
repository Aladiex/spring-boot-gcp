package io.aladiex.temp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.aladiex.temp.entity.Customer;
import io.aladiex.temp.entity.Node;
import io.aladiex.temp.entity.RateLock;
import io.aladiex.temp.service.CustomerService;
import io.aladiex.temp.service.RateLockService;
import io.aladiex.temp.tree.SalesAddedEvent;
import io.aladiex.temp.tree.SalesAddedListenner;

/**
 * REST controller for managing {@link io.aladiex.common.domain.RateLock}.
 */
@RestController
@RequestMapping("/api")
public class RateLockController{

    private final Logger log = LoggerFactory.getLogger(RateLockController.class);

    private static final String ENTITY_NAME = "RateLock";
    
      
    private final RateLockService rateLockService;
    
    public RateLockController(RateLockService rateLockService) {
        this.rateLockService = rateLockService;  
    }
    
   
    
    /**
     * {@code GET  /tree/email/{email} : get the tree.
     * @return the string of node 
     */
    @GetMapping("token/lock/projId/{projectId}/roundat/{roundat}")
    public String getRateLockByProjectIdAndRoundAt(@PathVariable Long projectId, @PathVariable int roundAt) 
    {
    	RateLock rateLock = rateLockService.getRateLockByProjIdAndRoundAt(projectId, roundAt).get();
    	BigDecimal bonus = rateLock.getBonus();
    	BigDecimal token = rateLock.getToken();
    	String rate = rateLock.getRate();
    	JSONObject jsonObj = new JSONObject(rate);
    	
        return "";
    }
    

    
}
