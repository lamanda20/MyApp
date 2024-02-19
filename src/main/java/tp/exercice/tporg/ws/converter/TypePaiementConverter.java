package tp.exercice.tporg.ws.converter;

import org.springframework.stereotype.Component;
import tp.exercice.tporg.ws.dto.TypePaiementDto;
import tp.exercice.tporg.bean.TypePaiement;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TypePaiementConverter {
    public TypePaiement toBean(TypePaiementDto dto) {
        TypePaiement bean = new TypePaiement();
        bean.setId(dto.getId());
        bean.setCode(dto.getCode());
        bean.setLibelle(dto.getLibelle());
        return bean;
    }
    public TypePaiementDto toDto(TypePaiement bean) {
        TypePaiementDto dto = new TypePaiementDto();
        dto.setId(bean.getId());
        dto.setCode(bean.getCode());
        dto.setLibelle(bean.getLibelle());
        return dto;
    }

    public List<TypePaiement> toBean(List<TypePaiementDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

    public List<TypePaiementDto> toDto(List<TypePaiement> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
