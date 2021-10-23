package org.una.proyecto_Municipal.components;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.dto.RolDTO;
import org.una.proyecto_Municipal.services.IFuncionarioService;
import org.una.proyecto_Municipal.services.IRolService;
import lombok.SneakyThrows;

import java.util.Optional;

@Component
public class DataLoader implements ApplicationRunner {

    @Value("admin")
    private String cedula;

    @Value("Una2021")
    private String password;

    @Autowired
    private IFuncionarioService funcionarioService;

    @Autowired
    private IRolService rolService;


    @SneakyThrows
    @Override
    public void run(ApplicationArguments args) {
        if (funcionarioService.findByCedulaAproximate(cedula).isEmpty()) {

            //Optional<RolDTO> colaboradorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_COLABORADOR.name()).build());
            Optional<RolDTO> auditorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_AUDITOR.name()).build());
            Optional<RolDTO> gestorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_GESTOR.name()).build());
            Optional<RolDTO> administradorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_ADMINISTRADOR.name()).build());


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

            System.out.println("Se agrega el usuario inicial a la aplicación");
        }else {
            System.out.println("Se encontro el usuario administrador, continuando...");
        }
    }

}
