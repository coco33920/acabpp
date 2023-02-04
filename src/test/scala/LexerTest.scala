import fr.charlotte.lexing.{Lexer, Token}
import org.scalatest.funsuite.AnyFunSuite

class LexerTest extends AnyFunSuite {

  test("LabelTest") {
    val result = Lexer("Label").lex();
    val should = List(Token(Token.Type.LABEL,"Label",0))
    assert(result == should)
  }

}
