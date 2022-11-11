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


function zero(numero) {
    if (numero<10) {
        numero = "0" + numero;
    }

    return numero;
}
window.addEventListener("load", data);
function data() {

    let data = new Date();

    let ora = zero(data.getHours());
    let minuti = zero(data.getMinutes());
    let secondi = zero(data.getSeconds());

document.getElementById("orologio").innerHTML = (ora + ":" + minuti + ":" + secondi);
setTimeout("data()", 1000);

}
