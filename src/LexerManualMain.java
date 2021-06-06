import java.io.FileInputStream;

public class LexerManualMain {

	public static void main(String[] args) throws Exception {
		System.out.println("BEGIN");
		String fileName = args[0];
		FileInputStream inputStream = new FileInputStream(fileName);
		compiler.FileReaderIntf fileReader = new compiler.FileReader(inputStream);
		compiler.LexerIntf lexer = new compiler.Lexer(fileReader);
        compiler.Token currentToken;
        String output = new String();
        do {
        	currentToken = lexer.lookAheadToken();
        	output += currentToken.toString() + "\n";
        	lexer.advance();
        } while (currentToken.m_type != compiler.Token.Type.EOF);
        System.out.print(output);
		System.out.println("END");
	}

}
