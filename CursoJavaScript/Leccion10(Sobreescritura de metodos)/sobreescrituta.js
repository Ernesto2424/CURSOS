class Empleado {
  constructor(nombre, sueldo) {
    this._nombre = nombre;
    this._sueldo = sueldo;
  }

  obtenerDetalles() {
    return `nombre:${this._nombre} sueldo:${this._sueldo}`;
  }
}


class Gerente extends Empleado{
    constructor(nombre,sueldo,departamento){
        super(nombre,sueldo);
        this._departamento = departamento;
    }

    obtenerDetalles(){
        return `Gerente:: ${super.obtenerDetalles()} departamento:${this._departamento}`;
    }
}

function determinarTipo(tipo){
    if(tipo instanceof Gerente){
        console.log( "Gerente" );
    }else{
        console.log( "Empleado" );
    }
    console.log( tipo.obtenerDetalles() );
}


let empleado1 = new Empleado("Name",7500);
let gerente1 = new Gerente("Ernesto",5000,"Sistemas");

determinarTipo( empleado1 );
determinarTipo( gerente1 );