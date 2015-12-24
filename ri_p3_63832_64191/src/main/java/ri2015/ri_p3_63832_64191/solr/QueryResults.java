/**
 * Aveiro University, Department of Electronics, Telecommunications and
 * Informatics. MIECT - Information Retrieval 
 * Miguel Vicente, 63832 Vasco Santos, 64191
 */
package ri2015.ri_p3_63832_64191.solr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Compare Query Results.
 * @author vsantos, mvicente
 */
public final class QueryResults extends ArrayList<Query> {
       
    /**
     * Query results object constrcutor.
     * @param path file path.
     */
    public QueryResults(String path){
        fillList(path);
    }
    
    /**
     * Fill Querys list.
     * @param path file path.
     */
    public void fillList(String path){
        
        File iFile = new File(path);
        try{
            FileInputStream fis = new FileInputStream(iFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            Query q;
            String qContent = "";
            ArrayList<String> docs = new ArrayList<>();
            
            String line = reader.readLine();
            while (line != null) {
                if(line.startsWith("Q")){
                    qContent = line.split(":")[1].trim();
                }
                else if(line.startsWith("//")){
                    this.add(new Query(qContent, docs));
                    docs = new ArrayList<>();
                }
                else{
                    docs.add(line);
                }
                line = reader.readLine();
            }
            this.add(new Query(qContent, docs));
            fis.close();
                
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }catch(IOException ex){
            System.out.println(ex.toString());
        }
    }
    
    /**
     * Results size.
     * @return size.
     */
    public int getSize(){
        return this.size();
    }
}
