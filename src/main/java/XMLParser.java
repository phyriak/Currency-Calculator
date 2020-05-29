import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class XMLParser {

    public  Map<String,Double> read(String fileName)  {
        Map<String,Double>resultMap=new HashMap<>();
        URL resource = getClass().getResource("/"+fileName);
        try {
            File file = new File(resource.getPath());
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            NodeList nodeList = doc.getElementsByTagName("Cube");
            for (int i = 2; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    resultMap.put(element.getAttribute("currency"),Double.parseDouble(element.getAttribute("rate")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
