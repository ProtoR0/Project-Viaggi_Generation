$(document).ready(function(){
    $(".asideSinistra").mouseenter(function(){
        $(this).animate({
            right:"1px",
            width:"90%",
            height:"auto"
        });
    });
        $(".asideSinistra").mouseleave(function(){
            $(this).animate({
                right:"1px",
                width:"80%",
                height:"auto"
            });
    });


    $(".asideDestra").mouseenter(function(){
        $(this).animate({
            left:"1px",
            width:"90%",
            height:"auto"
        });
    });
        $(".asideDestra").mouseleave(function(){
            $(this).animate({
                left:"1px",
                width:"80%",
                height:"auto"
            });
    });

});
