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
    return `id raton:${this._idRaton} ${super.toString}`;
  }
}//FINAL DE LA CLASE RATON
