import java.io.ByteArrayOutputStream;

public class VariableTest implements test.TestCaseIntf {

	public String executeTest(compiler.FileReaderIntf fileReader) throws Exception {
		compiler.LexerIntf lexer = new compiler.Lexer(fileReader);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        compiler.StmtReader stmt = new compiler.StmtReader(lexer, outStream);
        stmt.getStmtList();
        String output = outStream.toString("UTF-8");
        return output;
	}	
}
