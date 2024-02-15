/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Personal
 */
public abstract class DecoradorCondimento extends Bebida{
    
    Bebida bebida;
    String descripcion;

    @Override
    public float getCosto() {
       return costo;
    }
    
    public abstract String getDescripcion();
    
}
