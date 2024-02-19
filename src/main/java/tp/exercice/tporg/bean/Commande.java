package tp.exercice.tporg.bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Commande {
    //Test
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private double montantTotal;
    private double montantPayeCheque;
    private double montantPayeEspece;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
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
