package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.FacturaDTO;
import org.una.proyecto_Municipal.entities.Factura;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IFacturaRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

public class FacturaServiceImplementation implements  IFacturaService{


    @Autowired
    private IFacturaRepository facturaRepository;

    @Override
    public Optional<FacturaDTO> findById(Long id) {
        Optional<Factura> usuario = facturaRepository.findById(id);
        if (usuario.isEmpty()) throw new NotFoundInformationException();

        FacturaDTO usuarioDTO = MapperUtils.DtoFromEntity(usuario.get(), FacturaDTO.class);
        return Optional.ofNullable(usuarioDTO);

    }

    @Override
    public Optional<List<FacturaDTO>> findByNombre(String nombre) {
        return Optional.empty();
    }

//    @Override
//    public Optional<List<FacturaDTO>> findByCajeroId(Long id) {
//        List<FacturaDTO> facturaDTOList = MapperUtils.DtoListFromEntityList(facturaRepository.findByCajeroId(id), FacturaDTO.class);
//        if (facturaDTOList.isEmpty()) throw new NotFoundInformationException();
//        return Optional.ofNullable(facturaDTOList);
//    }


    private FacturaDTO getSavedFacturaDTO(FacturaDTO facturaDTO) {
        Factura factura = MapperUtils.EntityFromDto(facturaDTO, Factura.class);
        Factura facturaCreated = facturaRepository.save(factura);
        return MapperUtils.DtoFromEntity(facturaCreated, FacturaDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<FacturaDTO> create(FacturaDTO facturaDTO) {
        return Optional.ofNullable(getSavedFacturaDTO(facturaDTO));
    }

    //@Override
    @Transactional
    public Optional<FacturaDTO> update(FacturaDTO facturaDTO, Long id) {
        if (facturaRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedFacturaDTO(facturaDTO));

    }

}
