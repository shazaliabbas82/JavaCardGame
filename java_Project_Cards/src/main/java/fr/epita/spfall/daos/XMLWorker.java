/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epita.spfall.daos;

import fr.epita.spfall.engine.Game;
import fr.epita.spfall.entities.Player;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


/**
 *
 * @author ShzlAbbs
 */
public class XMLWorker {

    private final String filename = Paths.get("").toAbsolutePath().toString() + File.separator + "game.xml";

    public static Document createdocument() {
        DocumentBuilder dBuilder = null;
        File fXmlFile = null;
        String filename = Paths.get("").toAbsolutePath().toString() + File.separator + "game.xml";

        try {
            fXmlFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            return dBuilder.parse(fXmlFile);
        } catch (ParserConfigurationException | SAXException | IOException parserConfigurationException) {
            parserConfigurationException.printStackTrace();
            return null;
        }
    }

    public static Document createParser() {
        try {
            String filename = Paths.get("").toAbsolutePath().toString() + File.separator + "game.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filename);
            return doc;
        } catch (ParserConfigurationException | SAXException | IOException parserConfigurationException) {
            parserConfigurationException.printStackTrace();
            return null;
        }
    }

    public static void updateFile(Document document) {
        try {
            String filename = Paths.get("").toAbsolutePath().toString() + File.separator + "game.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filename);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerFactoryConfigurationError | SAXException | IOException | TransformerException transformerFactoryConfigurationError) {
            transformerFactoryConfigurationError.printStackTrace();

        }
    }

    public static org.dom4j.Document mainDocument() throws DocumentException {
        return new SAXReader().read(Paths.get("").toAbsolutePath().toString() + File.separator + "game.xml");
    }

    private org.dom4j.Document getDocument() throws Exception {
        SAXReader reader = new SAXReader();
        org.dom4j.Document document = reader.read(new File(this.filename));
        return document;
    }

    private void writerToFile(org.dom4j.Document document) throws Exception {
        // Get the output format 
        OutputFormat format = OutputFormat.createPrettyPrint();
        // Set the encoding of the XML output
        format.setEncoding("UTF-8");
        // Convert the bytes in memory into characters
        Writer writer = new OutputStreamWriter(new FileOutputStream(this.filename), "UTF-8");
        // Create dom4j output character stream
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        //true output
        xmlWriter.write(document);
        // Close the stream
        xmlWriter.close();
    }

    /**
     * Create anew value to insert in the XML file
     *
     * @param g the game
     * @throws Exception
     */
    public void create(Game g) throws Exception {
        org.dom4j.Document document = this.getDocument();
        Element rootElement = document.getRootElement();
        Element game = rootElement.addElement("game");
        game.addAttribute("rounds", String.valueOf(g.getRound()));
        game.addAttribute("id", String.valueOf(rootElement.elements().size() + 1));
        g.getPlayers().forEach((Player player) -> {
            try {
                Element p = game.addElement("player");
                p.addElement("name").setText(player.getName());
                p.addElement("score").setText(String.valueOf(player.getScore()));
                XMLWorker.this.writerToFile(document);
            } catch (Exception ex) {
                Logger.getLogger(XMLWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public void update(Game g) throws Exception {
        org.dom4j.Document document = this.getDocument();
        Element rootElement = document.getRootElement();
        Element element = rootElement.element("player");
        element.addElement("name").setText("4");
        element.addElement("score").setText("2");
        this.writerToFile(document);
    }

    public void delete() throws Exception {
        org.dom4j.Document document = this.getDocument();
        Element rootElement = document.getRootElement();
        Element priceElement = rootElement.element("player").element("unit price");
        priceElement.getParent().remove(priceElement);
        this.writerToFile(document);
    }
}
