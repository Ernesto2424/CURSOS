class Producto {
    static contadorProductos = 0;
  
    constructor(nombre, precio) {
      this._idProducto = ++Producto.contadorProductos;
      this._nombre = nombre;
      this._precio = precio;
    }
  
    get idProducto() {
      return this._idProducto;
    }
    get nombre() {
      return this._nombre;
    }
    set nombre(nombre) {
      this._nombre = nombre;
    }
    get precio() {
      return this._precio;
    }
    set precio(precio) {
      this._precio = precio;
    }
  
    toString() {
      return `${this._idProducto},
       ${this._nombre}, 
       $${this._precio}`;
    }
  } // fin de la clase Producto

  class Orden {
    static contadorOrdenes = 0;
    static get MAX_PRODUCTOS() {
      return 5;
    }
    constructor() {
      this._idOrden = ++Orden.contadorOrdenes;
      this._productos = [];
      
    }
  
    get idOrden() {
      return this._idOrden;
    }
  
    agregarProducto(producto) {
      if (this._productos.length < Orden.MAX_PRODUCTOS) {
        this._productos.push(producto);
      } else {
        console.log("no se pueden agregar mas productos");
      }
    }
  
    calcularTotal() {
      let totalVenta = 0;
  
      for (let producto of this._productos) {
        totalVenta += producto.precio;
      }
  
      return totalVenta;
    }
  
    mostrarOrden() {
      let productoOrden = "";
      for (let producto of this._productos) {
        productoOrden += producto.toString() + " ";
      }
      console.log(
        `Orden:${this._idOrden} Total:${this.calcularTotal()} Productos:${productoOrden}`
      );
    }
  }
  
  
  let producto1 = new Producto("camisa",150);
  let producto2 = new Producto("pantalón",200);
  
  let orden1 = new Orden();
  orden1.agregarProducto(producto1);
  orden1.agregarProducto(producto2);
  orden1.mostrarOrden();

  let orden2 = new Orden();
  orden2.agregarProducto(producto1);
  orden2.agregarProducto(producto2);
  orden2.agregarProducto(producto1);
  orden2.agregarProducto(producto2);
  orden2.agregarProducto(producto2);
  
  orden2.mostrarOrden();
