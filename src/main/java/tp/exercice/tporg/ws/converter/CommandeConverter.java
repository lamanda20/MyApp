package tp.exercice.tporg.ws.converter;

import org.springframework.stereotype.Component;
import tp.exercice.tporg.bean.Commande;
import tp.exercice.tporg.ws.dto.CommandeDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandeConverter {
    public Commande toBean(CommandeDto dto){
        Commande bean = new Commande();
        bean.setId(dto.getId());
        bean.setRef(dto.getRef());
        bean.setMontantTotal(dto.getMontantTotal());
        bean.setMontantPayeCheque(dto.getMontantPayeCheque());
        bean.setMontantPayeEspece(dto.getMontantPayeEspece());
        return bean;
    }
    public List<Commande> toBean(List<CommandeDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

    public CommandeDto toDto(Commande bean) {
        CommandeDto dto = new CommandeDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setMontantTotal(bean.getMontantTotal());
        dto.setMontantPayeCheque(bean.getMontantPayeCheque());
        dto.setMontantPayeEspece(bean.getMontantPayeEspece());
        return dto;
    }

    public List<CommandeDto> toDto(List<Commande> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}