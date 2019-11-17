import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;

// this class is used to parse through "EasyMine Data.xml"
// due to the nature of the code it will likely need to be restructured
// to include multiple nested xml tags/elements when we parse the final xml file
// since the EasyMine Data.xml file only nests rows 

//add "EasyMine Data.xml" to the project
public class BoardParser {

    public static void main(String[] args) {

        Parser("EasyMine Data.xml");

    }

    public static void Parser(String fileName)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(fileName); // File/document to parse

            NodeList record = doc.getElementsByTagName("record"); //record = each board.

            for(int i=0; i<record.getLength();i++)
            {
                Node row = record.item(i); // every 5 columns = 1 row
                if(row.getNodeType()==Node.ELEMENT_NODE) {
                    Element board = (Element) row; //this locates each column tag
                    String col1 = board.getAttribute("col1");
                    String col2 = board.getAttribute("col2");
                    String col3 = board.getAttribute("col3");
                    String col4 = board.getAttribute("col4");
                    String col5 = board.getAttribute("col5");
                    System.out.println(board.getTextContent()); //this prints out the data in each column tag for every row
                }
            }
        } catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
