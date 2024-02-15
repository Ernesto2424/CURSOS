//Tipo de dato String
var nombre = "carlos";
console.log(nombre);

//tipo de dato numerico
var numero = 1000;
console.log(numero);

//tipo de dato objeto
var objeto = {
    nombre : "Ernesto",
    apellido: "Flores",
    telefono: "5571156" 
}

console.log(objeto);
 
//tipo de dato Booleano
var bandera = false;
console.log(bandera);
console.log(typeof bandera);

//funciones en JS
function f(a,b){
return a+b;
}
console.log(f(5,5));
console.log(typeof f);

//tipo de dati symbol
var simbolo = Symbol("mi simbolo");
console.log(simbolo);
console.log(typeof simbolo);

//Tipo de dato Clase (Tambien es una funcion)
class Persona{

 constructor(nombre, apellido){
     this.nombre = nombre;
     this.apellido = apellido;
 }

}

console.log(typeof Persona);

//tipo de dati undefined
var x;
console.log(x);

x = undefined;

//palabra null = ausencia de valor
var y = null;
console.log(typeof y);

var arr = ["BMW", "AUDI", "FOR"];
console.log(arr);
console.log(typeof arr);

var z = '';
console.log(z);