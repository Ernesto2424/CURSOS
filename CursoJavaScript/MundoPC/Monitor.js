class Monitor {
  static contadorMonitor = 0;
  constructor(marca, tamaño) {
    this._idMonitor = ++Monitor.contadorMonitor;
    this._marca = marca;
    this._tamaño = tamaño;
  }

  get _idMonitor() {
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
