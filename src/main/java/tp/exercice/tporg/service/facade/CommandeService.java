package tp.exercice.tporg.service.facade;

import tp.exercice.tporg.bean.Commande;

import java.util.List;

public interface CommandeService {
    void update(Commande commande);

    Commande findByRef(String ref);

    int deleteByRef(String ref);

    List<Commande> findAll();

    int save(Commande commande);

    List<Commande> findNonPaye();
}
