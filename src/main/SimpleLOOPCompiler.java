package main;

import main.ast.nodes.Program;
import main.visitor.nameAnalyzer.NameAnalyzer;
import main.visitor.typeChecker.TypeChecker;
import main.visitor.utils.ErrorReporter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parsers.SimpleLOOPLexer;
import parsers.SimpleLOOPParser;

public class SimpleLOOPCompiler {
    public void compile(CharStream textStream) {
        SimpleLOOPLexer simpleLOOPLexer = new SimpleLOOPLexer(textStream);
        CommonTokenStream tokenStream = new CommonTokenStream(simpleLOOPLexer);
        SimpleLOOPParser simpleLOOPParser = new SimpleLOOPParser(tokenStream);

        Program program = simpleLOOPParser.simpleLOOP().simpleLOOPProgram;

        ErrorReporter errorReporter = new ErrorReporter();

        NameAnalyzer nameAnalyzer = new NameAnalyzer(program);
        nameAnalyzer.analyze();
        int numberOfErrors = program.accept(errorReporter);
        if(numberOfErrors > 0)
            System.exit(1);

        TypeChecker typeChecker = new TypeChecker(nameAnalyzer.getClassHierarchy());
        program.accept(typeChecker);

        numberOfErrors = program.accept(errorReporter);
        if(numberOfErrors > 0)
            System.exit(1);

        System.out.println("Compilation successful");
    }
}
