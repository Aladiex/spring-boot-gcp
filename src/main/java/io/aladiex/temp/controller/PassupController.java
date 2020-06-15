package io.aladiex.temp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.aladiex.temp.entity.Customer;
import io.aladiex.temp.entity.Node;
import io.aladiex.temp.service.CustomerService;
import io.aladiex.temp.tree.SalesAddedEvent;
import io.aladiex.temp.tree.SalesAddedListenner;

/**
 * REST controller for managing {@link io.aladiex.common.domain.Customer}.
 */
@RestController
@RequestMapping("/api")
public class PassupController implements SalesAddedListenner {

    private final Logger log = LoggerFactory.getLogger(PassupController.class);

    private static final String ENTITY_NAME = "Customer";
    Map<String, Node> treeMap = new HashMap<String, Node>();
    private final CustomerService customerService;
    Node root = null;
    public PassupController(CustomerService customerService) {
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
        	String sponsor = customer.getSponsor();
        	String email = customer.getEmail();
        	Node node = TreeController.treeMap.get(email);
        	Node parent = null;
        	if(origin==null||origin.length()==0)
        	{
        		parent = root;
        		
        	}
        	else
        	{
        		parent = treeMap.get(origin);
//        		
        	}
        	
        	if(origin.equals(sponsor)==false)
        	{
//        		TODO: check customer invested
//        		TODO: check indexNumber of child is even
        		int postition = -1;
        		for (int j = 0; j < parent.children.size(); j++) {
        			if(parent.children.get(j).getCustomer().getEmail().equals(email))
        			{
        				postition = j+1;
        			}
        			
				} 
        		
//        		check index of child is even
        		if(postition%2==0)
        		{
        			log.info("Need passup ");
        			System.out.println("Need passup ");
        			parent.getParent().addChild(node);
        		}
        	}
        	
        	
        }        
    }
    
    /**
     * {@code GET  /customers} : get the tree.
     * @return the string of root node
     */
    @GetMapping("passup/all")
    public ResponseEntity<String> getTree() {
    	
        return ResponseEntity.ok().body(treeMap.get("root@aladin.com").toString());
        
    }
    
    @GetMapping("passup/create")
    public ResponseEntity<String> createTree() {
    	this.treeMap.clear();
    	this.addTree();    	
    	
        return ResponseEntity.ok().body("OK " + treeMap.size() +" node added");
    }
    @GetMapping("passup/addSale/{email}/{sale}")
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
    @GetMapping("passup/email/{email}")
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
