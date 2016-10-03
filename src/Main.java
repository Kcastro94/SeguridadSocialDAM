import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SeguridadSocial seguridadSocial = new SeguridadSocial();
        SeguridadSocialMap seguridadSocialMapDni = new SeguridadSocialMap();
        SeguridadSocialMap seguridadSocialMapSS = new SeguridadSocialMap();


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

        seguridadSocialMapDni.altaPersona(jose);
        seguridadSocialMapDni.altaPersona(maria);
        seguridadSocialMapDni.altaPersona(carlos);
        seguridadSocialMapDni.altaPersona(anna);

        seguridadSocialMapSS.altaPersona(jose);
        seguridadSocialMapSS.altaPersona(maria);
        seguridadSocialMapSS.altaPersona(carlos);
        seguridadSocialMapSS.altaPersona(anna);

        System.out.println("Altas a la seguridad social: " + seguridadSocial.obtenerTodas());
        System.out.println("Altas a la seguridad social MAP: "+ seguridadSocialMapDni.obtenerTodas());

        System.out.println("Baja a la seguridad social: " + anna);
        seguridadSocial.bajaPersona(anna.getDni());

        System.out.println("Baja a la seguridad social MAP: "+anna);
        seguridadSocialMapDni.bajaPersona(anna.getDni());

        System.out.println("Lista de afiliados a la S.S.: " + seguridadSocial.obtenerTodas());
        seguridadSocial.obtenerPersonaPorNumSS(maria.getNumeroSeguridadSocial()).ifPresent(persona -> System.out.println("Persona por num SS.: " +persona));
        System.out.println("Lista de afiliados a la S.S. MAP: " +seguridadSocialMapSS.obtenerPersonaPorNumSS(maria.getNumeroSeguridadSocial()));

        seguridadSocial.obtenerPersonaPorDNI(jose.getDni()).ifPresent(persona -> System.out.println("Personas por DNI: "+persona));
        System.out.println("Personas por DNI MAP: "+seguridadSocialMapDni.obtenerPersonaPorDNI(jose.getDni()));

        System.out.println("obtenerPersonasRangoSalarial: " + seguridadSocial.obtenerPersonasRangoSalarial(23000.00, 45000.00));
        System.out.println("obtenerPersonaRangoSalarialMap: "+seguridadSocialMapDni.obtenerPersonasRangoSalarial(23000.00, 45000.00));

        seguridadSocial.obtenerPersonaSalarioMaximo().ifPresent(persona -> System.out.println("Salario máximo: "+persona));
        seguridadSocialMapDni.obtenerPersonaSalarioMaximo().ifPresent(persona -> System.out.println("Salario máximo MAP: "+persona));

        System.out.println("Obtener personas mayores que: "+seguridadSocial.obtenerPersonasMayoresQue(LocalDate.of(1992,1,1)));
        System.out.println("Obtener personas nacidas a partir de: "+seguridadSocialMapDni.obtenerPersonasNacidasAPartirDe(LocalDate.of(1985,1,1)));


    }
}
