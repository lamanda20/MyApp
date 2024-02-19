package tp.exercice.tporg.ws.facade;

import tp.exercice.tporg.bean.TypePaiement;
import tp.exercice.tporg.service.facade.TypePaiementService;
import tp.exercice.tporg.ws.converter.TypePaiementConverter;
import tp.exercice.tporg.ws.dto.TypePaiementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/TypePaiement/")
public class TypePaiementWs {
    @Autowired
    private TypePaiementService service;
    @Autowired
    private TypePaiementConverter converter;

    @PostMapping("")
    public int save(@RequestBody TypePaiementDto dto) {
        TypePaiement bean = converter.toBean(dto);
        return service.save(bean);
    }

    @GetMapping("code/{code}")
    public TypePaiementDto findByCode(@PathVariable String code) {

        TypePaiement bean = service.findByCode(code);
        TypePaiementDto dto = converter.toDto(bean);
        return dto;
    }

    @DeleteMapping("")
    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }
}
