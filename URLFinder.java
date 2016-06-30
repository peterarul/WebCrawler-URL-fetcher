
/**
 * Write a description of URLFinder here.
 * 
 * @author (Arul Peter) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class URLFinder {
public StorageResource findURLs(String url) {
        URLResource page = new URLResource(url);
        String source = page.asString();
        StorageResource store = new StorageResource();
        int start = 0;
        while (true) {
            int index = source.indexOf("href=", start);
            if (index == -1) {
                break;
            }
            int firstQuote = index+6; // after href="
            int endQuote = source.indexOf("\"", firstQuote);
            String sub = source.substring(firstQuote, endQuote);
            if ((sub.startsWith("http"))) {
                store.add(sub);
            }
            start = endQuote + 1;
        }
        return store;

        }

    public void testURL() {
        //StorageResource s1 = findURLs("https://www.whitehouse.gov");
        StorageResource s2 = findURLs("http://www.dukelearntoprogram.com/course2/data/newyorktimes.html");
        int j = 0;
        for (String link : s2.data()) {
            //System.out.println(link.endsWith(".com"));
            
            System.out.println(link);
            if (link.endsWith(".com") ||link.endsWith(".com/")){
                j++;
                System.out.println("Number links that end with .com or .com/ ::"+j);
            };
            
            
        }
        String link = s2.data().toString();
        int x = link.indexOf(".");
            int count = 0;
            while (x != -1) {
                count++;
                link = link.substring(x + 1);
                x = link.indexOf(".");
            }
        System.out.println("No of *.* in the input is : " + count);
       
        //link.endsWith(".com");
        //link.endsWith(".com/");
        
        //System.out.println("size = " + s1.size());
        System.out.println("size = " + s2.size());
    }
}
