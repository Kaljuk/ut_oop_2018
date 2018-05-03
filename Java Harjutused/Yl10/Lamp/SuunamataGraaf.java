package com.utoopproject.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
*/
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

/**
 * SuunamataGraaf
 */
public class SuunamataGraaf {

    private HashMap<String, HashSet<String>> punktid = new HashMap<String, HashSet<String>>();

    /*
    public static void main(String[] args) throws Exception {
        
        SuunamataGraaf g = new SuunamataGraaf("graph {rebane -- uba;uba -- reha;uba -- roheline;rebane -- rebane--kala;}");
        SuunamataGraaf i = new SuunamataGraaf(new File("test.txt"));
        SuunamataGraaf h = new SuunamataGraaf("graph{ rebane -- rebane --uba--reha;roheline -- uba;}");

         
        // int tipuAste(String) peab tagastama näidatud tipu astme
        System.out.println(g.tipuAste("rebane")); 
        
        // Set<String> tipuNaabrid(String); peab tagastama näidatud tipu naabertipud
        Set<String> naabrid = g.tipuNaabrid("rebane");
        for (String t: naabrid) {
            System.out.println("Rebane naaber:"+t);
        }
        // boolean equals(Object) peab tagastama true, kui argumendiks on samaväärne graaf (st. samade tippude ja servadega graaf)
        System.out.println("EQUALS h:g "+ h.equals(g));
        // boolean onAlamgraaf(SuunamataGraaf) peab tagastama true, kui käesolev graaf on argumendiks antud graafi alamgraaf.
        System.out.println("alamgraaf h:g "+ h.onAlamgraaf(g));
        System.out.println("alamgraaf g:h "+ g.onAlamgraaf(h));
        // String toString() peab tagastama graafi lihtsustatud DOT formaadis.        
        System.out.println(h.toString());
        System.out.println(g.toString());    
        
    }
    */


    // CONSTRUCTOR
    public SuunamataGraaf(String dotGraaf) {
        textToGraph(dotGraaf);
        //printGraph();
    }
    public SuunamataGraaf(File fn) throws Exception{
        // Save graaf here
        StringBuilder sb = new StringBuilder();
        InputStream inputStream;

        try {
            inputStream = new FileInputStream(fn);
        
        
        //InputStream inputStream = new FileInputStream(fn);
        BufferedReader failiSisu;
        // Ei kasuta fileReaderit ning saab kodeeringut valida
        failiSisu = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        
        // Get file contents
        String failiRida;
        while((failiRida= failiSisu.readLine()) != null) {
            sb.append(failiRida.replace("\n", "").replace(" ", ""));
        }
        // Close the buffer
        failiSisu.close();

        } catch(FileNotFoundException e) {
            System.out.println("FNF");
            //return null;
        }

        textToGraph(sb.toString());
    }
    
    public void printGraph() {
        for(String k: punktid.keySet()) {
            System.out.print(k+": ");
            for(String s : punktid.get(k)) {
                System.out.print(s+" ");
            }    
            System.out.println("__");
        }
    }

    private void textToGraph(String text) {
        text = text.replaceAll("\n ", "");
        // Get text between curly braces
        Pattern bracesPattern = Pattern.compile("\\{(.*)\\}");
        Matcher bracesMatcher = bracesPattern.matcher(text);
        if (bracesMatcher.find()) {
            //System.out.println(bracesMatcher.group(1));
            text = bracesMatcher.group(1);
        }
        String[] tipud = text.replaceAll(" ", "").replaceAll("\n", "").split(";");
        
        String[] suhted;
        HashSet<String> oneSet = new HashSet<String>();
        for(String s : tipud) {
            //System.out.println(s);
            suhted = s.split("--");
            for(int i=0; i<suhted.length; i++) {
                //System.out.println(suhted[i]);
                if (punktid.get(suhted[i]) == null) {
                    oneSet = new HashSet<String>();
                    if (i < suhted.length-1) {oneSet.add(suhted[i+1]);}
                    if (i > 0) {oneSet.add(suhted[i-1]);}
                    punktid.put(suhted[i], oneSet);
                } else {
                    oneSet = punktid.get(suhted[i]);
                    if (i < suhted.length-1) {oneSet.add(suhted[i+1]);}
                    if (i > 0) {oneSet.add(suhted[i-1]);}
                    punktid.put(suhted[i], oneSet);
                }                
            }
        }
    }

    public int tipuAste(String tipuNimi) {
        int aste = punktid.get(tipuNimi).size();
        return aste;
    }

    public Set<String> tipuNaabrid(String tipuNimi) {
        return punktid.get(tipuNimi);
    }

    public boolean equals(Object graafiNimi) {
        if (!(graafiNimi instanceof SuunamataGraaf)) return false;
        // Compare Keys
        SuunamataGraaf graaf = (SuunamataGraaf) graafiNimi;
        if (graaf.getPoints().size() != this.punktid.size()) return false;
        if (graaf.getPoints().keySet().equals(graaf.getPoints().keySet()) != true) return false;
        
        for(String k : graaf.getPoints().keySet()) {
            if (this.punktid.get(k) == null) return false;
            if (graaf.getPoints().get(k).size() != this.punktid.get(k).size()) return false;
            if (!(graaf.getPoints().get(k).containsAll(this.punktid.get(k))) || !(this.punktid.get(k).containsAll(graaf.getPoints().get(k)))) return false;
        }

        if (this.toString().length() != graaf.toString().length()) return false;
        
        return true;
    }

    public boolean onAlamgraaf(SuunamataGraaf graafiNimi) {
        SuunamataGraaf graaf = (SuunamataGraaf) graafiNimi;
        if (graaf.getPoints().size() < this.punktid.size()) return false;
        
        for(String k : graaf.getPoints().keySet()) {
            if (this.punktid.get(k) == null) continue;
            if (!(graaf.getPoints().get(k).containsAll(this.punktid.get(k)))) return false;
        }
        
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("graph{");
        for(String k: this.punktid.keySet()) {
            for(String sk : this.punktid.get(k)) {
                if (k.equals(sk) || k.compareTo(sk) > 1) {
                    //System.out.println(k+"--"+sk+";");
                    sb.append(k+"--"+sk+";");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }


    // GETTERS
    public HashMap<String, HashSet<String>> getPoints() {
        return this.punktid;
    }
}