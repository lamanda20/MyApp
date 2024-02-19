package tp.exercice.tporg.ws.facade;

import tp.exercice.tporg.bean.Commande;
import tp.exercice.tporg.service.facade.CommandeService;
import tp.exercice.tporg.ws.converter.CommandeConverter;
import tp.exercice.tporg.ws.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/commande/")
public class CommandeWs {
    @Autowired
    private CommandeService service;
    @Autowired
    private CommandeConverter converter;

    @PostMapping("")
    public int save(@RequestBody CommandeDto dto) {
        Commande bean = converter.toBean(dto);
        return service.save(bean);
    }

    @PutMapping("")
    public void update(@RequestBody CommandeDto dto) {
        Commande bean = converter.toBean(dto);
        service.update(bean);
    }

    @GetMapping("findnonpaye")
    public List<CommandeDto> findNonPaye() {
        List<Commande> beans = service.findNonPaye();
        List<CommandeDto> dtos = converter.toDto(beans);
        return dtos;
    }

    @GetMapping("ref/{ref}")
    public CommandeDto findByRef(@PathVariable String ref) {

        Commande bean = service.findByRef(ref);
        CommandeDto dto = converter.toDto(bean);
        return dto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return service.deleteByRef(ref);
    }

    @GetMapping("")
    public List<CommandeDto> findAll() {

        List<Commande> beans = service.findAll();
        List<CommandeDto> dtos = converter.toDto(beans);
        return dtos;
    }
}
