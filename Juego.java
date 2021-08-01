
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
        System.out.println("El jugador: " + name.getName()+ " será asignado a conductor " + "Si/No");
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
    
    //Asignamos posiciones
    public void assPrimerPuesto(PlayerId playerId){
        podio.assPrimerPuesto(jugadores.get(playerId));
        System.out.println("||||||" + jugadores.get(playerId).name().getName() + "Primer puesto"  + "||||||");
    }
    
    public void assSegundoPuesto(PlayerId playerId){
        podio.assSegundoPuesto(jugadores.get(playerId));
        System.out.println("||||||" + jugadores.get(playerId).name().getName() + "Segundo puesto"  + "||||||");
    }
    
    public void assTercerPuesto(PlayerId playerId){
        podio.assTercerPuesto(jugadores.get(playerId));
        System.out.println("||||||" + jugadores.get(playerId).name().getName() + "Tercer puesto"  + "||||||");
    }
    
    public Boolean finishCar(String name) {
        boolean carFinish = false;
        if(podio.tercerPuesto() == jugadores.get(playerId(name)) || podio.segundoPuesto() == jugadores.get(playerId(name)) || podio.primerPuesto == jugadores.get(playerId(name))){
            carFinish = true;
        }
        return carFinish;
    }
    
    public void mostrarPodio() {
        System.out.println("|||||| Podio |||||| ");
        System.out.println("Primer puesto" + podio.primerPuesto().name().getName());
        System.out.println("Segundo puesto" + podio.segundoPuesto().name().getName());
        System.out.println("Tercer puesto" + podio.tercerPuesto().name().getName());
    }
    
    public void repetirJuego() {
        Scanner in = new Scanner(System.in);
        System.out.println("Jugar otra vez S|N");
        while (!in.hasNext("[sSnN]")) {
            System.out.println("Escribe S, s o N, n");
            in.next();
        }
        String jugarOtro = in.next();
        if(jugarOtro.equals("S") || jugarOtro.equals("s")) {
            carrosEnPista.clear();
            carrilesEnJuego.clear();
            Podio podioNuevo = new Podio();
            podio = podioNuevo;
            startGame();
        }
    }
    
    public void startGame() {
        //Iniciamos con la identificación
        UUID id;
        id = UUID.randomUUID();
        GameId gameId = new GameId(id);
        
        //Pasamos a la selección de la pista
        Scanner in = new Scanner(System.in);
        System.out.println("Elige la pista en la que prefieres jugar: ");
        System.out.println("Pistas: ");
        int counter = 1;
        for(Pista p: pistas) {
            System.out.println(counter + "."+ "Kilometros: " + p.km() + "Número de carriles: " + p.numDeCarriles());
            counter++;
        }
        while(!in.hasNextInt())in.next();
        int pistaSeleccionada = in.nextInt();
        
        //Carros en juego y carriles
        carros.carros().forEach((key,value) -> {
            Carros carrosJuego = new Carros(gameId, value, Color.blue, 0);
            carrosEnPista.add(carrosJuego);
            
            int kmToMeters = pistas.get(pistaSeleccionada - 1).km() * 1000;
            Posicion posicion = new Posicion(0, kmToMeters);
            Carril carriles = new Carril(false, key,  gameId, posicion, kmToMeters);
            carrilesEnJuego.add(carriles);
        });
        
        //Start Game
        jugando = true;
        Conductor conductor = new Conductor();
        System.out.println("|||||| Inicio ||||||");
        
        //El juego solo se terminará si se completa el podio o si está "copado"
        while(jugando) {
            int contador = 0;
            System.out.println("|||||| Avance ||||||"+ "|||||| Meta: "+ carrilesEnJuego.get(contador).meters() + "metros");
            for (Carros carros: carrosEnPista) {
                if(!finishCar(carros.conductor().name())) {
                    int mover = conductor.girarDado() * 100;
                    carros.setDistancia(carros.distancia() + mover);
                    carrilesEnJuego.get(contador).movCar(carrilesEnJuego.get(contador).posicion(), mover);
                    System.out.println(carros.conductor().name() + "." + "mover " + mover + "a nueva posición " + carros.distancia());
                    
                    if (carrilesEnJuego.get(contador).movFinal()){
                        if (podio.primerPuesto() == null) {
                            assPrimerPuesto(playerId(carros.conductor().name()));
                        } else if (podio.segundoPuesto() == null) {
                            assSegundoPuesto(playerId(carros.conductor().name()));
                        } else if (podio.tercerPuesto() == null) {
                            assTercerPuesto(playerId(carros.conductor().name()));
                        }
                    }
                }
                contador++;
            }
            if(podio.copado()) {
                break;
            }
        }
        mostrarPodio();
        //guardarRegistrpBD();
        repetirJuego();
    }
    
    public Map<PlayerId, Jugador> jugadores() { return jugadores; }
    
    public Boolean jugando() { return jugando; }
    
    // Se retorna el identificador del jugador
    
    public PlayerId playerId(String name) {
        PlayerId lookId = null;
        for(PlayerId keys : jugadores.keySet()) {
            if(jugadores.get(keys).name().getName().equals(name)) { lookId = keys; }
        }
            return lookId;
        }
        }
  
  
