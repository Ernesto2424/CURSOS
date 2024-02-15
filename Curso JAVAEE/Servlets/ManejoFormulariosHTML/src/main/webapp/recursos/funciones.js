

function  validarForm(forma){
 let usuario = forma.usuario;
 if(usuario.value == "" || usuario.value=="Escribir Usuario"){
        alert("Debe proporcionar nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
 }
 
 let password = forma.password;
 if(password.value.length < 3 ){
        alert("debe proporcionar una contraseña al menos de 3 caracteres");
        password.focus();
        password.select();
       password.style.background="#fbc4ab";
        return false;
 }
 
 let tecnologias = forma.tecnologia;
 let checkSeleccionado = false;
 
    for (var i = 0; i < tecnologias.length; i++) {
        if(tecnologias[i].checked){
            checkSeleccionado = true;
        }
    }
    
    if(!checkSeleccionado){
        alert("debe seleccionar por lo menos una tecnologia");
        return false;
    }
    
    
  let generos = forma.genero;
  let radioSeleccionado = false;
  
    for (var i = 0; i < generos.length; i++) {
        if(generos[i].checked){
            radioSeleccionado = true;
        }
    }
    
    if(!radioSeleccionado){
        alert("Seleccione su genero correspondiete");
        return false;
    }
    
    let ocupacion = forma.ocupacion;
    if(ocupacion.value==""){
        alert("Seleccione una opcion");
        return false;
    }
    
    //Formualrio es valido
    alert("Datos guardados exitosamente!");
    return true;
 
 
 
 
 
 
 
}