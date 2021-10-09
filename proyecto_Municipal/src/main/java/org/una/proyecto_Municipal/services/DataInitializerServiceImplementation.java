package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.proyecto_Municipal.entities.Funcionario;
import org.una.proyecto_Municipal.entities.Rol;
import org.una.proyecto_Municipal.repositories.IFuncionarioRepository;
import org.una.proyecto_Municipal.repositories.IRolRepository;

@Service
public class DataInitializerServiceImplementation implements IDataInitializerService {



    @Autowired
    private IFuncionarioRepository funcionarioRepository;

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public void initDevelopData() {



//        Rol colaboradorRol =  rolRepository.save(Rol.builder().nombre("Colaborador").build());
//        Rol usuarioRol =  rolRepository.save(Rol.builder().nombre("Usuario").build());
//        Rol auditorRol =  rolRepository.save(Rol.builder().nombre("Auditor").build());
//        Rol contadorRol =  rolRepository.save(Rol.builder().nombre("Contador").build());
//        Rol administradorRol =  rolRepository.save(Rol.builder().nombre("Administrador").build());


//        Funcionario gestorFuncionario = new Funcionario();
//        gestorFuncionario.setUsuario("0123456789");
//        gestorFuncionario.setUsuario("Funcionario Prueba");
//        gestorFuncionario.setContrasenia("Una2021");
//        gestorFuncionario.setRol(usuarioRol);
//        funcionarioRepository.save(gestorFuncionario);

//        Usuario coordinadorDepartamentoUsuario = new Usuario();
//        coordinadorDepartamentoUsuario.setCedula("9876543210");
//        coordinadorDepartamentoUsuario.setNombreCompleto("Usuario Prueba Coordinador");
//        coordinadorDepartamentoUsuario.setEsJefe(true);
//        coordinadorDepartamentoUsuario.setPasswordEncriptado("Una2021");
//        coordinadorDepartamentoUsuario.setDepartamento(patentesDepartamento);
//        coordinadorDepartamentoUsuario.setRol(administradorRol);
//        usuarioRepository.save(coordinadorDepartamentoUsuario);

    }

    @Override
    public void deleteAllData() {
        rolRepository.deleteAll();
        funcionarioRepository.deleteAll();
//        departamentoRepository.deleteAll();
    }

}
