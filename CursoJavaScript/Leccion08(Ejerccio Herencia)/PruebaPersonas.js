class Persona{
    static contadorPersonas = 0;
    constructor(nombre, apellido, edad){
        this._idPersona = ++Persona.contadorPersonas;
        this._nombre = nombre;
        this._apellido = apellido;
        this._edad = edad;
    }

    get idPersona(){
        return this._idPersona;
    }

    get nombre(){
        return this._nombre;
    }

    get apellido(){
        return this._apellido;
    }

    get edad(){
        return this._edad;
    }

    set nombre(nombre){
        this._nombre = nombre;
    }

    set apellido(apellido){
    this._apellido = apellido;
    }

    set edad(edad){
        this._edad = edad;
    }

    toString(){
        return this._idPersona+' '+this._nombre+' '+this._apellido+' '+this._edad;
    }

} //fin de la clase persona


class Empleado extends Persona{

    static contadorEmpleado = 0;
    constructor(nombre, apellido, edad, sueldo){
        super(nombre, apellido, edad);
        this._idEmpleado = ++Empleado.contadorEmpleado;
        this._sueldo = sueldo;
    }

    get idEmpleado(){
        return this._idEmpleado;
    }

    get sueldo(){
        return this._sueldo;
    }

    set sueldo(sueldo){
        this._sueldo = sueldo;
    }

    toString(){
        return super.toString() + ' ' + this._idEmpleado + ' ' +this._sueldo;
    }

} //fin de la clase empleado


class Cliente extends Persona{

    static contadorCliente = 0;
    constructor(nombre, apellido, edad, fechaRegistro){
        super(nombre, apellido, edad);
        this._idCliente = ++Cliente.contadorCliente;
        this._fechaRegistro = fechaRegistro;
    }

    get idCliente(){
        return this._idCliente;
    }

    get fechaRegistro(){
        return this._fechaRegistro;
    }

    set fechaRegistro(fechaRegistro){
        this._fechaRegistro = fechaRegistro;
    }

    toString(){
        return super.toString() + ' ' + this._idCliente + ' ' + this._fechaRegistro;
    }

} //fin de la clase Cliente


//PRUEBA DE LA CLASE PERSONA
let persona1 = new Persona("Ernesto", "Flores", 21);
console.log( persona1.toString() );

let empleado1 = new Empleado("Emp1", "EmAp1",45,5400);
console.log( empleado1.toString() );

let cliente1 = new Cliente("Cli1","CliAp1",33,new Date());
console.log( cliente1.toString() );
