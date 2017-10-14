package pei_fp1;

public class PEI_FP1 {

    public static void example1() {
        GestaoXML gestor = new GestaoXML("../xml/note.xml");
        gestor.ReadXML();
        gestor.PrintXML_Note();
    }
    
    public static void example2() {
        GestaoXML gestor = new GestaoXML("../xml/menu_v1.xml");
        gestor.ReadXML();
        gestor.PrintXML_Menu();
    }
     
    public static void example3() {
        GestaoXML gestor = new GestaoXML("../xml/menu_v1.xml");
        gestor.ReadXML();
        gestor.printMenuXMLv2();
    }
    
    public static void example4(String filename) {
        GestaoXML gestor = new GestaoXML(filename);
        gestor.ReadXML();
        gestor.PrintXML();
    }
    
    public static void main(String[] args) {
        
        //example1();
        //example2();
        //example3();        
        example4("../xml/menu_v2.xml");
        
    }
    
}
