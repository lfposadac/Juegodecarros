
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
   public Driver driver;
   public Color color;
   public Integer distancia;
   public final Map <CarId, Driver> carros = new HashMap<> ();
   
   public Carros() {}

   public Carros(GameId gameId, Driver driver,Color color, Integer distancia){
       this.gameId = gameId;
       this.driver = driver;
       this.color = color;
       this.distancia = distancia;
        
       void assignDriver(CarId carId, Driver driver){ carros.put(carId, driver);}
       
   }
   
   
   
   

