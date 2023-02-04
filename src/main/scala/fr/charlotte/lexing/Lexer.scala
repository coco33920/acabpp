package fr.charlotte.lexing

import scala.collection.mutable
import Lexer.*

object Lexer:
  def isAnAllowedCharacter(input: Char): Boolean =
   input.isLetterOrDigit || input == '+' || input == '@'


class Lexer(input: String) {

  var currentPos = 0;
  var token: mutable.ArrayBuffer[Token] = mutable.ArrayBuffer.empty[Token];

  def lexOperator(nextChar: Char, tokenStartPos: Int): Boolean =
    if nextChar == '+' then
      token += Token(Token.Type.PLUS,"+",tokenStartPos)
      currentPos += 1
      true
    else if nextChar == '@' then
      token += Token(Token.Type.LF, "@", tokenStartPos)
      currentPos += 1
      true
    else
      false

  def lexString(nextChar: Char, tokenStartPos: Int): Boolean =
    if nextChar.isLetterOrDigit then
      var text = ""
      while currentPos < input.length && (input(currentPos).isLetterOrDigit) do
        text += input(currentPos)
        currentPos += 1
      val tpe = Token.stringToToken(text)
      token += Token(tpe, text, tokenStartPos)
      true
    else
      false

  def lex(): List[Token] =
    while currentPos < input.length do
      val tokenStartPos = currentPos
      val nextChar = input(currentPos)

      if nextChar.isWhitespace then
        currentPos += 1
      else if lexOperator(nextChar,tokenStartPos) then ()
      else if lexString(nextChar,tokenStartPos) then ()
      else
        throw new RuntimeException("Lexing error")
    token.toList
}
