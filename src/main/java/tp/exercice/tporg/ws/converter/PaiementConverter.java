package tp.exercice.tporg.ws.converter;

import org.springframework.stereotype.Component;
import tp.exercice.tporg.ws.dto.PaiementDto;
import tp.exercice.tporg.bean.Paiement;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaiementConverter {
    public Paiement toBean(PaiementDto dto) {
        Paiement bean = new Paiement();
        bean.setId(dto.getId());
        bean.setCode(dto.getCode());
        bean.setCommande(dto.getCommande());
        bean.setDatePaiement(dto.getDatePaiement());
        bean.setMontant(dto.getMontant());
        bean.setTypePaiement(dto.getTypePaiement());
        bean.setEncaissement(dto.isEncaissement());

        return bean;
    }

    public PaiementDto toDto(Paiement bean) {
        PaiementDto dto = new PaiementDto();
        dto.setId(bean.getId());
        dto.setCode(bean.getCode());
        dto.setCommande(bean.getCommande());
        dto.setDatePaiement(bean.getDatePaiement());
        dto.setMontant(bean.getMontant());
        dto.setTypePaiement(bean.getTypePaiement());
        dto.setEncaissement(bean.isEncaissement());

        return dto;
    }

    public List<Paiement> toBean(List<PaiementDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

    public List<PaiementDto> toDto(List<Paiement> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
