package edu.cibertec.gestioncitasmedicas;

import edu.cibertec.gestioncitasmedicas.especialidad.domain.model.Especialidad;
import edu.cibertec.gestioncitasmedicas.especialidad.infrastructure.out.EspecialidadRepository;
import edu.cibertec.gestioncitasmedicas.horario.domain.model.Horario;
import edu.cibertec.gestioncitasmedicas.horario.infrastructure.out.HorarioRepository;
import edu.cibertec.gestioncitasmedicas.medico.domain.model.Medico;
import edu.cibertec.gestioncitasmedicas.medico.infrastructure.out.MedicoRepository;
import edu.cibertec.gestioncitasmedicas.paciente.domain.model.Paciente;
import edu.cibertec.gestioncitasmedicas.paciente.infrastructure.out.PacienteRepository;
import edu.cibertec.gestioncitasmedicas.reservacita.domain.model.ReservaCita;
import edu.cibertec.gestioncitasmedicas.reservacita.infrastructure.out.ReservaCitaRepository;
import edu.cibertec.gestioncitasmedicas.usuario.domain.model.Usuario;
import edu.cibertec.gestioncitasmedicas.usuario.infrastructure.out.UsuarioRepository;
import edu.cibertec.gestioncitasmedicas.util.DataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EspecialidadRepository especialidadRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ReservaCitaRepository reservaCitaRepository;

    @Override
    public void run(String... args) throws Exception {

        cargarDatosPaciente();
        generarEspecialidades();
        cargarDatosMedicos();
        cargarDatosHorarios();
        cargarDatosUsuarios();
        //cargarDatosReservaCita();

    }

    private void cargarDatosUsuarios() {
        Faker faker = new Faker();
        int cantidadRegistros = faker.number().numberBetween(1, 6);

        for (int i = 0; i < cantidadRegistros; i++) {
            Usuario usuario = new Usuario();
            usuario.setNombre(DataGenerator.generarNombre());
            usuario.setApellidos(DataGenerator.generarApellidos());
            usuario.setEmail(DataGenerator.generarEmail(usuario.getNombre()));
            usuario.setEstado(DataGenerator.generarEstado());
            usuario.setPassword(DataGenerator.generarPassword());

            usuarioRepository.save(usuario);
        }
        System.out.println("Se han cargado " + cantidadRegistros + " usuarios.");
    }

    private void generarEspecialidades() {
        Faker faker = new Faker();
        int cantidadRegistros = faker.number().numberBetween(1, 6);

        for (int i = 0; i < cantidadRegistros; i++) {
            Especialidad especialidad = new Especialidad();
            especialidad.setDuracion(DataGenerator.generarDuracion());
            especialidad.setEstado(DataGenerator.generarEstado());
            especialidad.setNombre(DataGenerator.generarEspecialidadMedica());
            especialidad.setPrecioConsulta(DataGenerator.generarPrecioConsulta());

            especialidadRepository.save(especialidad);
        }
        System.out.println("Se han cargado " + cantidadRegistros + " especialidades.");
    }

    private void cargarDatosPaciente() {
        Faker faker = new Faker();
        int cantidadRegistros = faker.number().numberBetween(1, 6);
        for (int i = 0; i < cantidadRegistros; i++) {
            Paciente paciente = new Paciente();
            paciente.setNombre(DataGenerator.generarNombre());
            paciente.setApellidos(DataGenerator.generarApellidos());
            paciente.setEmail(DataGenerator.generarEmail(paciente.getNombre()));
            paciente.setEstado(DataGenerator.generarEstado());
            paciente.setFechaNacimiento(DataGenerator.generarFechaNacimiento());
            paciente.setNroDocumento(DataGenerator.generarNroDocumento());
            paciente.setTelefono(DataGenerator.generarTelefono());

            pacienteRepository.save(paciente);
        }
        System.out.println("Se han cargado " + cantidadRegistros + " registros de pacientes.");
    }

    private void cargarDatosMedicos() {
        Faker faker = new Faker();
        int cantidadRegistros = faker.number().numberBetween(1, 6);

        // Obtener todas las especialidades de la base de datos
        List<Especialidad> especialidades = especialidadRepository.findAll();

        for (int i = 0; i < cantidadRegistros; i++) {
            Medico medico = new Medico();
            medico.setNombre(DataGenerator.generarNombre());
            medico.setApellidos(DataGenerator.generarApellidos());
            medico.setCodigoCpi(DataGenerator.generarCodigoCPI());
            medico.setEmail(DataGenerator.generarEmail(medico.getNombre()));
            medico.setEstado(DataGenerator.generarEstado());
            medico.setTelefono(DataGenerator.generarTelefono());

            // Obtener una especialidad aleatoria de la lista de especialidades generadas
            int indiceEspecialidad = faker.number().numberBetween(0, especialidades.size());
            Especialidad especialidad = especialidades.get(indiceEspecialidad);
            medico.setEspecialidad(especialidad);

            medicoRepository.save(medico);
        }
        System.out.println("Se han cargado " + cantidadRegistros + " registros de médicos.");
    }


   private void cargarDatosHorarios() {
       Faker faker = new Faker();
       int cantidadRegistros = faker.number().numberBetween(1, 11);

       // Obtener todas las especialidades de la base de datos
       List<Especialidad> especialidades = especialidadRepository.findAll();
       List<Medico> medicos = medicoRepository.findAll();

       int horariosGenerados = 0; // Contador de horarios generados

       while (horariosGenerados < cantidadRegistros) {
           Medico medico = medicos.get(faker.number().numberBetween(0, medicos.size()));

           Horario horario = new Horario();
           horario.setFechaRegistro(DataGenerator.generarFechaHorario());
           horario.setHoraInicio(DataGenerator.generarHoraInicio());
           LocalTime horaInicio = horario.getHoraInicio();
           horario.setHoraFin(DataGenerator.generarHoraFin(horaInicio, medico.getEspecialidad().getDuracion()));
           horario.setEstado(DataGenerator.generarEstado());
           horario.setMedico(medico);
           // Obtener la especialidad del medico
           horario.setEspecialidad(medico.getEspecialidad());

           horarioRepository.save(horario);

           horariosGenerados++;
       }

       System.out.println("Se han cargado " + horariosGenerados + " registros de horarios.");
   }
