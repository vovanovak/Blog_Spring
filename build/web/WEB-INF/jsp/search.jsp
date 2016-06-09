<%-- 
    Document   : search
    Created on : 19.09.2014, 16:31:01
    Author     : Vova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="styles/search.style.css">   
        <script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
        <script src="scripts/search.script.js"></script>
    </head>
    <body load="bodyOnload()">
        <div id="wrapper">
            <div id="menu">
                <div style="display: inline;">
                   <a href="/blog/home"><img id="btnHome" style="cursor:pointer; margin-left: 150px;" src="images/home-512.png" width="32" /></a>
               </div>
               <div style="display: inline;"><span id="title">Blogger+</span></div>
               <div style="display: inline; margin-left: 185px;">
                   <img id="btnLogOut" style="cursor:pointer; margin-left: 10px;" src="images/shutdown-512.png" width="32" />
               </div>
            </div>
            <div id="search">
                <input id="searchInput"  placeholder="Enter search request"  />
            </div>
            <div id="main">
                 <div id="postList">
                <c:forEach var="val" items="${list}">
                <div class="post">
                    <div class="postcontent">
                        <div class="poster"><br />${val.getInfo().getUsername()}</div>
                        <div class="postHeader">${val.getPost().getPostheader()}</div>
                        <div class="postK" style="margin-bottom: 20px;">
                            <div class="postContent">${val.getPost().getPostbody()}</div>
                            <div class="postCommentsList">
                                 <c:forEach var="com" items="${val.getInfo().getComments()}">
                                    <div class="comment">
                                        <div class="commentSender1">${com.getUsername()}</div>
                                        <div class="commentBody1">${com.getCommentbody()}</div>
                                    </div>
                                 </c:forEach>
                                
                                <form style="margin-top: 10px;" th:action="@{/comment}" th:object="${comment}" method="post" action="/blog/comment">
                                    <input hidden th:field="*{commentBody}" name="PostId" value="${val.getPost().getId()}}" />
                                    <textarea id="commentBodyInput"
                                              class="textInput"
                                              th:field="*{commentBody}"
                                              name="CommentBody"
                                              required placeholder="Enter your comment"></textarea><br>

                                    <input id="buttonSubmit" class="commentSubmit" type="button" value="Comment" /><br>
                                </form>
                            </div>
                            <div class="someDiv">
                                <div class="postLikes">
                                     
                                    <c:if test="${val.getInfo().containsUserid(val.getPost().getUserid()) == false}">
                                         <img class="commentLikeImg" src="images/like-256.png" width="21" />
                                    </c:if>
                                    <c:if test="${val.getInfo().containsUserid(val.getPost().getUserid()) == true}">
                                         <img class="commentLikeImg" src="images/like-pressed-256.png" width="21" />
                                    </c:if>
                                   
                                    <span class="postLikesCount">${val.getInfo().getLikes().size()}</span>
                                    <span class="postLikesPostid">${val.getPost().getId()}</span>
                                </div>
                                <div class="postComments" >
                                    <img src="images/comments-256.png" width="21" />
                                    <span class="commentsCount">${val.getInfo().getComments().size()}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>	
                </c:forEach>    
                </div>
            </div>
        </div>
            
    </body>
</html>