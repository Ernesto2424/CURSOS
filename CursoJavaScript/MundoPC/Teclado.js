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
    return `id Teclado: ${this._idTeclado} ${super.toString}`;
  }
} //FINAL DE LA CLASE TECLADO
