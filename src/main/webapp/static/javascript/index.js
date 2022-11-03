$(document).ready(function(){

   
    $(".aside").hover(function(){
/*     $(".aside").hover(function(){

        $(this).css("width","350px")
    });
    }); */

    $(".aside").mouseenter(function(){
        $(this).css("width","350px")
    }),
        $(".aside").mouseleave(function(){
            $(this).css("width","300")
        });


})
});