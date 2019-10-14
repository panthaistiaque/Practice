/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etl;
 
import mysql_demo.intrgrationtest_0_1.IntrgrationTest;


/**
 *
 * @author Mohammad Istiaque Hossain <Software Developer>
 */
public class Etl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         String filePath = "F:\\OFFICE\\CBRS\\logs\\access_log.2019-05-29.log";
        System.out.println("etl");
        IntrgrationTest it = new IntrgrationTest();
        it.runJobInTOS(new String[]{"--context_param filePath="+filePath});
    }
    
}
