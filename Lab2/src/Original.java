import java.io.FileWriter;
import java.io.IOException;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.VCARD;

public class Original {
	
	@SuppressWarnings("unused")
	public static void main(final String[] args) {
		org.apache.log4j.Logger.getRootLogger()
			.setLevel(org.apache.log4j.Level.OFF);

		// Some definitions
		final String URI = "http://utdallas/semclass#";
		final String movieURI = URI + "Movie-";
		final String directorURI = URI + "director-";
		final String authorURI = URI + "author-";
		final String bookURI = URI + "Book-";
		final String directorTitle = "director";
		final String authorTitle = "author";

		// Define Directors
		
		final String m1URI = directorURI + "ByronHaskin";
 		final String m1Given = "Byron";
 		final String m1Family = "Haskin";
 		final String m1FullName = m1Given + " " + m1Family;
 		
 		final String m2URI = directorURI + "StevenSpielberg";
 		final String m2Given = "Steven";
 		final String m2Family = "Spielberg";
 		final String m2FullName = m2Given + " " + m2Family;
 		
 		final String m3URI = directorURI + "OrsanWelles";
 		final String m3Given = "Orsan";
 		final String m3Family = "Welles";
 		final String m3FullName = m3Given + " " + m3Family;
 		
 		final String m4URI = directorURI + "GeorgePal";
 		final String m4Given = "George";
 		final String m4Family = "Pal";
 		final String m4FullName = m4Given + " " + m4Family;
 		
 		final String m5URI = directorURI + "SimonWells";
 		final String m5Given = "Simon";
 		final String m5Family = "Wells";
 		final String m5FullName = m5Given + " " + m5Family;
 
 		final String m6URI = directorURI + "GoreVerbinski";
 		final String m6Given = "Gore";
 		final String m6Family = "Verbinski";
 		final String m6FullName = m6Given + " " + m6Family;
 
		// Define Author
 		final String wellsURI = directorURI + "HGWells";
 		final String wellsGiven = "Wells";
 		final String wellsFamily = "HG";
 		final String wellsFullName = wellsGiven + " " + wellsFamily;
 		
 		

		 // Define books
		final String b1URI = bookURI + "TheWarOfTheWorlds";
		final String b1Title = "The War Of The Worlds";
		final String b1Year = "1897";

		final String b2URI = bookURI + "TheTimeMachine";
 		final String b2Title = "The Time Machine";
 		final String b2Year = "1895";
 		
 		
		// Define movies
		final String movie1URI = movieURI + "TheWarOfTheWorlds1";
 		final String movie1Title = "The War Of The Worlds";
 		final String movie1Year = "1953";

 		final String movie2URI = movieURI + "TheWarOfTheWorlds2";
 		final String movie2Title = "The War Of The Worlds";
 		final String movie2Year = "2005";
 		
 		final String movie3URI = movieURI + "TheWarOfTheWorlds3";
 		final String movie3Title = "The War Of The Worlds";
 		final String movie3Year = "1938";
 		
 		final String movie4URI = movieURI + "TheTimeMachine1";
 		final String movie4Title = "The Time Machine";
 		final String movie4Year = "1960";
 		
 		final String movie5URI = movieURI + "TheTimeMachine2";
 		final String movie5Title = "The Time Machine";
 		final String movie5Year = "2002";
 		
 		

		// Make a TDB-backed dataset
		final String directory = "MyDatabases/";
		final Dataset dataset = TDBFactory.createDataset(directory + "Dataset1");

		// create an empty Model
		final Model model = dataset.getNamedModel("myrdf");

		// Create classes
		final Resource movie = model.createResource(movieURI);
		final Resource director = model.createResource(directorURI);
		final Resource book = model.createResource(bookURI);

		// Create custom properties
		final Property directorProperty = model.createProperty(movieURI, directorTitle);
		//final Property adaptationOfProperty = model.createProperty(movieURI, "AdaptationOf");

		// Create the director
		// and add the properties cascading style
		final Resource director1 = model.createResource(m1URI)
			.addProperty(RDF.type, director)
			.addProperty(VCARD.FN, m1FullName)
			.addProperty(VCARD.N, model.createResource()
				.addProperty(VCARD.Given, m1Given)
				.addProperty(VCARD.Family, m1Family))
			.addProperty(VCARD.TITLE, directorTitle);
		
		final Resource director2 = model.createResource(m2URI)
 				.addProperty(RDF.type, director)
 				.addProperty(VCARD.FN, m2FullName)
 				.addProperty(VCARD.N, model.createResource()
 					.addProperty(VCARD.Given, m2Given)
 					.addProperty(VCARD.Family, m2Family))
 				.addProperty(VCARD.TITLE, directorTitle);
 			
 		 //broadcast director of WOW
 		final Resource director3 = model.createResource(m3URI)
 				.addProperty(RDF.type, director)
 				.addProperty(VCARD.FN, m3FullName)
 				.addProperty(VCARD.N, model.createResource()
 					.addProperty(VCARD.Given, m3Given)
 					.addProperty(VCARD.Family, m3Family))
 				.addProperty(VCARD.TITLE, directorTitle);
 		
 		 //director of movie4
 		final Resource director4 = model.createResource(m4URI)
 				.addProperty(RDF.type, director)
 				.addProperty(VCARD.FN, m4FullName)
 				.addProperty(VCARD.N, model.createResource()
 					.addProperty(VCARD.Given, m4Given)
 					.addProperty(VCARD.Family, m4Family))
 				.addProperty(VCARD.TITLE, directorTitle);
 		
 		 //director of movie 5
 		final Resource director5 = model.createResource(m5URI)
 				.addProperty(RDF.type, director)
 				.addProperty(VCARD.FN, m5FullName)
 				.addProperty(VCARD.N, model.createResource()
 					.addProperty(VCARD.Given, m5Given)
 					.addProperty(VCARD.Family, m5Family))
 				.addProperty(VCARD.TITLE, directorTitle);
 		
 		final Resource director6 = model.createResource(m6URI)
 				.addProperty(RDF.type, director)
 				.addProperty(VCARD.FN, m6FullName)
 				.addProperty(VCARD.N, model.createResource()
 					.addProperty(VCARD.Given, m6Given)
 					.addProperty(VCARD.Family, m6Family))
 				.addProperty(VCARD.TITLE, directorTitle);
 		

		// Create the author
		final Resource wells = model.createResource(wellsURI)
			.addProperty(RDF.type, director)
			.addProperty(VCARD.FN, wellsFullName)
			.addProperty(VCARD.N, model.createResource()
				.addProperty(VCARD.Given, wellsGiven)
				.addProperty(VCARD.Family, wellsFamily))
			.addProperty(VCARD.TITLE, authorTitle);

		// Create book
		final Resource redAlert = model.createResource(b1URI)
			.addProperty(RDF.type, book)
			.addProperty(DC.creator, wells)
			.addProperty(DC.title, b1Title)
			.addProperty(DC.date, b1Year );
		
		final Resource book2 = model.createResource(b2URI)
 				.addProperty(RDF.type, book)
 				.addProperty(DC.creator, wells)
 				.addProperty(DC.title, b2Title)
 				.addProperty(DC.date, b2Year);
		

		// Create movies
		final Resource movie1 = model.createResource(movie1URI)
			.addProperty(RDF.type, movie)
			.addProperty(DC.title, movie1Title)
			.addProperty(DC.date, movie1Year)
			.addProperty(directorProperty, director1);

 		final Resource movie2 = model.createResource(movie2URI)
 				.addProperty(RDF.type, movie)
 				.addProperty(DC.title, movie2Title)
 				.addProperty(DC.date, movie2Year)
 				.addProperty(directorProperty, director2);
 			
 		
 		final Resource movie3 = model.createResource(movie3URI)
 				.addProperty(RDF.type, movie)
 				.addProperty(DC.title, movie3Title)
 				.addProperty(DC.date, movie3Year)
 				.addProperty(directorProperty, director3);
 			
 		final Resource movie4 = model.createResource(movie4URI)
 				.addProperty(RDF.type, movie)
 				.addProperty(DC.title, movie4Title)
 				.addProperty(DC.date, movie4Year)
 				.addProperty(directorProperty, director4);
 			
 		final Resource movie5 = model.createResource(movie5URI)
 				.addProperty(RDF.type, movie)
 				.addProperty(DC.title, movie5Title)
 				.addProperty(DC.date, movie5Year)
 				.addProperty(directorProperty, director5)
 				.addProperty(directorProperty, director6);
 			


		dataset.begin(ReadWrite.WRITE);
		try {

			final FileWriter xmlWriter = new FileWriter("Lab2p3_HXE170000.xml");
			final FileWriter n3Writer = new FileWriter("Lab2p3_HXE170000.n3");

			model.write(xmlWriter, "RDF/XML");
			model.write(n3Writer, "N3");

			xmlWriter.close();
			n3Writer.close();
			dataset.commit();

		} catch (final IOException e) {
			e.printStackTrace();
			dataset.end();
			model.close();
		}
	}
}