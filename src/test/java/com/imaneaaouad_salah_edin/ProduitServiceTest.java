package com.imaneaaouad_salah_edin;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

class ProduitServiceTest {

    @Test
    void testAjouterProduit() throws ProduitException, ProduitNotFoundException {
        ProduitService produitService = new ProduitService();

        Produit produit1 = new Produit(1L, "Produit1", 10.0, 5);
        produitService.ajouterProduit(produit1);

        assertEquals(produit1, produitService.trouverProduitParId(1L));

        assertThrows(ProduitException.class, () -> produitService.ajouterProduit(new Produit(1L, "Produit2", 15.0, 3)));
    }

    @Test
    void testTrouverProduitParId() throws ProduitNotFoundException, ProduitException {
        ProduitService produitService = new ProduitService();
        Produit produit1 = new Produit(1L, "Produit1", 10.0, 5);
        produitService.ajouterProduit(produit1);

        assertEquals(produit1, produitService.trouverProduitParId(1L));

        assertThrows(ProduitNotFoundException.class, () -> produitService.trouverProduitParId(2L));
    }

    @Test
    void testMettreAJourProduit() throws ProduitException, ProduitNotFoundException {
        ProduitService produitService = new ProduitService();
        Produit produit1 = new Produit(1L, "Produit1", 10.0, 5);
        produitService.ajouterProduit(produit1);

        produit1.setPrix(15.0);
        produit1.setQuantite(8);
        produitService.mettreAJourProduit(produit1);

        Produit produitMisAJour = (Produit) produitService.trouverProduitParId(1L);
        assertEquals(15.0, produitMisAJour.getPrix());
        assertEquals(8, produitMisAJour.getQuantite());

        assertThrows(ProduitNotFoundException.class, () -> produitService.mettreAJourProduit(new Produit(2L, "Produit2", 20.0, 3)));
    }

    @Test
    void testSupprimerProduit() throws ProduitNotFoundException, ProduitException {
    	
        ProduitService produitService = new ProduitService();
        
        Produit produit1 = new Produit(1L, "Produit1", 10.0, 5);
        
        produitService.ajouterProduit(produit1);

        produitService.supprimerProduit(1L);

        assertThrows(ProduitNotFoundException.class, () -> produitService.trouverProduitParId(1L));

        assertThrows(ProduitNotFoundException.class, () -> produitService.supprimerProduit(2L));
    }
}
