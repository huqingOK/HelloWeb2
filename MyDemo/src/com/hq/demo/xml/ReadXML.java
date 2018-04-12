package com.hq.demo.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by dell on 2018/4/12.
 */
public class ReadXML {
    public static void main(String[] strings) {
        try {


            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //创建真正的xml文档
            Document document = builder.parse(new File("language.xml"));
            //获取文档的根元素
            Element root = document.getDocumentElement();
            System.out.println("<language cat = \"" + root.getAttribute("cat") + "\">");
            //获取根元素的子元素，并遍历
            NodeList list = root.getElementsByTagName("lan");
            for (int i = 0; i < list.getLength(); i++) {
                Element lan = (Element) list.item(i);
                System.out.println("\t<lan id = \"" + lan.getAttribute("id") + "\">");
                NodeList clist = lan.getChildNodes();
                for (int j = 0; j < clist.getLength(); j++) {
                    Node c = clist.item(j);//element 是node子集
                    if (c instanceof Element) {// *text=  回车后面的缩进符也当成一个节点来读取，所以要判断一下是否是Elmelent对象，才输出
                        //输出子元素的的元素名和元素值
                        System.out.println("\t\t<" + c.getNodeName() + ">" + c.getTextContent() + "</" + c.getNodeName() + ">");
                    }
                }
                System.out.println("\t</lan>");
            }
            System.out.println("</language>");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
