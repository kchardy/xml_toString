import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

//        String imie;
//        String nazwisko;
//
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("Podaj imie: ");
//        imie = in.nextLine();
//
//        System.out.println("Podaj nazwisko: ");
//        nazwisko = in.nextLine();

        //-----------------------------------
try {

    File input = new File("input.txt");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(input);
    doc.getDocumentElement().normalize();

    System.out.print("Root Element: ");
    System.out.println(doc.getDocumentElement().getNodeName());
    NodeList nodeList = doc.getElementsByTagName("supercars");
    System.out.println("------------------------------------------");

    for (int i = 0; i < nodeList.getLength(); i++) {
        Node nNode = nodeList.item(i);
        System.out.println("\nCurent Element :");
        System.out.print(nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) nNode;
            System.out.print("company: ");
            System.out.println(element.getAttribute("company"));
            NodeList carNameList = element.getElementsByTagName("carname");

            for (int j = 0; j < carNameList.getLength(); j++) {
                Node node = carNameList.item(i);

                if (node.getNodeType() == node.ELEMENT_NODE) {
                    Element car = (Element) node;
                    System.out.print("car name: ");
                    System.out.println(car.getTextContent());
                    System.out.print("car type: ");
                    System.out.println(car.getAttribute("type"));
                }
            }
        }
    }
}catch (Exception e) {
    e.printStackTrace();
}

    }
}
