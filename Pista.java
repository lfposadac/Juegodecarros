 
/**
  * Clase pista donde se crea el objeto pista.
 * 
 * @author (Luis Fernando Posada Cano) 
 * @version (01/08/2021)
 */
public class Pista implements Values  {
    public Pista(Integer km, Integer numDeCarriles){
        this.km = km;
        this.numDeCarriles = numDeCarriles;
    }
    public Integer km;
    public Integer numDeCarriles;
    /*Override una característica que permite que una subclase o clase
     * secundaria proporcione una implementación específica de un método
     * que ya está provisto por una de sus superclases o clases principales.
     */ 
    @Override
    public Integer km() { return km; } 
    // Integer
    @Override 
    public Integer numDeCarriles() { return numDeCarriles; }
    
}
