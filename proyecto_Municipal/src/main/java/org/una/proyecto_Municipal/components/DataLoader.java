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


    @SneakyThrows
    @Override
    public void run(ApplicationArguments args) {
        if (funcionarioService.findByCedulaAproximate(cedula).isEmpty()) {

            //Optional<RolDTO> colaboradorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_COLABORADOR.name()).build());
            Optional<RolDTO> auditorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_AUDITOR.name()).build());
            Optional<RolDTO> gestorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_GESTOR.name()).build());
            Optional<RolDTO> administradorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_ADMINISTRADOR.name()).build());
            Optional<RolDTO> gerenteRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_GERENTE.name()).build());

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

            System.out.println("Se agrega el usuario inicial a la aplicación");
        }else {
            System.out.println("Se encontro el usuario administrador, continuando...");
        }
    }

}
