"use strict;"

let dv = new DeltakarValidering("fornamn", "etternamn", "mobilnr", "passord", "passordRep", "meldPaa");

dv.fornamnInput.addEventListener("input", dv.sjekkFornamn.bind(dv));
dv.etternamnInput.addEventListener("input", dv.sjekkEtternamn.bind(dv));
dv.mobilnrInput.addEventListener("input", dv.sjekkMobilnr.bind(dv));
dv.passordInput.addEventListener("input", dv.sjekkPassord.bind(dv));
dv.passordRepInput.addEventListener("input", dv.sjekkPassordRep.bind(dv));

dv.meldPaaButton.addEventListener("click", event => {

    if(dv.sjekkAlle()) {
        //alt ok, gjer "ingenting" - altså sender inn
    } else {
        if(!window.confirm("Det er feil i skjemaet.\nSend info til tenar?")) {
            // blir ikkje sendt
            event.preventDefault();
        } else {
            // blir sendt
        }
    }

});

dv.passordInput.addEventListener("mouseover", event => {
    dv.passordInput.title = ("Passordstyrke:\n<8      teikn = ugyldig (raudt)\n8-9     teikn = svakt (mørkeraudt)\n10-13 teikn = middels (gult)\n14+    teikn = sterkt (grønt)\nMå ha (minst) ein stor og liten bokstav og eit tal!");
});