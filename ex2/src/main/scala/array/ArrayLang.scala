package array

import common.Lang._

object ArrayLang {

  case class Program(statements: List[Statement])

  // Statements
  sealed abstract class Statement
  //  Example: x := x + 1
  case class AssignStmt(identifier: Variable, expression: Expression[Variable]) extends Statement
  //  Example: while (x < 5) x := x + 1
  case class WhileStmt(expression: Expression[String], body: List[Statement]) extends Statement
  //  Example: a := new Array[n+1]
  case class NewArrayStmt(identifier: Variable, length: Expression[Variable]) extends Statement
  //  Example: y = a[x+1]
  case class ReadArrayStmt(identifier: Variable, array: Variable, index: Expression[Variable]) extends Statement
  //  Example: a[x+1] := y+z
  case class AssignArrayStmt(identifier: Variable, index: Expression[Variable], value: Expression[Variable]) extends Statement
  //  Example: delete a
  case class DeleteArrayStmt(identifier: Variable) extends Statement

  // Expressions
  sealed abstract class Expression[Identifier]
  //  Example: x
  case class Var[Identifier](identifier: Identifier) extends Expression[Identifier]
  //  Example: len(x)
  case class ArrayLength[Identifier](identifier: Identifier) extends Expression[Identifier]
  //  Example: 42
  case class Lit[Identifier](literal: Literal) extends Expression[Identifier]
  //  Arithmetic Expressions
  case class Neg[Identifier](expression: Expression[Identifier]) extends Expression[Identifier]
  case class Add[Identifier](left: Expression[Identifier], right: Expression[Identifier]) extends Expression[Identifier]
  case class Sub[Identifier](left: Expression[Identifier], right: Expression[Identifier]) extends Expression[Identifier]
  case class Mul[Identifier](left: Expression[Identifier], right: Expression[Identifier]) extends Expression[Identifier]
  case class Div[Identifier](left: Expression[Identifier], right: Expression[Identifier]) extends Expression[Identifier]
  //  Boolean Expressions
  case class Not[Identifier](expression: Expression[Identifier]) extends Expression[Identifier]
  case class And[Identifier](left: Expression[Identifier], right: Expression[Identifier]) extends Expression[Identifier]
  case class Or[Identifier](left: Expression[Identifier], right: Expression[Identifier]) extends Expression[Identifier]
  case class Eq[Identifier](left: Expression[Identifier], right: Expression[Identifier]) extends Expression[Identifier]
  case class Lt[Identifier](left: Expression[Identifier], right: Expression[Identifier]) extends Expression[Identifier]
  case class Gt[Identifier](left: Expression[Identifier], right: Expression[Identifier]) extends Expression[Identifier]

}
