package ExecuteAroundPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//imperative coding

class FileProcessor{
	static String processFile() throws IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(ExecuteAroundPatternWithLambda.class.getResourceAsStream("data.txt")))){
			return br.readLine();  //line that does the required task  // what if we want to return two lines
		}
	}
}



//Execute Around Pattern


interface BufferedReaderProcessor{
	
	String processFile(BufferedReader br) throws IOException;
}


class EnhancedFileProcessor{
	
	static String enhancedProcessFile(BufferedReaderProcessor processor) throws IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(ExecuteAroundPatternWithLambda.class.getResourceAsStream("data.txt")))){
			return processor.processFile(br);  
		}
	}
}


public class ExecuteAroundPatternWithLambda {
	
	
	public static void main(String[] args) {
		try {
			System.out.println(FileProcessor.processFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			String oneLine = EnhancedFileProcessor.enhancedProcessFile((br) -> br.readLine());
			System.out.println(oneLine);
			
			String twoLines = EnhancedFileProcessor.enhancedProcessFile((br) -> br.readLine()+br.readLine());
			System.out.println(twoLines);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}




