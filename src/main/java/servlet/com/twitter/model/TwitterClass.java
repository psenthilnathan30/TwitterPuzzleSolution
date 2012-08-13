/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twitter.model;

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
        String str1 = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    
    public Map tweetCount(String userName, int tweetCount) throws TwitterException {

        Twitter unauthenticatedTwitter = new TwitterFactory().getInstance();
        List l = new ArrayList();
        Set set = new TreeSet();
        int pageCount = tweetCount / 200;
        List<Status> statuses[] = new ResponseList[pageCount];

       
        int c = 1;
        for (int i = 0; i < statuses.length; i++) {
            Paging paging = new Paging(i + 1, 200);
             
          statuses[i] = unauthenticatedTwitter.getUserTimeline(userName, paging);
            
            for (Status s : statuses[i]) {

                System.out.println("TimeLine: " + s);
                String text = s.getText();
                int wc = wordCount(text);
                l.add(new Integer(wc));
                set.add(new Integer(wc));
                System.out.println("The total tweet count is " + c++ + " " + text);
            }
        }

        Map m = new HashMap();
        for (Object wordCount : set) {
            int occurence = Collections.frequency(l, wordCount);
            m.put((Integer) wordCount, new Integer(occurence));
        }

        return m;
    }

    public static void main(String[] arg) throws TwitterException {

        System.out.println("hiiiiiiiiiiii");
        Map m = new TwitterClass().tweetCount("actorSurya", 200);
        for (Object obj : m.keySet()) {
            System.out.println("No of Words: " + obj + " : No of times: " + m.get(obj));
        }

    }
}
