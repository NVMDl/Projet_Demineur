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
    
    // constructeur appelé a la création d'une case
    Case() {
        Bomb = false;
        Drapeau = false;
        KitDeminages = false;
        BombNumber = 0;
    }
    
    Boolean placerDrapeau(){
        if(Drapeau){
            return false;
        }
        Drapeau = true;
        return true;
    }


    Boolean placerKitDeminages(){
        if(KitDeminages){
            return false;
        }
        KitDeminages = true;
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
        if (Bomb != true) {
            return false;
        }
        return true;
    }
    
    Boolean activerBomb(){
        if(presenceBomb() != true){
            return false;
        }
        Bomb = false;
        System.out.println("Une bombe a été activée");
        return true;
    }
    
    Boolean presenceKitDeminages(){
        if (KitDeminages == false) {
            return false;
        }
        return true;
    }
    
    /*
    Boolean recupererKitDeminages(){
        if(presenceKitDeminages()){
            KitDeminages = false;
            return true;
        }
        return false;
    }
    */
    
    Boolean presenceDrapeau(){
        if (Drapeau == false) {
            return false;
        }
        return true;
    }
    
    /*
    Boolean recupererDrapeau(){
        if(presenceDrapeau()){
            Drapeau = false;
            return true;
        }
        return false;
    }
    */
    
     Boolean activerKitDeminages(){
        if(KitDeminages){
           
            KitDeminages = false;
            System.out.println("Un kit de déminages a été activé");
            return true;
        }
        return false;
    }
     
    int NbreBombAutour(){
        if (!Bomb){
            return BombNumber;
        }
        return 0;
    }
    
     
}
