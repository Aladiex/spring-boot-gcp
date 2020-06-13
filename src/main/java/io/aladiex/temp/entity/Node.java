package io.aladiex.temp.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

import io.aladiex.temp.tree.SalesAddedEvent;
import io.aladiex.temp.tree.SalesAddedListenner;


public class Node {
	
	
	private int id;
	private Node parent;
	public ArrayList<Node> children = new ArrayList<Node>();
	private Customer customer = null;
	private String origin;
	private int position=0;
	private int level = 0;
	private SalesAddedListenner listenner;
	
	public Node(Customer customer)
	{
		this.setCustomer(customer);
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Node getParent() {
		return parent;
	}
	

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	public void addChild(Node node)
	{
		node.setLevel(this.getLevel()+1);
		this.children.add(node);
		node.setParent(this);
	}
	
//	the parent call the addSale() method
	public void addSale(int sale)
	{
		this.getCustomer().setSale(this.getCustomer().getSale()+sale);
		if(this.getParent()!=null)
		{
			this.getParent().addSale(sale);
		}
		if (listenner != null) {
			listenner.onSalesAdded(new SalesAddedEvent(this));
		}
	}
	
	public String toString()
	{
		String str = "";
		for(int i=0;i<this.getLevel();i++)
		{
			str +="&emsp;";
		}
		str+=this.getCustomer().getEmail()+"-"+this.getCustomer().getSale()+"-"+this.getLevel()+"<br>";
		
		for(int j = 0; j<children.size();j++)
		{
			str+=children.get(j).toString();
		}
		return str;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public SalesAddedListenner getListenner() {
		return listenner;
	}

	public void setListenner(SalesAddedListenner listenner) {
		this.listenner = listenner;
	}
	
}
