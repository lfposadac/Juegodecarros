
/**
 * Clase para guardar la lista de los ganadors.
 * 
 * @author (Luis Fernando Posada Cano) 
 * @version (01/08/2021)
 */
/*
 * Serializable es una clase ubicada en el paquete Java. io. Serializable, la cual no cuenta con 
 * ningún método, por lo que es una clase que sirve solamente para especificar que todo el estado
 * de un objeto instanciado podrá ser escrito o enviado en la red como una trama de bytes
 */
import java.io.Serializable;
public class ListaGanadores
{
    public int id;
    public int cantidadPrimero;
    public int cantidadSegundo;
    public int cantidadTercero;
    public String name;
    
    public ListaGanadores(){}
    
    public ListaGanadores(int id, String name, int cantidadPrimero, int cantidadSegundo, int cantidadTercero){
      this.id = id;
      this.name = name;
      this.cantidadPrimero = cantidadPrimero;
      this.cantidadSegundo = cantidadSegundo;
      this.cantidadTercero = cantidadTercero;
    }
    
    public int getId(){ return id; }
    
    public String getName() { return name; }
    
    public int getCantidadPrimero() { return cantidadPrimero; }
    
    public int getCantidadSegundo() { return cantidadSegundo; }
    
    public int getCantidadTercero() { return cantidadTercero; }
    
    public void setId(int id) { this.id = id; }
    
    public void setName(String name) { this.name = name; }
    
    public void setCantidadPrimero(int cantidadPrimero){ this.cantidadPrimero = cantidadPrimero;}
    
    public void setCantidadSegundo(int cantidadSegundo){ this.cantidadSegundo = cantidadSegundo;}
    
    public void setCantidadTercero(int cantidadTercero){ this.cantidadTercero = cantidadTercero;}
    
    }

