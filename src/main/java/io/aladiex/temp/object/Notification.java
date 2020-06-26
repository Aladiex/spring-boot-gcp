package io.aladiex.temp.object;

import java.util.UUID;

import com.google.gson.Gson;

public class Notification {

	private String id;
	private String type;
	private Data data;
	private long createdAt;
	private String network;
	private String additionData;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getAdditionData() {
		return additionData;
	}

	public void setAdditionData(String additionData) {
		this.additionData = additionData;
	}

	public String generateId() {
		return UUID.randomUUID().toString();
	}

	public Notification() {
	}

	public Notification(String type, Data data, String network, String additionData) {
		this.id = generateId();
		this.type = type;
		this.data = data;
		this.createdAt = System.currentTimeMillis();
		this.network = network;
		this.additionData = additionData;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", type=" + type + ", data=" + new Gson().toJson(data) + ", createdAt="
				+ createdAt + ", network=" + network + ", additionData=" + additionData + "]";
	}

}