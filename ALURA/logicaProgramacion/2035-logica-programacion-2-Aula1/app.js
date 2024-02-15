



function asignarTexto(elemento, texto){
    let titulo = document.querySelector(elemento);
    titulo.innerHTML = texto;
    
}

function intentoDeUsuario(){
    let numeroUsuario = parseInt(document.getElementById("valorUsuario").value);
    
    
}

function numeroAleatorio() {
    return Math.floor(Math.random() * 10) +1;
}

asignarTexto("h1","Juego del Numero Secreto");
asignarTexto("p","Escoje un número entre el 1 y 10");
let numeroSecreto = numeroAleatorio();
console.log(numeroSecreto);
