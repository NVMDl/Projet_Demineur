/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mega_demineur_kamenidoudie_delahaye;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author delah
 */
public class Partie {
    Joueur Joueur;
    Grille GrilleJeu= new Grille();
    Joueur Listejoueurs[] = new Joueur[1];
    int NombreTtBomb;//Nombre de bombes au total
    
    
    void initialiserPartie() {
        Random r = new Random();
        //Mise en place de la grille
        GrilleJeu.viderGrille();
        
        //Initialisation du nombre total de bombes
        NombreTtBomb = 40;
        
        //Identification du joueur
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez votre pseudo : ");
        Joueur J = new Joueur(sc.nextLine());
        Listejoueurs[0] = J;
        System.out.println(J.Nom);
        
        // On donne des drapeaux au joueur
        J.NbreDrapeau = NombreTtBomb;
        
        // On donne des Kits de Déminages au joueur
        J.NbreKitDeminages = NombreTtBomb%3 + 1;
        
        // Génération aléatoire de bombes et de kit de déminages
        // On place les bombes
        Random nAlea = new Random();//r pour random
        for (int nBomb = 1; nBomb <= 40; nBomb++) {
            int iAlea = nAlea.nextInt(20);
            int jAlea = nAlea.nextInt(20);
            if (GrilleJeu.placer_Bomb(iAlea,jAlea) != true) {
                nBomb--;
            }
        }
        // On place les Kits de Déminages
        for (int nKitDeminages = 1; nKitDeminages <= J.NbreKitDeminages; nKitDeminages++) {
            int iAlea = nAlea.nextInt(20);
            int jAlea = nAlea.nextInt(20);
            if (GrilleJeu.TabCase[iAlea][jAlea].presenceBomb() == true || (GrilleJeu.TabCase[iAlea][jAlea].presenceBomb() != true && GrilleJeu.placer_KitDeminages(iAlea,jAlea) != true)) {
                nKitDeminages--;
            }
        }

        GrilleJeu.afficherGrilleSurConsole();
    }
    
    int menu_joueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Jouez !");
        System.out.println("1) Découvrir une case \n2) Placer un drapeau \n3) Récuperer un drapeau \n4) Utiliser un kit de déminages \n ");
        int choix = sc.nextInt();
        while (choix > 4 || choix < 1) {
            System.out.println("Choix invalide, recommencez");
            choix = sc.nextInt();
        }
        return choix;
    }
    
    boolean recupereDrapeau() {
        return true;
    }
    
    boolean utiliseKit() {
        return false;
    }
    
    void debuterPartie() {
        
    }
 
}
