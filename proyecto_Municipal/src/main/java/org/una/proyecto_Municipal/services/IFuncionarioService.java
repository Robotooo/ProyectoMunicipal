package org.una.proyecto_Municipal.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;

import java.util.List;
import java.util.Optional;

public interface IFuncionarioService {

    public Optional<FuncionarioDTO> findById(long id);

    public Optional<List<FuncionarioDTO>> findAll();

    public Optional<List<FuncionarioDTO>> findByUsuario(String user);

    public Optional<List<FuncionarioDTO>> findByRolId(long id);

    public Optional<List<FuncionarioDTO>> findByEstado(boolean estado);

    public Optional<FuncionarioDTO> findByCedula(String cedula);

    public Optional<List<FuncionarioDTO>> findByCedulaAproximate(String cedula);

    public Optional<FuncionarioDTO> create(FuncionarioDTO funcionarioDTO) throws PasswordIsBlankException;

    public Optional<FuncionarioDTO> update(FuncionarioDTO funcionarioDTO, long id) throws PasswordIsBlankException;

    public void delete(long id);

    public void deleteAll();

    public UserDetails loadUserByUsername(String username);


}
