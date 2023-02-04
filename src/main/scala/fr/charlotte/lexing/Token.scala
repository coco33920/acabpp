package fr.charlotte.lexing

case class Token(tpe: Token.Type, body: String, startPos: Int)

object Token:
  enum Type:
    case ACAB
    case PLUS
    case LF

  def stringToToken(str: String): Type =
    str match
      case "acab" => Type.ACAB
      case "+" => Type.PLUS
      case "@" => Type.LF

  def tokenToString(tpe: Type): String =
    tpe match
      case Type.ACAB => "acab"
      case Type.PLUS => "+"
      case Type.LF => "@"