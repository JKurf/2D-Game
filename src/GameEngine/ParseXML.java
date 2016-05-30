package GameEngine;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaderJAXPFactory;
import org.jdom2.input.sax.XMLReaders;

import java.io.File;
import java.io.IOException;

/**
 * @author Jack Kurfman
 * @version 5/6/2016.
 */
public class ParseXML {

    public static void main(String[] args) {
        ParseXML x = new ParseXML(new File("World/Test World.world"));
        System.out.println(x.getValueByKey("title"));
        System.out.println(x.getValueByKey("id"));
        System.out.println(x.getArrayByKey("map"));
    }

    private Document XML;

    public ParseXML(File file) {
        try {
            this.XML = new SAXBuilder().build(file);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRoot() {
        return XML.getRootElement().getName();
    }

    public int getContent() {
        return XML.getRootElement().getContentSize();
    }

    public String getValueByKey(String key) {
        return XML.getRootElement().getChildText(key);
    }

    public String[] getArrayByKey(String key) {
        return null;
    }
}
