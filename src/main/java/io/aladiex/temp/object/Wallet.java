package io.aladiex.temp.object;

public class Wallet {

	private String address;

	private String privateKey;

	private String accId;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	@Override
	public String toString() {
		return "Wallet [address=" + address + ", privateKey=" + privateKey + ", accId=" + accId + "]";
	}
	
	

}
