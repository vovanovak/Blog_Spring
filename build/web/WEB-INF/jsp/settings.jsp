<%-- 
    Document   : settings
    Created on : 20.09.2014, 18:40:34
    Author     : Vova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Settings</title>
        <link rel="stylesheet" type="text/css" href="styles/search.style.css">  
        <script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
        <script>
            function getSettings(){
                
                
                
            }
            $(document).ready(function() {
                $('#btnWatch').on("click", function(){
                    $($('#elemId').val()).css($('#prop').val(), $('#value').val());
                });
                $('#btnSave').on("click", function(){
                    var elemid1 = $('#elemId').val();
                    var prop1 = $('#prop').val();
                    var value1 = $('#value').val();
                    $.ajax({
                        url: "/blog/settingssave",
                        type: "POST",
                        data: {elemid: elemid1, prop: prop1, value: value1},
                        success: function(){
                            alert("Success");
                        }
                    });
                });
                setTimeout(
                        function(){
                            $.ajax({
                                url: "/blog/settingsget",
                                type: "POST",
                                data: {d: "post"},
                                success: function(res){
                                    var list = JSON.parse(res);
                                    for (var i = 0;i<list.length;i++){
                                        console.log(list[i]);
                                        var elem = list[i].element;
                                        var prop = list[i].property;
                                        var val = list[i].value;

                                        $($(elem).val()).css($().val(prop), $(val).val());
                                    }
                                }
                            });
                        }, 2000);
 
//                $('#btnSwitch').on("click", function(){
//                    url: "blog/settingsdef",
//                    type: "POST",
//                    data: {obj: "obj"},
//                    success: function(){
//                        alert("Success");
//                    }
//                });
            });
        </script>
    </head>
    <body>
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
            
            <div id="main">
                <div id="postList">
                
                <div class="post">
                    <div class="postcontent">
                        <div class="poster"><br />Sender</div>
                        <div class="postHeader">Header</div>
                        <div class="postK" style="margin-bottom: 20px;">
                            <div class="postContent">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                            <div class="postCommentsList" style="display: block;">
                                 
                                <div class="comment">
                                    <div class="commentSender1">Comment Sender</div>
                                    <div class="commentBody1">Some comment here</div>
                                </div>
                                 
                                
                                <form style="margin-top: 10px;" th:action="@{/comment}" th:object="${comment}" method="post" action="/blog/comment">
                                    <input hidden th:field="*{commentBody}" name="PostId" value="${val.getPost().getId()}}" />
                                    <textarea id="commentBodyInput"
                                              class="textInput"
                                              th:field="*{commentBody}"
                                              name="CommentBody"
                                              required placeholder="Enter your comment"></textarea><br>

                                    <input id="buttonSubmit" class="commentSubmit" style="background: #C0C0C0; width: 540px; border: 1px solid white;" type="button" value="Comment" /><br>
                                </form>
                            </div>
                            <div class="someDiv">
                                <div class="postLikes">
                                     
                                   
                                    <img class="commentLikeImg" src="images/like-256.png" width="21" />
                                    
                                   
                                    <span class="postLikesCount">0</span>
                                    <span class="postLikesPostid">1</span>
                                </div>
                                <div class="postComments" >
                                    <img src="images/comments-256.png" width="21" />
                                    <span class="commentsCount">0</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>	
                    <form>
                        <input id="elemId" class="searchInput1" placeholder="Enter element id or class" />
                        <input id="prop" class="searchInput1" placeholder="Enter property" />
                        <input id="value" class="searchInput1" placeholder="Enter value" />
                        <input class="commentSubmit" id="btnWatch" value="Watch" type="button" />
                        <input class="commentSubmit" id="btnSave" value="Save" type="button" />
                        <input class="commentSubmit" id="btnSwitch" value="Switch to default" type="button" />
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
