import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class NewsHeadlineScraper {

    public static void main(String[] args) {

        String url = "https://www.thehindu.com/news/national/maharashtra/";
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 11.0; Win64; x64) Chrome")
                    .referrer("https://www.google.com")
                    .get();

            Elements headlines = document.select("h3");

            System.out.println("Top News Headlines:\n");

            int count = 1;

            for (Element headline : headlines) {

                String text = headline.text();

                if (!text.isEmpty()) {
                    System.out.println(count + ". " + text);
                    count++;
                }
            }

        } catch (Exception e) {
            System.out.println("Error while fetching headlines");
            e.printStackTrace();
        }
    }
}
