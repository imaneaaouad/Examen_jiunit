package com.imaneaaouad_salah_edin;
import java.util.ArrayList;
import java.util.List;

public class ProduitService {
    
    private List<Produit> produits = new ArrayList<>();

    
    
    
    
          public void ajouterProduit(Produit produit) {
       
          if (!produitExiste(produit.getId()) && !nomProduitExiste(produit.getNom())) {
            
              if (validerDonneesProduit(produit)) {
                  produits.add(produit);
                   System.out.println("Produit ajouté avec succès !");
              } else {
                    System.out.println("Erreur : Les données du produit ne sont pas valides !");
               }
           } else {
                  System.out.println("Erreur : Un produit avec le même ID ou nom existe déjà !");
              }
         }

   
    public Produit obtenirProduitParId(Long id) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                return produit;
            }
        }
        System.out.println("Aucun produit trouvé avec cet ID.");
        return null;
    }

    
         public void mettreAJourProduit(Produit nouveauProduit) {
               for (int i = 0; i < produits.size(); i++) {
                    Produit produit = produits.get(i);
                      if (produit.getId().equals(nouveauProduit.getId())) {
                
                        if (validerDonneesProduit(nouveauProduit)) {
                            produits.set(i, nouveauProduit);
                          System.out.println("Produit mis à jour avec succès !");
                          } else {
                            System.out.println("Erreur : Les données du produit ne sont pas valides !");
                           }
                       return;
                      }
                     }
                   System.out.println("Erreur : Aucun produit trouvé avec cet ID pour la mise à jour.");
                   }

   
    public void supprimerProduit(Long id) {
        produits.removeIf(produit -> produit.getId().equals(id));
        System.out.println("Produit supprimé avec succès !");
    }

   
    private boolean produitExiste(Long id) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    
    private boolean nomProduitExiste(String nom) {
        for (Produit produit : produits) {
            if (produit.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

   
    private boolean validerDonneesProduit(Produit produit) {
        return produit.getPrix() > 0 && produit.getQuantite() > 0;
    }


	public Object trouverProduitParId(long l) {
		// TODO Auto-generated method stub
		return l;
	}
}

