package pei_fp1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GestaoXML {
    
    private final String filename;
    private Document doc;
    
    public GestaoXML(String filename) {
        this.filename = filename;
    }
    
    public void ReadXML() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
            dbf.setIgnoringComments(true);
            dbf.setIgnoringElementContentWhitespace(true);
            doc = db.parse(this.filename);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(GestaoXML.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }

    /**
     * Método responsável por imprimir para a linha de comandos o conteúdo do documento XML lido no método readXML
     */
    public void PrintXML_Note() {
        //Permite devolver o elemento que se encontra no root do documento
        System.out.println("Note :" + doc.getDocumentElement().getNodeName());
        //permite retornar lista de elementos do documento que são filhos do elemento root
        NodeList nList = doc.getChildNodes(); // ou doc.getElementsByTagName("note")
        //No exemplo, apenas existe um item como filho do nodo root
        Element eElement = (Element) nList.item(0);
        //listagem dos elementos
        System.out.println("To: " + eElement.getElementsByTagName("to").item(0).getTextContent());
        System.out.println("From: " + eElement.getElementsByTagName("from").item(0).getTextContent());
        System.out.println("Heading: " + eElement.getElementsByTagName("heading").item(0).getTextContent());
        System.out.println("Body: " + eElement.getElementsByTagName("body").item(0).getTextContent());
    }

    /**
     * Método responsável por imprimir para a linha de comandos o conteúdo do documento XML lido no método readXML
     */
    public void PrintXML_Menu() {
        //Permite devolver o elemento que se encontra no root do documento
        System.out.println("Menu :" + doc.getDocumentElement().getNodeName());
        //permite retornar lista de elementos do documento que são filhos do elemento root
        NodeList pizzas = doc.getChildNodes().item(0).getChildNodes();
        for (int i = 0; i < pizzas.getLength(); i++) {
            //aceder a filhos do tipo nodo
            if (pizzas.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element pizzaElement = (Element) pizzas.item(i);
                //listagem dos elementos
                System.out.println("Pizza cod: " + pizzaElement.getElementsByTagName("codigo").item(0).getTextContent());
                System.out.println("Pizza name: " + pizzaElement.getElementsByTagName("name").item(0).getTextContent());
                NodeList ingredientNodes = pizzaElement.getElementsByTagName("ingredients");
                for (int j = 0; j < ingredientNodes.getLength(); j++) {
                    Element ingredientElement = (Element) ingredientNodes.item(j);
                    System.out.println("Ingredient name: " + ingredientElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Ingredient category: " + ingredientElement.getElementsByTagName("category").item(0).getTextContent());
                    System.out.println("Ingredient unit: " + ingredientElement.getElementsByTagName("unit").item(0).getTextContent());
                    System.out.println("Ingredient calories: " + ingredientElement.getElementsByTagName("calories").item(0).getTextContent());

                }
                System.out.println("preco: " + pizzaElement.getElementsByTagName("price").item(0).getTextContent());

            }
        }
    }

    public void printMenuXMLv2() {
        //Permite devolver o elemento que se encontra no root do documento
        System.out.println("Menu: " + doc.getDocumentElement().getNodeName());
        
        //permite retornar lista de elementos do documento que são filhos do elemento root
        NodeList pizzas = doc.getChildNodes().item(0).getChildNodes();
        for (int i = 0; i < pizzas.getLength(); i++) {
        
            //aceder a filhos do tipo nodo
            if (pizzas.item(i).getNodeType() == Node.ELEMENT_NODE) {

                //listagem dos elementos
                NodeList pizzaChilds = pizzas.item(i).getChildNodes();

                for (int j = 0; j < pizzaChilds.getLength(); j++) {
                    
                    // não considerar #text nodes vazios
                    if (pizzaChilds.item(j).getNodeType() == Node.TEXT_NODE && pizzaChilds.item(j).getNodeValue().trim().length() == 0) {
                        continue;
                    }
                        
                    System.out.println("Elemento: " + pizzaChilds.item(j).getNodeName() + " Conteudo: " + pizzaChilds.item(j).getTextContent());
                    
                }
            }
        }
    }
    
    /**
     * Print All 
    */    
    public void PrintXML() {
        Node root = doc.getDocumentElement();        
        ListNode(root, "");
    }
    
    private void ListNode(Node node, String ident) {
        
        if (node.getNodeType() == Node.TEXT_NODE) {
            String text = node.getNodeValue().trim();
            if (text.length() > 0) { 
                System.out.println(ident + "valor: " + text); 
            }
        } else {
            
            System.out.println(ident + node.getNodeName());
            
            NamedNodeMap attributes = node.getAttributes();
            for (int i = 0; i < attributes.getLength(); ++i) {
                Node att = attributes.item(i);
                System.out.println(ident + "  " + att.getNodeName() + ": " + att.getNodeValue());
            }
        }
        
        NodeList childNodeList = node.getChildNodes(); 
        for(int i = 0 ; i < childNodeList.getLength() ; i++) {
            short type = childNodeList.item(i).getNodeType();
            if (type == Node.ELEMENT_NODE || type == Node.TEXT_NODE) { 
                ListNode(childNodeList.item(i), ident + "  ");     
            } 
        }
    
    }
    
}
