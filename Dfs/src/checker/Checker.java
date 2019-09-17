package checker;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Checker implements Runnable {
	private ArrayList<Product> prdList;
	private int result;
	
	public Checker(ArrayList<Product> list) {
		prdList = list;

		System.out.println("Checker 생성자");
	}

	@Override
	public void run() {
		System.out.println("스레드 시작");
		// TODO Auto-generated method stub
		while (true) {
			try {
				for (int i = 0; i < prdList.size(); i++) {
					String prdUrl = prdList.get(i).getPrdUrl();
					Document doc = null;
					try {
						doc = Jsoup.connect(prdUrl).get();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					String title = "lottedfs";

					if (title.equals("lottedfs")) {
						Elements prdName = doc.select("em.name");
						String prdNameText = prdName.text();

						Elements img = doc.select("#detailZoom");
						String imgPath = img.attr("src");

						Elements soldout = doc.select("div.buyBtn.soldOut");
						// System.out.println(soldout.isEmpty());
						if (soldout.isEmpty()) {
							System.out.println("재고있음" + prdNameText);
							//out.println("<script>notificationOpen('" + prdName + "', '" + prdUrl + "');</script>");
						}
					}
				}
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public int getResult() {
		return result;
	}
}
