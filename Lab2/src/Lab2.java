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

public class Lab2 {
	
	@SuppressWarnings("unused")
	public static void main(final String[] args) {
		org.apache.log4j.Logger.getRootLogger()
			.setLevel(org.apache.log4j.Level.OFF);
		
		// Some definitions
		final String URI = "http://utdallas/semclass#";
		final String movieURI = URI + "Movie-";
		final String bookURI = URI + "Book-";
		final String broadcastURI = URI + "broadcast-";
		final String directorTitle = "director";
		final String authorTitle = "author";
		final String writerTitle = "writer";
		final String personURI = URI+"person-";

		// Define Directors
		
		final String m1URI = personURI + "ByronHaskin";
 		final String m1Given = "Byron";
 		final String m1Family = "Haskin";
 		final String m1FullName = m1Given + " " + m1Family;
 		
 		final String m2URI = personURI + "StevenSpielberg";
 		final String m2Given = "Steven";
 		final String m2Family = "Spielberg";
 		final String m2FullName = m2Given + " " + m2Family;
 		
 		//broadcast writer
 		final String m3URI = personURI + "HowardKoch";
 		final String m3Given = "Howard";
 		final String m3Family = "Koch";
 		final String m3FullName = m3Given + " " + m3Family;
 		
 		final String m4URI = personURI + "GeorgePal";
 		final String m4Given = "George";
 		final String m4Family = "Pal";
 		final String m4FullName = m4Given + " " + m4Family;
 		
 		final String m5URI = personURI + "SimonWells";
 		final String m5Given = "Simon";
 		final String m5Family = "Wells";
 		final String m5FullName = m5Given + " " + m5Family;
 
 		final String m6URI = personURI + "GoreVerbinski";
 		final String m6Given = "Gore";
 		final String m6Family = "Verbinski";
 		final String m6FullName = m6Given + " " + m6Family;
 
		// Define Author
 		final String wellsURI = personURI + "HGWells";
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
 		
 		//Broadcast movie
 		
 		final String broadCastURI = movieURI + "TheWarOfTheWorldsBroadCast";
 		final String broadCastTitle = "The War Of The Worlds";
 		final String broadCastYear = "1938";
 		
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
		final Resource book = model.createResource(bookURI);
		final Resource broadcast = model.createResource(broadCastURI);
		final Resource person = model.createResource(personURI);

		// Create custom properties
		final Property directorProperty = model.createProperty("http://utdallas/semclass#directorlink");
		final Property broadCastWriterProperty = model.createProperty("http://utdallas/semclass#broadCastWriter");
		final Property bookProperty = model.createProperty("http://utdallas/semclass#booklink");
		final Property yearProperty = model.createProperty("http://utdallas/semclass#yearlink");

		
		// Create the director
		// and add the properties cascading style
		final Resource director1 = model.createResource(m1URI)
			.addProperty(RDF.type, person)
			.addProperty(VCARD.FN, m1FullName)
			.addProperty(VCARD.N, model.createResource()
				.addProperty(VCARD.Given, m1Given)
				.addProperty(VCARD.Family, m1Family))
			.addProperty(VCARD.TITLE, directorTitle);
		
		final Resource director2 = model.createResource(m2URI)
 				.addProperty(RDF.type, person)
 				.addProperty(VCARD.FN, m2FullName)
 				.addProperty(VCARD.N, model.createResource()
 					.addProperty(VCARD.Given, m2Given)
 					.addProperty(VCARD.Family, m2Family))
 				.addProperty(VCARD.TITLE, directorTitle);
 			
 		 //broadcast director of WOW
 		final Resource director3 = model.createResource(m3URI)
 				.addProperty(RDF.type, person)
 				.addProperty(VCARD.FN, m3FullName)
 				.addProperty(VCARD.N, model.createResource()
 					.addProperty(VCARD.Given, m3Given)
 					.addProperty(VCARD.Family, m3Family))
 				.addProperty(VCARD.TITLE, writerTitle);
 		
 		 //director of movie4
 		final Resource director4 = model.createResource(m4URI)
 				.addProperty(RDF.type, person)
 				.addProperty(VCARD.FN, m4FullName)
 				.addProperty(VCARD.N, model.createResource()
 					.addProperty(VCARD.Given, m4Given)
 					.addProperty(VCARD.Family, m4Family))
 				.addProperty(VCARD.TITLE, directorTitle);
 		
 		 //director of movie 5
 		final Resource director5 = model.createResource(m5URI)
 				.addProperty(RDF.type, person)
 				.addProperty(VCARD.FN, m5FullName)
 				.addProperty(VCARD.N, model.createResource()
 					.addProperty(VCARD.Given, m5Given)
 					.addProperty(VCARD.Family, m5Family))
 				.addProperty(VCARD.TITLE, directorTitle);
 		
 		final Resource director6 = model.createResource(m6URI)
 				.addProperty(RDF.type, person)
 				.addProperty(VCARD.FN, m6FullName)
 				.addProperty(VCARD.N, model.createResource()
 					.addProperty(VCARD.Given, m6Given)
 					.addProperty(VCARD.Family, m6Family))
 				.addProperty(VCARD.TITLE, directorTitle);
 		

		// Create the author
		final Resource wells = model.createResource(wellsURI)
			.addProperty(RDF.type, person )
			.addProperty(VCARD.FN, wellsFullName)
			.addProperty(VCARD.N, model.createResource()
				.addProperty(VCARD.Given, wellsGiven)
				.addProperty(VCARD.Family, wellsFamily))
			.addProperty(VCARD.TITLE, authorTitle);

		// Create book
		final Resource book1 = model.createResource(b1URI)
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
			.addProperty(yearProperty, movie1Year)
			.addProperty(directorProperty, director1)
			.addProperty(bookProperty, book1);

 		final Resource movie2 = model.createResource(movie2URI)
 				.addProperty(RDF.type, movie)
 				.addProperty(DC.title, movie2Title)
 				.addProperty(yearProperty, movie2Year)
 				.addProperty(directorProperty, director2)
 				.addProperty(bookProperty, book1);
 			
 		
 		final Resource broadcast3 = model.createResource(broadCastURI)
 				.addProperty(RDF.type, broadcast)
 				.addProperty(DC.title, broadCastTitle)
 				.addProperty(yearProperty, broadCastYear)
 				.addProperty(broadCastWriterProperty, director3)
 				.addProperty(bookProperty, book1);
 			
 		final Resource movie4 = model.createResource(movie4URI)
 				.addProperty(RDF.type, movie)
 				.addProperty(DC.title, movie4Title)
 				.addProperty(yearProperty, movie4Year)
 				.addProperty(directorProperty, director4)
 				.addProperty(bookProperty, book2);
 			
 		final Resource movie5 = model.createResource(movie5URI)
 				.addProperty(RDF.type, movie)
 				.addProperty(DC.title, movie5Title)
 				.addProperty(yearProperty, movie5Year)
 				.addProperty(directorProperty, director5)
 				.addProperty(directorProperty, director6)
 				.addProperty(bookProperty, book2);
 			

		dataset.begin(ReadWrite.WRITE);
		try {

			final FileWriter xmlWriter = new FileWriter("Lab2p3_HXE170000.xml");
			final FileWriter n3Writer = new FileWriter("Lab2p3_HXE170000.n3");
			final FileWriter rdfWriter = new FileWriter("Lab2P3_HXE170000.rdf");
			model.write(xmlWriter, "RDF/XML");
			model.write(rdfWriter,"RDF/XML");
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