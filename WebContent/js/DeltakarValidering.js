"use strict;"

class DeltakarValidering {

    constructor(fornamnId, etternamnId, mobilnrId, passordId, passordRepId, meldPaaId) {
        this._fornamnInput = document.getElementById(fornamnId);
        this._etternamnInput = document.getElementById(etternamnId);
        this._mobilnrInput = document.getElementById(mobilnrId);
        this._passordInput = document.getElementById(passordId);
        this._passordRepInput = document.getElementById(passordRepId);
        this._meldPaaButton = document.getElementById(meldPaaId);
    }

    get fornamnInput() {
        return this._fornamnInput;
    }

    set fornamnInput(fornamnInput) {
        this._fornamnInput = fornamnInput;
    }

    get etternamnInput() {
        return this._etternamnInput;
    }

    set etternamnInput(etternamnInput) {
        this._etternamnInput = etternamnInput;
    }

    get mobilnrInput() {
        return this._mobilnrInput;
    }

    set mobilnrInput(mobilnrInput) {
        this._mobilnrInput = mobilnrInput;
    }

    get passordInput() {
        return this._passordInput;
    }

    set passordInput(passordInput) {
        this._passordInput = passordInput;
    }

    get passordRepInput() {
        return this._passordRepInput;
    }

    set passordRepInput(passordRepInput) {
        this._passordRepInput = passordRepInput;
    }

    get meldPaaButton() {
        return this._meldPaaButton;
    }

    set meldPaaButton(meldPaaButton) {
        this._meldPaaButton = meldPaaButton;
    }

    sjekkFornamn() {
        Validering.sjekk(fun => {return Validering.erRettFornamn(this._fornamnInput.value)}, this.fornamnInput);
    }
    
    sjekkEtternamn() {
        Validering.sjekk(fun => {return Validering.erRettEtternamn(this._etternamnInput.value)}, this.etternamnInput);
    }
    
    sjekkMobilnr() {
        Validering.sjekk(fun => {return Validering.erRettMobilnr(this._mobilnrInput.value)}, this.mobilnrInput);
    }
    
    sjekkPassord() {
        let passord = this._passordInput.value;
        if (!Validering.erRettPassord(passord)) {
            //ugyldig passord
            this._passordInput.setAttribute("style", "border-color: red");
        } else if (passord.length >= 8 && passord.length < 10) {
            //gyldig men svakt
            this._passordInput.setAttribute("style", "border-color: darkred");
        } else if (passord.length >= 10 && passord.length < 14) {
            //gyldig og ok styrke
            this._passordInput.setAttribute("style", "border-color: yellow");
        } else {
            //gyldig og god styrke
            this._passordInput.setAttribute("style", "border-color: green");
        }
    }
    
    sjekkPassordRep() {
        Validering.sjekk(fun => {return Validering.erRettPassordRep(this._passordInput.value, this._passordRepInput.value)}, this._passordRepInput);
    }

    sjekkAlle() {
        return Validering.erAlleRette(this._fornamnInput.value, this._etternamnInput.value, this._mobilnrInput.value, this._passordInput.value, this._passordRepInput.value);
    }
}

