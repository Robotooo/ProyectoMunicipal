package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.una.proyecto_Municipal.entities.Factura;
import org.una.proyecto_Municipal.entities.Funcionario;


import java.util.List;
import java.util.Optional;

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long> {

    //public List<Funcionario> findByNombreContainingIgnoreCase(String nombre);

    //public List<Funcionario> findByUsuario(String usuario);

    public Funcionario findByCedulaAndPasswordEncriptado(String cedula, String passwordEncriptado);

    public List<Funcionario> findByCedulaContaining(String cedula);

    public List<Funcionario> findByUsuario(String nombre);

    public List<Factura>  findByRolId(Long id);

    Optional<Funcionario> findByCedula(String cedula);

    public List<Funcionario> findByEstado(boolean estado);

    public Funcionario findByTransaccionId(Long id);

    //public List<Funcionario> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto);

//    @Query("select u from Funcionario u where UPPER(u.usuario) like CONCAT('%',UPPER(:usuario),'%')")
//    public Funcionario findNombreWithLikeSQL(@Param("usuario")String usuario);

    //public Funcionario login(AuthenticationRequest authenticationRequest) ;

}
