
/**
 * La clase carril es la creación del carrril dentro del juego.
 * 
 * @author (Luis Fernando Posada Cano) 
 * @version (01/08/2021)
 */
import java.util.*;
public class Carril
{
    public boolean movFinal;
    public CarId carId;
    public GameId gameId;
    public Posicion posicion;
    public Integer meters;
    
    public Carril (boolean movFinal, CarId carId, GameId gameId, Posicion posicion, Integer meters){
     this.movFinal = movFinal;
     this.carId = carId;
     this.gameId = gameId;
     this.posicion = posicion;
     this.meters = meters;
    }
    
    public void llegadaAMeta(){
        if(posicionAct() >= posicionMeta()){ movFinal = true; }}

    public void movCar(Posicion posicion, Integer cantidad){
        this.posicion = posicion;
        posicion.setActual(posicion.actual()+ cantidad);
        llegadaAMeta();
    }
    
    public Boolean movFinal() { return movFinal;}
    
    public Posicion posicion() { return posicion;}
    
    public Integer posicionAct() { return posicion.actual(); }
    
    public Integer posicionMeta() { return posicion.meta(); }
   
    public Integer meters(){ return meters; }
        
    }

