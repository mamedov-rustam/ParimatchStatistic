package parimatch.hacker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by rustam on 10.07.15.
 */
public class GamesService {
    private static final Logger LOG = Logger.getAnonymousLogger();
    private URL url;
    private String html;

    public GamesService(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    // TEMP!!!
    public GamesService(String html, Boolean b) {
        this.html = html;
    }

    public List<MatchWithTotal> findMatches(String command) throws IOException {
        ArrayList<MatchWithTotal> matchWithTotals = new ArrayList<>();

        Random random = new Random();
        Iterator<Element> iterator = Jsoup.parse(html).getElementsByTag("tr").iterator();
        while (iterator.hasNext()) {
            Element tr = iterator.next();
            Elements tds = tr.getElementsByTag("td");
            if (tds.size() > 3 && tds.get(1).toString().toUpperCase().contains(command.toUpperCase())) {
                String[] score = tds.get(3).text().trim().split(":");
                int total = Integer.valueOf(score[0]) + Integer.valueOf(score[1]);
                double kof = KofGenerator.generate(); // need replace on real kof
                matchWithTotals.add(new MatchWithTotal(kof, total));
            }
        }

        return matchWithTotals;
    }
}
