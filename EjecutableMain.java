
/**
 * Desde se ejecuta todo el juego
 * 
 * @author (Luis Fernando Posada Cano) 
 * @version (01/08/2021)
 */
import java.awt.Color;
import java.util.*;
public class EjecutableMain
{
    public static void main(String[] args){
        UUID id;
        int jugadoresTotales;
        String nameJugador;
        
        Juego newGame = new Juego();
        
        System.out.println("Cargando un nuevo juego:_____________ ");
        
        Scanner in = new Scanner(System.in);
        System.out.println("¿Cúantos jugadores van a jugar?");
        while(!in.hasNextInt()) in.next();
        jugadoresTotales = in.nextInt();
        
        for(int i = 0; i< jugadoresTotales; i++) {
            id = UUID.randomUUID();
            PlayerId playerId = new PlayerId(id);
            nombreJugador = "jugador" + (i + 1);
            Name name = new Name(nombreJugador);
            newGame.crearJugador(playerId, name, Color.blue);
        }
        
        newGame.crearPistas();
        
        newGame.startGame();
        
        }
    }

