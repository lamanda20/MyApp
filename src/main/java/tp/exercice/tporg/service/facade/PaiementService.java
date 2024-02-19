package tp.exercice.tporg.service.facade;

import tp.exercice.tporg.bean.Paiement;

import java.util.List;

public interface PaiementService {
    List<Paiement> findAll();

    Paiement findByCode(String code);


    int deleteByCode(String code);


    int deleteByCommandeRef(String ref);

    List<Paiement> findByCommandeRef(String ref);

    int save(Paiement paiement);

    int encaisser(String codePaiement);
}
