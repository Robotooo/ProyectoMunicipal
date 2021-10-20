package org.una.proyecto_Municipal.components;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.dto.RolDTO;
import org.una.proyecto_Municipal.services.IFuncionarioService;
import org.una.proyecto_Municipal.services.IRolService;
/*import org.una.Proyecto_Municipal.dto.DepartamentoDTO;
import org.una.inventario.dto.RolDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.services.IDepartamentoService;
import org.una.inventario.services.IRolService;
import org.una.inventario.services.IUsuarioService;*/

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
        if (funcionarioService.findByCedula(cedula).isEmpty()) {

            Optional<RolDTO> colaboradorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_COLABORADOR.name()).build());
            Optional<RolDTO> auditorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_AUDITOR.name()).build());
            Optional<RolDTO> usuarioRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_GESTOR.name()).build());
            Optional<RolDTO> administradorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_ADMINISTRADOR.name()).build());


//            FuncionarioDTO cajeroUsuario = FuncionarioDTO.builder()
//                    .cedula("0123453782")
//                    .usuario("Usuario Prueba Cajero")
//                    .passwordEncriptado("Una2021")
//                    .rol(usuarioRol.orElseThrow()).build();
//            funcionarioService.create(cajeroUsuario);

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
