/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.com.twitter.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author senthil
 */
public class TwitterClass {

    public static int wordCount(String str) {
        int count = 1;
       
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    public Map getTweetsFromTwitter(String userName, int totalCount) throws TwitterException {

        Twitter unauthenticatedTwitter = new TwitterFactory().getInstance();
        List l = new ArrayList();
        Set set = new TreeSet();
        int pageCount = totalCount / 200;
        List<Status> statuses[] = new ResponseList[pageCount];
        for (int i = 0; i < statuses.length; i++) {
            Paging paging = new Paging(i + 1, 200);
            statuses[i] = unauthenticatedTwitter.getUserTimeline(userName, paging);
            for (Status s : statuses[i]) {
                String text = s.getText();
                int wc = wordCount(text);
                l.add(new Integer(wc));
                set.add(new Integer(wc));              
            }
        }

        Map m = new HashMap();
        for (Object wordCount : set) {
            int occurence = Collections.frequency(l, wordCount);
            m.put((Integer) wordCount, new Integer(occurence));
        }

        return m;
    }

   
}
