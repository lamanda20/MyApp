package tp.exercice.tporg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tp.exercice.tporg.bean.Commande;

import java.util.List;


@Repository
public interface CommandeDao extends JpaRepository<Commande,Long>{

    Commande findByRef(String ref);
    int deleteByRef(String ref);
    @Query("SELECT c FROM Commande c WHERE (c.montantTotal > c.montantPayeEspece + c.montantPayeCheque)")
    List<Commande> findNonPaye();
}
