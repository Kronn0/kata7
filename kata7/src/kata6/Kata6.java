
package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import static java.util.stream.Collectors.joining;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import kata6.Comments;


public class Kata6 {

    
    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException  {
        
        URL url = new URL("https://jsonplaceholder.typicode.com/comments");
        Gson gson = new Gson();
        String json = read(url);
        ArrayList<Comments> comments = new ArrayList<>();
        JsonArray array = gson.fromJson(json, JsonArray.class);
        for (int i = 0; i < array.size(); i++) {
        JsonObject jsonObject = gson.fromJson(json, JsonArray.class).get(i).getAsJsonObject();
        Comments comment = gson.fromJson(jsonObject, Comments.class);
        comments.add(comment);  
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(comments.get(i));
        }
        
        for (Comments comment : comments) {
           System.out.print(toXml(comment));
        }

    }

    private static String read(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }           
    }
    
     public static String toXml(Comments comment) {
        try {
            JAXBContext context = JAXBContext.newInstance(Comments.class);
            
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            
            StringWriter writer = new StringWriter();
            marshaller.marshal(comment, writer);
            return writer.toString();
            
        } catch(Exception e) {
            throw new IllegalStateException("Error while serializing an Object to XML", e);
        }
    }    
}
        
    
    