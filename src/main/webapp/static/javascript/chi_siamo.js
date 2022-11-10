$(document).ready(function(){
    $(".aside").mouseenter(function(){
        $(this).animate({
            right:"1px",
            width:"250px",
            height:"auto"
        });
    });
        $(".aside").mouseleave(function(){
            $(this).animate({
                left:"1px",
                width:"200px",
                height:"auto"
            });
    });

});