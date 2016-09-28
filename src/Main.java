import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SeguridadSocial seguridadSocial = new SeguridadSocial();


        LocalDate date = LocalDate.of(1994,1,1);
        Persona jose = new Persona("39425364H", "111111111", "Jose", "Tomás", date, 45000.00);
        date = LocalDate.of(1990,1,1);
        Persona maria =  new Persona("39425654W", "33333333", "Maria", "Gallego", date, 61300.20);
        date = LocalDate.of(1997,1,1);
        Persona carlos = new Persona("39425355Q", "22222222", "Carlos", "Torres", date, 23000.00);
        date = LocalDate.of(1980,1,1);
        Persona anna = new Persona("39425987J", "444444444", "Anna", "Pina", date, 17654.88);

        seguridadSocial.altaPersona(jose);
        seguridadSocial.altaPersona(maria);
        seguridadSocial.altaPersona(carlos);
        seguridadSocial.altaPersona(anna);

        System.out.println("Altas a la seguridad social: " + seguridadSocial.obtenerTodas());

        System.out.println("Baja a la seguridad social: " + anna);
        seguridadSocial.bajaPersona(anna.getDni());

        System.out.println("Lista de afiliados a la S.S.: " + seguridadSocial.obtenerTodas());
        seguridadSocial.obtenerPersonaPorNumSS(maria.getNumeroSeguridadSocial()).ifPresent(persona -> System.out.println("Persona por num SS.: " +persona));

        seguridadSocial.obtenerPersonaPorDNI(jose.getDni()).ifPresent(persona -> System.out.println("Personas por DNI: "+persona));

        seguridadSocial.obtenerPersonaPorNumSS(maria.getNumeroSeguridadSocial()).ifPresent(persona -> System.out.println(persona));

        System.out.println("obtenerPersonasRangoSalarial: " + seguridadSocial.obtenerPersonasRangoSalarial(23000.00, 45000.00));

        seguridadSocial.obtenerPersonaSalarioMaximo().ifPresent(persona -> System.out.println("Salario máximo: "+persona));

        seguridadSocial.obtenerPersonasMayoresQue(LocalDate.of(1980,1,1));


    }
}
