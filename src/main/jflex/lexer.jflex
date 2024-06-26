package example;
import java_cup.runtime.SymbolFactory;
import java.io.StringReader;

%%

%public
%class Lexer
%unicode
%cupsym ParserSym
%cup

%{
    SymbolFactory sf;

    public Lexer(String line, SymbolFactory sf) {
        this(new StringReader(line));
        this.sf = sf;
    }
%}

%eofval{
    return sf.newSymbol("EOF", ParserSym.EOF);
%eofval}

Number = [0-9]+

%%

"+"         { return sf.newSymbol("+", ParserSym.PLUS); }
"-"         { return sf.newSymbol("-", ParserSym.MINUS); }
"*"         { return sf.newSymbol("*", ParserSym.TIMES); }
"("         { return sf.newSymbol("(", ParserSym.LPAREN); }
")"         { return sf.newSymbol(")", ParserSym.RPAREN); }
{Number}    { return sf.newSymbol("NUMBER", ParserSym.NUMBER, Integer.valueOf(yytext())); }
.           { /* ignore */ }
