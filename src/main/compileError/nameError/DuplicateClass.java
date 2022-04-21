package main.compileError.nameError;

import main.compileError.CompileError;

public class DuplicateClass extends CompileError {
    public DuplicateClass(int line, String className) {
        super(line, "Redefinition of class " + className);
    }
}
