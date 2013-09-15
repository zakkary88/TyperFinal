/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import com.sun.org.apache.xerces.internal.impl.io.MalformedByteSequenceException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
/**
 *
 * @author Marcin
 */
public class XMLParser {
        
    private DocumentBuilderFactory factory = null;
    private DocumentBuilder builder = null;
    private String urlString = null;
    private Document doc = null;
    private Node root = null;
    
    private JTextArea screen = null;
       
    public XMLParser(JTextArea screen, String urlString) throws ParserConfigurationException, SAXException, IOException, MalformedByteSequenceException   
    {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        this.screen = screen;
        this.urlString = urlString;
        
        //URI uri = convertToURLEscapingIllegalCharacters(urlString);
        InputSource is = load(urlString);
        //InputSource is = load(uri);
        //InputSource is = load(uri.toString());

        //doc = builder.parse(uri.toString());
        //doc = builder.parse(is);
          doc = builder.parse(new URL(urlString).openStream());
        
          root = doc.getDocumentElement();      
    }
    
    private InputSource load(String urlString) throws FileNotFoundException, UnsupportedEncodingException, SAXException, IOException
    {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        Reader reader = new InputStreamReader(inputStream,"UTF-8");
     
        InputSource is = new InputSource(reader);
        is.setEncoding("UTF-8");
        
        return is;
    }
    
//    private InputSource load(URI uri) throws FileNotFoundException, UnsupportedEncodingException, SAXException, IOException
//    {
//        URL url = new URL(uri.toString());
//        InputStream inputStream = url.openStream();
//        Reader reader = new InputStreamReader(inputStream,"UTF-8");
//     
//        InputSource is = new InputSource(reader);
//        is.setEncoding("UTF-8");
//        
//        return is;
//    }
    
//    private URI convertToURLEscapingIllegalCharacters(String string)
//    {
//        try 
//        {
//            String decodedURL = URLDecoder.decode(string, "UTF-8");
//            URL url = new URL(decodedURL);
//            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()); 
//            return uri;  
//        } 
//        catch (Exception ex) 
//        {
//            ex.printStackTrace();
//            return null;
//        }        
//    }
    /*
    public void viewNode(Node parent)
    {
        NodeList children = parent.getChildNodes();
        for(int i=0; i<children.getLength(); i++)
        {
            Node child = children.item(i);
            if(child instanceof Element)
            {
                //System.out.println(child.getNodeName());
                screen.append(child.getNodeName() + "\n");
                viewAllAttributes(child);
                
                viewNode(child);
            }
        }
    }
    
    public void parse1()
    {
        viewNode(root);
    }
    */
    public void parse()
    {
        //oxip
        NodeList children = root.getChildNodes();       
        for(int i=0; i<children.getLength(); i++)
        {
            //response
            Node child = children.item(i);
            if(child instanceof Element)
            {
                //williamhill
                NodeList children1 = child.getChildNodes();
                for(int j=0; j<children1.getLength(); j++)
                {
                    Node child1 = children1.item(j);
                    if(child1 instanceof Element)
                    {
                        //class
                        NodeList children2 = child1.getChildNodes();
                        for(int k=0; k<children2.getLength(); k++)
                        {
                            Node child2 = children2.item(k);
                            if(child2 instanceof Element)
                            {
                                //type
                                viewLeague(child2);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void viewLeague(Node parent)
    {
        //type
        NodeList children = parent.getChildNodes();
        for(int i=0; i<children.getLength(); i++)
        {
            Node child = children.item(i);
            if(child instanceof Element)
            {
                viewLeagueAttributes(child);
                //market
                viewMatch(child);
            }
        }
    }
    
    private void viewMatch(Node parent)
    {
        //market
        NodeList children = parent.getChildNodes();
        for(int i=0; i<children.getLength(); i++)
        {
            Node child = children.item(i);
            
            if(child instanceof Element)
            {
                viewMatchAttributes(child);               
                //participant
                viewOptions(child);
            }
        }
    }
    
    private void viewOptions(Node parent)
    {
        //participant
        NodeList children = parent.getChildNodes();
        /*
        NamedNodeMap parentAttrs = parent.getAttributes();
        
            for(int i=0; i<children.getLength(); i++)
            {
                   if(parentAttrs.getNamedItem("name").getNodeName().contains("Match"))
                   {
           
                    Node child = children.item(i);
                    if(child instanceof Element)
                        viewOptionsAttributes(child);
                   }
            } 
        */
        
        for(int i=0; i<children.getLength(); i++)
        {
            Node child = children.item(i);
            if(child instanceof Element)
                viewOptionsAttributes(child);
        }
    }
    
    private void viewOptionsAttributes(Node node)
    {
        NamedNodeMap attributes = node.getAttributes();
        String name = "";
        String odd = "";
        
        for(int i=0; i<attributes.getLength(); i++)
        {
            Node attr = attributes.item(i);
            if(attr.getNodeName().equals("name"))
                name = attr.getNodeValue();
            
            if(attr.getNodeName().equals("oddsDecimal"))
                odd = attr.getNodeValue();            
        }
        //System.out.println("\t" + name + ": " + odd);
        screen.append("\t\t" + name + ": " + odd + "\n");
    }
    
    private void viewMatchAttributes(Node node)
    {
        NamedNodeMap attributes = node.getAttributes();
        String name = "";
        String date = "";
        String time = "";
        
        for(int i=0; i<attributes.getLength(); i++)
        {
            Node attr = attributes.item(i);

            if(attr.getNodeName().equals("name")) 
                name = attr.getNodeValue();

            if(attr.getNodeName().equals("betTillDate"))
                date = "Date: " + attr.getNodeValue();

            if(attr.getNodeName().equals("betTillTime"))
                time = "Time: " + attr.getNodeValue();
 
        }
        screen.append("\t" + name + " || " + date + " || " + time + "\n");
    }
    
    private void viewLeagueAttributes(Node node)
    {
        NamedNodeMap attributes = node.getAttributes();
        for(int i=0; i<attributes.getLength(); i++)
        {
            Node attr = attributes.item(i);
            if(attr.getNodeName().equals("name"))
            {
                String value = attr.getNodeValue();
                //System.out.println(value);
                screen.append(value + "\n");
            }         
        }
    }
    /*
    private void viewAllAttributes(Node node)
    {
        NamedNodeMap attributes = node.getAttributes();
        String name = "";
        String value = "";
        
        for(int i=0; i<attributes.getLength(); i++)
        {
            Node attr = attributes.item(i);
            name = attr.getNodeName();
            value = attr.getNodeValue();
            System.out.print("\t || " + name + ": " + value);
            System.out.println();
        }
    }
    * */
}
