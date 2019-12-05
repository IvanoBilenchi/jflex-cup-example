package example;

import java_cup.runtime.DefaultSymbolFactory;
import java_cup.runtime.SymbolFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import example.Lexer;
import example.Parser;

class Main {

    private static Object parseExpression(String expression) throws Exception {
        SymbolFactory symbolFactory = new DefaultSymbolFactory();
        Parser parser = new Parser(new Lexer(expression, symbolFactory), symbolFactory);
        return parser.parse().value;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.printf("= %s\n", parseExpression(reader.readLine()));
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }
}
