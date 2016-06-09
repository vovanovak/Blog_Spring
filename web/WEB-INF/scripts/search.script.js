/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function rotate(angle, name) {
    var $elem = $(name);

    $({deg: 0}).animate({deg: angle}, {
        duration: 2000,
        step: function(now) {
            $elem.css({
                transform: 'rotate(' + now + 'deg)'
            });
        },
        complete: function() {
           window.location.replace("/blog/logout");
        }
    });
}
 function hasLikes(pid, i){
    $.ajax({
        url: "/blog/haslike",
        type: "POST",
        data: {postid: pid},

        success: function(res) {

            var elem = document.getElementsByClassName("post")[i];
            if (res == "true")
                $(elem).find('.postLikes').find('img').attr("src", "images/like-pressed-256.png");
            else
                $(elem).find('.postLikes').find('img').attr("src", "images/like-256.png");
        }
    });
}

function getUsernameById(uid, i){

    $.ajax({
        url: "/blog/getusername",
        type: "POST",
        data: {userid: uid},

        success: function(res) {
           var elem = document.getElementsByClassName("post")[i];

           $(elem).find('.poster').text(res);
        }
    });

}


$(window).load(function() {

    $('#searchInput').focus();
    $('#searchInput').on("input", function(){

        var req = $('#searchInput').val();
        $.ajax({
            url: "/blog/search",
            type: "POST",
            data: {request: req },
            success: function(res) {
              var list = JSON.parse(res);
              $('#postList').html("");
              for (var i = 0;i<list.length;i++){

                  $('#postList').append(
                        '<div class="post">' +
                        '<div class="postcontent"><br />' +
                        '<a href="/blog/user/' + list[i].post.userid + '" style="text-decoration: none;"><div class="poster" ><br /></div></a>' +
                        '<div class="postHeader">' + list[i].post.postheader + '</div>' +
                        '<div class="postK" style="margin-bottom: 20px;">' +
                            '<div class="postContent">' + list[i].post.postbody  + '</div>' + 
                             '<div class="someDiv">'+
                             '<div class="postLikes">' +
                                    '<img src="" width="21" /> ' +
                                    '<span class="postLikesCount">' + list[i].info.likes.length + '</span>'+
                                    '<span class="postLikesPostid">'+ list[i].post.id + '</span>'+
                                '</div>'+
                               ' <div class="postComments" >'+
                                '    <img src="images/comments-256.png" width="21" />'+
                                 '   <span class="commentsCount">' +  list[i].info.comments.length +'</span>'+
                               ' </div>'+
                           ' </div>'+
                            '</div>' +
                    '</div>');


              }
              for (var i = 0;i<list.length;i++){
                  hasLikes(list[i].post.id, i);
                  getUsernameById(list[i].post.userid, i);
              }
        }});
    });
    $('.postComments').on("click", function (){ 
        if ($(this).parents(".postK").find(".postCommentsList").css("display") == "block"){
            $(this).parents(".postK").find(".postCommentsList").slideUp();
        }else{
            $(this).parents(".postK").find(".postCommentsList").slideDown();
        }
    });
    $('.postLikes').on("click", function() {
        var pid = $(this).parent().find('.postLikesPostid').text();
        var img = $(this).find('.commentLikeImg');
        var count = $(this).find('.postLikesCount');
        var val = 0;
        if (img.attr('src') == 'images/like-256.png'){
            val = 1;
        }
        else{
            val = -1;
        }
        $.ajax({
            url: "/blog/likeA",
            type: "POST",
            data: {postid: pid, plus: val },

            success: function() {
                if (img.attr('src') == 'images/like-256.png'){
                    img.fadeTo("slow", 0.5);
                    img.attr('src', 'images/like-pressed-256.png');
                    count.text(parseInt(count.text()) + 1);
                    img.fadeTo("slow", 1);
                }
                else{
                    img.fadeTo("slow", 0.5);
                    img.attr('src', 'images/like-256.png');
                    count.text(parseInt(count.text()) - 1);
                    img.fadeTo("slow", 1);
                }
            }
        });
    });
    $('#btnLogOut').on("click", function() {
        rotate(360, '#btnLogOut');
    });
    $('#btnSettings').on("click", function() {
        rotate(360, '#btnSettings');
    });

});