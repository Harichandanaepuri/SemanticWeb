import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.sparql.resultset.ResultsFormat;

import java.io.*;
public class Lab3_2 extends Object {
    public static void main (String args[]) throws FileNotFoundException {
    	org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
    	try {
    		Model model = ModelFactory.createDefaultModel();
    		long startTime=System.currentTimeMillis();    	
    		RDFDataMgr.read(model, "Monterey.rdf");
    		long endTime=System.currentTimeMillis();
    		double duration = ((endTime-startTime)*0.001);
    		float time = (float) duration;
    		System.out.printf("Load of Monterey.rdf took " + "%.1f" + " seconds\n", time);
    		String queryString = " Prefix inc:<http://urn.monterey.org/incidents#> " +
				" Select ?p ?o ?p1 ?o1 ?p2 ?o2 " +
				" Where { " +
				"   inc:incident1621 ?p ?o . " +
				"   OPTIONAL { " +
				"     ?o ?p1 ?o1 . " +
				"   OPTIONAL { " +
				"     ?o1 ?p2 ?o2 . " +
				"   } " +
				"   FILTER (?p1 != <http://blackbook.com/terms#incident>) " +
				"  } " +
				" } " ;
    		Query query = QueryFactory.create(queryString);
    		QueryExecution qe = QueryExecutionFactory.create(query, model);
    		QueryExecution qe1 = QueryExecutionFactory.create(query, model);
    		ResultSet res = qe.execSelect();

    		FileOutputStream out= new FileOutputStream(new File("Lab3_2_HXE170000.xml"));
    		ResultSetFormatter.output(out,res,ResultsFormat.FMT_RDF_XML );
    		System.out.println(res.getRowNumber()+" triples written into output file.");

    		//Extra Credit
			Model mod = ModelFactory.createDefaultModel() ;
			mod.read("Lab3_2_HXE170000.xml");
			FileWriter out2= new FileWriter("Lab3_2EC_HXE170000.rdf");
			mod.write(out2, "RDF/XML");
			FileWriter out3= new FileWriter("Lab3_2EC_HXE170000.ttl");
			mod.write(out3, "TURTLE");

    		qe.close();
	    	}
    	catch(Exception e){
    			e.printStackTrace();
    	} 
    }
}
