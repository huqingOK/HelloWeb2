package com.hq.demo.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

/**
 * Created by dell on 2018/4/12.
 * 创建xml文件
 */
public class CreateXML {

    public static void main(String[] strings) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("languages");
            root.setAttribute("cat", "it");

            Element lan1 = document.createElement("lan");
            lan1.setAttribute("id", "1");//键值对都得是String类型的

            Element name1 = document.createElement("name");
            Element ide1 = document.createElement("ide");
            name1.setTextContent("Java");
            ide1.setTextContent("IntelljIdea");

            lan1.appendChild(name1);
            lan1.appendChild(ide1);//要分次数写
            root.appendChild(lan1);//添加子节点
            document.appendChild(root);


            //输出
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            //输出字符串
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));
            System.out.println(writer.toString());
            //输出文件
            transformer.transform(new DOMSource(document),new StreamResult(new File("newXML.xml")));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
