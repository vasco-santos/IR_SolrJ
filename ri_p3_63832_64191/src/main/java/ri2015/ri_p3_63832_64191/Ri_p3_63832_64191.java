/**
 * Aveiro University, Department of Electronics, Telecommunications and
 * Informatics. MIECT - Information Retrieval Miguel Vicente, 63832 Vasco
 * Santos, 64191
 */
package ri2015.ri_p3_63832_64191;

import java.io.File;
import java.util.Locale;
import org.apache.commons.cli.*;

/**
 * Main Program for Information Retrieval Assignment 2.
 * @author vsantos, mvicente
 */
public class Ri_p3_63832_64191 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //String url = "http://localhost:8983/solr/ri";
        //String path = "/home/vsantos/Dropbox/Cadeiras/RI/ri-2015/queries";

        Locale.setDefault(new Locale("en", "US"));

        // Possible arguments definition
        Options options = new Options();
        options.addOption("u", "url", true, "Solr url");
        options.addOption("c", "collection", true, "Collection to index");
        options.addOption("s", "search", true, "Search query file path");
        
        // Execution usage
        HelpFormatter formatter = new HelpFormatter();
        String usage = "java -jar target/ri_p3_63832_64191-1.0-SNAPSHOT.jar [-c <path>]";
        usage += "[-s <solr_url>]\n";

        String header = "\nPossible commands to execute are:";
        String footer = "\nPossible execution: \n";
        footer += "java -Xmx512M -jar target/ri_p3_63832_64191-1.0-SNAPSHOT.jar ";
        footer += "-c <path> -u <url> \n";
        footer += "java -Xmx512M -jar target/ri_p3_63832_64191-1.0-SNAPSHOT.jar ";
        footer += "-s <path> -u <url> \n";

        // Argument Parsing
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if (args.length != 4) {
                formatter.printHelp(usage, header, options, footer);
            }
            else if (cmd.hasOption("c") && cmd.hasOption("u")) {
                String collectionPath = cmd.getOptionValue("c");
                File f = new File(collectionPath);
                if (!f.isDirectory()) {
                    System.out.println("Invalid Document collection path!");
                    System.exit(0);
                } else {
                    String url = cmd.getOptionValue("u");
                    Processor p = new Processor(collectionPath, url);
                    p.start();
                }
            }
            else if(cmd.hasOption("s") && cmd.hasOption("u")){
                String filePath = cmd.getOptionValue("s");
                File f = new File(filePath);
                if (!f.isFile()) {
                    System.out.println("Invalid queries File!");
                    System.exit(0);
                } else {
                    String url = cmd.getOptionValue("u");
                    SearchProcessor sp = new SearchProcessor(url, filePath);
                    sp.start();
                }
            }
            else{
                System.out.println("Invalid Input");
            }
        // Argument parsing excetion.
        } catch (ParseException exp) {
            formatter.printHelp(usage, header, options, footer);
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
        }
    }
}