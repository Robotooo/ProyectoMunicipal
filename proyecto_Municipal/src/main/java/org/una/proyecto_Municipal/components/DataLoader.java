package org.una.proyecto_Municipal.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.proyecto_Municipal.dto.*;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
import org.una.proyecto_Municipal.services.*;
import lombok.SneakyThrows;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

//    @Autowired
//    private IBienxColaboradorService bienxcolaboradorService;

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

            loadFuncionarios();

            loadColaboradores();

            //loadBienes();

            loadParametros();

            loadCobros();

            loadCalendario();

            loadLicencias();

            loadRutas();

            loadPropiedades();

//          TODO:
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

    private Date convertStringToDate(String fechaString) throws java.text.ParseException {
        Date date = new SimpleDateFormat("yyyy-mm-dd").parse(fechaString);
        return date;
    }

    private void loadCalendario() throws ParseException {
        //calendario licencias
        Date d1 = convertStringToDate("2021-11-16");
        Date d2 = convertStringToDate("2022-2-16");
        Date d3 = convertStringToDate("2022-5-16");
        Date d4 = convertStringToDate("2022-8-16");
        Date d5 = convertStringToDate("2022-11-16");
        CalendarioDTO calendarioLicencias = CalendarioDTO.builder()
                .id(Long.valueOf(1))
                .tipo(1)
                .periodo(3)
                .fecha1(d1)
                .fecha2(d2)
                .fecha3(d3)
                .fecha4(d4)
                .fecha5(d5)
                .build();
        calendarioService.create(calendarioLicencias);

        //calendario limpieza de vías
        d1 = convertStringToDate("2021-11-16");
        d2 = convertStringToDate("2022-1-16");
        d3 = convertStringToDate("2022-3-16");
        d4 = convertStringToDate("2022-5-16");
        d5 = convertStringToDate("2022-7-16");
        Date d6 = convertStringToDate("2022-9-16");
        Date d7 = convertStringToDate("2022-11-16");
        CalendarioDTO calendarioLimpieza = CalendarioDTO.builder()
                .id(Long.valueOf(2))
                .tipo(2)
                .periodo(2)
                .fecha1(d1)
                .fecha2(d2)
                .fecha3(d3)
                .fecha4(d4)
                .fecha5(d5)
                .fecha6(d6)
                .fecha7(d7)
                .build();
        calendarioService.create(calendarioLimpieza);

        //calendario rutas
        d1 = convertStringToDate("2021-11-16");
        d2 = convertStringToDate("2021-12-16");
        d3 = convertStringToDate("2022-1-16");
        d4 = convertStringToDate("2022-2-16");
        d5 = convertStringToDate("2022-3-16");
        d6 = convertStringToDate("2022-4-16");
        d7 = convertStringToDate("2022-5-16");
        Date d8 = convertStringToDate("2022-6-16");
        Date d9 = convertStringToDate("2022-7-16");
        Date d10 = convertStringToDate("2022-8-16");
        Date d11 = convertStringToDate("2022-9-16");

        CalendarioDTO calendarioRutas = CalendarioDTO.builder()
                .id(Long.valueOf(3))
                .tipo(3)
                .periodo(1)
                .fecha1(d1)
                .fecha2(d2)
                .fecha3(d3)
                .fecha4(d4)
                .fecha5(d5)
                .fecha6(d6)
                .fecha7(d7)
                .fecha8(d8)
                .fecha9(d9)
                .fecha10(d10)
                .fecha11(d11)
                .build();
        calendarioService.create(calendarioRutas);
    }

    private void loadCobros() {
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
    }

    private void loadRutas(){
        //rutas
        RutaDTO ruta = RutaDTO.builder()
                .estado(true)
                //.bienId(bien)
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
    }

    private void loadPropiedades(){
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
    }

    private void loadLicencias(){
        //bienes
        BienDTO bien = BienDTO.builder().build();
        bienService.create(bien);

        BienDTO bien1 = BienDTO.builder().build();
        bienService.create(bien1);

        BienDTO bien2 = BienDTO.builder().build();
        bienService.create(bien2);

        //licencias
        LicenciaDTO licencia = LicenciaDTO.builder().bienId(bien2)
                .distrito("San Isidro")
                .email("licenacia1@gmail.com")
                .estado(true)
                .ganancias(300000)
                .nombre("licencia1")
                .telefono("12345678")
                .bienId(bien)
                .build();
        licenciaService.create(licencia);

        LicenciaDTO licencia2 = LicenciaDTO.builder().bienId(bien)
                .distrito("San Isidro")
                .email("licencia2@gmail.com")
                .estado(true)
                .ganancias(500000)
                .nombre("licencia2")
                .telefono("87654321")
                .bienId(bien2)
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
    }

    private void loadFuncionarios() throws PasswordIsBlankException {

        //Optional<RolDTO> colaboradorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_COLABORADOR.name()).build());
        Optional<RolDTO> auditorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_AUDITOR.name()).build());
        Optional<RolDTO> gestorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_GESTOR.name()).build());
        Optional<RolDTO> administradorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_ADMINISTRADOR.name()).build());
        Optional<RolDTO> gerenteRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_GERENTE.name()).build());
        Optional<RolDTO> botRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_BOT.name()).build());

        FuncionarioDTO gestorUsuario = FuncionarioDTO.builder()
                .cedula("01234537682")
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
    }

    private void loadColaboradores() throws ParseException {
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
    }

    private void loadParametros() throws ParseException {
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

        //--------------------------
        //---Variables 'valores'----
        //--------------------------

        ParametroDTO periodoCobroLicencia = ParametroDTO.builder()
                .descripcion("cantidad de meses por los que se cobra")
                .estado(true)
                .nombre("PeriodoCobroLicencia")
                .valor(4)
                .build();
        parametroService.create(periodoCobroLicencia);

        ParametroDTO montoMinimoLicencia = ParametroDTO.builder()
                .descripcion("monto mínimo a cobrar por el servicio de licencia")
                .estado(true)
                .nombre("MontoMinimoLicencia")
                .valor(4)
                .build();
        parametroService.create(montoMinimoLicencia);

        ParametroDTO porcentajeSobreGananciaBrutaLicencia = ParametroDTO.builder()
                .descripcion("porcentaje sobre ganancias brutas que se va a cobrar")
                .estado(true)
                .nombre("PorcentajeSobreGananciasBrutasLicencia")
                .valor(4)
                .build();
        parametroService.create(porcentajeSobreGananciaBrutaLicencia);

        ParametroDTO costoTimbre = ParametroDTO.builder()
                .descripcion("costo del timbre")
                .estado(true)
                .nombre("CostoTimbre")
                .valor(4)
                .build();
        parametroService.create(costoTimbre);

        ParametroDTO periodoCobroLimpieza = ParametroDTO.builder()
                .descripcion("cantidad de meses por los que se cobra")
                .estado(true)
                .nombre("PeriodoCobroLimpieza")
                .valor(4)
                .build();
        parametroService.create(periodoCobroLimpieza);

        ParametroDTO montoPorMetroFrenteLimpieza = ParametroDTO.builder()
                .descripcion("monto a cobrar por cada metro de frente en la propiedad")
                .estado(true)
                .nombre("montoPorMetroFrenteLimpieza")
                .valor(4)
                .build();
        parametroService.create(montoPorMetroFrenteLimpieza);

        ParametroDTO maximoMetrosLimpieza = ParametroDTO.builder()
                .descripcion("cantidad máxima de metros de frente a considerar")
                .estado(true)
                .nombre("maximoMetrosLimpieza")
                .valor(4)
                .build();
        parametroService.create(maximoMetrosLimpieza);

        ParametroDTO minimoMetrosLimpieza = ParametroDTO.builder()
                .descripcion("cantidad minima de metros de frente a considerar")
                .estado(true)
                .nombre("minimoMetrosLimpieza")
                .valor(4)
                .build();
        parametroService.create(minimoMetrosLimpieza);

        ParametroDTO periodoCobroBuses = ParametroDTO.builder()
                .descripcion("cantidad de meses por los que se cobra")
                .estado(true)
                .nombre("PeriodoCobroBuses")
                .valor(4)
                .build();
        parametroService.create(periodoCobroBuses);

        ParametroDTO salidaPorDiaBuses = ParametroDTO.builder()
                .descripcion("cantidad de salidas por dia")
                .estado(true)
                .nombre("salidaPorDiaBuses")
                .valor(4)
                .build();
        parametroService.create(salidaPorDiaBuses);
    }

}
