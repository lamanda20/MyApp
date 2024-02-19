package tp.exercice.tporg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tp.exercice.tporg.dao.CommandeDao;
import tp.exercice.tporg.bean.Commande;
import tp.exercice.tporg.service.facade.CommandeService;
import tp.exercice.tporg.service.facade.PaiementService;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Override
    public int save(Commande commande) {
        if (commandeDao.findByRef(commande.getRef()) != null) {
            return -1;
        } else
            commandeDao.save(commande);
        return 1;
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        int res2 = paiementService.deleteByCommandeRef(ref);
        int res1 = commandeDao.deleteByRef(ref);
        return res1 + res2;
    }

    @Override
    public void update(Commande commande) {
        if (commandeDao.findByRef(commande.getRef()) != null) {
            commandeDao.save(commande);
        }
    }

    @Override
    public Commande findByRef(String ref) {
        return commandeDao.findByRef(ref);
    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    @Override
    public List<Commande> findNonPaye() {
        return commandeDao.findNonPaye();
    }

    private @Autowired CommandeDao commandeDao;
    private @Autowired PaiementService paiementService;

}
