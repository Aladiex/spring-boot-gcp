package io.aladiex.temp.controller;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.aladiex.temp.object.Calculation;
import io.aladiex.temp.object.Notification;
import io.aladiex.temp.object.Wallet;

@RestController(value = "LightWalletController")
public class LightWalletController {

	final public static String EMAIL = "aladiex.official@gmail.com";
	final public static String PASS = "thispassworkisveryfuckysecretst";
	final public static String TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJsaWdodHdhbGxldCIsImp0aSI6ImFsYWRpZXgub2ZmaWNpYWxAZ21haWwuY29tIn0.g498j4-YFHzFpz2nQSmInt5D7gPB9-plPtAuJ3Zy9xs";
	final public static String DOMAIN = "https://alawallet.df.r.appspot.com/";
	final public static String NOTIFICATION_TOKEN = "cfEtQGkKWOrhm8OwoYGOTeLdceRG2A5dMuENOVcCSeSDSb4rbY";

	static Calculation cal = new Calculation();
	static Logger log = Logger.getLogger(LightWalletController.class.getName());

	ExecutorService executorService = Executors.newFixedThreadPool(1);

	@PostMapping(value = "/api/notifications")
	@ResponseBody
	public String responce(@RequestBody Notification notifi, @RequestParam("t") String notifiToken) throws IOException {
		// security filter here
		if (!notifiToken.equals(LightWalletController.NOTIFICATION_TOKEN)) {
			log.warning("Url token invalid!");
			return null;
		}
		log.info("notifi: " + notifi.toString());
		executorService.execute(new Runnable() {
			public void run() {
				try {
					if (notifi.getType().equals("wallet:addresses:new-payment")) {
						notifiNewPayment(notifi);
					} else if (notifi.getType().equals("wallet:addresses:send")) {
						notifiSendPayment(notifi);
						// }else if (notifi.getType().equals("wallet:addresses:buy")) {
						// LightWallet.notifiBuyPayment(notifi, transactionReponsitory, userRepository);
						// }else if (notifi.getType().equals("wallet:addresses:sell")) {
						// LightWallet.notifiSellPayment(notifi, transactionReponsitory,
						// userRepository);
					} else {
						log.warning("notification type invalid: " + notifi.getType());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		return null;
	}

	public static JSONObject sendCoin(String account, String to, String amount, String fee, String currency,
			String dataObj) throws IOException {
		account = account.replaceAll(" ", "%20");
		String url = LightWalletController.DOMAIN + "/accounts/" + account + "/transactions";
		log.info("url send: " + url);
		JSONObject json = new JSONObject();
		json.put("to", to);
		json.put("amount", amount);
		json.put("currency", currency);
		json.put("data", dataObj);
		json.put("fee", fee);
		log.info("account: " + account + " send info: " + json.toString());
		JSONObject result = new JSONObject();
		try {
			Response res = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true)
					.header("Content-Type", "application/json").header("Authorization", LightWalletController.TOKEN)
					.requestBody(json.toString()).method(Method.POST).timeout(100 * 1000).execute();
			log.info("send coin body: " + res.body());
			log.info("send coin code: " + res.statusCode() + "");
			JSONObject resp = new JSONObject(res.body());
			result.put("hash", resp.getString("hash"));
			result.put("fee", resp.getString("fee"));
			return result;
		} catch (Exception e) {
			log.severe("send coin ex: " + e.getMessage());
			result.put("hash", "0xtransactionerrorhashnotfound" + System.currentTimeMillis());
			result.put("fee", fee);
			return result;
		}
	}

	public static JSONObject buySellCoin(String account, String type, String amount, String fee, String currency,
			String dataObj) throws IOException {
		String url = LightWalletController.DOMAIN + "/accounts/" + account + "/buysell";
		log.info("url send: " + url);
		JSONObject json = new JSONObject();
		json.put("type", type);
		json.put("amount", amount);
		json.put("currency", currency);
		json.put("data", dataObj);
		json.put("fee", fee);
		log.info("account: " + account + " send info: " + json.toString());
		JSONObject result = new JSONObject();
		try {
			Response res = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true)
					.header("Content-Type", "application/json").header("Authorization", LightWalletController.TOKEN)
					.requestBody(json.toString()).method(Method.POST).timeout(90 * 1000).execute();
			log.info(res.body());
			log.info(res.statusCode() + "");
			JSONObject resp = new JSONObject(res.body());
			result.put("hash", resp.getString("hash"));
			result.put("fee", resp.getString("fee"));
			return result;
		} catch (Exception e) {
			log.severe("send coin ex: " + e.getMessage());
			result.put("hash", "hash");
			result.put("fee", fee);
			return result;
		}
	}

	public static String getEthFee() {
		String url = "https://ethgasstation.info/json/ethgasAPI.json";
		double fee = 0.0;
		try {
			Document doc = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true).timeout(30 * 1000).get();
			log.info("result: " + doc.body().text());
			JSONObject json = new JSONObject(doc.body().text());
			fee = json.getDouble("fast") / 10;
			return cal.divide(fee * 21000, 1000000000);
		} catch (Exception e) {
			log.warning("get Eth fee ex: " + e.getMessage());
			return "0.00063";
		}
	}

	public static String createAccount(String email, String curency) throws IOException {
		String url = LightWalletController.DOMAIN + "/accounts";
		JSONObject json = new JSONObject();
		json.put("name", email + "-" + curency);
		json.put("primary", true);
		if (curency.equals("USDT"))
			curency = "ETH";
		if (curency.equals("TXC") || curency.equals("VNDT"))
			curency = "TRX";
		json.put("currency", curency);
		try {
			Response res = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true)
					.header("Content-Type", "application/json").header("Authorization", LightWalletController.TOKEN)
					.requestBody(json.toString()).method(Method.POST).timeout(60 * 1000).execute();
			System.out.println(res.body());
			if (res.statusCode() == 200) {
				return res.body();
			}
			if (res.body().indexOf("is already exist") > -1) {
				return getAccount(email, curency);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e.getMessage());
		}
		return null;
	}

	public static String getAccount(String email, String curency) throws IOException {
		String id = EMAIL + "|" + email + "-" + curency;
		String url = DOMAIN + "/accounts/" + id;
		try {
			Document doc = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true)
					.header("Content-Type", "application/json").header("Authorization", TOKEN).timeout(60 * 1000).get();
			log.info(doc.body().text());
			String res = doc.body().text();
			if (res.indexOf("Error Page") > -1) {
				return null;
			}
			return res;
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
			throw new IOException(e.getMessage());
		}
	}

