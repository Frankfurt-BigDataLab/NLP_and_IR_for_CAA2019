import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SPARQLConnector {

	
	/**
	 * Wandelt den Input durch den JSON-Endpoint in einen String um
	 * @param rd InputStreamReader bzw. BufferedStreamReader
	 * @return
	 * @throws IOException
	 * 
	 * Quelle: http://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
	 */
  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }
  	
  /**
   * Bekommt eine URL und gibt mir einen JSON zurück
   * @param url JSONObject
   * @return
   * @throws IOException
   * @throws JSONException
   * 
   * Quelle: http://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
   */
  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  /**
   * Programmeintrittspunkt
   * 
   * Bezieht URI (enthaelt die Query) vom SPARQL-ENDPOINT einen JSON
   * Verarbeitet diesen.
   * Extrahiert die URL der Muenzen,
   * speichert diese
   * 
   * 
   * @author Matthias Jostock
   * @param args
   * @throws IOException
   * @throws JSONException
   */
  public static void main(String[] args) throws IOException, JSONException {
    
	  System.out.println("start");
	  JSONObject json = readJsonFromUrl("http://nomisma.org/query?query=PREFIX+rdf%3A%09%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0D%0APREFIX+bio%3A%09%3Chttp%3A%2F%2Fpurl.org%2Fvocab%2Fbio%2F0.1%2F%3E%0D%0APREFIX+crm%3A%09%3Chttp%3A%2F%2Fwww.cidoc-crm.org%2Fcidoc-crm%2F%3E%0D%0APREFIX+dcmitype%3A%09%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fdcmitype%2F%3E%0D%0APREFIX+dcterms%3A%09%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3E%0D%0APREFIX+foaf%3A%09%3Chttp%3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E%0D%0APREFIX+geo%3A%09%3Chttp%3A%2F%2Fwww.w3.org%2F2003%2F01%2Fgeo%2Fwgs84_pos%23%3E%0D%0APREFIX+nm%3A%09%3Chttp%3A%2F%2Fnomisma.org%2Fid%2F%3E%0D%0APREFIX+nmo%3A%09%3Chttp%3A%2F%2Fnomisma.org%2Fontology%23%3E%0D%0APREFIX+org%3A%09%3Chttp%3A%2F%2Fwww.w3.org%2Fns%2Forg%23%3E%0D%0APREFIX+osgeo%3A%09%3Chttp%3A%2F%2Fdata.ordnancesurvey.co.uk%2Fontology%2Fgeometry%2F%3E%0D%0APREFIX+rdac%3A%09%3Chttp%3A%2F%2Fwww.rdaregistry.info%2FElements%2Fc%2F%3E%0D%0APREFIX+skos%3A%09%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E%0D%0APREFIX+spatial%3A+%3Chttp%3A%2F%2Fjena.apache.org%2Fspatial%23%3E%0D%0APREFIX+un%3A%09%3Chttp%3A%2F%2Fwww.owl-ontologies.com%2FOntology1181490123.owl%23%3E%0D%0APREFIX+xsd%3A%09%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%0D%0A%0D%0ASELECT+%3Ftype+%3Fauth+%3Fcoin+%3FobvRef+%3FrevRef+WHERE+%7B%0D%0A%0D%0A%3Ftype+dcterms%3Asource+nm%3Aric.%0D%0A%3Fcoin+nmo%3AhasTypeSeriesItem+%3Ftype+.%0D%0A%7B+%3Fcoin+nmo%3AhasObverse+%3Fobverse+.%0D%0A%3Fobverse+foaf%3Adepiction++%3FobvRef+%7D%0D%0A%3Fcoin+nmo%3AhasTypeSeriesItem+%3Ftype+.%0D%0A%7B+%3Fcoin+nmo%3AhasReverse+%3Freverse+.%0D%0A%3Freverse+foaf%3Adepiction++%3FrevRef+%7D%0D%0A%3Ftype+nmo%3AhasAuthority+%3Fauth%0D%0A%0D%0A%7D%0D%0A&output=json");
	  System.out.println("running");

//    System.out.println(json.get("head"));

	  JSONObject results = (JSONObject) json.get("results");
	  JSONArray bindings = results.getJSONArray("bindings");
    
	  for (int i = 0; i < bindings.length(); ++i) {
	    //System.out.println(i+1+"/"+bindings.length());
        JSONObject bin = bindings.getJSONObject(i);
        System.out.print(((JSONObject) bin.get("auth")).get("value")+"\t\t");
        System.out.print(((JSONObject) bin.get("type")).get("value")+"\t\t");
        System.out.print(((JSONObject) bin.get("coin")).get("value")+"\t\t\t");
        System.out.print(((JSONObject) bin.get("obvRef")).get("value")+"\t\t\t");
        System.out.println(((JSONObject) bin.get("revRef")).get("value"));
        
        String authString = ((JSONObject) bin.get("auth")).get("value").toString();
        String[] authPath = authString.split("/");
        String coinString = ((JSONObject) bin.get("coin")).get("value").toString();
        String[] coinPath = coinString.split("/");
        String typeString = ((JSONObject) bin.get("type")).get("value").toString();
        String[] typePath = typeString.split("/");
        String oTString = ((JSONObject) bin.get("obvRef")).get("value").toString();
        String[] oTPath = oTString.split("/");
        String rTString = ((JSONObject) bin.get("revRef")).get("value").toString();
        String[] rTPath = rTString.split("/");
        //System.out.println(coinPath[2]);
        
         if(coinPath[2].equals("numismatics.org"))	{
        
	        URL urlObv = new URL(((JSONObject) bin.get("obvRef")).get("value").toString());
	        try {
		        InputStream inObv = new BufferedInputStream(urlObv.openStream());
		        ByteArrayOutputStream outObv = new ByteArrayOutputStream();
		        byte[] bufObv = new byte[1024];
		        int n = 0;
		        while (-1!=(n=inObv.read(bufObv)))
		        {
		           outObv.write(bufObv, 0, n);
		        }
		        outObv.close();
		        inObv.close();
		        byte[] responseObv = outObv.toByteArray();
	        
	        
	        
	        
	        
		        System.out.println("pic1"+File.separator+authPath[authPath.length-1]+File.separator+typePath[typePath.length-1]+File.separator+coinPath[2]+File.separator+coinPath[coinPath.length-1]+File.separator+oTPath[oTPath.length-1]);
		        coinPath[coinPath.length-1] = coinPath[coinPath.length-1].replace("?", "");
		        new File("pic1"+File.separator+authPath[authPath.length-1]+File.separator+typePath[typePath.length-1]+File.separator+coinPath[2]+File.separator+coinPath[coinPath.length-1]).mkdirs();
		        
		        FileOutputStream fosObv = new FileOutputStream("pic1"+File.separator+authPath[authPath.length-1]+File.separator+typePath[typePath.length-1]+File.separator+coinPath[2]+File.separator+coinPath[coinPath.length-1]+File.separator+oTPath[oTPath.length-1]);
		        fosObv.write(responseObv);
		        fosObv.close();
        	}catch (Exception ex) {
        		continue;
        	} /* 
	        
	        URL url = new URL(((JSONObject) bin.get("revRef")).get("value").toString());
	        try {
	        	InputStream in = new BufferedInputStream(url.openStream());
	        
		        ByteArrayOutputStream out = new ByteArrayOutputStream();
		        byte[] buf = new byte[1024];
		        int n1 = 0;
		        while (-1!=(n1=in.read(buf)))
		        {
		           out.write(buf, 0, n1);
		        }
		        out.close();
		        in.close();
		        byte[] response = out.toByteArray();
		        
		        
		        
		        System.out.println("pic1"+File.separator+authPath[authPath.length-1]+File.separator+typePath[typePath.length-1]+File.separator+coinPath[coinPath.length-1]+File.separator+rTPath[rTPath.length-1]);
		        new File("pic1"+File.separator+authPath[authPath.length-1]+File.separator+typePath[typePath.length-1]+File.separator+coinPath[coinPath.length-1]).mkdirs();
		        
		        FileOutputStream fos = new FileOutputStream("pic1"+File.separator+authPath[authPath.length-1]+File.separator+typePath[typePath.length-1]+File.separator+coinPath[coinPath.length-1]+File.separator+rTPath[rTPath.length-1]);
		        fos.write(response);
		        fos.close();
	        }catch (Exception ex) {
	        	continue;
	        } */
    	
    	// }
        
	  System.out.println("finished");
        
    }

	  
  }  
  
}