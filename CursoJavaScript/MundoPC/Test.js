class DispositivoEntrada {
    constructor(tipoEntrada, marca) {
      this._tipoEntrada = tipoEntrada;
      this._marca = marca;
    }
  
    get tipoEntrada() {
      return this._tipoEntrada;
    }
    set tipoEntrada(tipoEntrada) {
      this._tipoEntrada = tipoEntrada;
    }
  
    get marca() {
      return this._marca;
    }
    set marca(marca) {
      this._marca = marca;
    }
  
    toString() {
      return `tipoEntrada: ${this._tipoEntrada} marca: ${this._marca}`;
    }
  } //FINAL DE LA CLASE DISPOSITIO_ENTRADA

  class Raton extends DispositivoEntrada {
    static contadorRaton = 0;
  
    constructor(tipoEntrada, marca) {
      super(tipoEntrada, marca);
      this._idRaton = ++Raton.contadorRaton;
    }
  
    get idRaton() {
      return this._idRaton;
    }
  
    toString() {
      return `id raton:${this._idRaton} ${super.toString()}`;
    }
  }//FINAL DE LA CLASE RATON

  
  class Teclado extends DispositivoEntrada {
    static contadorTeclado = 0;
  
    constructor(tipoEntrada, marca) {
      super(tipoEntrada, marca);
      this._idTeclado = ++Teclado.contadorTeclado;
    }
  
    get idTeclado() {
      return this._idTeclado;
    }
  
    toString() {
      return `id Teclado: ${this._idTeclado} ${super.toString()}`;
    }
  } //FINAL DE LA CLASE TECLADO

  
  class Monitor {
    static contadorMonitor = 0;
    constructor(marca, tamaño) {
      this._idMonitor = ++Monitor.contadorMonitor;
      this._marca = marca;
      this._tamaño = tamaño;
    }
  
    get idMonitor() {
      return this._idMonitor;
    }
    get marca() {
      return this._marca;
    }
    set marca(marca) {
      this._marca = marca;
    }
  
    get tamaño() {
      return this._tamaño;
    }
    set tamaño(tamaño) {
      this._tamaño = tamaño;
    }
  
    toString() {
      return `id Monitor: ${this._idMonitor} marca:${this._marca} tamaño:${this._tamaño}`;
    }
  } //FINAL DE LA CLASE MONITOR

  
  class Computadora {
    static contadorComputadora = 0;
    constructor(nombre, monitor, teclado, raton) {
      this._idComputadora = ++Computadora.contadorComputadora;
      this._nombre = nombre;
      this._monitor = monitor;
      this._teclado = teclado;
      this._raton = raton;
    }
  
    toString() {
      return `id Computadora: ${this._idComputadora} nombre: ${this._nombre} \nmonitor: ${this._monitor} \nteclado: ${this._teclado} \nraton: ${this._raton}`;
    }
  } //FINAL DE LA CLASE COMPUTADORA

  class Orden {
    static contadorOrden = 0;
    constructor() {
      this._idOrden = ++Orden.contadorOrden;
      this._computadoras = [];
    }
  
    get idOrden() {
      return this._idOrden;
    }
   
  
    agregarComputadora(computadora) {
     
        this._computadoras.push(computadora);
        

    }
  
    mostrarOrden() {
      let temp = "";
      for (let computadora of this._computadoras) {
        temp += `\n${computadora}`;
      }
      console.log(`Orden: ${this._idOrden} Computadoras: ${temp}\n`);
    }
  }
  
  
  let raton1 = new Raton("USB","HP");
  let teclado1 = new Teclado("INA","DELL");
  let monitor1 = new Monitor("HP",27);
  let computadora1 = new Computadora("hp",monitor1,teclado1,raton1);

  let raton2 = new Raton("USB","HP");
  let teclado2 = new Teclado("INA","DELL");
  let monitor2 = new Monitor("HP",27);
  let computadora2 = new Computadora("hp",monitor1,teclado1,raton1);

  let orden1 = new Orden();
  orden1.agregarComputadora(computadora1);
  orden1.agregarComputadora(computadora2);
  orden1.mostrarOrden();
 // console.log(computadora1.toString());