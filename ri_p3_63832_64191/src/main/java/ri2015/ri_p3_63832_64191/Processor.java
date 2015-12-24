/**
 * Aveiro University, Department of Electronics, Telecommunications and
 * Informatics. MIECT - Information Retrieval 
 * Miguel Vicente, 63832 Vasco Santos, 64191
 */
package ri2015.ri_p3_63832_64191;

import java.util.Iterator;
import ri2015.ri_p3_63832_64191.corpusReader.CorpusReader;
import ri2015.ri_p3_63832_64191.corpusReader.Document;
import ri2015.ri_p3_63832_64191.solr.SolrHandler;

/**
 * Pipeline Processor to process the documents of the collection.
 * @author vsantos,mvicente
 */
public class Processor {
    
    /**
     * Corpus Reader reference.
     */
    private final CorpusReader cr;
    
    /**
     * Solr Handler reference.
     */
    private final SolrHandler solr;
    
    /**
     * Constructor of the Pipeline Processor.
     * @param dir path for the collection of documents.
     * @param url solr core url.
     */
    public Processor(String dir, String url){
        
        cr = new CorpusReader(dir);
        solr = new SolrHandler(url);
    }
    
    /**
     * Method responsible for start the Pipeline processor.
     */
    public void start(){
        Document doc;
        int docId = 0;
        System.out.println("Processing...");
        
        Iterator<Document> it = cr.iterator();
        while ((doc = it.next()) != null) {
            if (doc.valid()) {
                solr.addDocument(doc);
                docId++;
            }
        }
        solr.end();
    }
}
