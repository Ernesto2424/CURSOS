class Persona{

    /* NOTA: cunado se trabjaa con clases no se puede
    aplicar HOSTING, pero cunado se trabaja con funciones 
    si aplica el HOSTING, es decir, en las clases se debe primero
    crear la clase y despues utilizarla
    mientras que cuando son funciones se puede usar antes y despues
    poner la funcion ya que por automatico se hace HOSTING y se manda
    primero la funcion y ya despues se usa, aunque en el codifo
    aparezca al revez en ocasiones*/

    //metodo constructor
    constructor(nombre, apellido){
        this._nombre = nombre;
        this._apellido = apellido;
    }

    get nombre(){
        return this._nombre;
    }

    set nombre(nombre){
        this._nombre = nombre;
    }

}

let persona1 = new Persona("Ernesto","Flores");
//se manda a llmar el metodo SET y no la propiedad _nombre
persona1.nombre = "modificado";
//se manda a llamar el metodo GET y no la propiedad nombre
console.log(persona1.nombre);