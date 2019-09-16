/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco Gamboa
 */
public class Main {
    public static void  main(String[] args){
     JsonController j = new JsonController("data.json");
     j.initialize();
    }
}
