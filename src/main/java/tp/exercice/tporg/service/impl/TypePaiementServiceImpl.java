package tp.exercice.tporg.service.impl;
import tp.exercice.tporg.dao.TypePaiementDao;
import tp.exercice.tporg.bean.TypePaiement;
import tp.exercice.tporg.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypePaiementServiceImpl implements TypePaiementService {
    @Autowired
    private TypePaiementDao typepaiementdao;
    @Override
    public TypePaiement findByCode(String code) {
        return typepaiementdao.findByCode(code);
    }
    @Override
    public int deleteByCode(String code) {
        return typepaiementdao.deleteByCode(code);
    }
    @Override
    public int save(TypePaiement typePaiement) {
        if (findByCode(typePaiement.getCode()) != null) {
            return -1;
        } else
            typepaiementdao.save(typePaiement);
        return 1;
    }
}