

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

$(window).load(function() {
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
        if (img.attr('src') == '../images/like-256.png'){
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
                if (img.attr('src') == '../images/like-256.png'){
                    img.fadeTo("slow", 0.5);
                    img.attr('src', '../images/like-pressed-256.png');
                    count.text(parseInt(count.text()) + 1);
                    img.fadeTo("slow", 1);
                }
                else{
                    img.fadeTo("slow", 0.5);
                    img.attr('src', '../images/like-256.png');
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