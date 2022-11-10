$(document).ready(function(){
    $(".aside").mouseenter(function(){
        $(this).animate({
            right:"1px",
            width:"80%",
            height:"auto"
        });
    });
        $(".aside").mouseleave(function(){
            $(this).animate({
                left:"1px",
                width:"70%",
                height:"auto"
            });
    });

});