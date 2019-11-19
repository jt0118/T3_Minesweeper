import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class BoardParser {

    private ArrayList<String> parsedData;
    private int difficulty;

    public BoardParser(int difficulty) {
        parsedData = new ArrayList<String>();
        this.difficulty = difficulty;
        Parser("testing.xml");
    }

    public void Parser(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileName);
            ArrayList<String> temp = new ArrayList<String>();

            String selectedDifficutly = " ";
            if (difficulty == 0) {
                selectedDifficutly = "easy";
            }
            else if (difficulty == 1) {
                selectedDifficutly = "medium";
            }
            else{
                selectedDifficutly = "hard";
            }

            NodeList record = doc.getElementsByTagName(selectedDifficutly);
            for (int i = 0; i < record.getLength(); i++) {
                Node row = record.item(i); // every 5 columns = 1 row
                if (row.getNodeType() == Node.ELEMENT_NODE) {
                    Element board = (Element) row; //this locates each column tag
                    // Easy
                    String col1 = board.getAttribute("col1");
                    String col2 = board.getAttribute("col2");
                    String col3 = board.getAttribute("col3");
                    String col4 = board.getAttribute("col4");
                    String col5 = board.getAttribute("col5");
                    // Medium
                    if(difficulty == 1 || difficulty == -1) {
                        String col6 = board.getAttribute("col6");
                        String col7 = board.getAttribute("col7");
                        String col8 = board.getAttribute("col8");
                        String col9 = board.getAttribute("col9");
                    }
                    // Hard
                    if(difficulty == -1) {
                        String col10 = board.getAttribute("col10");
                        String col11 = board.getAttribute("col11");
                        String col12 = board.getAttribute("col12");
                        String col13 = board.getAttribute("col13");
                        String col14 = board.getAttribute("col14");
                        String col15 = board.getAttribute("col15");
                        String col16 = board.getAttribute("col16");
                    }

                    String key = board.getTextContent();
                    temp.add(key);
                }
            }

            String tempString = " ";
            for (int j = 0; j < temp.size(); j++) {
                tempString = temp.get(j);
                for (int k = 0; k < tempString.length(); k++) {
                    char c = tempString.charAt(k);
                    int a = Character.getNumericValue(c);
                    if (c == 'M' || a >= 0) {
                        parsedData.add(String.valueOf(c));
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<String> getParsedData() {
        return parsedData;
    }
}