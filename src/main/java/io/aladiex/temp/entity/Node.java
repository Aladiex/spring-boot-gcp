package io.aladiex.temp.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Node {
	
	
	private int id;
	private Node parent;
	public ArrayList<Node> children = new ArrayList<Node>();
	private Customer customer = new Customer();
	private String origin;
	private int position=0;
	

	private int level = 0;
	
	
	public Node(Customer customer)
	{
		this.customer = customer;
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
	
	public String toString()
	{
		String str = "";
		for(int i=0;i<this.getLevel();i++)
		{
			str +="&emsp;";
		}
		str+=this.customer.getEmail()+"-"+this.customer.getSale()+"<br>";
		
		for(int j = 0; j<children.size();j++)
		{
			str+=children.get(j).toString();
		}
		return str;
	}
	
}
