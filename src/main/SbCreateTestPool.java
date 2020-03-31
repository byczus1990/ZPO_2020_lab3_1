package main;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;

public class SbCreateTestPool {

	public static void createPool() throws IOException
	{
		Map<String, String[]> map = new HashMap<>();
		
		map.put("kot", new String[] {"cat","puss","feline"});
		map.put("pies", new String[] {"dog","pooch","cur"});
		map.put("lubic", new String[] {"like","love","enjoy"});
		map.put("samolot", new String[] {"plane","kite","aircraft"});
		map.put("samochod", new String[] {"car","automobile","auto"});
		map.put("kula", new String[] {"ball","sphere","bullet"});
		map.put("piorun", new String[] {"thunderbolt","lightning"});
		map.put("zwierze", new String[] {"animal","beast"});
		map.put("mapa", new String[] {"map","chart"});
		map.put("spacer", new String[] {"walk","stroll","wander"});

		// create a writer
		Writer writer = Files.newBufferedWriter(Paths.get("PolEngTest.json"));

	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    
	    gson.toJson(map, writer);

	    writer.close();
	}
	public static Map<String,String[]> getWordsFromJson()
	{
		try {
		    Gson gson = new Gson();

		    Reader reader = Files.newBufferedReader(Paths.get("PolEngTest.json"));

		    Map<String, String[]> map = gson.fromJson(reader, Map.class);

//		    // print map entries
//		    for (Map.Entry<?, ?> entry : map.entrySet()) {
//		        System.out.println(entry.getKey() + "=" + entry.getValue());
//		    }

		    reader.close();
		    
		    return map;

		} catch (Exception ex) {
		    ex.printStackTrace();
		    return null;
		}

	}
}
