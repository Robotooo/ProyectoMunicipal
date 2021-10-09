package org.una.proyecto_Municipal.services;

import org.apache.http.auth.InvalidCredentialsException;

import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;

import java.util.List;
import java.util.Optional;

public interface IFuncionarioService {

    public Optional<FuncionarioDTO> findById(Long id);

    public Optional<List<FuncionarioDTO>> findAll();

    public Optional<List<FuncionarioDTO>> findByUsuario(String user);

    public Optional<List<FuncionarioDTO>> findByCedulaAproximate(String cedula);

    public Optional<List<FuncionarioDTO>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto);

    public Optional<List<FuncionarioDTO>> findByRolId(Long id);

    public Optional<List<FuncionarioDTO>> findByEstado(boolean estado);

    public Optional<FuncionarioDTO> findByCedula(String cedula);

    public Optional<FuncionarioDTO> create(FuncionarioDTO funcionarioDTO);

    public Optional<FuncionarioDTO> update(FuncionarioDTO funcionarioDTO, Long id) throws PasswordIsBlankException;

    public void delete(Long id);

    public void deleteAll();

   // public AuthenticationResponse login(AuthenticationRequest authenticationRequest) throws InvalidCredentialsException;

    //  TODO: Hacer método "loadFuncionario"
}
