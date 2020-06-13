package io.aladiex.temp.tree;

import java.util.EventListener;



public interface SalesAddedListenner extends EventListener {
	public void onSalesAdded(SalesAddedEvent event);
}
