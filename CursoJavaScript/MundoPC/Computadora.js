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
