package tp.exercice.tporg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tp.exercice.tporg.bean.Paiement;

import java.util.List;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {
    Paiement findByCode(String code);
    int deleteByCode(String code);
    List<Paiement> findByCommandeRef(String ref);
    int deleteByCommandeRef(String ref);
}