package main.compileError.nameError;

import main.compileError.CompileError;

public class CyclicDependency extends CompileError {
    public CyclicDependency(int line, String className) {
        super(line, "Class " + className + " is in a dependency cycle");
    }
}
