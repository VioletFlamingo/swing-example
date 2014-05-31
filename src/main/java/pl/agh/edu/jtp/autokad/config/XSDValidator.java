package pl.agh.edu.jtp.autokad.config;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;


/**
 * Created by Paulina on 31.05.2014.
 */

public class XSDValidator {
    public static boolean validate(String file, String XSDFile) throws SAXException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File(XSDFile));
        Validator validator = schema.newValidator();

        try {
            validator.validate(new StreamSource(new File(file)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

