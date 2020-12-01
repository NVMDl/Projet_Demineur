/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mega_demineur_kamenidoudie_delahaye;

/**
 *80 bombes
 * @author delah
 */

public class Case {
    boolean Bomb;
    boolean Drapeau;
    boolean KitDeminages;
    int BombNumber;
    
Boolean placerDrapeau(){
        if(Drapeau){
            return false;
        }
        Drapeau = true;
        return true;
    }
    
    Boolean placerBomb(){
        if(Bomb){
            return false;
        }
        Bomb = true;
        return true;
    }
    
    Boolean presenceBomb(){
        return Bomb;
    }
    
    Boolean activerBomb(){
        if(Case.Choisir_Case()==Bomb){
            Joueur.PerdreVie();// creer une autre classe
            Bomb = false;
            System.out.println("Vous perdez une vie");
            return true;
        }
        return false;
    }
    
    
}
