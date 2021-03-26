package run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Run {

	public static void main(String[] args) {
		/*
		 * *Properties 
		 * - Map 계열의 컬렉션(key + value 세트로 담는)
		 * - Key값도 String, Value 값도 String인 특징
		 * - Properties에 담겨있는 것들을 파일로 출력을 한다거나 
		 *   파일에 있는 데이터들을 Properties 입력 받아올 수 있는
		 *   즉, 파일과 입출력할 수 있는 메소드를 제공!
		 * 
		 *   
		 *   CRUD 구현(C-Insert, R-Select, U-Update, D-Delete)
		 */
		/*
		 * Properties prop = new Properties();
		 
		// setProperty 메소드(key, value를 세팅하는 메소드)
		// Map의 특징 : 순서 유지 되지 않는다.
		prop.setProperty("C", "Insert");
		prop.setProperty("R", "Select");
		prop.setProperty("U", "Update");
		prop.setProperty("D", "Delete");
		
		 System.out.println(prop);
		
		 // getProperty 메소드
		 System.out.println(prop.getProperty("R"));
		 System.out.println(prop.getProperty("C"));
		 
		try {
			// <prop 내용 담은 파일 생성하겠다.>
			prop.store(new FileOutputStream("test.properties"), "test properties");
			prop.storeToXML(new FileOutputStream("test.xml"), "test properties");
			
			// <prop 내용 담은 파일 불러오겠다>
			prop.load(new FileInputStream("test.properties"));
			prop.loadFromXML(new FileInputStream("test.xml"));
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		*/
		
		Properties prop1 = new Properties();
		
		try {
			prop1.load(new FileInputStream("test.properties"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop1.getProperty("driver"));
		System.out.println(prop1.getProperty("url"));
		System.out.println(prop1.getProperty("username"));
		System.out.println(prop1.getProperty("password"));
		
		System.out.println("======================");
		
		Properties prop2 = new Properties();
		
		try {
			prop2.loadFromXML(new FileInputStream("test.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop2.getProperty("selectList"));
		System.out.println(prop2.getProperty("updateMember"));
		System.out.println(prop2.getProperty("deleteMember"));
	}

}
