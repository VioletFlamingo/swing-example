package pl.agh.edu.jtp.autokad.config;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class SAXObjectGetter {

    public static void parseXML() {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                String content = null;
                String name = null;
                String figureClass = null;
                String icon = null;
                String hint = null;

                public void startElement(String uri, String localName,
                                         String qName, Attributes attributes)
                        throws SAXException {

                }

                @Override
                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
                    switch(qName.toLowerCase()){
                        case "figure":
                            Figure f = new Figure(name, icon, figureClass, hint);
                        case "name":
                            name=content;
                            break;
                        case "figureclass":
                            figureClass = content;
                            break;
                        case "icon":
                            icon = content;
                            break;
                        case "hint":
                            hint = content;
                            break;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length)
                        throws SAXException {
                    content = String.copyValueOf(ch, start, length).trim();
                }

            };

            saxParser.parse("configuration.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}