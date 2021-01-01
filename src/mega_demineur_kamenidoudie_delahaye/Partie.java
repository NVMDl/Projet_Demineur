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
        Joueur = new Joueur(sc.nextLine());
        Listejoueurs[0] = Joueur;
        //System.out.println(Joueur.Nom);
        
        // On donne des drapeaux au joueur
        Joueur.NbreDrapeau = NombreTtBomb;
        
        // On donne des Kits de Déminages au joueur
        Joueur.NbreKitDeminages = NombreTtBomb%3 + 1;
        
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
        for (int nKitDeminages = 1; nKitDeminages <= Joueur.NbreKitDeminages; nKitDeminages++) {
            int iAlea = nAlea.nextInt(20);
            int jAlea = nAlea.nextInt(20);
            if (GrilleJeu.TabCase[iAlea][jAlea].presenceBomb() == true || (GrilleJeu.TabCase[iAlea][jAlea].presenceBomb() != true && GrilleJeu.placer_KitDeminages(iAlea,jAlea) != true)) {
                nKitDeminages--;
            }
        }
        GrilleJeu.IncrementeBombNumberGrille();
        GrilleJeu.afficherGrilleSurConsole();
    }
    
    int menu_joueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nFaites votre choix !");
        System.out.println("1) Découvrir une case \n2) Placer un drapeau \n3) Récuperer un drapeau \n4) Utiliser un kit de déminages \n ");
        int choix = sc.nextInt();
        while (choix > 4 || choix < 1) {
            System.out.println("Choix invalide, recommencez");
            choix = sc.nextInt();
        }
        return choix;
    }
    
    int Choix_ligne() {
        Scanner s = new Scanner(System.in);
        System.out.println("Veuillez saisir une ligne :");
        int i = s.nextInt();
        while (i > 19 || i < 0) {
            System.out.println("Choix invalide, recommencez : ");
            i = s.nextInt();
        }
        return i;
    }
    
    int Choix_colonne() {
        Scanner s = new Scanner(System.in);
        System.out.println("Veuillez saisir une colonne :");
        int j = s.nextInt();
        while (j > 19 || j < 0) {
            System.out.println("Choix invalide, recommencez : ");
            j = s.nextInt();
        }
        return j;
    }
    
    boolean decouvreCase() {
        //GrilleJeu.Choisir_Case();
        int i = Choix_ligne();
        int j = Choix_colonne();
        
        if (GrilleJeu.activer_Bomb(i, j) == true) {
            GrilleJeu.IncrementeBombNumberCase(i, j);
            if (Joueur.PerdreVie() != true) {
                return false;//Le joueur n'a plus de vie et perd la partie
            }
        }
        if (GrilleJeu.recupere_Kit(i, j) == true) {
            Joueur.obtenirKitDemi();
        }
        return true;
    }
    
    boolean utiliseDrapeau() {//même que placer_drapeau()
        int i = Choix_ligne();
        int j = Choix_colonne();
        
        if (Joueur.utiliserDrapeau() == true && GrilleJeu.placer_Drapeau(i, j) == true) {
            return true;
        } else {
            return false;
        }
    }
    
    boolean recupereDrapeau() {
        int i = Choix_ligne();
        int j = Choix_colonne();
        
        if (GrilleJeu.recupere_Drapeau(i, j) == true) {
            Joueur.reprendreDrapeau();
            return true;
        } else {
            return false;
        }
    }
    
    boolean utiliseKit() {
        int i = Choix_ligne();
        int j = Choix_colonne();
        
        if (GrilleJeu.TabCase[i][j].Bomb == true) {
            Joueur.utiliserKitDem();
            GrilleJeu.TabCase[i][j].Bomb = false;
            return true;
        } else {
            if (GrilleJeu.recupere_Kit(i, j) == true) {
                Joueur.obtenirKitDemi();
                return true;
            }
            return false;
        }
    }
    
    boolean actionJoueur() {
        boolean resultat = true;
        System.out.println("\n " + Joueur.Nom + ", jouez ");
        System.out.println(" - Il vous reste " + Joueur.NbreDrapeau + " Drapeaux");
        System.out.println(" - Il vous reste " + Joueur.NbreKitDeminages + " Kits de Déminages");
        System.out.println(" - Il vous reste " + Joueur.HP + " points de vie");
        int choix = menu_joueur();
        switch (choix) {
            case 1:
                /*if (decouvreCase() == false) {//Le joueur a perdu, il n'a plus de points de vie
                    resultat = true;
                    //return resultat;
                } else {
                    resultat = false;
                }*/
                if (decouvreCase() == false) {//Le joueur a perdu, il n'a plus de points de vie
                    resultat = false;
                } else {
                    resultat = true;
                }
                break;
            case 2:
                if (utiliseDrapeau() == false) {
                    System.out.println("Vous avez choisi une case découverte ou bien vous n'avez pas de drapeaux");
                    resultat = false;
                    //return resultat;
                }
                break;
            case 3:
                if (recupereDrapeau() == false) {
                    System.out.println("Vous avez choisi une case sans drapeau");
                    resultat = false;
                    //return resultat;
                }
                break;
            case 4:
                if (utiliseKit() == false) {
                    System.out.println("Vous avez choisi une case découverte ou ayant un drapeau ou bien n'avez pas de kit de déminages");
                    resultat = false;
                    //return resultat;
                }
                break;
        }
        return resultat;
    }
    
    void debuterPartie() {
        initialiserPartie();
        Scanner s = new Scanner(System.in);
        do {
            while (actionJoueur() == false) {
                if (decouvreCase() == false) {
                    break;
                }
                System.out.println("Recommencez l'action");
            }
            if (decouvreCase() == false) {
                break;
            }
            GrilleJeu.afficherGrilleSurConsole();
        } while (GrilleJeu.etreGagnantePourJoueur(Listejoueurs[0]) != true);

        if (GrilleJeu.etreGagnantePourJoueur(Listejoueurs[0]) == true) {
            System.out.println(" Félicitations ! ");
        } else {
            System.out.println("Vous ferez mieux la prochaine fois :| ");
        }
    }
}
