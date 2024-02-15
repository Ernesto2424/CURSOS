public class CremaBatida extends DecoradorCondimento{

@Override
    public String getDescripcion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public float getCosto() {
       return costo + bebida.costo;
    }

    
}
