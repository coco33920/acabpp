import fr.charlotte.lexing.{Lexer, Token}
import org.scalatest.funsuite.AnyFunSuite

class LexerTest extends AnyFunSuite {

  test("LabelTest") {
    val result = Lexer("Label").lex();
    val should = List(Token(Token.Type.LABEL,"Label",0))
    assert(result == should)
  }

  test("plusTest"){
    val result = Lexer("+").lex();
    val should = List(Token(Token.Type.PLUS,"+",0))
    assert(result == should)
  }

  test("acabTest"){
    val result = Lexer("acab").lex();
    val should = List(Token(Token.Type.ACAB,"acab",0))
    assert(result == should)
  }

  test("linefeedTest"){
    val result = Lexer("@").lex();
    val should = List(Token(Token.Type.LF,"@",0))
    assert(result == should)
  }

  test("mixedTest"){
    val result = Lexer("++acab@+").lex();
    val should = List(
      Token(Token.Type.PLUS,"+",0),
      Token(Token.Type.PLUS,"+",1),
      Token(Token.Type.ACAB,"acab",2),
      Token(Token.Type.LF,"@",6),
      Token(Token.Type.PLUS,"+",7)
    )
    assert(result == should)
  }

}
