
public class LexerTest implements test.TestCaseIntf {


	public String executeTest(compiler.FileReaderIntf fileReader) throws Exception {
        compiler.Lexer lexer = new compiler.Lexer(fileReader);
        compiler.Token currentToken;
        String output = new String();
        do {
        	currentToken = lexer.lookAheadToken();
        	output += currentToken.toString() + "\n";
        	lexer.advance();
        } while (currentToken.m_type != compiler.Token.Type.EOF);
		return output;
	}
}
