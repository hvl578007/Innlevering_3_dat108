package no.hvl.dat108.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import no.hvl.dat108.entity.Deltakar;

/**
 * DeltakarEAO
 */
@Stateless
public class DeltakarEAO {

    @PersistenceContext(name = "deltakarPU")
    private EntityManager em;

    public void leggTilDeltakar(Deltakar d) {
        em.persist(d);
    }

    public Deltakar hentBrukar(String mobilnr) {
        return em.find(Deltakar.class, mobilnr);
    }

    public List<Deltakar> hentListe() {
        TypedQuery<Deltakar> query = em.createQuery(
            "SELECT d FROM Deltakar d", Deltakar.class);
        return query.getResultList();
    }

}