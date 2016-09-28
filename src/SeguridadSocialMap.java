/**
 * Created by usu32 on 19/09/2016.
 */
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SeguridadSocialMap {
    private Map<String, Persona> personaMapDni;
    private Map<String, Persona> personaMapSS;

    public SeguridadSocialMap() {
        personaMapDni = new HashMap<>();
        personaMapSS = new HashMap<>();
    }

    // Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social
    public void altaPersona(Persona persona) {

        if(!personaMapDni.containsKey(persona.getDni()) && !personaMapSS.containsKey(persona.getNumeroSeguridadSocial())) {
            personaMapDni.put(persona.getDni(), persona);
            personaMapSS.put(persona.getNumeroSeguridadSocial(), persona);
        }
    }

    public void bajaPersona(String dni) {

        Persona persona = personaMapDni.get(dni);
        personaMapSS.remove(persona.getNumeroSeguridadSocial());
        personaMapDni.remove(persona.getDni());
    }

    public Persona obtenerPersonaPorDNI(String dni) {
        return personaMapDni.get(dni);
    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
        return personaMapSS.get(numSS);
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){

        return personaMapDni.values().stream().filter(persona -> persona.getSalario()>=min && persona.getSalario()<=max).collect(Collectors.toList());
    }

    public List<Persona> obtenerPersonasNacidasAPartirDe(LocalDate fecha){

        return personaMapDni.values().stream().filter(persona -> persona.getFechaNacimiento().isAfter(fecha)).collect(Collectors.toList());
    }

    public Collection<Persona> obtenerTodas(){

        return personaMapDni.values();
    }

    public Optional<Persona> obtenerPersonaSalarioMaximo(){
        //Aplica un método de la clase persona de forma abstracta (sin aplicarlo a ningún objeto creado)
        return personaMapDni.values().stream().max(Comparator.comparing(Persona::getSalario));
    }

    @Override
    public String toString() {
        return "SeguridadSocialMap{" +
                "personaMapDni=" + personaMapDni +
                ", personaMapSS=" + personaMapSS +
                '}';
    }
}

