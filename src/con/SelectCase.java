/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package con;

import mod.Grille;
import mod.Navire;
import vue.SeaBattle;

/**
 *
 * @author ueve
 */
public class SelectCase {
    
    public static void selectioner(Integer num){
        
        SeaBattle.getPartie().getJoueur().getNavires().setCoordonneeX(cord(num)[0]);
        SeaBattle.getPartie().getJoueur().getNavires().setCoordonneeY(cord(num)[1]);
        selectionerCrille(num);
        
        Navire n = SeaBattle.getPartie().getJoueur().getNavires();
        System.out.println(n.getType()+"   "+n.getCoordonneeX()+":"+n.getCoordonneeY()+"   "+n.getPosition());
    }
    
    
    private static int[] cord(Integer num){
        int tab[] = new int[2];
        if (num <10) {
            tab[0] = 0;
            tab[1] = num;
        }
        else{
            String val = num.toString();
            tab[0] = Integer.parseInt(val.substring(0, 1));
            tab[1] = Integer.parseInt(val.substring(1, 2));
        }
        return tab;
    }
    
    public static void selectionerCrille(Integer num){
        Grille grille = SeaBattle.getPartie().getJoueur().getGrille();
        int cases[] = new int[SeaBattle.getPartie().getJoueur(0).getGrille().getVue().cases(num).length];
        cases = SeaBattle.getPartie().getJoueur(0).getGrille().getVue().cases(num);
        for (int i = 0; i < cases.length; i++) {
            grille.getCasGrille(cord(cases[i])[0], cord(cases[i])[1]).setEtat("Plein");
        }
    }
}
