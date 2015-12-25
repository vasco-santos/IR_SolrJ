# IR_SolrJ
Information Retrieval - Index document collection to a Solr core using a Solrj.

## Operation for indexing a collection. 

![alt tag](https://raw.githubusercontent.com/vasco-santos/IR_SolrJ/master/img/RI3_Diagram1.png)

## Operation for making a set queries and compute the Mean Average Precision. 

![alt tag](https://raw.githubusercontent.com/vasco-santos/IR_SolrJ/master/img/RI3_Diagram2.png)

## Execution

The Solr core has to be running and this Project has to be compiled before starting the execution.

**(1)** Index a document collection to a Solr Core.

`java -jar target/ri_p3_63832_64191-1.0-SNAPSHOT-jar-with-dependencies.jar -c [collection_path] -u [core_url]`

**(2)** Make a set of queries to a Solr core.

`java -jar target/ri_p3_63832_64191-1.0-SNAPSHOT-jar-with-dependencies.jar -s [queries_path] -u [core_url]`

## Queries File Template

`queries.txt`

## Information

Maven project developed for Information Retrieval course with [Miguel Vicente](https://github.com/mvicente93).