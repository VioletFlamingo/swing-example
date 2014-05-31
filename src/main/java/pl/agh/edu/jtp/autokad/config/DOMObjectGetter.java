package pl.agh.edu.jtp.autokad.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class DOMObjectGetter {

    private List<Figure> figureList;

    public boolean parseXML(String filename) {
        try {
            if (!XSDValidator.validate(filename, "resources"+File.separator+"configuration.xsd")) {
                return false;
            }
            File file = new File(filename);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("figure");

            figureList = new ArrayList<>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element elem = (Element) nodeList.item(i);

                figureList.add(new Figure(getAttribute("name", elem),
                        getAttribute("class", elem), getAttribute("icon", elem),
                        getAttribute("hint", elem)));
            }

            for (Figure f : figureList) {
                System.out.println(f);
            }

            return true;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getAttribute(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node value = nodeList.item(0);
        return value.getNodeValue();
    }

    public List<Figure> getList() {
        return figureList;
    }
}
