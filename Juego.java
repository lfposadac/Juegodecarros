
/**
 * Clase para la ejecucción de las funcionalidades
 * 
 * @author (Luis Fernando Posada Cano) 
 * @version (01/08/2021)
 */
import java.awt.Color;
import java.util.*;
public class Juego
{
    public Map<PlayerId, Jugador> jugadores = new HashMap <>();
    private final Carros carros = new Carros();
    private Boolean firstGame = true;
    public Pista pista;
    public Podio podio = new Podio();
    public Boolean jugando;
    public ArrayList<Carros> carrosEnPista = new ArrayList<>();
    public ArrayList<Pista> pistas = new ArrayList<>();
    public ArrayList<Carril> carrilesEnJuego = new ArrayList<>();
    //public ArrayList<ListaGanadores> ganadores = new ArrayList<>();

    public Juego(){}
    
    //Lo incial es crear un registro de jugadores con sus respectivos identificadores
    public void registroJugador(PlayerId playerId, Name name, Color color) {
        Jugador jugador = new Jugador(name, color, 0);
        jugadores.put(playerId, jugador);
        createConductor(name);
    }
    
    //Se crea el conductor con sus respectivo coche.
    public void createConductor(Name name){
        UUID id;
        Scanner in = new Scanner(System.in);
        System.out.println("El jugador: " + name.getName()+ "será asignado a conductor" + "S/N");
        while(!in.hasNext("[sSnN]")){
            System.out.println("Su respuesta deber ser en terminos de S, s o N, n");
            in.next();
        }
        String seePlayers = in.next();
        if (seePlayers.equals("S") || seePlayers.equals("s")) {
            Conductor conductor = new Conductor(name.getName());
            id = UUID.randomUUID();
            CarId carId = new CarId(id);
            carros.assignDriver(carId, conductor);
        }
    }
    
    //Creamos las pistas con los carriles
    public void createPistas(){
        int numCarriles = carros.numCarros();
        int kmRandom;
        for(int i= 0; i < carros.numCarros(); i++){
            kmRandom = (int)(Math.random() * 100 + 1);
            Pista pista = new Pista(kmRandom, numCarriles);
            pistas.add(pista);
        }
    }
    
    public void assPrimerPuesto(PlayerId playerId){
        podio.assPrimerPuesto(jugadores.get(playerId));
        System.out.println("||||||" + jugadores.get(playerId).name().getName() + "Primer puesto"  + "||||||");
        
    }
        }
    }
            
        }
    
    }
}
