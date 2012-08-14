/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.com.twitter.form;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author senthil
 */
public class TwitterForm extends org.apache.struts.action.ActionForm {
    
    private String twitterId;
    private int tweetCount;
    private Map map;
   

  
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    /**
     * @return
     */
    public String getTwitterId() {
        return twitterId;
    }

    /**
     * @param string
     */
    public void setTwitterId(String string) {
        twitterId = string;
    }

    /**
     * @return
     */
    public int getTweetCount() {
        return tweetCount;
    }

    /**
     * @param i
     */
    public void setTweetCount(int i) {
        tweetCount = i;
    }

    /**
     *
     */
    public TwitterForm() {
        super();
        // TODO Auto-generated constructor stub
    }

   

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        
        ActionErrors errors=new ActionErrors();
        
        if (getTwitterId() == null || getTwitterId().length() < 1) {
            errors.add("TweetId", new ActionMessage("error.TweetId.required"));
            // TODO: add 'error.TweetId.required' key to your resources
        }
        
        
        return errors;
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    
    
   
}
