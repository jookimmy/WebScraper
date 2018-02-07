import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class WebScraper {
    public static void main(String[] args) {
        int hamletWords = urlToString("http://erdani.com/tdpl/hamlet.txt").split(" ").length;
        System.out.println("Hamlet word count: " + hamletWords);
        int leisure = urlToString("https://www.bls.gov/tus/charts/chart9.txt").split(" ").length;
        System.out.println("Leisure word count: " + leisure);
        int forecast = urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt").split(" ").length;
        System.out.println("Forecast word count: " + forecast);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int oneWord(String keyword, String url) {
        String arrURL[] = url.toLowerCase().split(" ");
        String newKeyword = keyword.toLowerCase();
        int count = 0;
        for (String word: arrURL) {
            if (word == newKeyword) {
                count++;
            }
        }
        return count;
    }

    public static int uniqueCount(String url) {
        String splitURL[] = url.split(" ");
        return 0;
    }
}

