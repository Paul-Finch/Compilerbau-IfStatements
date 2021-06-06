import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class VariableManualMain {

	public static void main(String[] args) throws Exception {
		System.out.println("BEGIN");
		String fileName = args[0];
		FileInputStream inputStream = new FileInputStream(fileName);
		compiler.FileReaderIntf fileReader = new compiler.FileReader(inputStream);
		compiler.LexerIntf lexer = new compiler.Lexer(fileReader);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        compiler.StmtReaderIntf stmtReader = new compiler.StmtReader(lexer, outStream);
		stmtReader.getStmtList();
        String output = outStream.toString("UTF-8");
        System.out.println(output);
		System.out.println("END");
	}

}
