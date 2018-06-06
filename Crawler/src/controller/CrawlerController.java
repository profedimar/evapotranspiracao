/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import crawler.Downloader;
import crawler.Reader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class CrawlerController {
    
    public static void download(String siteconfig, String folder){
        
        //read
        Map<String, String> sites =  Reader.read(siteconfig);
        
        for(String site: sites.keySet()){
            String file = folder+"/"+site+"/"+getCurrentDate()+"/amanha.html";
            try {
                Downloader.downloader(sites.get(site), file);
            } catch (IOException ex) {
                Logger.getLogger(CrawlerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static String getCurrentDate(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy_MM_dd");
        return formatador.format(data);
    }
}
