package Test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4JTest {
    @Test
    public void test1() {
        // 创建一个SaxReader
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read("src/books.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println(document);
    }
    //读取books.xml生成Book类
    @Test
    public void test2() throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        Element rootElement = document.getRootElement();
        @SuppressWarnings("Unchecked")
        List<Element> books = rootElement.elements("book");
        for (Element book :books) {
            // 获取标签 element
            // System.out.println(book.element("name").asXML());
            // 获取标签text
            // System.out.println(book.element("name").getText());
            // 获取标签对应的内容
            // System.out.println(book.elementText("name"));
            String id = book.attributeValue("id");
            String name = book.elementText("name");
            String author = book.elementText("author");
            String price = book.elementText("price");
            System.out.println(new Book(id,name,author, BigDecimal.valueOf(Double.parseDouble(price))));
        }

    }

}
