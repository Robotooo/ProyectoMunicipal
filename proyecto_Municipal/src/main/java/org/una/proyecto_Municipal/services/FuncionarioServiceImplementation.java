package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.una.proyecto_Municipal.dto.*;
import org.una.proyecto_Municipal.entities.Funcionario;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;

import org.una.proyecto_Municipal.repositories.IFuncionarioRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImplementation implements IFuncionarioService, UserDetailsService {

    @Autowired
    private IFuncionarioRepository funcionarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    //findBy...
    @Override
    @Transactional(readOnly = true)
    public Optional<FuncionarioDTO> findById(Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isEmpty()) throw new NotFoundInformationException();

        FuncionarioDTO funcionarioDTO = MapperUtils.DtoFromEntity(funcionario.get(), FuncionarioDTO.class);
        return Optional.ofNullable(funcionarioDTO);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<FuncionarioDTO>> findAll() {
        List<FuncionarioDTO> funcionarioDTOList = MapperUtils.DtoListFromEntityList(funcionarioRepository.findAll(), FuncionarioDTO.class);
        return Optional.ofNullable(funcionarioDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<FuncionarioDTO>> findByUsuario(String user) {
        List<Funcionario> funcionarioList = funcionarioRepository.findByUsuario(user);
        List<FuncionarioDTO> funcionarioDTOList = MapperUtils.DtoListFromEntityList(funcionarioList, FuncionarioDTO.class);
        return Optional.ofNullable(funcionarioDTOList);
    }

    @Override
    public Optional<List<FuncionarioDTO>> findByRolId(Long id) {
        List<FuncionarioDTO> funcionarioDTOList = MapperUtils.DtoListFromEntityList(funcionarioRepository.findByRol(id), FuncionarioDTO.class);
        if (funcionarioDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(funcionarioDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<FuncionarioDTO>> findByEstado(boolean estado) {
        List<Funcionario> funcionarioList = funcionarioRepository.findByEstado(estado);
        List<FuncionarioDTO> funcionarioDTOList = MapperUtils.DtoListFromEntityList(funcionarioList, FuncionarioDTO.class);
        return Optional.ofNullable(funcionarioDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FuncionarioDTO> findByCedula(String cedula) {
        Optional<Funcionario> funcionario = funcionarioRepository.findByCedula(cedula);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(funcionario, FuncionarioDTO.class));
    }

    @Override
    public Optional<List<FuncionarioDTO>> findByCedulaAproximate(String cedula) {
        List<Funcionario> usuarioList = funcionarioRepository.findByCedulaContaining(cedula);
        if (usuarioList.isEmpty()) return Optional.empty();

        List<FuncionarioDTO> usuarioDTOList = MapperUtils.DtoListFromEntityList(usuarioList, FuncionarioDTO.class);
        return Optional.ofNullable(usuarioDTOList);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Funcionario> funcionarioBuscado = funcionarioRepository.findByCedula(username);
        if (funcionarioBuscado.isPresent()) {
            Funcionario usuario = funcionarioBuscado.get();
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
            UserDetails userDetails = new User(usuario.getCedula(), usuario.getPasswordEncriptado(), roles);
            return userDetails;
        } else {
            throw new UsernameNotFoundException("Username not found, check your request");
        }
    }


    private String encriptarPassword(String password) throws PasswordIsBlankException {
        if (!password.isBlank()) {
            return bCryptPasswordEncoder.encode(password);
        }else{
            throw new PasswordIsBlankException();
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        funcionarioRepository.deleteAll();
    }

    //get
    private FuncionarioDTO getSavedFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = MapperUtils.EntityFromDto(funcionarioDTO, Funcionario.class);
        Funcionario funcionarioCreated = funcionarioRepository.save(funcionario);
        return MapperUtils.DtoFromEntity(funcionarioCreated, FuncionarioDTO.class);
    }

    @Override
    @Transactional
    public Optional<FuncionarioDTO> create(FuncionarioDTO funcionarioDTO) throws PasswordIsBlankException {
        funcionarioDTO.setPasswordEncriptado(encriptarPassword(funcionarioDTO.getPasswordEncriptado()));
        return Optional.ofNullable(getSavedFuncionarioDTO(funcionarioDTO));
    }


    @Override
    public Optional<FuncionarioDTO> update(FuncionarioDTO funcionarioDTO, Long id) throws PasswordIsBlankException {
       if (funcionarioRepository.findById(id).isEmpty()) return Optional.empty();

        return Optional.ofNullable(getSavedFuncionarioDTO(funcionarioDTO));
    }



}
