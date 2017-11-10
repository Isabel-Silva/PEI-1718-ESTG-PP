package demos;

import core.GestorXML;
import java.io.File;

public class Demo {
    
    public static void main(String[] args) throws Exception {
        String xml = "../1_1/menu.xml", xsd = "../1_1/menu.xsd";
        if(new File(xml).exists() && new File(xsd).exists()) { // verifica se os ficheiros existem
            GestorXML gestor = new GestorXML(xml, xsd); // Cria gestor com xml e xsd associado
            if (gestor.validate(true)) { // Valida xml de acordo com o xsd, sem xsd retorna true, ex:  GestorXML(xml, null);           
                System.out.println("o documento é valido!");                
                if (gestor.Read(true)) { // Lê ficheiro                    
                    gestor.print(true, true); // imprime desde root incluindo atributos e filhos                   
                    gestor.print("price", true, true); // imprime os price incluindo atributos e filhos                                       
                }    
            } else { System.out.println("o documento é invalido!"); }
        } else { System.out.println("Ficheiros não encontrados."); }    
    }
}
