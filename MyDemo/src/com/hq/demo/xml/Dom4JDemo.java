package com.hq.demo.xml;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/**
 * Created by dell on 2018/4/12.
 *
 * https://dom4j.github.io/
 */
public class Dom4JDemo {
    public static void main(String[] strings) {

        String xmlStr = "<root>\n" +
                "    <people>Alice</people>\n" +
                "</root>";
        try {
            Document document = DocumentHelper.parseText(xmlStr);
         System.out.println(document.asXML());
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
}
