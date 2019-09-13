
import java.io.*; 
 
import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model; 
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.VCARD;

public class Shilpa {
	static Model mv = null;
	public static void main (String args[]) {
		org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
		
		
		String AuthURI           = "http://utdallas/semclass#personHGWells";
		String Dir1URI				="http://utdallas/semclass#personByronHaskin";
		String Dir2URI				="http://utdallas/semclass#personStevenSpielberg";
		String RadURI				="http://utdallas/semclass#personOrsonWelles";
		String Dir3URI				="http://utdallas/semclass#personGeorgePal";
		String Dir4URI				="http://utdallas/semclass#personSimonWells";
		String Dir5URI				="http://utdallas/semclass#personGoreVervinski";
		 
		String AuthName          = "H.G.Wells";
		String Dir1Name          = "Byron Haskin";
		String Dir2Name          = "Steven Spielberg";
		String Dir3Name          = "George Pal";
		String Dir4Name          = "Simon Wells";
		String Dir5Name          = "Gore Vervinski";
		String RadName          = "Orson Welles";
		
		String movieTM1_URI    	= "http://utdallas/semclass#moviesTimeMachine1";
		String movieTM2_URI    	= "http://utdallas/semclass#moviesTimeMachine2";
		String movieWOW1_URI	= "http://utdallas/semclass#moviesWarOfWorlds1";
		String movieWOW2_URI	= "http://utdallas/semclass#moviesWarOfWorlds2";
		String radioWOW_URI 	= "http://utdallas/semclass#radioWarOfWorlds";
		
		String yrTM           = "1895";
		String yrWOW           = "1897";
		String yrWOW1          ="1953";
		String yrWOW2          ="2005";
		String yrWOWbroad      ="1938";
		
		String yrTM1=             "1960";
		String yrTM2            ="2002";
		
		String bookTM_URI     = "http://utdallas/semclass#booksTimeMachine";
		String bookWOW_URI     = "http://utdallas/semclass#booksWarOfWorlds";
		

		//Default model
		mv = ModelFactory.createDefaultModel();

		Resource movie = mv.createResource("http://utdallas/semclass#Movie");

		Resource person = mv.createResource("http://utdallas/semclass#Person");

		Resource book = mv.createResource("http://utdallas/semclass#Book");

		Property MvYear      = mv.createProperty("http://utdallas/semclass#year");
		Property MvDirector  = mv.createProperty("http://utdallas/semclass#director");
		Property Movie      = mv.createProperty("http://utdallas/semclass#movielink");
		Property Book  = mv.createProperty("http://utdallas/semclass#booklink");
		//Directors
		Resource byron = mv.createResource(Dir1URI)
				.addProperty(RDF.type, person)
				.addProperty(VCARD.FN, Dir1Name)
				.addProperty(VCARD.N, mv.createResource()
				.addProperty(VCARD.Given, "Byron")
				.addProperty(VCARD.Family, "Haskin"))
				.addProperty(VCARD.TITLE, "Mr");
		Resource steven = mv.createResource(Dir2URI)
				.addProperty(RDF.type, person)
				.addProperty(VCARD.FN, Dir2Name)
				.addProperty(VCARD.N, mv.createResource()
				.addProperty(VCARD.Given, "Steven")
				.addProperty(VCARD.Family, "Spielberg"))
				.addProperty(VCARD.TITLE, "Mr");
		Resource george = mv.createResource(Dir3URI)
				.addProperty(RDF.type, person)
				.addProperty(VCARD.FN, Dir3Name)
				.addProperty(VCARD.N, mv.createResource()
				.addProperty(VCARD.Given, "George")
				.addProperty(VCARD.Family, "Pal"))
				.addProperty(VCARD.TITLE, "Mr");
		Resource simon = mv.createResource(Dir4URI)
				.addProperty(RDF.type, person)
				.addProperty(VCARD.FN, Dir4Name)
				.addProperty(VCARD.N, mv.createResource()
						.addProperty(VCARD.Given, "Simon")
						.addProperty(VCARD.Family, "Wells"))
				.addProperty(VCARD.TITLE, "Mr");
		Resource gore = mv.createResource(Dir5URI)
				.addProperty(RDF.type, person)
				.addProperty(VCARD.FN, Dir1Name)
				.addProperty(VCARD.N, mv.createResource()
						.addProperty(VCARD.Given, "Gore")
						.addProperty(VCARD.Family, "Vivinsky"))
				.addProperty(VCARD.TITLE, "Mr");



			// Create the author

			Resource hgwells = mv.createResource(AuthURI)
				.addProperty(RDF.type, person)
				.addProperty(VCARD.FN, AuthName)
				.addProperty(VCARD.N, mv.createResource()
					.addProperty(VCARD.Given, "H.G.")
					.addProperty(VCARD.Family, "Wells"))
				.addProperty(VCARD.TITLE, "Mr");

			// Create the broadcaster

						Resource orson = mv.createResource(RadURI)
							.addProperty(RDF.type, person)
							.addProperty(VCARD.FN, RadName)
							.addProperty(VCARD.N, mv.createResource()
								.addProperty(VCARD.Given, "Orsen")
								.addProperty(VCARD.Family, "Welles"))
							.addProperty(VCARD.TITLE, "Mr");

			// Create book

			 Resource TimeMach = mv.createResource(bookTM_URI)
				.addProperty(RDF.type, book)
				.addProperty(DC.creator, hgwells)
				.addProperty(MvYear, yrTM)
				.addProperty(DC.title, "The Time Machine");

			 Resource WarOWorld = mv.createResource(bookWOW_URI)
					.addProperty(RDF.type, book)
					.addProperty(DC.creator, hgwells)
					.addProperty(MvYear, yrWOW)
					.addProperty(DC.title, "The War Of The Worlds");


			// Create movies

			Resource TimeMachMovie1 = mv.createResource(movieTM1_URI)
				.addProperty(RDF.type, movie)
				.addProperty(DC.title, "Time Machine 1")
				.addProperty(MvYear, yrTM1)
				.addProperty(Book, TimeMach)
				.addProperty(MvDirector, george);
			
			Resource TimeMachMovie2 = mv.createResource(movieTM2_URI)
					.addProperty(RDF.type, movie)
					.addProperty(DC.title, "Time Machine 2")
					.addProperty(MvYear, yrTM2)
					.addProperty(Book, TimeMach)
					.addProperty(MvDirector, simon)
					.addProperty(MvDirector, gore);
			Resource WarOfWorldMovie1 = mv.createResource(movieWOW1_URI)
					.addProperty(RDF.type, movie)
					.addProperty(DC.title, "War Of Worlds 1")
					.addProperty(MvYear, yrWOW1)
					.addProperty(Book, WarOWorld)
					.addProperty(MvDirector, byron);
			final Resource WarOfWorldMovie2 = mv.createResource(movieWOW2_URI)
					.addProperty(RDF.type, movie)
					.addProperty(DC.title, "War Of Worlds 2")
					.addProperty(MvYear, yrWOW2)
					.addProperty(Book, WarOWorld)
					.addProperty(MvDirector, steven);
			final Resource WarOfWorldBroadcast = mv.createResource(movieTM1_URI)
					.addProperty(RDF.type, movie)
					.addProperty(DC.title, "War Of Worlds Broadcast")
					.addProperty(MvYear, yrWOWbroad)
					.addProperty(Book, WarOWorld)
					.addProperty(MvDirector, orson);
				


			
		

		// TDB-backed dataset created
		String directory = "MyDatabases/Dataset1" ;
		Dataset dataset = TDBFactory.createDataset(directory);

		try {
			PrintWriter writeOne = new PrintWriter("Lab2p3_sxc173331.xml", "UTF-8");
			PrintWriter writeTwo = new PrintWriter("Lab2p3_sxc173331.n3", "UTF-8");
			System.out.println("Files opened\nWriting mode");
			dataset.begin(ReadWrite.WRITE) ;
			mv.write(writeOne, "RDF/XML-ABBREV");
			mv.write(writeTwo, "N3");
			dataset.commit();
			dataset.end() ;
			// files closed
			writeOne.close();
			writeTwo.close();
			mv.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}