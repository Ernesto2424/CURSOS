


//creacion de un objeto
let persona = {

nombre: "Ernesto",
apellido: "Flores",
edad: 21,
email: "correo@mail.om",
idioma: "es",
get lang(){
    return this.idioma.toUpperCase();
},

set lang(lang){
    this.idioma = lang.toUpperCase();
},

get nombreCompleto(){
    return this.nombre +" "+ this.apellido;
}



}

//creacion de un objeto con palabra New
let persona2 = new Object();
persona2.nombre = "Nombre";
persona2.direccion = "saturno 15";
persona2.telefono = "55744545";

console.log(persona2.telefono);

//acceder a un objeto
console.log(persona.nombre);
console.log(persona.apellido);
console.log(persona);
console.log(persona.nombreCompleto);
console.log(persona["apellido"]);
//for in
for(propiedad in persona){
    console.log(propiedad);
    console.log(persona[propiedad]);
}

persona.tel = "64545";

console.log(persona);

delete persona.tel;
console.log(persona);

//formas de imprimir un objeto

//concatemar ada valor de cada propiedad
console.log(persona.nombre+ ' ,' + persona.apellido);

//for in
for(nombrepropiedad in persona){
    console.log(persona[nombrepropiedad]);
}

//como arreglo
let personaArrar = Object.values( persona );
console.log( personaArrar );

//como JSON
let personaString = JSON.stringify( persona );
console.log(personaString);

persona.lang = "uk";
console.log( persona.lang );
console.log(persona.idioma);

//METODO CONSTRUCTOR

//funcion de constructor de tipo persona

function people(nom, ape, ema){
    this.nombre = nom;
    this.apellido = ape;
    this.email = ema;
    this.nombreCompleto = function(){
        return this.nombre + " " +this.apellido;
    }

    
}

let padre = new people("miNombre", "miApellido", "miEmail");
console.log( padre );

let madre = new people("MADRE","AMDR","EMAND");
console.log( madre );

padre.nombre = "su nombre";
console.log( padre.nombreCompleto() );

//fromas de construir objetos
let miObjeto = new Object();
//esta es la mas recomndable
let miObjeto2 = {};
let micadena = new String("hola");
let numero = new Number(10);

let miArreglo = [];

people.prototype.tel = "+52";

//METODO CALL

let Person1 = {
    nombre: "ernest",
    apellido: "flores",
    nombreCompleto: function(titulo, tel){
        return titulo + ": "+this.nombre + " " +this.apellido+" "+tel;
    }
}

let Person2 = {
    nombre: "ern2",
    apellido: "flores2",
    
}
Person1.nombreCompleto();

//argumentos con call
console.log( Person1.nombreCompleto.call( Person2, 'ing', '54541' ) );


//METODO APPLY
let arr = ["Ing","54512"];
console.log( Person1.nombreCompleto.apply( Person2, arr ) );
