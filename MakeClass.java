
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Scanner;

public class MakeClass {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Please enter your intended file name");
		String name;
		name = sc.nextLine();
		
		//System.out.println(name);
		String filesep = "\\";
		String path = "bin"+filesep;
		try {
			File makethis = new File(path+name+".java");
			PrintWriter createclass = new PrintWriter(makethis);
			createclass.println ("public class " + name + "{");
			createclass.println("\t public Integer i;");
			createclass.println("\t public " + name + "()" + "{i=3;}");
			createclass.println("}");
			createclass.close();
			Runtime.getRuntime().exec("javac "+path +name+".java");
			Class<?> madeClass = Class.forName(name);
			Constructor oc = (Constructor) madeClass.getConstructor();
			Object instanceclass = oc.newInstance();
			Field field = instanceclass.getClass().getDeclaredField("i");    
			Object value = field.get(instanceclass);
			System.out.println(value.toString());
			
		} catch (Exception e) {
			
		}
		
	}

}

