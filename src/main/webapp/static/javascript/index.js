$(document).ready(function(){

    $(".nav-link").on({

        mouseenter: function(){
            $(this).css("background-color","#9C9C9C");
        },

        mouseleave: function(){
            $(this).css("background-color", ""); //prendere colore navbar
        }
    });

    
    $(".aside").on({

        mouseenter:function(){
            $(this).animate({
                right:"400px",
                height:"auto",
                width: "400px"
            });
        },

        mouseleave:function(){
            $(this).animate({
                width:"300px",
                height:"auto",
            });
        }

        
    });


})