import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;

public class fileOps {

	public static void main(String[] args) throws IOException {
		
		File f = new File("a.txt");
		BufferedReader br=new BufferedReader(new FileReader(f));
		String a=new String();
		while((a=br.readLine())!=null) {

			System.out.println(a);
			
		}
	}
}
