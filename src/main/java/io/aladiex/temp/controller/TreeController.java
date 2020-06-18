package io.aladiex.temp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class TreeController implements SalesAddedListenner {

    private final Logger log = LoggerFactory.getLogger(TreeController.class);

    private static final String ENTITY_NAME = "Customer";
    
    public static Map<String, Node> treeMap = new HashMap<String, Node>();
    public static List<Customer> customers = new ArrayList<>();
    
    private final CustomerService customerService;
    Node root = null;
    public TreeController(CustomerService customerService) {
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
        
        customers = customerService.getAll();
        log.info("length of customer: "+customers.size());
        
        for(int i=0;i<customers.size();i++)
        {
        	Customer customer = customers.get(i);
        	String email = customer.getEmail().trim();
        	Node node = new Node(customer);
        	node.setListenner(this);
        	treeMap.put(email, node);	
        }
        
       
        
//        List<String> origins = Arrays.asList("buidinhngoc.ai@gmail.com", "contact@winvest.io", "hoangdev@gmail.com");
        List<String> origins = Arrays.asList("hoangdev@gmail.com");
        origins.forEach(orig -> {
        	Node origin = treeMap.get(orig);
        	root.addChild(origin);
        	buildTree(origin);
        });
        
    }
    
    private void buildTree(Node ala) {
    	String email = ala.getCustomer().getEmail();
    	if (email == null || email.isEmpty()) return;
    	List<Customer> customs = customers.stream().filter(item -> item.getOrigin().equalsIgnoreCase(email)).collect(Collectors.toList());
    	customs.forEach(item -> {
    		Node node = treeMap.get(item.getEmail());
    		ala.addChild(node);
    		buildTree(node);
    	});
    }
    
    /**
     * add new node to the treeMap.
     * @param new Customer
     * @return the treeMap with new node.
     */
    public Map<String, Node> addNewNode(Customer newCustomer)
    {
    	Node newNode = new Node(newCustomer);
    	String email = newCustomer.getEmail();
    	String origin = newCustomer.getOrigin();
    	if(treeMap.get(email)==null)
    	{
    		if(origin.length()>0||origin!=null)
        	{
        		Node parentNode = treeMap.get(origin);
        		parentNode.addChild(newNode);
        		treeMap.put(email, newNode);
        	}
    	}
    	
    	return treeMap;
    }
    
    /**
     * {@code GET  tree/all} : get the tree.
     * @return the string of root node
     */
    @GetMapping("tree/all")
    public ResponseEntity<String> getTree() {
    	
        return ResponseEntity.ok().body(treeMap.get("root@aladin.com").toString());
        
    }
    
    
    /**
     * {@code GET  tree/create} : create the tree.
     * @return the string size of node
     */
    @GetMapping("tree/create")
    public ResponseEntity<String> createTree() {
    	this.treeMap.clear();
    	this.addTree();    	
    	
        return ResponseEntity.ok().body("OK " + treeMap.size() +" node added");
    }
    
    /**
     * {@code GET  /tree/addSale/{email}/{sale}} : add the sale for Node.
     * @param String email, int sale
     * @return the string ok  if add sale to node success
     */
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
     * {@code GET  /tree/email/{email} : get the tree.
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
    

    /**
     * {@code GET  /tree/email/{email}/children} : get children of the node.
     * @return the string of node 
     */
    @GetMapping("tree/email/{email}/children")
    public ResponseEntity<String> getChildrenOfNodeByEmail(@PathVariable String email) {
        return ResponseEntity.ok().body(treeMap.get(email).children.size()+"");
    }
    
    /**
     * {@code GET  /tree/email/{email}/children} : get children of the node.
     * @return the total decendant of node -1 
     */
    @GetMapping("tree/email/{email}/descendant")
    public ResponseEntity<String> getDescendantOfNodeByEmail(@PathVariable String email) {
    	return ResponseEntity.ok().body(treeMap.get(email).getDescendant()+"");        
    }
    
    /**
     * {@code GET  /tree/email/{email}/sale} : get children of the node.
     * @return the string of node 
     */
    @GetMapping("tree/email/{email}/sale")
    public ResponseEntity<String> getSaleOfNodeByEmail(@PathVariable String email) {
    	return ResponseEntity.ok().body(treeMap.get(email).getCustomer().getSale()+"");        
    }
    
	@Override
	public void onSalesAdded(SalesAddedEvent event) {
		// TODO Auto-generated method stub
		Node source = event.getSource();
		customerService.save(source.getCustomer());
	}
}
