package org.una.proyecto_Municipal.services;

import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.AuthenticationRequest;
import org.una.proyecto_Municipal.dto.AuthenticationResponse;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.dto.RolDTO;
import org.una.proyecto_Municipal.entities.Funcionario;
import org.una.proyecto_Municipal.repositories.IFuncionarioRepository;
import org.una.proyecto_Municipal.jwt.JwtProvider;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.Optional;

@Service
public class AutenticationServiceImplementation implements IAutenticationService {

    @Autowired
    private IFuncionarioRepository funcionarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    @Transactional(readOnly = true)
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) throws InvalidCredentialsException {

        // Llama al "authenticationRequest para obtener la cedula
        Optional<Funcionario> usuario = funcionarioRepository.findByCedula(authenticationRequest.getCedula());

        if(usuario.isPresent() && bCryptPasswordEncoder.matches(authenticationRequest.getPassword(), usuario.get().getPasswordEncriptado())){
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getCedula(), authenticationRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Set JWT
            authenticationResponse.setJwt(jwtProvider.generateToken(authenticationRequest));
            FuncionarioDTO usuarioDto = MapperUtils.DtoFromEntity(usuario.get(), FuncionarioDTO.class);
            authenticationResponse.setFuncionarioDTO(usuarioDto);
            authenticationResponse.setRolDTO(RolDTO.builder().nombre(usuarioDto.getRol().getNombre()).build());

            return authenticationResponse;
        } else{
            throw new InvalidCredentialsException();
        }

    }
}
