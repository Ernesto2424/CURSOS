class Orden {
  static contadorOrden = 0;
  constructor() {
    this._idOrden = ++Orden.contadorOrden;
    this._computadoras = [];
  }

  get idOrden() {
    return this._idOrden;
  }
  get MAX_ORDEN() {
    return 5;
  }

  agregarComputadora(computadora) {
    if (this._computadoras.length < Orden.MAX_ORDEN) {
      this._computadoras.push(computadora);
    } else {
      console.log("Ha ecedido el numero maximo de pedidos");
    }
  }

  mostrarOrden() {
    let temp = "";
    for (let computadora of this._computadoras) {
      temp += `\n${computadora}`;
    }
    console.log(`Orden: ${this._idOrden} Computadoras: ${temp}`);
  }
}
