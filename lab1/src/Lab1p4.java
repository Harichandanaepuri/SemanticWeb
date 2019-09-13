import java.io.FileWriter;
import java.io.IOException;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

public class Lab1p4 {
	
	public static void main(final String[] args) {
		org.apache.log4j.Logger.getRootLogger()
			.setLevel(org.apache.log4j.Level.OFF);

		final String directory = "MyDatabases/";
		final Dataset dataset = TDBFactory.createDataset(directory + "Dataset1");

		final String id = "874659";
		final String personURI = "http://utdallas/semclass/" + id;
		final String givenName = "May";
		final String familyName = "Westford";
		final String prefix = "Dr.";
		final String fullName = prefix + " " + givenName +  " " + familyName;
		final String title = "North America Division Vice President";
		final String email = "May.Westford@consolidatedsem.com";
		final String org = "Consolidated Semantics, U.S";
		final String bdate = "March 28, 1965";
		dataset.begin(ReadWrite.WRITE);
		try {
			final Model model = dataset.getNamedModel("myrdf");

			@SuppressWarnings("unused")
			final Resource kevin = model.createResource(personURI)
				.addProperty(VCARD.FN, fullName)
				.addProperty(VCARD.BDAY, bdate)
				.addProperty(VCARD.EMAIL, email)
				.addProperty(VCARD.TITLE, title)
				.addProperty(VCARD.ORG, org);
			FileManager.get()
				.readModel(model, "HXE170000_FOAFFriends.rdf");

			final FileWriter xmlWriter = new FileWriter("Lab1p4_HXE170000.xml");
			final FileWriter ntpWriter = new FileWriter("Lab1p4_HXE170000.ntp");
			final FileWriter n3Writer = new FileWriter("Lab1p4_HXE170000.n3");

			model.write(xmlWriter, "RDF/XML");
			model.write(ntpWriter, "N-TRIPLE");
			model.write(n3Writer, "N3");
			
			dataset.commit();

		} catch (final IOException e) {
			e.printStackTrace();
			dataset.end();
		}
	}
}