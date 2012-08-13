/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twitter.action;

import com.twitter.form.TwitterForm;
import com.twitter.model.TwitterClass;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author senthil
 */
public class TwitterHandle extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        
        TwitterForm tf=(TwitterForm)form;
        String id=tf.getTwitterId();
        int totalTweetCount=tf.getTweetCount();
        
        TwitterClass twitterClass=new TwitterClass();
        
        Map map=twitterClass.tweetCount(id, totalTweetCount);
        tf.setMap(map);
        
        
        
        return mapping.findForward(SUCCESS);
    }
}
