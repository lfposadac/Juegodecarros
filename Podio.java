
/**
 * Clase donde se hará el podio
 * 
 * @author (Luis Fernando Posada Cano) 
 * @version (01/08/2021)
 */
public class Podio implements Seguimiento
{
  public Jugador primerPuesto;
  public Jugador segundoPuesto;
  public Jugador tercerPuesto;
  
  public Podio(){}
  
  public void assPrimerPuesto(Jugador jugador) { primerPuesto = jugador; }
  
  public void assSegundoPuesto(Jugador jugador) { segundoPuesto = jugador; }
  
  public void assTercerPuesto(Jugador jugador) { tercerPuesto = jugador; }
  
  @Override 
  public Jugador primerPuesto() {  return primerPuesto; }
  
  @Override 
  public Jugador segundoPuesto() { return segundoPuesto; }
  
  @Override
  public Jugador tercerPuesto(){ return tercerPuesto; }
  
  @Override
  public Boolean copado(){ 
      Boolean ocupado = false;
      if(primerPuesto != null && segundoPuesto != null && tercerPuesto != null ){
          ocupado = true;
      }
      return ocupado;
    }
}
