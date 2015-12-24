/**
 * Aveiro University, Department of Electronics, Telecommunications and
 * Informatics. MIECT - Information Retrieval 
 * Miguel Vicente, 63832 Vasco Santos, 64191
 */
package ri2015.ri_p3_63832_64191.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import ri2015.ri_p3_63832_64191.corpusReader.Document;

/**
 * Index Documents to a Solr core.
 * @author vsantos,mvicente
 */
public class SolrHandler {
    
    /**
     * Solr server.
     */
    private HttpSolrClient server;
    
    /**
     * Current number of documents in cache.
     */
    private int docsCache;
    
    /**
     * Solr handler constructor.
     * @param url solr core.
     */
    public SolrHandler (String url){
        
        server = new HttpSolrClient(url);
        docsCache = 0;
    }
    
    
    /**
     * Add a new Document to the Solr Core.
     * @param d document.
     */
    public void addDocument (Document d){
        
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("originalName", d.getFilename());
        doc.addField("docIdentifier", d.getDocName());
        doc.addField("content", d.getContent());
        doc.addField("speaker", d.getSpeaker());
        doc.addField("language", d.getLanguage());
        doc.addField("date", d.getDate());
        doc.addField("year", d.getYear());
        docsCache++;
        try{
            server.add(doc);
            if(docsCache % 100 == 0){
                docsCache = 0;
                server.commit();
            }
        }
        catch(Exception e){ 
            System.out.println(e.toString());
        }
    }
    
    /**
     * Finished document collection.
     */
    public void end(){
        try{
            server.commit();
        }
        catch(Exception e){ }
    }
    
    /**
     * Find documents where the query term appear.
     * @param q query.
     * @return SolrDocumentList.
     */
    public SolrDocumentList findDocument(String q){
        
        SolrDocumentList results = null;
        SolrQuery query = new SolrQuery();
        
        query.setQuery(q);
        query.setRows(Integer.MAX_VALUE);
        query.setParam("wt", "json");
        try{
            QueryResponse response = server.query(query);
            results = response.getResults();           
        }catch(Exception e){ 
            System.out.println(e.toString());
        }
        return results;
    }
}
