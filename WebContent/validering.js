"use strict";

let fornamnInput = document.getElementById("fornamn");
let etternamnInput = document.getElementById("etternamn");
let mobilnrInput = document.getElementById("mobilnr");
let passordInput = document.getElementById("passord");
let passordRepInput = document.getElementById("passordRep");

fornamnInput.addEventListener("input", sjekkFornamn);
etternamnInput.addEventListener("input", sjekkEtternamn);
mobilnrInput.addEventListener("input", sjekkMobilnr);
passordInput.addEventListener("input", sjekkPassord);
passordRepInput.addEventListener("input", sjekkPassordRep);

passordInput.addEventListener("mouseover", event => {
    passordInput.title = ("Test...");
});

function sjekkFornamn() {
    let fornamn = fornamnInput.value;
    if (fornamn.charAt(0) !== fornamn.charAt(0).toUpperCase() || fornamn.length < 2 || fornamn.length > 20) {
        fornamnInput.setAttribute("style", "border-color: red; border-width: thick");
    } else {
        fornamnInput.setAttribute("style", "border-color: green; border-width: medium");
    }
}

function sjekkEtternamn() {
    let etternamn = etternamnInput.value;
    if (etternamn.charAt(0) !== etternamn.charAt(0).toUpperCase() || etternamn.length < 2 || etternamn.length > 20) {
        etternamnInput.setAttribute("style", "border-color: red; border-width: thick");
    } else {
        etternamnInput.setAttribute("style", "border-color: green; border-width: medium");
    }
}

function sjekkMobilnr() {
    let mobilnr = mobilnrInput.value;
    if (mobilnr.length !== 8) {
        mobilnrInput.setAttribute("style", "border-color: red; border-width: thick");
    } else {
        mobilnrInput.setAttribute("style", "border-color: green; border-width: medium");
    }
}

function sjekkPassord() {
    let passord = passordInput.value;
    if (passord.length < 8) {
        passordInput.setAttribute("style", "border-color: red; border-width: thick");
    } else if (passord.length >= 8 && passord.length <= 10) {
        passordInput.setAttribute("style", "border-color: orangered; border-width: medium");
    } else if (passord.length > 10 && passord.length < 14) {
        passordInput.setAttribute("style", "border-color: yellow; border-width: medium");
    } else {
        passordInput.setAttribute("style", "border-color: green; border-width: medium");
    }
}

function sjekkPassordRep() {
    let passord = passordInput.value;
    let passordRep = passordRepInput.value;
    if (passord !== passordRep) {
        passordRepInput.setAttribute("style", "border-color: red; border-width: thick");
    } else {
        passordRepInput.setAttribute("style", "border-color: green; border-width: medium");
    }
}