

package main;

import main.visitor.codeGenerator.CodeGenerator;
import main.visitor.typeChecker.TypeChecker;
import main.visitor.utils.ASTTreePrinter;
import main.visitor.utils.ErrorReporter;
import parsers.*;
import main.ast.nodes.Program;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import main.visitor.nameAnalyzer.*;

public class SimpleLOOPCompiler {
    public void compile(CharStream textStream) {
        SimpleLOOPLexer simpleLOOPLexer = new SimpleLOOPLexer(textStream);
        CommonTokenStream tokenStream = new CommonTokenStream(simpleLOOPLexer);
        SimpleLOOPParser simpleLOOPParser = new SimpleLOOPParser(tokenStream);

        Program program = simpleLOOPParser.simpleLOOP().simpleLOOPProgram;
        ErrorReporter errorReporter = new ErrorReporter();

        NameAnalyzer nameAnalyzer = new NameAnalyzer(program);
        nameAnalyzer.analyze();

        TypeChecker typeChecker = new TypeChecker(nameAnalyzer.getClassHierarchy());
        program.accept(typeChecker);

        int numberOfErrors = program.accept(errorReporter);

        CodeGenerator codeGenerator = new CodeGenerator(nameAnalyzer.getClassHierarchy());
        program.accept(codeGenerator);

        if(numberOfErrors == 0)
            System.out.println("Compilation Successful");

    }
}