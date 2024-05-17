package prodMS.CRUD;//package prodMS.CRUD;
//
//import groovy.lang.GroovyClassLoader;
//import groovy.lang.GroovyObject;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.lang.reflect.InvocationTargetException;
//import java.nio.charset.StandardCharsets;
//import java.util.Scanner;
//
//@SpringBootApplication
//public class CrudApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(CrudApplication.class, args);
//
//		GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
//		try {
//			// Load the Groovy script template from the resources folder
//			InputStream inputStream = CrudApplication.class.getClassLoader().getResourceAsStream("templates/script_template.groovy");
//			if (inputStream == null) {
//				throw new IOException("Resource not found: templates/script_template.groovy");
//			}
//
//			// Read the content of the script
//			String groovyTemplate = new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\A").next();
//			System.out.println("Groovy Script Content:\n" + groovyTemplate); // Debugging statement
//
//			// Compile and load the Groovy script dynamically at runtime
//			Class<?> groovyClass = groovyClassLoader.parseClass(groovyTemplate);
//			System.out.println("Loaded Groovy Class: " + groovyClass.getName()); // Debugging statement
//
//			// Instantiate the Groovy class
//			GroovyObject groovyObject = (GroovyObject) groovyClass.getDeclaredConstructor().newInstance();
//
//			// Call the sayHello method dynamically
//			String dynamicValue = "World"; // Example dynamic value
//			String result = (String) groovyObject.invokeMethod("Greetings", new Object[]{dynamicValue});
//			System.out.println(result);
//		} catch (IOException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//			e.printStackTrace();
//		}
//	}
//}


//package prodMS.CRUD;
//
//import groovy.lang.GroovyClassLoader;
//import groovy.lang.GroovyObject;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.lang.reflect.InvocationTargetException;
//
//@SpringBootApplication
//public class CrudApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(CrudApplication.class, args);
//
//		GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
//		try {
//			// Load the Groovy script from the file system
//			File scriptFile = new File("src/main/resources/templates/script_template.groovy");
//			String groovyScript = new String(Files.readAllBytes(scriptFile.toPath()), StandardCharsets.UTF_8);
//
//			// Compile and load the Groovy script dynamically at runtime
//			Class<?> groovyClass = groovyClassLoader.parseClass(groovyScript);
//
//			// Instantiate the Groovy class
//			GroovyObject groovyObject = (GroovyObject) groovyClass.getDeclaredConstructor().newInstance();
//
//			// Call the sayCheese method dynamically
//			String dynamicValue = "World"; // Example dynamic value
//			String result = (String) groovyObject.invokeMethod("Greetings", dynamicValue);
//			System.out.println(result);
//		} catch (IOException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
//	}
//}


import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
		SpringApplication.run(CrudApplication.class, args);
		GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
		Class<?> groovyClass = groovyClassLoader.parseClass(new File("src/main/resources/templates/script_template.groovy"));
		GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
		String result = (String) groovyObject.invokeMethod("Greetings", "groovy");
		System.out.println(result);
	}
}