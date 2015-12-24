/**
 * Aveiro University, Department of Electronics, Telecommunications and
 * Informatics. MIECT - Information Retrieval 
 * Miguel Vicente, 63832 Vasco Santos, 64191
 */
package ri2015.ri_p3_63832_64191;

import ri2015.ri_p3_63832_64191.solr.QueryAveragePrecision;
import ri2015.ri_p3_63832_64191.solr.QueryResults;
import ri2015.ri_p3_63832_64191.solr.SolrHandler;

/**
 * Pipeline Processor to query the documents of the collection.
 * @author vsantos,mvicente
 */
public class SearchProcessor {
    
    /**
     * Solr Handler reference.
     */
    private final SolrHandler solr;
    
    /**
     * Original query results.
     */
    private QueryResults qr;
    
    
    private QueryAveragePrecision qap;
    
    /**
     * Constructor of the Pipeline Processor.
     * @param url solr core url.
     * @param filePath path.
     */
    public SearchProcessor(String url, String filePath){
        
        solr = new SolrHandler(url);
        qr = new QueryResults(filePath);
        qap = new QueryAveragePrecision();
    }
    
    /**
     * Method responsible for start the Pipeline processor.
     */
    public void start(){
        System.out.println("Start Processing...");
        System.out.println("-------------------");
        qr.forEach((query)->{
            System.out.println("Query: " + query.getQuery());
            qap.computeAP(query.getResults(), solr.findDocument(query.getQuery()));
            System.out.println("-------------------");
        });
        
        qap.getMeanAP(qr.size());
    }
}
