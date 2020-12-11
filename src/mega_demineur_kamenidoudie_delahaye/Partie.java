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
    //int NombreTtBomb;
    
    void initialiserPartie() {
        Random r = new Random();
        //Mise en place de la grille
        GrilleJeu.viderGrille();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choix du pseudo du J1 :");
        Joueur J1 = new Joueur(sc.nextLine());
        Listejoueurs[0] = J1;
        
        
        
        
        
        

        System.out.println(J1.Nom);
       

        // On donne des jetons aux joueurs
        for (int i = 0; i < 21; i++) {

            Drapeau D = new Drapeau(Listejoueurs[0]);// faux car pas de classe drapeau je sais mais c'est pour avoir un model)

            J1.ajouterDrapeau(D);

            
        }

        // Determine qui est le premier joueur
        

        // Génération des 5 trous noirs et de 2 désintégrateurs sur les trou noirs
        int compteur = 0;
        for (int i = 0; i < 5; i++) {
            int ligne_trou_noir = r.nextInt(20);
            int colonne_trou_noir = r.nextInt(20);
            if (compteur < 2) {
                if (!GrilleJeu.placer_KitDeminages(ligne_trou_noir, colonne_trou_noir)) {
                    compteur--;
                }
                compteur = compteur + 1;
            }
            if (!GrilleJeu.placer_Bomb(ligne_trou_noir, colonne_trou_noir)) {
                i--;
            }
        }

        // On place les trois derniers désintégrateurs
        for (int i = 0; i < 3; i++) {
            int ligne_désin = r.nextInt(6);
            int colonne_désin = r.nextInt(7);
            if (!GrilleJeu.placer_KitDeminages(ligne_désin, colonne_désin) || GrilleJeu.TabCase[ligne_désin][colonne_désin].presenceBomb()) {
                i--;
            }
        }

        GrilleJeu.afficherGrilleSurConsole();
}
 
}
