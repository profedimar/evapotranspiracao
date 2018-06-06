/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import crawler.Reader;
import java.util.Map;

/**
 *
 * @author Administrador
 */
public class CrawlerController {
    
    public static void download(String site, String folder){
        
        //read
        Map<String, String> sites =  Reader.read(site);
        
    }
}
