function miFuncion1(){
    console.log("funciion 1");
}

function miFuncion2(){
    console.log("funciion 2");
}

miFuncion1();
miFuncion2();

function imprimir(mensaje){
    console.log(mensaje);
}

function sumar(op1, op2, imprimir){
 let res = op1 + op2;
 imprimir(`resultado: ${res}`);
}

sumar(5,15, imprimir);


//Funciones setTimeOut


/*function miFuncionCallBCK(){
    console.log("saludos despues de 5 segundos");
}

setTimeout(miFuncionCallBCK, 5000); // se ejecuta despues de 3 seg

setTimeout( () => console.log("saludos despues de 3.5 seg"), 3500 );
*/

//FuncionesserInterval


let reloj = () => {

    let fecha = new Date();
    console.log(`${fecha.getHours()}: ${fecha.getMinutes()}: ${fecha.getSeconds()}`);
}

setInterval(reloj, 1000);
