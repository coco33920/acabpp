package fr.charlotte.lexing

case class Token(tpe: Token.Type, body: String, startPos: Int):
  override def toString: String = s"[type=$tpe;text=$body;startPos=$startPos]"

object Token:
  enum Type:
    case ACAB
    case PLUS
    case LF
    case INT
    case LABEL

  def stringToToken(str: String): Type =
    str match
      case "acab" => Type.ACAB
      case "+" => Type.PLUS
      case "@" => Type.LF
      case i =>
        try {
          i.strip().toInt
          Type.INT
        } catch {
          case _: Exception => Type.LABEL
        }