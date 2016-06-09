<%-- 
    Document   : user
    Created on : 18.09.2014, 15:44:10
    Author     : Vova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="../styles/user.style.css">
        <style type="text/css"></style>
        <script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
        <script src="../scripts/user.script.js"></script> 
    </head>
    <body load="bodyOnload()">
        <div id="wrapper">
            <div id="menu">
               <div style="display: inline;">
                   <a href="/blog/home"><img id="btnHome" style="cursor:pointer; margin-left: 150px;" src="../images/home-512.png" width="32" /></a>
               </div>
               <div style="display: inline;"><span id="title">Blogger+</span></div>
               <div style="display: inline; margin-left: 185px;">
                   <img id="btnLogOut" style="cursor:pointer; margin-left: 10px;" src="../images/shutdown-512.png" width="32" />
               </div>
            </div>
            <div id="main">
                <c:forEach var="val" items="${list}">
                    <div class="post">
                    <div class="postcontent">
                        <div class="poster"><br />${val.getInfo().getUsername()}</div>
                        <div class="postHeader">${val.getPost().getPostheader()}</div>
                        <div class="postK" style="margin-bottom: 20px;">
                            <div class="postContent">${val.getPost().getPostbody()}</div>
                            <div class="postCommentsList" style="display: none; margin-top: 10px; border-top: 1px solid #C0C0C0;">
                                 
                                
                                 <c:forEach var="com" items="${val.getInfo().getComments()}">
                                    <div class="comment">
                                        
                                        <div class="commentSender1">${com.getUsername()}</div>
                                        <div class="commentBody1">${com.getCommentbody()}</div>
                                    </div>
                                 </c:forEach>
                                
                                <form style="margin-top: 10px;" th:action="@{/commentA}" th:object="${comment}" method="post" action="/blog/commentA">
                                    <input hidden th:field="*{commentBody}" name="PostId" value="${val.getPost().getId()}}" />
                                    <textarea style=" border-radius: 2px; border: 1px solid white; width: 534px;"
                                              class="textInput" th:field="*{commentBody}" name="CommentBody"
                                              required placeholder="Enter your comment"></textarea><br>

                                    <input id="buttonSubmit" style=" border: 1px solid white; background:#C0C0C0; width: 540px;" type="submit" value="Comment" /><br>
                                </form>
                               
                            </div>
                            <div style="margin-top: 20px; height: 40px;">
                                <div class="postLikes" 
                                     style="display: inline; cursor: pointer;">
                                    <c:if test="${val.getInfo().containsUserid(currentUserId) == false}">
                                         <img class="commentLikeImg" src="../images/like-256.png" width="21" />
                                    </c:if>
                                    <c:if test="${val.getInfo().containsUserid(currentUserId) == true}">
                                         <img class="commentLikeImg" src="../images/like-pressed-256.png" width="21" />
                                    </c:if>
                                   
                                    <span class="postLikesCount" style="font-size: 13pt;">${val.getInfo().getLikes().size()}</span>
                                    <span class="postLikesPostid" style="display:none;">${val.getPost().getId()}</span>
                                </div>
                                <div class="postComments" 
                                     style="display: inline;cursor: pointer; position:relative;left: 480px;">
                                    <img src="../images/comments-256.png" width="21" />
                                    <span style="font-size: 13pt;">${val.getInfo().getComments().size()}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>	
                </c:forEach>        
            </div>
        </div>
            
    </body>
</html>