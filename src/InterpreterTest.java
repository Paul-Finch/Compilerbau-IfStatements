import java.io.ByteArrayOutputStream;

public class InterpreterTest implements test.TestCaseIntf {

	public String executeTest(compiler.FileReaderIntf fileReader) throws Exception {
		compiler.CompileEnv compiler = new compiler.CompileEnv(fileReader);
		compiler.compile();
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		compiler.execute(outStream);
		String output = outStream.toString("UTF-8");
		return output;
	}	
}
