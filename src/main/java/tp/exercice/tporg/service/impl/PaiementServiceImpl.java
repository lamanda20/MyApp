package tp.exercice.tporg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tp.exercice.tporg.dao.PaiementDao;
import tp.exercice.tporg.bean.Commande;
import tp.exercice.tporg.bean.Paiement;
import tp.exercice.tporg.bean.TypePaiement;
import tp.exercice.tporg.service.facade.CommandeService;
import tp.exercice.tporg.service.facade.PaiementService;
import tp.exercice.tporg.service.facade.TypePaiementService;

import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {

    public static final String ESPECE = "Espece";
    public static final String CHEQUE = "Cheque";

    @Override
    public int save(Paiement paiement) {
        Commande commande = commandeService.findByRef(paiement.getCommande().getRef());
        paiement.setCommande(commande);

        TypePaiement typePaiement = typePaiementService.findByCode(paiement.getTypePaiement().getCode());
        paiement.setTypePaiement(typePaiement);

        if (commande == null) {
            return -1;
        } else if (commande.getMontantPayeCheque() + commande.getMontantPayeEspece() + paiement.getMontant() > commande.getMontantTotal()) {
            return -2;
        } else if (!ESPECE.equals(typePaiement.getCode()) && !CHEQUE.equals(typePaiement.getCode())) {
            return -3;
        } else {
            dao.save(paiement);
            if (ESPECE.equals(typePaiement.getCode())) {
                commande.setMontantPayeEspece(commande.getMontantPayeEspece() + paiement.getMontant());
            } else if (CHEQUE.equals(typePaiement.getCode())) {
                commande.setMontantPayeCheque(commande.getMontantPayeCheque() + paiement.getMontant());
            }
            commandeService.update(commande);
            return 1;
        }
    }

    @Override
    public int encaisser(String codePaiement) {
        Paiement paiement = dao.findByCode(codePaiement);
        Commande commande = commandeService.findByRef(paiement.getCommande().getRef());
        paiement.setCommande(commande);
        TypePaiement typePaiement = typePaiementService.findByCode(paiement.getTypePaiement().getCode());
        paiement.setTypePaiement(typePaiement);
        if (paiement == null) {
            return -1;
        } else if (!CHEQUE.equals(typePaiement.getCode())) {
            return -2;
        } else if (paiement.isEncaissement()) {
            return -3;
        } else {
            paiement.setEncaissement(true);
            dao.save(paiement);
            commande.setMontantPayeCheque(commande.getMontantPayeCheque() - paiement.getMontant());
            commande.setMontantPayeEspece(commande.getMontantPayeEspece() + paiement.getMontant());
            commandeService.update(commande);
            return 1;
        }
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        Paiement paiement = dao.findByCode(code);

        Commande commande = paiement.getCommande();
        paiement.setCommande(commande);

        TypePaiement typePaiement = paiement.getTypePaiement();
        paiement.setTypePaiement(typePaiement);

        if (CHEQUE.equals(typePaiement.getCode())) {
            commande.setMontantPayeCheque(commande.getMontantPayeCheque() - paiement.getMontant());
        } else if (ESPECE.equals(typePaiement.getCode())) {
            commande.setMontantPayeEspece(commande.getMontantPayeEspece() - paiement.getMontant());
        }
        commandeService.update(commande);
        return dao.deleteByCode(code);
    }

    @Override
    public List<Paiement> findAll() {
        return dao.findAll();
    }

    @Override
    public Paiement findByCode(String code) {
        return dao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCommandeRef(String ref) {
        return dao.deleteByCommandeRef(ref);
    }

    @Override
    public List<Paiement> findByCommandeRef(String ref) {
        return dao.findByCommandeRef(ref);
    }

    @Autowired
    private PaiementDao dao;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private TypePaiementService typePaiementService;
}