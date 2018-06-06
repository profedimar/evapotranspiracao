/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Reader {
    
    //definir o arquivo de sites e a pasta onde salvar variáveis estáticas

    public static Map<String, String> read(String file) {
        Map<String, String> sites = new HashMap<>();
        
        try (
            BufferedReader reader = new BufferedReader(new FileReader(file));) {
            reader.readLine(); //pula o cabeçalho
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String partes[] = line.split(",");
                sites.put(partes[0].replace(" ", "_").toLowerCase(), partes[1]);
            }
            return sites;
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
