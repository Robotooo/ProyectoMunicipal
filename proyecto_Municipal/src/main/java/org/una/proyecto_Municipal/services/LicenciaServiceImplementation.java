package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.LicenciaDTO;
import org.una.proyecto_Municipal.entities.Licencia;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.ILicenciaRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class LicenciaServiceImplementation implements ILicenciaService{

    @Autowired
    private ILicenciaRepository licenciaRepository;

    //findBy...
    @Override
    public Optional<LicenciaDTO> findById(Long id) {
        Optional<Licencia> proveedor = licenciaRepository.findById(id);
        if (proveedor.isEmpty()) throw new NotFoundInformationException();

        LicenciaDTO proveedorDTO = MapperUtils.DtoFromEntity(proveedor.get(), LicenciaDTO.class);
        return Optional.ofNullable(proveedorDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<LicenciaDTO>> findAll() {
        List<LicenciaDTO> licenciaDTOList = MapperUtils.DtoListFromEntityList(licenciaRepository.findAll(), LicenciaDTO.class);
        return Optional.ofNullable(licenciaDTOList);
    }

    @Override
    public Optional<List<LicenciaDTO>> findByNombre(String nombre) {
        List<Licencia> licenciaList = licenciaRepository.findByNombre(nombre);
        List<LicenciaDTO> licenciaDTOList =  MapperUtils.DtoListFromEntityList(licenciaList, LicenciaDTO.class);
        return Optional.ofNullable(licenciaDTOList);
    }

    @Override
    public Optional<LicenciaDTO> findByTelefono(String telefono) {
        return Optional.empty();
    }

//    @Override
//    public Optional<LicenciaDTO> findByTelefono(String telefono) {  //??
//        Optional<Licencia> licencia = Optional.ofNullable(licenciaRepository.findByTelefono(telefono));
//        if (licencia.isEmpty()) throw new NotFoundInformationException();
//
//        LicenciaDTO licenciaDTO = MapperUtils.DtoFromEntity(licencia.get(), LicenciaDTO.class);
//        return Optional.ofNullable(licenciaDTO);
//    }

    @Override
    public Optional<LicenciaDTO> findByEmail(String email) {
        Optional<Licencia> licencia = Optional.ofNullable(licenciaRepository.findByEmail(email));
        if (licencia.isEmpty()) throw new NotFoundInformationException();

        LicenciaDTO licenciaDTO = MapperUtils.DtoFromEntity(licencia.get(), LicenciaDTO.class);
        return Optional.ofNullable(licenciaDTO);
    }

    @Override
    public Optional<List<LicenciaDTO>> findByDistrito(String distrito) {
        return Optional.empty();
    }

//    @Override
//    public Optional<List<LicenciaDTO>> findByDistrito(Boolean distrito) {
//        List<Licencia> licenciaList = licenciaRepository.findByEstado(distrito);
//        List<LicenciaDTO> licenciaDTOList = MapperUtils.DtoListFromEntityList(licenciaList, LicenciaDTO.class);
//        return Optional.ofNullable(licenciaDTOList);
//    }

    @Override
    public Optional<List<LicenciaDTO>> findByEstado(boolean estado) {
        List<Licencia> licenciaList = licenciaRepository.findByEstado(estado);
        List<LicenciaDTO> licenciaDTOList = MapperUtils.DtoListFromEntityList(licenciaList, LicenciaDTO.class);
        return Optional.ofNullable(licenciaDTOList);
    }

    @Override
    public Optional<List<LicenciaDTO>> findByBienId(Long id) {
        return Optional.empty();
        //TODO: findbyBienId
    }

//    //@Override
//    public Optional<List<LicenciaDTO>> findByBienId(Long id) {
//        List<LicenciaDTO> licenciaDTOList = MapperUtils.DtoListFromEntityList(licenciaRepository.findByBienId(id), LicenciaDTO.class);
//        if (licenciaDTOList.isEmpty()) throw new NotFoundInformationException();
//        return Optional.ofNullable(licenciaDTOList);
//    }

    @Override
    public Optional<List<LicenciaDTO>> findPendienteTotalLicencias(String cedula) {
        List<LicenciaDTO> licenciaDTOList = MapperUtils.DtoListFromEntityList(licenciaRepository.findPendienteTotalLicencias(cedula), LicenciaDTO.class);
        if (licenciaDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(licenciaDTOList);
    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        licenciaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        licenciaRepository.deleteAll();
    }

    //get
    private LicenciaDTO getSavedLicenciaDTO(LicenciaDTO licenciaDTO) {
        Licencia licencia = MapperUtils.EntityFromDto(licenciaDTO, Licencia.class);
        Licencia licenciaCreated = licenciaRepository.save(licencia);
        return MapperUtils.DtoFromEntity(licenciaCreated, LicenciaDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<LicenciaDTO> create(LicenciaDTO licenciaDTO) {
        return Optional.ofNullable(getSavedLicenciaDTO(licenciaDTO));
    }

    @Override
    @Transactional
    public Optional<LicenciaDTO> update(LicenciaDTO licenciaDTO, Long id) {
        if (licenciaRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedLicenciaDTO(licenciaDTO));

    }

}
