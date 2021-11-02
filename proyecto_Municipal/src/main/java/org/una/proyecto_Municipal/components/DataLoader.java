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
    private IBienxColaboradorService bienxcolaboradorService;

    @Autowired
    private ICobroService cobroService;

    @Autowired
    private IParametroService parametroService;


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

            ColaboradorDTO colaborador = ColaboradorDTO.builder()
                    .cedula("116380047")
                    .nombre("Andrey")
                    .telefono("89417655")
                    .build();

            colaboradorService.create(colaborador);

            ColaboradorDTO colaborador1 = ColaboradorDTO.builder()
                    .cedula("12345")
                    .nombre("Oa")
                    .telefono("123456789")
                    .build();

            colaboradorService.create(colaborador1);

//            BienxColaboradorDTO bienxcolaborador = BienxColaboradorDTO.builder()
//                    .porcentaje(20)
//                    .build();
//
//            bienxcolaboradorService.create(bienxcolaborador);

            CobroDTO cobro = CobroDTO.builder()
                    .estado(true)
                    .monto(300)
                    .periodo(2)
                    .build();

            cobroService.create(cobro);

            CobroDTO cobro1 = CobroDTO.builder()
                    .estado(false)
                    .monto(400)
                    .periodo(1)
                    .build();

            cobroService.create(cobro1);

            CobroDTO cobro2 = CobroDTO.builder()
                    .estado(true)
                    .monto(350)
                    .periodo(3)
                    .build();

            cobroService.create(cobro2);

            CobroDTO cobro3 = CobroDTO.builder()
                    .estado(false)
                    .monto(450)
                    .periodo(2)
                    .build();

            cobroService.create(cobro3);

            ParametroDTO horario1 = ParametroDTO.builder()
                    .descripcion("Lunes a Viernes de 8:00 am a 5:00 pm")
                    .estado(true)
                    .nombre("formulas")
                    .valor(2)
                    .build();
            parametroService.create(horario1);


            ParametroDTO formula1 = ParametroDTO.builder()
                    .descripcion("Formula Licencias comerciales: Tarifa trimestral = Ganancias brutas * 0,2 (minimo de 40 000 colones)")
                    .estado(true)
                    .nombre("Formula")
                    .valor(1)
                    .build();
            parametroService.create(formula1);

            ParametroDTO formula2 = ParametroDTO.builder()
                    .descripcion("Formula propiedades: Tarifa bimestral = metros de frente / 1500 (mínimo de 8 metros a cobrar y un máximo de 35)")
                    .estado(true)
                    .nombre("Formula")
                    .valor(1)
                    .build();
            parametroService.create(formula2);

            ParametroDTO formula3 = ParametroDTO.builder()
                    .descripcion("Formula rutas: Tarifa mensual = cantidad de salidas diarias * 200")
                    .estado(true)
                    .nombre("Formula")
                    .valor(1)
                    .build();
            parametroService.create(formula3);

            ParametroDTO horario2 = ParametroDTO.builder()
                    .descripcion("Sabado de 8:00 am a 12:00 md")
                    .estado(true)
                    .nombre("Horario")
                    .valor(2)
                    .build();
            parametroService.create(horario2);

            ParametroDTO help1 = ParametroDTO.builder()
                    .descripcion("/horario Devuelve el horario de la empresa")
                    .estado(true)
                    .nombre("Help")
                    .valor(3)
                    .build();
            parametroService.create(help1);

            ParametroDTO help2 = ParametroDTO.builder()
                    .descripcion("/formulas Devuelve las formulas de calculo de impuestos")
                    .estado(true)
                    .nombre("Help")
                    .valor(3)
                    .build();
            parametroService.create(help2);

            ParametroDTO help3 = ParametroDTO.builder()
                    .descripcion("/pendiente Cedula Devuelve los pendientes asociados a una cedula")
                    .estado(true)
                    .nombre("Help")
                    .valor(3)
                    .build();
            parametroService.create(help3);

            ParametroDTO help4 = ParametroDTO.builder()
                    .descripcion("/pagos cedula fecha inicio fecha final Devuelve los pagos asociados a una cedula entre un rango de fechas")
                    .estado(true)
                    .nombre("Help")
                    .valor(3)
                    .build();
            parametroService.create(help4);

            ParametroDTO help5 = ParametroDTO.builder()
                    .descripcion("/impuesto cedula tipo de impuesto (1. Licencias comerciales 2. Limpieza de vías 3. Rutas de buses) Devuelve los pendientes asociados a una cedula según un tipo de impuesto")
                    .estado(true)
                    .nombre("Help")
                    .valor(3)
                    .build();
            parametroService.create(help5);

            System.out.println("Se agrega el usuario inicial a la aplicación");
        } else {
            System.out.println("Se encontro el usuario administrador, continuando...");
        }
    }

}
