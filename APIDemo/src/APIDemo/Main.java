/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APIDemo;

import Controllers.DefaultPrototypeController;
import view.EditorScreenController;

/**
 * @author Carlos Esquivel
 * @author Marco Gamboa
 */
public class Main {
    public static void main(String[] args){
        DefaultPrototypeController.loadDefaultPrototypes();
        new EditorScreenController(); 
    } 
}
