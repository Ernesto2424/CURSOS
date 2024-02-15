//tipos primitivos
let x = 10;

function cambiarValor(a){
    a = 20;
}

//paso por valor
/* solo se pasa una copia del valor de la variable a la funcion
es decir el valor de la variable no se modifica */
cambiarValor(x);
console.log(x);

//paso por referencia

const persona = {
    nombre: "Ernesto",
    apellido:"Flores"
}

function cambiarValorObjeto(p1){
    p1.nombre = "Neto";
    p1.apellido = "Flowers";
}
// paso por referencia
/* cuando se trabaja con obetos
se hace paso por referencia, mientras que 
cuando se trabaja con tipos primitivos solo se hace
el paso por valor */
cambiarValorObjeto( persona );
console.log(persona);