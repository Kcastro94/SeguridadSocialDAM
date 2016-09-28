/**
 * Created by usu32 on 19/09/2016.
 */
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SeguridadSocial {
    private List<Persona> personasList;

    public SeguridadSocial() {
        personasList = new ArrayList<>();
    }


    // Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social
    public void altaPersona(Persona persona) {

        boolean repetida = personasList.stream().anyMatch(personaActual -> personaActual.getDni().equals(persona.getDni()) ||
                personaActual.getNumeroSeguridadSocial().equals(persona.getNumeroSeguridadSocial()));

        if (!repetida){
            personasList.add(persona);
        }
    }

    public void bajaPersona(String dni) {
        personasList.removeIf(persona -> persona.getDni().equals(dni));
    }

    public Optional<Persona> obtenerPersonaPorDNI(String dni) {
        return personasList.stream().filter(persona -> persona.getDni().equals(dni)).findFirst();
    }

    public Optional<Persona> obtenerPersonaPorNumSS(String numSS) {
        return personasList.stream().filter(persona -> persona.getNumeroSeguridadSocial().equals(numSS)).findFirst();
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){

        return personasList.stream().filter(
                persona -> persona.getSalario() >= min && persona.getSalario() <= max).collect(Collectors.toList());
    }

    public List<Persona> obtenerPersonasMayoresQue(LocalDate fecha){
        return personasList.stream().filter(persona -> persona.getFechaNacimiento().isBefore(fecha)).collect(Collectors.toList());
    }

    public List<Persona> obtenerTodas(){
        return personasList;
    }

    public Optional<Persona> obtenerPersonaSalarioMaximo(){
        return personasList.stream().max(Comparator.comparing(Persona::getSalario));
    }

    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }
}

