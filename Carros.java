/**
 * Los creación de los carros. 
 * 
 * @author (Luis Fernando Posada Cano) 
 * @version (01/08/2021)
 */
import java.awt.Color;
import java.util.*;
/*
 * Un HashMap básicamente designa claves únicaspara los valores correspondientes que se pueden
 * recuperar en cualquier punto dado.
 */
public class Carros
{
   public GameId gameId;
   public Conductor conductor;
   public Color color;
   public Integer distancia;
   public final Map <CarId, Conductor> carros = new HashMap<> ();
   
   public Carros() {}

   public Carros(GameId gameId, Conductor conductor,Color color, Integer distancia){
       this.gameId = gameId;
       this.conductor = conductor;
       this.color = color;
       this.distancia = distancia;
    }
        
   public void assignDriver(CarId carId, Conductor conductor){ carros.put(carId, conductor);}
   
   public Map <CarId, Conductor> carros(){return carros; }
   
   public void setDistancia(Integer distancia){ this.distancia = distancia; }
   
   public Integer numCarros(){ return carros.size(); }
   
   public Color color(){ return color;}
   
   public Integer distancia() {return distancia;}
   
   public Conductor conductor() { return conductor; }
       
   }
       

   
   
   
   

