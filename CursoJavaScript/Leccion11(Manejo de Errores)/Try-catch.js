/*

'use strict'

try {
    let  x = 10;    

    throw "mi error";
} catch (error) {
    console.log(error);
}finally{
    console.log("termina la revision de errores");
}

console.log("continuamos...");

*/
'use strict'
let resultado = "cadena de texto";

try {
    x=10;
    if( isNaN(resultado) ) throw "No es un numero"
    
} catch (error) {
    console.log(error);
    console.log(error.name);
    console.log(error.message);
}