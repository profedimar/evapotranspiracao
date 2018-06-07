/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import crawler.Downloader;
import crawler.Reader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class ForecastCrawlerController {

    public static int download(String siteconfig, String folder) {

        //read
        Map<String, String> sites = Reader.read(siteconfig);

        int nrDownloads = 0;
        for (String site : sites.keySet()) {
            try {
                File dir = new File(folder + "/" + site + "/" + getCurrentDate() + "/");
                dir.mkdirs();
                String file = dir.getAbsolutePath() + "/" + getNextDate() + ".html";
                Downloader.downloader(sites.get(site), file);
                nrDownloads++;
            } catch (IOException ex) {
                Logger.getLogger(ForecastCrawlerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return nrDownloads;
    }

    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy_MM_dd");
        return formatador.format(date);
    }

    public static String getNextDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date date = calendar.getTime();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy_MM_dd");
        return formatador.format(date);
    }

    public static void main(String[] args) {
        download("/media/edimar/Dados/implementacoes/java/evapotranspiracao/Crawler/input/sites.csv", "/media/edimar/Dados/implementacoes/java/evapotranspiracao/Crawler/output");
    }
}
