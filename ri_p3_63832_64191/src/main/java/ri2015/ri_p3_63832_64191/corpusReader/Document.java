/**
 * Aveiro University, Department of Electronics, Telecommunications and Informatics.
 * MIECT - Information Retrieval
 *  Miguel Vicente, 63832
 *  Vasco Santos, 64191
 */
package ri2015.ri_p3_63832_64191.corpusReader;

/**
 * Document data structure.
 * @author vicente
 */
public class Document {
    
    private String cid;
    private String sid;
    private String content;
    private String filename;
    private String speaker;
    private String date;
    private String language;
    private int year;


    public Document( String filename,String cid, String sid, String content, String speaker, String language) {
        this.cid = cid;
        this.sid = sid;
        this.content = content;
        this.filename = filename;
        this.speaker = speaker;
        this.language = language;
      
        String name = this.filename.replace("ep-", "");
        String [] data = name.split("-");
        if(Integer.parseInt(data[0]) > 16){
            this.date =  "19" + data[0]+ "-" + data[1] + "-" +data[2];
            this.year = Integer.parseInt("19" + data[0]);
        }
        else{
            this.date =  "20" + data[0]+ "-" + data[1] + "-" +data[2];
            this.year = Integer.parseInt("20" + data[0]);
        }
    }
    
    
    public String getDocumentName(){
        return this.filename+"_"+cid+"_"+sid+"_"+language+"_"+speaker;
    }

    public String getFilename() {
        return filename;
    }
    
    public String getDocName(){
        return this.filename+"_"+cid+"_"+sid;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getDate() {
        return date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    public int getYear(){
        return year;
    }
    
    public boolean valid(){
        return !this.cid.equals("") && !this.sid.equals("") && !this.content.equals("");
    }
    
}
