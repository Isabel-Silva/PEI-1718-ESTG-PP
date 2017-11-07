package demos;

import core.GestorXML;
import core.XpathEvaluator;
import core.exceptions.XpathNoResultsException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Node;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto <br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PEI - Processamento Estruturado de Informação<br>
 * 2017 / 2018 <br>
 * </h3>
 * <p>
 * <strong>Descrição:</strong>
 * Classe de exemplo que permite gerir o conteúdo de um documento XML
 * <br>
 * </p>
 *
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String xml = "./files/bookstore.xml", xsd = "./files/bookstore.xsd";
        GestorXML gestor = new GestorXML(xml, xsd); // Cria gestor com xml e xsd associado
        if (gestor.validate(true)) { // Valida xml de acordo com o xsd, sem xsd retorna true, ex:  GestorXML(xml, null);           
            System.out.println("o documento é valido!");
            if (gestor.read(true)) { try {
                // Lê ficheiro
                // gestor.print(true, true); // imprime desde root incluindo atributos e filhos
                Node book = XpathEvaluator.applyXpathExpressionToNode("//book[1]/*[2]",gestor.getDocument());
                GestorXML.listNode(book, true, false, 0);
            } catch (XpathNoResultsException ex) {
                    System.out.println("Sem resultados");
                }
            }
        } else {
            System.out.println("o documento é invalido!");
        }
    }

}
