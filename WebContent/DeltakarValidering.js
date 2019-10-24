"use strict";

let fornamnInput = document.getElementById("fornamn");
let etternamnInput = document.getElementById("etternamn");
let mobilnrInput = document.getElementById("mobilnr");
let passordInput = document.getElementById("passord");
let passordRepInput = document.getElementById("passordRep");
let meldPaaButton = document.getElementById("meldPaa");

fornamnInput.addEventListener("input", sjekkFornamn);
etternamnInput.addEventListener("input", sjekkEtternamn);
mobilnrInput.addEventListener("input", sjekkMobilnr);
passordInput.addEventListener("input", sjekkPassord);
passordRepInput.addEventListener("input", sjekkPassordRep);

meldPaaButton.addEventListener("click", event => {

    //skal ein validere "på nytt?" eller? berre dialogboks
    //!!!!!
    //må evt lage "2 funksjonar" per sjekk, ein med boolsk retur-verdi som seier om det er korrekt -> kan bruke her
    //og ein som endrar på fargen

    if(!window.confirm("Send info til tener?")) {
        // blir ikkje sendt
        event.preventDefault();
    } else {
        // blir sendt
    }
});

passordInput.addEventListener("mouseover", event => {
    passordInput.title = ("Passordstyrke:\n<8      teikn = ugyldig (raudt)\n8-9     teikn = svakt (mørkeraudt)\n10-13 teikn = middels (gult)\n14+    teikn = sterkt (grønt)");
});

function sjekkFornamn() {
    let fornamn = fornamnInput.value;
    // sjekker om første boksta er stor, og at lengda er rett
    if (fornamn.charAt(0) !== fornamn.charAt(0).toUpperCase() || fornamn.length < 2 || fornamn.length > 20) {
        fornamnInput.setAttribute("style", "border-color: red");
    } else {
        fornamnInput.setAttribute("style", "border-color: green");
    }
}

function sjekkEtternamn() {
    let etternamn = etternamnInput.value;
    // sjekker om første boksta er stor, og at lengda er rett
    if (etternamn.charAt(0) !== etternamn.charAt(0).toUpperCase() || etternamn.length < 2 || etternamn.length > 20) {
        etternamnInput.setAttribute("style", "border-color: red");
    } else {
        etternamnInput.setAttribute("style", "border-color: green");
    }
}

function sjekkMobilnr() {
    let mobilnr = mobilnrInput.value;
    if (mobilnr.length !== 8) {
        mobilnrInput.setAttribute("style", "border-color: red");
    } else {
        mobilnrInput.setAttribute("style", "border-color: green");
    }
}

function sjekkPassord() {
    let passord = passordInput.value;
    if (passord.length < 8) {
        //ugyldig passord
        passordInput.setAttribute("style", "border-color: red");
    } else if (passord.length >= 8 && passord.length < 10) {
        //gyldig men svakt
        passordInput.setAttribute("style", "border-color: darkred");
    } else if (passord.length >= 10 && passord.length < 14) {
        //gyldig og ok styrke
        passordInput.setAttribute("style", "border-color: yellow");
    } else {
        //gyldig og god styrke
        passordInput.setAttribute("style", "border-color: green");
    }
}

function sjekkPassordRep() {
    let passord = passordInput.value;
    let passordRep = passordRepInput.value;
    if (passord !== passordRep) {
        passordRepInput.setAttribute("style", "border-color: red");
    } else {
        passordRepInput.setAttribute("style", "border-color: green");
    }
}