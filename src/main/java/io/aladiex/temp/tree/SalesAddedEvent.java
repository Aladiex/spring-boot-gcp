package io.aladiex.temp.tree;

import io.aladiex.temp.entity.Node;

public class SalesAddedEvent {
	private Node source;
	public SalesAddedEvent(Node source)
	{
		this.setSource(source);
	}
	public Node getSource() {
		return source;
	}
	public void setSource(Node source) {
		this.source = source;
	}
	
}