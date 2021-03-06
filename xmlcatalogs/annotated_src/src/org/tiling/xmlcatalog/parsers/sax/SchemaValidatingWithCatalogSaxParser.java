@snip_start@package org.tiling.xmlcatalog.parsers.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.xml.resolver.tools.CatalogResolver;
import org.tiling.xmlcatalog.parsers.DefaultErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * This class is a wrapper around a JAXP SAX parser that validates against a 
 * W3C XML Schema (if specified in the XML document) and uses an XML catalog.
 */
public class SchemaValidatingWithCatalogSaxParser implements SaxParser {
	
	public void parse(InputSource inputSource) throws ParserConfigurationException, SAXException, IOException {@snip_end@
@snip_start@		@snip_end@SAXParserFactory factory = SAXParserFactory.newInstance();
@snip_start@		@snip_end@factory.setNamespaceAware(true);
@snip_start@		@snip_end@factory.setValidating(true);
@snip_start@		@snip_end@SAXParser parser = factory.newSAXParser();
@snip_start@		@snip_end@@open_bold@parser.setProperty(
@snip_start@		@snip_end@	"http://java.sun.com/xml/jaxp/properties/schemaLanguage",
@snip_start@		@snip_end@	"http://www.w3.org/2001/XMLSchema"
@snip_start@		@snip_end@);@close_bold@
@snip_start@		@snip_end@XMLReader reader = parser.getXMLReader();
@snip_start@		@snip_end@reader.setEntityResolver(new CatalogResolver());
@snip_start@		@snip_end@reader.setErrorHandler(new DefaultErrorHandler());
@snip_start@		@snip_end@reader.parse(inputSource);@snip_start@
	}
}@snip_end@