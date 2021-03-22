
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.carlos.proyecto1.Analizadores.Parser;

import com.carlos.proyecto1.Analizadores.Lexer.capasLexer;
import com.carlos.proyecto1.ED.Cola;
import com.carlos.proyecto1.ED.Pila;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parserCapas extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return parserCapasSym.class;
}

  /** Default constructor. */
  @Deprecated
  public parserCapas() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parserCapas(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parserCapas(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\007\000\002\002\007\000\002\002\004\000\002\004" +
    "\011\000\002\005\003\000\002\005\002\000\002\003\003" +
    "\000\002\003\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\021\000\004\004\004\001\002\000\004\007\007\001" +
    "\002\000\004\002\006\001\002\000\004\002\000\001\002" +
    "\000\004\004\011\001\002\000\004\010\021\001\002\000" +
    "\004\005\012\001\002\000\004\004\013\001\002\000\004" +
    "\005\014\001\002\000\004\011\015\001\002\000\004\006" +
    "\016\001\002\000\006\004\011\010\ufffd\001\002\000\004" +
    "\010\ufffe\001\002\000\004\010\uffff\001\002\000\006\002" +
    "\ufffb\004\004\001\002\000\004\002\ufffc\001\002\000\004" +
    "\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\021\000\004\002\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\004\007\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\004\016\005\017\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\002\021\003\022\001\001\000\002\001\001" +
    "\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parserCapas$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parserCapas$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parserCapas$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



        
    private Cola errores = new Cola();    
    private Pila usuarios = new Pila();
    
    public parserCapas(capasLexer lex){
        super(lex);
    }

    public void report_error(String message, Object info){
        System.out.println("reporterror");
    }
    public void report_fatal_error(String message, Object info){
        System.out.println("reportfatal");
    }

    /*
    public void syntax_error(Symbol cur_token){

    }*/

    protected int error_sync_size() {
        return 1;
    }

    public Cola getErrores(){
        return errores;
    }

    public Pila getUsuarios(){
        return usuarios;
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parserCapas$actions {
  private final parserCapas parser;

  /** Constructor */
  CUP$parserCapas$actions(parserCapas parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parserCapas$do_action_part00000000(
    int                        CUP$parserCapas$act_num,
    java_cup.runtime.lr_parser CUP$parserCapas$parser,
    java.util.Stack            CUP$parserCapas$stack,
    int                        CUP$parserCapas$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parserCapas$result;

      /* select the action based on the action number */
      switch (CUP$parserCapas$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // s ::= NUM L_A cont L_C sp 
            {
              Object RESULT =null;

              CUP$parserCapas$result = parser.getSymbolFactory().newSymbol("s",0, ((java_cup.runtime.Symbol)CUP$parserCapas$stack.elementAt(CUP$parserCapas$top-4)), ((java_cup.runtime.Symbol)CUP$parserCapas$stack.peek()), RESULT);
            }
          return CUP$parserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= s EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parserCapas$stack.elementAt(CUP$parserCapas$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parserCapas$stack.elementAt(CUP$parserCapas$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parserCapas$stack.elementAt(CUP$parserCapas$top-1)).value;
		RESULT = start_val;
              CUP$parserCapas$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parserCapas$stack.elementAt(CUP$parserCapas$top-1)), ((java_cup.runtime.Symbol)CUP$parserCapas$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parserCapas$parser.done_parsing();
          return CUP$parserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // cont ::= NUM COM NUM COM COLOR DOT_COM cont2 
            {
              Object RESULT =null;

              CUP$parserCapas$result = parser.getSymbolFactory().newSymbol("cont",2, ((java_cup.runtime.Symbol)CUP$parserCapas$stack.elementAt(CUP$parserCapas$top-6)), ((java_cup.runtime.Symbol)CUP$parserCapas$stack.peek()), RESULT);
            }
          return CUP$parserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // cont2 ::= cont 
            {
              Object RESULT =null;

              CUP$parserCapas$result = parser.getSymbolFactory().newSymbol("cont2",3, ((java_cup.runtime.Symbol)CUP$parserCapas$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserCapas$stack.peek()), RESULT);
            }
          return CUP$parserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // cont2 ::= 
            {
              Object RESULT =null;

              CUP$parserCapas$result = parser.getSymbolFactory().newSymbol("cont2",3, ((java_cup.runtime.Symbol)CUP$parserCapas$stack.peek()), RESULT);
            }
          return CUP$parserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // sp ::= s 
            {
              Object RESULT =null;

              CUP$parserCapas$result = parser.getSymbolFactory().newSymbol("sp",1, ((java_cup.runtime.Symbol)CUP$parserCapas$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserCapas$stack.peek()), RESULT);
            }
          return CUP$parserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // sp ::= 
            {
              Object RESULT =null;

              CUP$parserCapas$result = parser.getSymbolFactory().newSymbol("sp",1, ((java_cup.runtime.Symbol)CUP$parserCapas$stack.peek()), RESULT);
            }
          return CUP$parserCapas$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parserCapas$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parserCapas$do_action(
    int                        CUP$parserCapas$act_num,
    java_cup.runtime.lr_parser CUP$parserCapas$parser,
    java.util.Stack            CUP$parserCapas$stack,
    int                        CUP$parserCapas$top)
    throws java.lang.Exception
    {
              return CUP$parserCapas$do_action_part00000000(
                               CUP$parserCapas$act_num,
                               CUP$parserCapas$parser,
                               CUP$parserCapas$stack,
                               CUP$parserCapas$top);
    }
}

}