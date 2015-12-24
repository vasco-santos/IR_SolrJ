/**
 * Aveiro University, Department of Electronics, Telecommunications and
 * Informatics. MIECT - Information Retrieval 
 * Miguel Vicente, 63832 Vasco Santos, 64191
 */
package ri2015.ri_p3_63832_64191.solr;

import java.util.ArrayList;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrDocument;

/**
 * Query Average Precision compute.
 * @author vsantos,mvicente
 */
public class QueryAveragePrecision {
    
    /**
     * Sum of average precision.
     */
    private double sumAvgPrecision;
    
    /**
     * Query average precision constructor.
     */
    public QueryAveragePrecision(){
        this.sumAvgPrecision = 0.0;
    }
    
    /**
     * Method responsible for computing the average precision of the obtained results.
     * @param original original results.
     * @param res obtained results.
     */
    public void computeAP(ArrayList<String> original, SolrDocumentList res){
        
        int count = 0;
        int found = 0;
        double avgPrecision = 0.0;
        for(SolrDocument doc : res){
            count++;
            if(original.contains(doc.get("docIdentifier"))){
                found++;
                avgPrecision += ((double)found/count);
            }
        }
        avgPrecision /= original.size();
        sumAvgPrecision += avgPrecision;
        System.out.println("Avg Precision: " + avgPrecision);
    }
    
    /**
     * Compute Mean Average Precision.
     */
    public void getMeanAP(int size){
        
        double mean = sumAvgPrecision / size;
        System.out.println("Mean Average Precision: " + mean);
    }
}