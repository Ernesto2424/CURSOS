let miPromesa = new Promise( (resolver, rechazada) => {
    let expresion = false;
    if(expresion)
     resolver('Resolvio Correcto');
     else
      rechazada('se produjo un error');
});

miPromesa.then(
    valor => console.log(valor),
    error => console.log(error)
);