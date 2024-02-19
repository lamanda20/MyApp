package tp.exercice.tporg.ws.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import tp.exercice.tporg.bean.Commande;
import tp.exercice.tporg.bean.TypePaiement;

import java.time.LocalDateTime;

public class PaiementDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String code;
    private LocalDateTime datePaiement;
    private double montant;
    @ManyToOne
    private TypePaiement typePaiement;
    private boolean encaissement;
    @ManyToOne
    private Commande commande;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public boolean isEncaissement() {
        return encaissement;
    }

    public void setEncaissement(boolean encaissement) {
        this.encaissement = encaissement;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
