<%-- 
    Document   : result
    Created on : 10 Aug, 2012, 3:26:45 PM
    Author     : senthil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%! int i = 0;
    int val = 0;%>
<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Twitter Puzzle Solution Page</title>
        <script type="text/javascript" src="jquery/jquery-1.7.2.js" ></script>
        <script type="text/javascript" src="jquery/jquery-ui.min.js"></script>
        <script type="text/javascript" src="jquery/extremes.js"></script>
        <link rel="stylesheet" type="text/css" href="files/result.css"></link>
        <script type="text/javascript">
            
            
                        
            $(document).ready(function(){
                         
                $('.reset').extremes({ 
                              
                    diameter:200  }
            );
                $('.reset li').hover(function(){
                    $('#desc'+(this.id)).show();
                },function(){
                    $('#desc'+(this.id)).hide("slide",{direction:"down"},500); 
                });
               
           
                $('.reset li').each(function() {
                    var $li = $(this);
                          
                    $li.hover(function() {
                        $li.effect('shake', {times: 1, distance: 1}, 200);
                    }, function() {
                        $li.effect('shake', {times: 2, direction: 'down', distance: 1}, 200);
                    });
                });
                
                
                
                $('.reset .words').each(function(){
                    
                    var $words=$(this);
                    
                    
                    $words.hover(function(){
                        var size=($(this).attr('value'))*3+20;
                                                   
                        $(this).css("fontSize", size+'px');
                    },function(){
                                   
                        $(this).css("fontsize", 30+'px'); 
                    });
                    
                    
                    
                    var num=$(this).attr('value');
                    var r = 175;
                    var b = 255-num*2;
                    var g = 150+num; 
                                      
                    //   var size1=20
                    //    var size=(num*10)+size1;
                    //alert("Font Size is "+size);
                    
                    
                    //   $(this).css("fontSize", size1+'px');
                    $(this).css("color", "rgb("+r+","+g+","+b+")");
                    // alert("Color is "+ "rgb("+r+","+g+","+b+")");
        
                });
                            
                
                
                
            });
           
            
        </script>
    </head>
    <body>
        <div id="head">
            <a href="home.jsp"> Twitter Handle@</a>
        </div>

        <div class="blocks">
            <ul class="reset">


                <logic:iterate id="m" name="TwitterForm" property="map"> 


                    <li id="<%=i%>" class="words"  value="<bean:write name="m" property="value"/>"><bean:write name="m" property="key"/></li>
                    <li id="desc<%=i%>" class="hide"><bean:write name="m" property="key"/>  Words  present <bean:write name="m" property="value"/> ToTal Tweets </li>
                    <%i++;%>
                </logic:iterate>

                <%i = 0;%>
            </ul>  

        </div>



    </body>
</html:html>