/*
@Transactional
  void cargarDatosReservaCita() {
        Faker faker = new Faker();
        int cantidadRegistros = faker.number().numberBetween(1, 6);

        List<Especialidad> especialidades = especialidadRepository.findAll();
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<Horario> horarios = horarioRepository.findAll();
        List<Usuario> usuarios = usuarioRepository.findAll();

    List<Long> horariosFiltrados = horarios.stream()
            .filter(horario -> horario.getEstado() != 0)
            .map(Horario::getIdHorario)
            .collect(Collectors.toList());

    Set<Long> horariosAsignados = new HashSet<>(horariosFiltrados);

    System.out.println("horarios"+ horariosAsignados);
        for (int i = 0; i < cantidadRegistros; i++) {

            ReservaCita reservaCita = new ReservaCita();

            reservaCita.setEstado(DataGenerator.generarEstado());
            reservaCita.setFechaRegistro(DataGenerator.generarFechaRegistro());

            // Obtener especialidad aleatoria para obtener el precio
            int indiceEspecialidad = faker.number().numberBetween(0, especialidades.size());
            Especialidad especialidad = especialidades.get(indiceEspecialidad);
            reservaCita.setPrecio(especialidad.getPrecioConsulta());

            // Obtener paciente aleatorio
            int indicePaciente = faker.number().numberBetween(0, pacientes.size());
            Paciente paciente = pacientes.get(indicePaciente);
            reservaCita.setPaciente(paciente);

            // Obtener horario aleatorio que no esté asignado previamente
            int maxIntentos = 10;
            int intentos = 0;
            Horario horario = null;

            while (intentos < maxIntentos && horario == null) {
                int indiceHorario = faker.number().numberBetween(0, horarios.size());
                Horario horarioActual = horarios.get(indiceHorario);

                boolean horarioAsignado = horariosAsignados.contains(horarioActual.getIdHorario());
                boolean reservaExistente = reservaCitaRepository.existsReservasCitaByFechaAndEspecialidadAndPaciente(
                        horarioActual.getFechaRegistro(),
                        horarioActual.getEspecialidad().getIdEspecialidad(),
                        paciente.getIdPaciente()
                );

                if (!horarioAsignado && !reservaExistente) {
                    horario = horarioActual;
                }

                intentos++;
            }

            if (horario != null) {
                reservaCita.setHorario(horario);
                // Obtener usuario aleatorio
                int indiceUsuario = faker.number().numberBetween(0, usuarios.size());
                Usuario usuario = usuarios.get(indiceUsuario);
                reservaCita.setUsuario(usuario);

                horariosAsignados.add(horario.getIdHorario());

                // Actualizar estado del horario a "1"
                horario.setEstado(1);
                horarioRepository.save(horario);

                reservaCitaRepository.save(reservaCita);
            } else {
                System.out.println("NO HAY HORARIOS DISPONIBLES");
            }
        }
      System.out.println("Se han cargado " + cantidadRegistros + " registros de reservaCitas.");
    }*/

}
