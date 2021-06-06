package compiler;

import java.io.FileInputStream;
import java.io.OutputStream;

public class CompileEnv implements CompileEnvIntf {
	private FileReaderIntf m_fileReader;
	private SymbolTable m_symbolTable;
	private FunctionTable m_functionTable;
	private Lexer m_lexer;
	private StmtReaderIntf m_stmtReader;
	private InstrBlock m_entry;
	private InstrBlock m_currentBlock;
	
	public CompileEnv(String fileName) throws Exception {
		FileInputStream inputStream = new FileInputStream(fileName);		
		m_fileReader = new FileReader(inputStream);
		m_symbolTable = new SymbolTable();
		m_functionTable = new FunctionTable();
		m_lexer = new Lexer(m_fileReader);
		m_stmtReader = new StmtReader(m_lexer, this);
	}
	
	public CompileEnv(FileReaderIntf fileReader) throws Exception {
		m_fileReader = fileReader;
		m_symbolTable = new SymbolTable();
		m_functionTable = new FunctionTable();
		m_lexer = new Lexer(m_fileReader);
		m_stmtReader = new StmtReader(m_lexer, this);
	}

	public void compile() throws Exception {
		m_entry = new InstrBlock();
		m_currentBlock = m_entry;
		m_stmtReader.getStmtList();
	}
	
	public void execute(OutputStream outStream) throws Exception {
		ExecutionEnv env = new ExecutionEnv(m_symbolTable, outStream);
		env.execute(m_entry.getIterator());
	}
	
	public void addInstr(InstrIntf instr) {
		m_currentBlock.addInstr(instr);
	}
	
	public InstrBlock createBlock() {
		InstrBlock newBlock = new InstrBlock();
		return newBlock;
	}
	
	public void setCurrentBlock(InstrBlock instrBlock) {
		m_currentBlock = instrBlock;
	}

	public InstrBlock getCurrentBlock() {
		return m_currentBlock;
	}

	public SymbolTable getSymbolTable() {
		return m_symbolTable;
	}

	public FunctionTable getFunctionTable() {
		return m_functionTable;
	}
}
