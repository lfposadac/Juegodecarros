
/**
 * Está clase es para saber la posición del carro
 * 
 * @author (Luis Fernando Posada Cano) 
 * @version (01/08/2021)
 */
public class Posicion 
{
    public Integer meta;
    public Integer actual;
   
    public Posicion(Integer actual, Integer meta){
        this.meta = meta;
        this.actual = actual;
    }
    
    public void setActual(Integer actual){
        this.actual = actual;
    }
    
    public Integer meta(){ return meta; }
    
    public Integer actual() { return actual; }
    
    interface Seguimiento {
        public Integer meta();
        public Integer actual();
    }
    
}
