console.log("Aplicación calculadora");

function sumar(){

    const formulario = document.getElementById("formulario");
    let A = formulario["operandoA"];
    let B = formulario["operandoB"];
    let resultado = parseInt(operandoA.value) + parseInt(operandoB.value);
    if (isNaN(resultado)){
        resultado = "INGRESE VALORES NUMERICOS";  
    }
    document.getElementById("resultado").innerHTML= `Resultado: ${resultado}`;
    console.log(resultado);


}

function restar(){

    const formulario = document.getElementById("formulario");
    let A = formulario["operandoA"];
    let B = formulario["operandoB"];
    let resultado = parseInt(operandoA.value) - parseInt(operandoB.value);
    if (isNaN(resultado)){
        resultado = "INGRESE VALORES NUMERICOS";  
    }
    document.getElementById("resultado").innerHTML= `Resultado: ${resultado}`;
    console.log(resultado);


}

function multiplicar(){

    const formulario = document.getElementById("formulario");
    let A = formulario["operandoA"];
    let B = formulario["operandoB"];
    let resultado = parseInt(operandoA.value) * parseInt(operandoB.value);
    if (isNaN(resultado)){
        resultado = "INGRESE VALORES NUMERICOS";  
    }
    document.getElementById("resultado").innerHTML= `Resultado: ${resultado}`;
    console.log(resultado);


}

function dividir(){

    const formulario = document.getElementById("formulario");
    let A = formulario["operandoA"];
    let B = formulario["operandoB"];
    let resultado = parseInt(operandoA.value) / parseInt(operandoB.value);
    if (isNaN(resultado)){
        resultado = "INGRESE VALORES NUMERICOS";  
    }
    document.getElementById("resultado").innerHTML= `Resultado: ${resultado}`;
    console.log(resultado);


}