/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Downloader {

    
    public static void downloader(String url, String file) throws MalformedURLException, IOException {
        URL u = new URL(url);
        BufferedWriter writer;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(u.openStream()))) {
            writer = new BufferedWriter(new FileWriter(file));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
        writer.close();
    }
    
    public static void main(String[] args) {
        try {
            downloader("http://www.google.com", "C:\\Users\\Administrador\\Desktop/teste/data.html");
        } catch (IOException ex) {
            Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
