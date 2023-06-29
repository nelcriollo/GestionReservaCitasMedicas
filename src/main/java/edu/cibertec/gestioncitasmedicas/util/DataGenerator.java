package edu.cibertec.gestioncitasmedicas.util;

import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DataGenerator {

    private static final Faker faker = new Faker();

    private static final Random random = new Random();
    private static final List<String> especialidadesMedicas = Arrays.asList(
            "Cardiología", "Dermatología", "Endocrinología", "Gastroenterología",
            "Neurología", "Oftalmología", "Pediatría", "Psiquiatría", "Traumatología"
    );

    public static int generarDuracion() {
        return faker.number().numberBetween(30, 61);
    }

    public static int generarEstado() {
        return faker.number().numberBetween(0,0);
    }

    public static String generarEspecialidadMedica() {
        int indice = random.nextInt(especialidadesMedicas.size());
        return especialidadesMedicas.get(indice);
    }

    public static BigDecimal generarPrecioConsulta() {
        return BigDecimal.valueOf(faker.number().randomDouble(2, 50, 201));
    }
    public static String generarNombre() {
        return faker.name().firstName();
    }
    public static String generarApellidos() {
        String apellido1 = faker.name().lastName();
        String apellido2 = faker.name().lastName();
        return apellido1 + " " + apellido2;
    }


    public static String generarEmail( String nombre) {
        return faker.internet().emailAddress(nombre);
    }

    public static Date generarFechaNacimiento() {
        return faker.date().birthday();
    }

    public static String generarNroDocumento() {
        return faker.number().digits(8);
    }

    public static String generarTelefono() {
        return faker.phoneNumber().cellPhone();
    }

    public static String generarCodigoCPI() {
        return "CPI" + faker.number().numberBetween(1, 10000000);
    }

    public static LocalDate generarFechaHorario() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaFutura = fechaActual.plusDays(30);
        return fechaFutura;
    }

    public static LocalTime generarHoraInicio() {
        int hour = faker.number().numberBetween(8, 18);
        return LocalTime.of(hour, 0);
    }

    public static LocalTime generarHoraFin(LocalTime horaInicio, int duracion) {
        return horaInicio.plusMinutes(duracion);
    }

    public static String generarPassword() {
        // Generar una contraseña aleatoria de 8 caracteres
        String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[{]};:'\",<.>/?";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int indice = random.nextInt(caracteresPermitidos.length());
            password.append(caracteresPermitidos.charAt(indice));
        }
        return password.toString();
    }

    public static LocalDate generarFechaRegistro() {
        return LocalDate.now();
    }

}
