package tp.exercice.tporg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tp.exercice.tporg.bean.TypePaiement;

@Repository
public interface TypePaiementDao extends JpaRepository<TypePaiement, Long> {
    TypePaiement findByCode(String code);
    int deleteByCode(String code);



}
