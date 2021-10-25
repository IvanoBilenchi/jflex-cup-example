package example;

import java_cup.runtime.ComplexSymbolFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    private static Object parseExpression(String expression) throws Exception {
        ComplexSymbolFactory factory = new ComplexSymbolFactory();
        example.Lexer lexer = new example.Lexer(expression, factory);
        example.Parser parser = new example.Parser(lexer, factory);
        return parser.parse().value;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.printf("= %s\n", parseExpression(reader.readLine()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
