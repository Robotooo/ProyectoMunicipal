package org.una.proyecto_Municipal.components;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.proyecto_Municipal.dto.*;
import org.una.proyecto_Municipal.services.*;
import lombok.SneakyThrows;

import java.util.Optional;

@Component
public class DataLoader implements ApplicationRunner {

    @Value("${spring.security.user.name}")
    private String cedula;

    @Value("${spring.security.user.password}")
    private String password;

    @Autowired
    private IFuncionarioService funcionarioService;

    @Autowired
    private IRolService rolService;

    @Autowired
    private IColaboradorService colaboradorService;

    @Autowired
    private IBienService bienService;

    @Autowired
    private IBienxColaboradorService bienxcolaboradorService;

    @Autowired
    private ICobroService cobroService;

    @Autowired
    private IRutaService rutaService;

    @Autowired
    private IDiaSemanaService diasemanaService;

    @Autowired
    private IParametroService parametroService;

    @Autowired
    private ILicenciaService licenciaService;

    @Autowired
    private IDeclaracionAnualService declaracionService;

    @Autowired
    private IPropiedadService propiedadService;

    @Autowired
    private ICalendarioService calendarioService;

    @SneakyThrows
    @Override
    public void run(ApplicationArguments args) {
        if (funcionarioService.findByCedulaAproximate(cedula).isEmpty()) {

            //Optional<RolDTO> colaboradorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_COLABORADOR.name()).build());
            Optional<RolDTO> auditorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_AUDITOR.name()).build());
            Optional<RolDTO> gestorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_GESTOR.name()).build());
            Optional<RolDTO> administradorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_ADMINISTRADOR.name()).build());
            Optional<RolDTO> gerenteRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_GERENTE.name()).build());
            Optional<RolDTO> botRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_BOT.name()).build());

            //funcionarios
            FuncionarioDTO gestorUsuario = FuncionarioDTO.builder()
                    .cedula("0123453782")
                    .usuario("Usuario Prueba Cajero")
                    .passwordEncriptado("Una2021")
                    .rol(gestorRol.orElseThrow()).build();
            funcionarioService.create(gestorUsuario);

            FuncionarioDTO administradorUsuario = FuncionarioDTO.builder()
                    .cedula(cedula)
                    .usuario("Usuario Administrador")
                    .passwordEncriptado(password)
                    .rol(administradorRol.orElseThrow()).build();
            funcionarioService.create(administradorUsuario);

            FuncionarioDTO botUsuario = FuncionarioDTO.builder()
                    .cedula("roboto")
                    .usuario("Usuario Bot")
                    .passwordEncriptado("botcito")
                    .rol(botRol.orElseThrow()).build();
            funcionarioService.create(botUsuario);

            //colaboradores
            ColaboradorDTO colaborador = ColaboradorDTO.builder()
                    .cedula("116380047")
                    .nombre("Andrey")
                    .telefono("89417655")
                    .build();
            colaboradorService.create(colaborador);

            ColaboradorDTO colaborador1 = ColaboradorDTO.builder()
                    .cedula("117940673")
                    .nombre("Danah")
                    .telefono("61519481")
                    .build();
            colaboradorService.create(colaborador1);

            ColaboradorDTO colaborador2 = ColaboradorDTO.builder()
                    .cedula("116950926")
                    .nombre("Henry")
                    .telefono("83594798")
                    .build();
            colaboradorService.create(colaborador2);

            //bienes
            BienDTO bien = BienDTO.builder().build();
            bienService.create(bien);

            BienDTO bien1 = BienDTO.builder().build();
            bienService.create(bien1);

            BienDTO bien2 = BienDTO.builder().build();
            bienService.create(bien2);

            //cobros
            CobroDTO cobro = CobroDTO.builder()
                    .estado(true)
                    .monto(50000)
                    .tipo(1) //1. licencias 2. propiedades 3. rutas
                    .periodo(3)
                    .build();
            cobroService.create(cobro);

            CobroDTO cobro1 = CobroDTO.builder()
                    .estado(false)
                    .monto(40000)
                    .tipo(3)
                    .periodo(1)
                    .build();
            cobroService.create(cobro1);

            CobroDTO cobro2 = CobroDTO.builder()
                    .estado(true)
                    .monto(35000)
                    .tipo(2)
                    .periodo(2)
                    .build();
            cobroService.create(cobro2);

            CobroDTO cobro3 = CobroDTO.builder()
                    .estado(false)
                    .monto(45000)
                    .tipo(3)
                    .periodo(1)
                    .build();
            cobroService.create(cobro3);

            //rutas
            RutaDTO ruta = RutaDTO.builder()
                    .estado(true)
                    .nombreRuta("PZ - SJ")
                    .finalRuta("fin")
                    .inicioRuta("ini")
                    .build();
            rutaService.create(ruta);

            //dias semana
            DiaSemanaDTO dia = DiaSemanaDTO.builder()
                    .cantidadSalidas(5)
                    .nombreDia("lunes")
                    .build();
            diasemanaService.create(dia);

            //licencias
            LicenciaDTO licencia = LicenciaDTO.builder()
                    .distrito("San Isidro")
                    .email("licencia1@gmail.com")
                    .estado(true)
                    .ganancias(300000)
                    .nombre("licencia1")
                    .telefono("12345678")
                    .build();
            licenciaService.create(licencia);

            LicenciaDTO licencia2 = LicenciaDTO.builder()
                    .distrito("San Isidro")
                    .email("licencia2@gmail.com")
                    .estado(true)
                    .ganancias(500000)
                    .nombre("licencia2")
                    .telefono("87654321")
                    .build();
            licenciaService.create(licencia2);

            //declaraciones anules
            DeclaracionAnualDTO declaracion = DeclaracionAnualDTO.builder()
                    .anio(2019)
                    .montoAnual(1000000)
                    .build();
            declaracionService.create(declaracion);

            DeclaracionAnualDTO declaracion1 = DeclaracionAnualDTO.builder()
                    .anio(2020)
                    .montoAnual(2000000)
                    .build();
            declaracionService.create(declaracion1);

            DiaSemanaDTO dia1 = DiaSemanaDTO.builder()
                    .cantidadSalidas(9)
                    .nombreDia("martes")
                    .build();
            diasemanaService.create(dia1);

            DiaSemanaDTO dia2 = DiaSemanaDTO.builder()
                    .cantidadSalidas(6)
                    .nombreDia("miércoles")
                    .build();
            diasemanaService.create(dia2);

            DiaSemanaDTO dia3 = DiaSemanaDTO.builder()
                    .cantidadSalidas(7)
                    .nombreDia("jueves")
                    .build();
            diasemanaService.create(dia3);

            DiaSemanaDTO dia4 = DiaSemanaDTO.builder()
                    .cantidadSalidas(10)
                    .nombreDia("viernes")
                    .build();
            diasemanaService.create(dia4);

            //propiedades
            PropiedadDTO propiedad = PropiedadDTO.builder()
                    .canton("Pérez Zeledón")
                    .direccion("Barrio ...")
                    .distrito("San Isidro")
                    .esEstado(true)
                    .estado(true)
                    .provincia("San José")
                    .zona(1)
                    .build();
            propiedadService.create(propiedad);

            PropiedadDTO propiedad2 = PropiedadDTO.builder()
                    .canton("Pérez Zeledón")
                    .direccion("Barrio ...")
                    .distrito("San Isidro")
                    .esEstado(true)
                    .estado(true)
                    .provincia("San José")
                    .zona(2)
                    .build();
            propiedadService.create(propiedad2);

            //parametros
            ParametroDTO horario1 = ParametroDTO.builder()
                    .descripcion("Lunes a Viernes de 8:00 am a 5:00 pm")
                    .estado(true)
                    .nombre("horario")
                    .valor(2)
                    .build();
            parametroService.create(horario1);

            ParametroDTO horario2 = ParametroDTO.builder()
                    .descripcion("Sabado de 8:00 am a 12:00 md")
                    .estado(true)
                    .nombre("horario")
                    .valor(2)
                    .build();
            parametroService.create(horario2);

            ParametroDTO formula1 = ParametroDTO.builder()
                    .descripcion("Formula licencias comerciales -> Tarifa trimestral = Ganancias brutas * 0,2 (minimo de 40 000 colones)")
                    .estado(true)
                    .nombre("formula")
                    .valor(1)
                    .build();
            parametroService.create(formula1);

            ParametroDTO formula2 = ParametroDTO.builder()
                    .descripcion("Formula limpieza de vías -> Tarifa bimestral = metros de frente / 1500 (mínimo de 8 metros a cobrar y un máximo de 35)")
                    .estado(true)
                    .nombre("formula")
                    .valor(1)
                    .build();
            parametroService.create(formula2);

            ParametroDTO formula3 = ParametroDTO.builder()
                    .descripcion("Formula rutas de buses -> Tarifa mensual = cantidad de salidas diarias * 200")
                    .estado(true)
                    .nombre("formula")
                    .valor(1)
                    .build();
            parametroService.create(formula3);

            ParametroDTO help1 = ParametroDTO.builder()
                    .descripcion("/horario Devuelve el horario de la empresa")
                    .estado(true)
                    .nombre("help")
                    .valor(3)
                    .build();
            parametroService.create(help1);

            ParametroDTO help2 = ParametroDTO.builder()
                    .descripcion("/formulas Devuelve las formulas de calculo de impuestos")
                    .estado(true)
                    .nombre("help")
                    .valor(3)
                    .build();
            parametroService.create(help2);

            ParametroDTO help3 = ParametroDTO.builder()
                    .descripcion("/pendiente cedula Devuelve los pendientes asociados a una cedula")
                    .estado(true)
                    .nombre("help")
                    .valor(3)
                    .build();
            parametroService.create(help3);

            ParametroDTO help4 = ParametroDTO.builder()
                    .descripcion("/pagos cedula fecha inicio fecha final Devuelve los pagos asociados a una cedula entre un rango de fechas")
                    .estado(true)
                    .nombre("help")
                    .valor(3)
                    .build();
            parametroService.create(help4);

            ParametroDTO help5 = ParametroDTO.builder()
                    .descripcion("/impuesto cedula tipo de impuesto (1. Licencias comerciales 2. Limpieza de vías 3. Rutas de buses) Devuelve los pendientes asociados a una cedula según un tipo de impuesto")
                    .estado(true)
                    .nombre("help")
                    .valor(3)
                    .build();
            parametroService.create(help5);
//TODO:
//            CalendarDTO licenciaCalendario = CalendarDTO.builder()
//                    .monto(10000)
//                    .
//                    .build();
//            calendarioService.create(licenciaCalendario);

            System.out.println("Se agrega el usuario inicial a la aplicación");
        } else {
            System.out.println("Se encontro el usuario administrador, continuando...");
        }
    }

}
