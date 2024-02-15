
function miFuncion(a,b){
    console.log(arguments.length);
    return a+b;
}
console.log(miFuncion(2,5));

//Funciones de tipo expresion

let x = function funcion(a,b){return a+b};

console.log(x(2,4));

//Funciones del tipo self invoking
(function (a,b){
console.log("ejecutando la funcion: "+ (a+b));
})(3,4);

//Funciones como objetos
var miFuncionTexto = miFuncion.toString();
console.log(miFuncionTexto);

//Funciones del tipo Flecha
/* para estas funciones ya no se necesita poner
function y ni el return */
const sumarFuncionTipoFlecha = (a,b) => a+b;
resultado = sumarFuncionTipoFlecha(5,2);
console.log(resultado);

