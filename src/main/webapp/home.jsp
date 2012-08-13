<%-- any content can be specified here e.g.: --%>
<%@ page pageEncoding="UTF-8" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html>
    <head>
        <title>Twitter Puzzle Solution</title>
        <link rel="stylesheet" type="text/css" href="files/home.css"/>
    </head>
    <body>
        <div id="content">
        <html:form action="/twitterHandle.action">
            <table border="0" align="center">
                <tr>
                    <td colspan="41" class="row"><font color="red"><html:errors /></font></td>
                </tr>

                <tbody>
                    <tr>
                       
                    </tr>
                    <tr>
                        
                        <td align="left" class="row">Twitter Handle @</td>
                        <td align="left" class="row"><html:text property="twitterId" size="30" maxlength="30"/><br/></td>
                    </tr>
                    <tr>
                        <br/>
                        <td align="left" class="row">No Of Tweets </td>
                        <td align="left" class="row">
                            <html:select  property="tweetCount" >
                                         <option>200</option>
                                         <option>400</option>
                                         <option>600</option>
                                         <option>800</option>
                                         <option>1000</option>
                            </html:select></td>
            
            
                    </tr>
                    <br/>
                    <tr>
                        <td align="center" class="row"><input type="image" src="files/submit.png" alt="img alt" border="0" /> </td>
                        
                    </tr>
                </tbody>
            </table>

        </html:form>
            </div>
    </body>
</html:html>
