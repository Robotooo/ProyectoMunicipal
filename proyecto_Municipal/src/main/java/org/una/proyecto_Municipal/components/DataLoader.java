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

import java.util.Optional;

@Component
public class DataLoader implements ApplicationRunner {

    @Value("${app.admin-user}")
    private String cedula;

    @Value("${app.password}")
    private String password;

    @Autowired
    private IFuncionarioService funcionarioService;

    @Autowired
    private IRolService rolService;

    @Override
    public void run(ApplicationArguments args) {

        if (funcionarioService.findByCedulaAproximate(cedula).get().size() == 0) {


            Optional<RolDTO> colaboradorRol = rolService.create(RolDTO.builder().nombre("Colaborador").build());
            Optional<RolDTO> auditorRol = rolService.create(RolDTO.builder().nombre("Auditor").build());
            Optional<RolDTO> gerenteRol = rolService.create(RolDTO.builder().nombre("Contador").build());
            Optional<RolDTO> gestorRol = rolService.create(RolDTO.builder().nombre("Usuario").build());
            Optional<RolDTO> administradorRol = rolService.create(RolDTO.builder().nombre("Administrador").build());


            FuncionarioDTO auditorFuncionario = FuncionarioDTO.builder()
                    .cedula("0123456789")
                    .usuario("Usuario Prueba")
                    .passwordEncriptado("Una2021")
                    .rol(auditorRol.orElseThrow()).build();
            funcionarioService.create(auditorFuncionario);

//            UsuarioDTO contadorUsuario = UsuarioDTO.builder()
//                    .cedula("9876543210")
//                    .nombreCompleto("Usuario Prueba Contador")
//                    .esJefe(true)
//                    .passwordEncriptado("Una2021")
//                    .departamento(contabilidadDepartamento.orElseThrow())
//                    .rol(contadorRol.orElseThrow()).build();
//            usuarioService.create(contadorUsuario);
//
//            UsuarioDTO administradorUsuario = UsuarioDTO.builder()
//                    .cedula(cedula)
//                    .nombreCompleto("Usuario Administrador")
//                    .passwordEncriptado(password)
//                    .departamento(informaticaDepartamento.orElseThrow())
//                    .rol(administradorRol.orElseThrow()).build();
//            usuarioService.create(administradorUsuario);

            System.out.println("Se agrega el usuario inicial a la aplicación");
        }else {
            System.out.println("Se encontro el usuario administrador, continuando...");
        }
    }

}

