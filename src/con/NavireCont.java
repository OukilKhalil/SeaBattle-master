/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package con;

import java.util.Iterator;
import mod.CaseGrille;
import mod.Navire;
import vue.GrilleVue;
import vue.SeaBattle;

/**
 *
 * @author ueve
 */
public class NavireCont {
    
    public static void couler(Navire n){
        Iterator<CaseGrille> cases = n.getCases().iterator();
        GrilleVue gv = SeaBattle.getPartie().getJoueur(1).getGrille().getVue();
        while (cases.hasNext()) {
            CaseGrille cg = cases.next();
            gv.getCaseBtn(Integer.parseInt(String.valueOf(cg.getX())+String.valueOf(cg.getY()))).setDisable(true);
            SeaBattle.getPartie().getJoueur(1).setNavireRestants(SeaBattle.getPartie().getJoueur().getNavireRestants()-1);
        }
        
    }
}
