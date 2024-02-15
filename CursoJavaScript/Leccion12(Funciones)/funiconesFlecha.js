'use strict'

function miFuncion(){
    console.log("Saludos desde mi funcion");
}

miFuncion();

/*
const funcionFlecha = () => {
    console.log("Saludos desde funcion flecha");
}

funcionFlecha();
*/

//const funcionFelcha = () => console.log("Saludos desde funcion flecha");
//funcionFelcha();

const saludar = () => "saludos desde funcion flecha3";
console.log(saludar());

const regresaObjeto  = () => ( {nombre:"ERnesto", apellido:"flores"} )

console.log(regresaObjeto());

const funcionConParametros = (mensaje) => console.log( mensaje );

funcionConParametros("saludos con parametros");