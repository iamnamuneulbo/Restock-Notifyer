package com.restocknotifyer.checker;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.restocknotifyer.product.Product;

public class Checker {

	private Product product;

	public Checker(Product product) {

		this.product = product;
	}

	private String getUrl() {

		String prdUrl = product.getPrdUrl();
		Response response = null;
		try {
			response = Jsoup.connect(prdUrl).followRedirects(true).execute();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		prdUrl = response.url().toString();

		return (prdUrl);
	}

	public Product check() {

		String prdUrl = getUrl();

		Document doc = null;

		try {

			doc = Jsoup.connect(prdUrl).get();
		} catch (IOException e) {

			e.printStackTrace();
		}

		String prdNameTag = null;
		String prdImgTag = null;
		String soldoutTag = null;

		if (prdUrl.contains("smartstore")) {

			prdNameTag = "dt.prd_name";
			prdImgTag = "div.img_va img";
			soldoutTag = "div.not_goods";
		}

		else if (prdUrl.contains("lotte")) {

			prdNameTag = "p.pname";
			prdImgTag = "div.zoom-area img";
			soldoutTag = "div.prd-notice";
		}

		if (prdNameTag != null && prdImgTag != null && soldoutTag != null) {

			Elements prdNameEl = null;
			try {
				prdNameEl = doc.select(prdNameTag);
			} catch (Exception e) {
			}

			String prdName = prdNameEl.text();
			product.setPrdName(prdName);

			Elements img = doc.select(prdImgTag);

			String prdImg = img.attr("src");
			product.setPrdImg(prdImg);

			Elements soldout = doc.select(soldoutTag);

			if (soldout.isEmpty()) {
				product.setStock(true);
			}
		}

		return product;
	}
}