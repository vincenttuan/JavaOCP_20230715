package day02;

import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class StringDemo7 {

	public static void main(String[] args) throws Exception {
		// XML範例: 請計算出 "學生成績檔D.txt" 所有分數的總和
		DocumentBuilderFactory dBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder dBuilder = dBuilderFactory.newDocumentBuilder();
		
		// 將 xml 文件透過 dBuilder.parse() 放到 Document 物件中
		File file = new File("C:\\Users\\MB-207\\eclipse-workspace\\JavaOCP_20230715\\src\\day02\\學生成績檔D.txt");
		Document doc = dBuilder.parse(file);
		NodeList nodeList = doc.getElementsByTagName("student");
		System.out.printf("筆數: %d\n", nodeList.getLength());
		Student[] students = new Student[nodeList.getLength()];
		for(int i=0;i<nodeList.getLength();i++) {
			Node node = nodeList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) { // 是否是元素節點
				Element element = (Element)node;
				String NAME = element.getElementsByTagName("NAME").item(0).getTextContent();
				String SCORE1 = element.getElementsByTagName("SCORE1").item(0).getTextContent();
				String SCORE2 = element.getElementsByTagName("SCORE2").item(0).getTextContent();
				String SCORE3 = element.getElementsByTagName("SCORE3").item(0).getTextContent();
				
				Student student = new Student(NAME, SCORE1, SCORE2, SCORE3);
				students[i] = student;
			}
		}
		
		System.out.println(Arrays.toString(students));
		
		int summary = 0;
		for(Student student : students) {
			summary += Integer.parseInt(student.SCORE1);
			summary += Integer.parseInt(student.SCORE2);
			summary += Integer.parseInt(student.SCORE3);
		}
		System.out.printf("成績總和: %,d\n", summary);
		
	}

}
