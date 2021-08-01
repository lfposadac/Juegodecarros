
/**
 * Creación del piloto o del conductor de los carros. 
 * 
 * @author (Luis Fernando posada Cano) 
 * @version (01/08/2021)
 */
public class Conductor
{
    public String name;
    
    public Conductor() { }
    
    public Conductor(String name){ this.name = name; }
    
    public String name() { return name; }
    
    public Integer girarDado() {
        int dadoRandom = (int) (Math.random() * 6 + 1);
        return dadoRandom;
    }
}
