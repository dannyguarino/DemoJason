/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojason;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.TreeMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *
 * @author danieleguarino
 */
public class DemoJason {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        for (String s : getTitles()) {
            System.out.println(s);
        }
        
        JSONArray tempTableau = getClaim("inputfile.json");
        
        System.out.println(tempTableau.toString());
        
        //System.out.println("Titre: " + getTitles().toString() );
    }
    
    public static List<String> getTitles() throws IOException {
        List<String> titres = new ArrayList<String>();
        
        String textJson = FileReader.loadFileIntoString("catalog.json", "UTF-8");
        
        JSONArray tableauJSON = (JSONArray) JSONSerializer.toJSON(textJson);
        
        //System.out.println(tableauJSON.toString());
        
        long nombreElements = tableauJSON.size();
        
        for (int i = 0; i < nombreElements; i++) {
            JSONObject objActuel = tableauJSON.getJSONObject(i);
            titres.add(objActuel.getString("title"));
        }
        return titres;
    }
    
    public static ArrayList<String> getCDs() throws IOException {
        String textJson = FileReader.loadFileIntoString("catalog.json", "UTF-8");
        
        
        return null;
    }
    
    public static String faireJSON() {
        
        JSONObject nouveauCd = new JSONObject();
        
        nouveauCd.accumulate("id", "1321033823");
        nouveauCd.accumulate("total", 9.9);
        nouveauCd.accumulate("date", "11/11/2011");
        nouveauCd.accumulate("validated", true);
        
        TreeMap albums = new TreeMap();
        albums.put("id", "1");
        albums.put("title", "Hide your heart");
        
        return nouveauCd.toString();
        
    }
    
    public static JSONArray getClaim(String fileName) throws IOException {
        
        //String textJson = FileReader.loadFileIntoString(fileName, "UTF-8");
        Object textJson = (Object)FileReader.loadFileIntoString(fileName, "UTF-8");
        
        System.out.println(textJson.toString());
        System.out.println("-------------");
        
        
        //JSONObject jsonobj = new JSONObject();
        JSONObject jsonobj = (JSONObject) textJson;
        System.out.println(jsonobj.toString());
        
        
        JSONArray tableau = (JSONArray) JSONSerializer.toJSON(textJson);
        
        return tableau;
    }
    
    public static void loadArray(String fileName) {
        
    }
    
}
/*
import java.io.FileNotFoundException;
04
import java.io.FileReader;
05
import java.io.IOException;
06
import java.util.Iterator;
07
 
08
import org.json.simple.JSONArray;
09
import org.json.simple.JSONObject;
10
import org.json.simple.parser.JSONParser;
11
import org.json.simple.parser.ParseException;
12
 
13
public class JsonParseTest {
14
 
15
    private static final String filePath = "C:\\Users\\katerina\\Desktop\\jsonTestFile.json";
16
     
17
    public static void main(String[] args) {
18
 
19
        try {
20
            // read the json file
21
            FileReader reader = new FileReader(filePath);
22
 
23
            JSONParser jsonParser = new JSONParser();
24
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
25
 
26
            // get a String from the JSON object
27
            String firstName = (String) jsonObject.get("firstname");
28
            System.out.println("The first name is: " + firstName);
29
 
30
            // get a number from the JSON object
31
            long id =  (long) jsonObject.get("id");
32
            System.out.println("The id is: " + id);
33
 
34
            // get an array from the JSON object
35
            JSONArray lang= (JSONArray) jsonObject.get("languages");
36
             
37
            // take the elements of the json array
38
            for(int i=0; i<lang.size(); i++){
39
                System.out.println("The " + i + " element of the array: "+lang.get(i));
40
            }
41
            Iterator i = lang.iterator();
42
 
43
            // take each value from the json array separately
44
            while (i.hasNext()) {
45
                JSONObject innerObj = (JSONObject) i.next();
46
                System.out.println("language "+ innerObj.get("lang") +
47
                        " with level " + innerObj.get("knowledge"));
48
            }
49
            // handle a structure into the json object
50
            JSONObject structure = (JSONObject) jsonObject.get("job");
51
            System.out.println("Into job structure, name: " + structure.get("name"));
52
 
53
        } catch (FileNotFoundException ex) {
54
            ex.printStackTrace();
55
        } catch (IOException ex) {
56
            ex.printStackTrace();
57
        } catch (ParseException ex) {
58
            ex.printStackTrace();
59
        } catch (NullPointerException ex) {
60
            ex.printStackTrace();
61
        }
62
 
63
    }
64
 
65
}



*/
