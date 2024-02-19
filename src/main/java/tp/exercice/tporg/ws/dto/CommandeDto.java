package tp.exercice.tporg.ws.dto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import tp.exercice.tporg.bean.Paiement;

import java.util.List;

public class CommandeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String ref;
    private double montantTotal;
    private double montantPayeCheque;
    private double montantPayeEspece;
    @OneToMany
    private List<Paiement> paiements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public double getMontantPayeCheque() {
        return montantPayeCheque;
    }

    public void setMontantPayeCheque(double montantPayeCheque) {
        this.montantPayeCheque = montantPayeCheque;
    }

    public double getMontantPayeEspece() {
        return montantPayeEspece;
    }

    public void setMontantPayeEspece(double montantPayeEspece) {
        this.montantPayeEspece = montantPayeEspece;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }
}