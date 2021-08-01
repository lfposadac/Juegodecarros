
/**
 * Clase jugador donde se crea el objeto jugador
 * 
 * @author (Luis Fernando Posada Cano <lfposadac@eafit.edu.co>) 
 * @version (01/08/2021)
 */
import java.awt.Color;
public class Jugador
{
    public Name name; 
    public Color color;
    public Integer puntos;
    
    public Jugador (Name name, Color color, Integer puntos){
        this.name = name;
        this.color = color;
        this.puntos = puntos;
    }
    
    public Name name() { return name; }
    
    public Color color() { return color; }
    
    public void assPuntos(Integer puntos) {  puntos = puntos; }
}
