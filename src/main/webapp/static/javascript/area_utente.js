document.getElementById("dataInizio").onchange = function () {
    var input = document.getElementById("dataFine");
    input.setAttribute("min", this.value);
}



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
