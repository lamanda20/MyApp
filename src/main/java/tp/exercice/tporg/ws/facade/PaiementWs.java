package tp.exercice.tporg.ws.facade;

import tp.exercice.tporg.ws.converter.PaiementConverter;
import tp.exercice.tporg.ws.dto.PaiementDto;
import tp.exercice.tporg.bean.Paiement;
import tp.exercice.tporg.service.facade.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/passpaiement/")
public class PaiementWs {
    @Autowired
    private PaiementService service;
    @Autowired
    private PaiementConverter converter;

    @GetMapping("commande/ref/{ref}")
    public List<PaiementDto> findByCommandeRef(@PathVariable String ref) {
        List<Paiement> beans = service.findByCommandeRef(ref);
        List<PaiementDto> dtos = converter.toDto(beans);
        return dtos;
    }

    @PutMapping("encaisser/code/{code}")
    public int encaisser(@PathVariable String code) {
        return service.encaisser(code);
    }

    @GetMapping("code/{code}")
    public PaiementDto findByCode(@PathVariable String code) {
        Paiement bean = service.findByCode(code);
        PaiementDto dto = converter.toDto(bean);
        return dto;
    }

    @DeleteMapping("commande/ref/{ref}")
    public int deleteByCommandeRef(@PathVariable String ref) {
        return service.deleteByCommandeRef(ref);
    }

    @PostMapping("")
    public int save(@RequestBody PaiementDto dto) {
        Paiement bean = converter.toBean(dto);
        return service.save(bean);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }

    @GetMapping("")
    public List<PaiementDto> findAll() {

        List<Paiement> beans = service.findAll();
        List<PaiementDto> dtos = converter.toDto(beans);
        return dtos;
    }
}



