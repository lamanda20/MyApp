package tp.exercice.tporg.service.facade;

import tp.exercice.tporg.bean.TypePaiement;


public interface TypePaiementService {

    TypePaiement findByCode(String code);

    int deleteByCode(String code);

    int save(TypePaiement typePaiement);
}
