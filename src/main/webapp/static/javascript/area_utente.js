document.getElementById("dataInizio").onchange = function () {
    var input = document.getElementById("dataFine");
    input.setAttribute("min", this.value);
}