package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.proyecto_Municipal.entities.Funcionario;


import java.util.List;
import java.util.Optional;

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long> {

    public List<Funcionario> findByUsuario(String nombre);

    public List<Funcionario> findByRol(Long id);

    Optional<Funcionario> findByCedula(String cedula);

    public List<Funcionario> findByCedulaContaining(String cedula);

    public List<Funcionario> findByEstado(boolean estado);

    @Query(value = "{call registrarTransaccion(:accion_in, :objeto_in, :funId_in, :parametro_in)}", nativeQuery=true)
    public void registrarTransaccion(
            @Param("accion_in") String accion_in,
            @Param("objeto_in") String objeto_in,
            @Param("funId_in") Long funId_in,
            @Param("parametro_in") String parametro_in
    );

//    public Funcionario findByCedulaAndPasswordEncriptado(String cedula, String passwordEncriptado);

//    @Query("select u from Funcionario u where UPPER(u.usuario) like CONCAT('%',UPPER(:usuario),'%')")
//    public Funcionario findNombreWithLikeSQL(@Param("usuario")String usuario);

}
