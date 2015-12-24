/**
 * Aveiro University, Department of Electronics, Telecommunications and
 * Informatics. MIECT - Information Retrieval 
 * Miguel Vicente, 63832 Vasco Santos, 64191
 */
package ri2015.ri_p3_63832_64191.solr;

import java.util.ArrayList;

/**
 * Query object.
 * @author vsantos, mvicente
 */
public class Query {
    
    /**
     * Query value.
     */
    private String query;
    
    /**
     * Documents where the query has results.
     */
    private ArrayList<String> results;
    
    /**
     * Query constructor.
     * @param query query value.
     * @param results documents list.
     */
    public Query(String query, ArrayList<String> results){
        this.query = query;
        this.results = results;
    }

    /**
     * Get query value.
     * @return query value.
     */
    public String getQuery() {
        return query;
    }

    /**
     * Query query results list.
     * @return list of results.
     */
    public ArrayList<String> getResults() {
        return results;
    }
}