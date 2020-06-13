package io.aladiex.temp.controller;

import io.aladiex.temp.entity.Customer;
import io.aladiex.temp.entity.Node;

import io.aladiex.temp.service.CustomerService;
import io.aladiex.temp.tree.SalesAddedEvent;
import io.aladiex.temp.tree.SalesAddedListenner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * REST controller for managing {@link io.aladiex.common.domain.Customer}.
 */
@RestController
@RequestMapping("/api")
public class CustomerController implements SalesAddedListenner {

    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private static final String ENTITY_NAME = "Customer";
    Map<String, Node> treeMap = new HashMap<String, Node>();
    private final CustomerService customerService;
    Node root = null;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
        
    }
    
    
    /**
     * {@code GET  /customers} : get the tree.
     * @return the tree
     */
    public void  addTree() {
    	Customer rootCustomer = new Customer();
        String emailRoot = "root@aladin.com";
        rootCustomer.setEmail(emailRoot);
        rootCustomer.setOrigin(null);
        root = new Node(rootCustomer);
        treeMap.put(emailRoot, root);
        
        List<Customer> customers = customerService.getAll();
        log.info("length of customer: "+customers.size());
        
        for(int i=0;i<customers.size();i++)
        {
        	Customer customer = customers.get(i);
        	String email = customer.getEmail();
        	Node node = new Node(customer);
        	node.setListenner(this);
        	treeMap.put(email, node);	
        }
        
        for(int i=0;i<customers.size();i++)
        {
        	Customer customer = customers.get(i);
        	String origin = customer.getOrigin();
        	String email = customer.getEmail();
        	Node node = treeMap.get(email);
        	if(origin==null||origin.length()==0)
        	{
        		root.addChild(node);
        	}
        	else
        	{
        		Node parent = treeMap.get(origin);
        		parent.addChild(node);
        	}
        	
        }
       

        
    }
    
    /**
     * {@code GET  /customers} : get the tree.
     * @return the string of root node
     */
    @GetMapping("tree/all")
    public ResponseEntity<String> getTree() {
    	
        return ResponseEntity.ok().body(treeMap.get("root@aladin.com").toString());
        
    }
    
    @GetMapping("tree/create")
    public ResponseEntity<String> createTree() {
    	
    	
    	this.treeMap.clear();
    	this.addTree();    	
    	
        return ResponseEntity.ok().body("OK " + treeMap.size() +" node added");
        
    }
    @GetMapping("tree/addSale/{email}/{sale}")
    public ResponseEntity<String> addSale(@PathVariable String email,@PathVariable int sale) {
    	
    	
    	Node node = this.treeMap.get(email);
    	if(node !=null)
    	{
    		node.getParent().addSale(sale);
    		return ResponseEntity.ok().body("OK" + sale+" added to "+node.getParent().getCustomer().getEmail());
    	}
    	else
    	{
    		return ResponseEntity.notFound().build();
    	}
        
        
    }
    
    /**
     * {@code GET  /customers} : get the tree.
     * @return the string of node 
     */
    @GetMapping("tree/email/{email}")
    public ResponseEntity<String> getTreeByEmail(@PathVariable String email) {
    	if(treeMap.size()<=1)
    	{
    		this.addTree();
    	}
        return ResponseEntity.ok().body(treeMap.get(email).toString());
        
    }


	@Override
	public void onSalesAdded(SalesAddedEvent event) {
		// TODO Auto-generated method stub
		Node source = event.getSource();
		customerService.save(source.getCustomer());
		
		
	}
}
