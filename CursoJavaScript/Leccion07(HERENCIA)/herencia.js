
class Persona{


    static contadorPersona = 0;

    static get MAX_OBJ(){
        return 2;
    }
     //metodo constructor
    constructor(nombre, apellido){
        this._nombre = nombre;
        this._apellido = apellido;
        if( Persona.contadorPersona< Persona.MAX_OBJ){
            this.idPersona = ++Persona.contadorPersona;
        }else{
            console.log("ERROR NO SE PUEDE CREAR MAS OBJ");
        }
        
    }

    

    get nombre(){
        return this._nombre;
    }

    set nombre(nombre){
        this._nombre = nombre;
    }

    get apellido(){
        return this._apellido;
    }

    set apellido(apellido){
        this._apellido = apellido;
    }

    nombreCompleto(){
        return this.idPersona+" "+this._nombre+" "+this._apellido;
    }
    //sobreescribiendo el metodo de la clase padre(OBJECT)
    toString(){
        //se aplica polimorfismo
        /* es decir si se usa persona se manda a llamar
        ese metodo, pero si se usa empleado, se manda a llamar
        el metodo nombreCompleto de la clase Empleado */
        return this.nombreCompleto();
    }

    static saludar(){
        console.log("saludos desde static");
    }

} //FIN DE LA CLASE PERSONA



class Empleado extends Persona{

    constructor(nombre, apellido, departamento){
        super(nombre, apellido); //llamar al constructor de la clase padre
        this._departamento = departamento;
    }

    get departamento(){
        return this._departamento;
    }

    set departamento(departamento){
        this._departamento = departamento;
    }

    //sobrescitura de metodos
    nombreCompleto(){
        return super.nombreCompleto() +": "+ this._departamento;
    }

}//FIN DE LA CLASE EMPLEADO
let persona = new Persona("ernesto","folres");

let empleado = new Empleado("empleado","flores","sistemas");
let persona2 = new Persona("ernesto","folres");
console.log(persona.toString());
console.log(empleado.toString());
console.log(persona2.toString());

console.log(Persona.MAX_OBJ);