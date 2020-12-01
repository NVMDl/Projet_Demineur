/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mega_demineur_kamenidoudie_delahaye;

/**
 *
 * @author delah
 */

 import java.util.Scanner;

public class Grille {
    Case TabCase[][] = new Case[15][25];
    
     Grille() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                TabCase[i][j] = new Case();
            }
        }
    }
  
     
 Scanner sc ;
         
   Case Choisir_Case(){
       sc = new Scanner (System.in);
      int i=sc.nextInt();
      int j=sc.nextInt();
      return TabCase[i][j];
           
   }
      
    
     
 boolean etreGagnantePourJoueur(Joueur un_joueur) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (TabCase[i][j] != null && Joueur.HP >0;
                        && TabCase[i][j + 1] != null && Joueur.HP >0;
                        && TabCase[i][j + 2] != null && Case[i][j + 2].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && TabCase[i][j + 3] != null && Case[i][j + 3].lireCouleurDuJeton().equals(un_joueur.Couleur)) {
                    return true;
                }

            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (Case[i][j] != null && Case[i][j].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Case[i + 1][j] != null && Case[i + 1][j].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Case[i + 2][j] != null && Case[i + 2][j].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Case[i + 3][j] != null && Case[i + 3][j].lireCouleurDuJeton().equals(un_joueur.Couleur)) {
                    return true;
                }

            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (Case[i][j] != null && Case[i][j].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Case[i + 1][j + 1] != null && Case[i + 1][j + 1].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Case[i + 2][j + 2] != null && Case[i + 2][j + 2].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Case[i + 3][j + 3] != null && Case[i + 3][j + 3].lireCouleurDuJeton().equals(un_joueur.Couleur)) {
                    return true;
                }

            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (Case[i][j] != null && Case[i][j].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Case[i - 1][j + 1] != null && Case[i - 1][j + 1].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Case[i - 2][j + 2] != null && Case[i - 2][j + 2].lireCouleurDuJeton().equals(un_joueur.Couleur)
                        && Case[i - 3][j + 3] != null && Case[i - 3][j + 3].lireCouleurDuJeton().equals(un_joueur.Couleur)) {
                    return true;
                }

            }
        }

        return false;

    }
     
 
  void viderGrille() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                TabCase[i][j].Bomb = false;
                TabCase[i][j].KitDeminages = false;
                TabCase[i][j].Drapeau = false;
            }
        }
    }
 void activer_Bomb(int colonne, int ligne) { // boolean
        int i = 20;
        while (TabCase[ligne][colonne].activer_Bomb() == null) {// perdre vie aussi
            i--;
            if (i == 0) {
                break;
            }
        }
        if (i >= 0 && i < 20) {
            tabCase[ligne][colonne].activerTrouNoir();
        }
     
     
     
     
     
     
     
      Boolean placerDrapeau(int ligne, int colonne) {
        if (!Case[ligne][colonne].Drapeau) {
            Case[ligne][colonne].Drapeau = true;
            return true;
        }
        return false;
}
}