	public static void resetTokenBalance(String email, String address, String currency, String token)
			throws IOException {
		email = email.replaceAll(" ", "%20");
		String id = EMAIL + "|" + email + "-" + currency;
		String url = DOMAIN + "/accounts/" + id + "/address/" + address + "/check-balance/" + token;
		try {
			Document doc = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true)
					.header("Content-Type", "application/json").header("Authorization", TOKEN).timeout(60 * 1000).get();
			log.info(doc.body().text());
			String res = doc.body().text();
			if (res.indexOf("Error Page") > -1) {
				return;
			}
			return;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e.getMessage());
		}
	}

	public static Wallet createWalletAddress(String email, String currency) throws Exception {
		JSONObject json = new JSONObject(createAccount(email, currency));
		Wallet wallet = new Wallet();
		wallet.setAddress(json.getString("primaryAddress"));
		wallet.setAccId(json.getString("id"));
		wallet.setPrivateKey(json.getString("secretSeeds"));
		return wallet;
	}

	public void notifiSendPayment(Notification notifi) throws IOException {
		String hash = notifi.getData().getHash();

		boolean tranInvalid = notifi.getData().isInvalid();
		if (tranInvalid) {
			log.warning("Transaction is invalid");
			return;
		}
		// TODO
		return;
	}

	public void notifiNewPayment(Notification notifi) throws IOException {
		String hash = notifi.getData().getHash();

		boolean tranInvalid = notifi.getData().isInvalid();
		if (tranInvalid) {
			log.warning("Transaction is invalid");
			return;
		}
		// TODO
		return;
	}

}
