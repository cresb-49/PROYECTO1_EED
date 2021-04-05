
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.carlos.proyecto1.Analizadores.Parser;

import com.carlos.proyecto1.Analizadores.Lexer.userLexer;
import com.carlos.proyecto1.ED.*;
import com.carlos.proyecto1.Tokens.token;
import com.carlos.proyecto1.Objetos.*;
import com.carlos.proyecto1.Exepciones.CloneNodeException;
import java_cup.runtime.Symbol;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parserUsuario extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return parserUsuarioSym.class;
}

  /** Default constructor. */
  @Deprecated
  public parserUsuario() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parserUsuario(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parserUsuario(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\014\000\002\002\007\000\002\002\004\000\002\002" +
    "\003\000\002\003\003\000\002\003\002\000\002\006\003" +
    "\000\002\006\002\000\002\004\004\000\002\004\003\000" +
    "\002\005\004\000\002\005\002\000\002\005\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\021\000\006\003\004\004\006\001\002\000\004\002" +
    "\uffff\001\002\000\004\002\023\001\002\000\004\006\007" +
    "\001\002\000\010\003\012\005\010\010\ufffb\001\002\000" +
    "\010\003\021\007\017\010\ufff7\001\002\000\004\010\ufffc" +
    "\001\002\000\004\010\ufff9\001\002\000\004\010\014\001" +
    "\002\000\010\002\ufffd\003\004\004\006\001\002\000\004" +
    "\002\ufffe\001\002\000\004\002\001\001\002\000\006\003" +
    "\012\005\010\001\002\000\004\010\ufffa\001\002\000\004" +
    "\010\ufff6\001\002\000\004\010\ufff8\001\002\000\004\002" +
    "\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\021\000\004\002\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\004\010\006\012" +
    "\001\001\000\004\005\017\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\002\014\003\015" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\004" +
    "\021\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parserUsuario$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parserUsuario$actions(this);
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
    return action_obj.CUP$parserUsuario$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



        
    private Pila errores = new Pila();    
    private AVL usuarios;
    private ListaDobleEnlazadaCircular listaCircularImagenes;
    private traducErrorParserUsuario traductorError;
    
    public parserUsuario(userLexer lex,ListaDobleEnlazadaCircular listaImagenes, AVL usuariosSistema){
        super(lex);
        this.listaCircularImagenes=listaImagenes;
        this.usuarios = usuariosSistema;
        this.traductorError = new traducErrorParserUsuario();
    }

    public void report_error(String message, Object info){
        System.out.println("reporterror");
    }
    public void report_fatal_error(String message, Object info){
        System.out.println("reportfatal");
    }

    public void syntax_error(Symbol cur_token){
        token tok = (token) cur_token.value;
        String err = "Parametro inesperado \""+tok.getLexeme()+"\" se esperaba [";
        for (int i = 0; i < expected_token_ids().size(); i++) {
            if (!traductorError.tokenEsperado(expected_token_ids().get(i)).equals("")) {
                err = err + traductorError.tokenEsperado(expected_token_ids().get(i));
                if (i < (expected_token_ids().size() - 1)) {
                    err = err + " ó ";
                }
            }
        }
        err = err +"] Linea: "+tok.getLine()+",Columna: "+tok.getColumn();
        System.out.println(err);
        errores.push(err);
    }

    protected int error_sync_size() {
        return 1;
    }

    public Pila getErrores(){
        return errores;
    }

    public AVL getUsuarios(){
        return usuarios;
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parserUsuario$actions {
  private final parserUsuario parser;

  /** Constructor */
  CUP$parserUsuario$actions(parserUsuario parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parserUsuario$do_action_part00000000(
    int                        CUP$parserUsuario$act_num,
    java_cup.runtime.lr_parser CUP$parserUsuario$parser,
    java.util.Stack            CUP$parserUsuario$stack,
    int                        CUP$parserUsuario$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parserUsuario$result;

      /* select the action based on the action number */
      switch (CUP$parserUsuario$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // s ::= USER D_DOT contenido DOT_COMA sp 
            {
              Object RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-4)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-4)).right;
		Object e1 = (Object)((java_cup.runtime.Symbol) CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-4)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-2)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-2)).right;
		Object e2 = (Object)((java_cup.runtime.Symbol) CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-2)).value;
		
        if(e2!=null){
            Pila pilaTmp = (Pila)e2;
            token tok = (token)e1;
            if(pilaTmp.isEmpty()){
                System.out.println("Pila vacia");
                usuario nuevo = new usuario(tok.getLexeme(), new ListaDobleEnlazada());
                try {
                    usuarios.agregar(new NodoArbol(nuevo.getUser(),nuevo));
                } catch (CloneNodeException e) {
                    System.out.println(e.getMessage()+",Linea: "+tok.getLine()+" ,Columna: "+tok.getColumn());
                    errores.push(e.getMessage()+",Linea: "+tok.getLine()+" ,Columna: "+tok.getColumn());
                }
            }else{
                System.out.println("Pila con datos");
                ListaDobleEnlazada imagenes = new ListaDobleEnlazada();
                Imagen tmp = null;
                while (!pilaTmp.isEmpty()) {                    
                    tmp = (Imagen)pilaTmp.pop();
                    try{
                        imagenes.agregar(new Nodo(tmp.getId(),tmp));
                    }catch(CloneNodeException e){
                        System.out.println(e.getMessage()+",Linea: "+tok.getLine()+" ,Columna: "+tok.getColumn());
                        errores.push(e.getMessage()+",Linea: "+tok.getLine()+" ,Columna: "+tok.getColumn());
                    }
                    
                }
                usuario nuevo = new usuario(tok.getLexeme(), imagenes);
                try {
                    usuarios.agregar(new NodoArbol(nuevo.getUser(),nuevo));
                } catch (CloneNodeException e) {
                    System.out.println(e.getMessage()+",Linea: "+tok.getLine()+" ,Columna: "+tok.getColumn());
                    errores.push(e.getMessage()+",Linea: "+tok.getLine()+" ,Columna: "+tok.getColumn());
                }
            }
        }
    
              CUP$parserUsuario$result = parser.getSymbolFactory().newSymbol("s",0, ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-4)), ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), RESULT);
            }
          return CUP$parserUsuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= s EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-1)).value;
		RESULT = start_val;
              CUP$parserUsuario$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-1)), ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parserUsuario$parser.done_parsing();
          return CUP$parserUsuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // s ::= error 
            {
              Object RESULT =null;

              CUP$parserUsuario$result = parser.getSymbolFactory().newSymbol("s",0, ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), RESULT);
            }
          return CUP$parserUsuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // sp ::= s 
            {
              Object RESULT =null;

              CUP$parserUsuario$result = parser.getSymbolFactory().newSymbol("sp",1, ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), RESULT);
            }
          return CUP$parserUsuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // sp ::= 
            {
              Object RESULT =null;

              CUP$parserUsuario$result = parser.getSymbolFactory().newSymbol("sp",1, ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), RESULT);
            }
          return CUP$parserUsuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // contenido ::= cont 
            {
              Object RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()).right;
		Object e1 = (Object)((java_cup.runtime.Symbol) CUP$parserUsuario$stack.peek()).value;
		
                RESULT =e1;
            
              CUP$parserUsuario$result = parser.getSymbolFactory().newSymbol("contenido",4, ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), RESULT);
            }
          return CUP$parserUsuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // contenido ::= 
            {
              Object RESULT =null;
		
                RESULT = new Pila();
            
              CUP$parserUsuario$result = parser.getSymbolFactory().newSymbol("contenido",4, ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), RESULT);
            }
          return CUP$parserUsuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // cont ::= ID cont2 
            {
              Object RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-1)).right;
		Object e1 = (Object)((java_cup.runtime.Symbol) CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()).right;
		Object e2 = (Object)((java_cup.runtime.Symbol) CUP$parserUsuario$stack.peek()).value;
		
            if(e2!=null){
                Pila tmpPila = (Pila)e2;
                token tok = (token)e1;
                Nodo nodoTmp = listaCircularImagenes.buscar(tok.getLexeme());
                if(nodoTmp!=null){
                    Imagen imagenTmp = (Imagen)nodoTmp.getContenido();
                    if (tmpPila.buscar(imagenTmp.getId())==null) {
                        tmpPila.push(imagenTmp, imagenTmp.getId());
                        System.out.println("Agrege la imagen a la pila");
                    }else{
                        System.out.println("Ya habia asignado la imagen \""+tok.getLexeme()+"\",Linea: "+tok.getLine()+" ,Columna: "+tok.getColumn());
                        errores.push("Ya habia asignado la imagen \""+tok.getLexeme()+"\",Linea: "+tok.getLine()+" ,Columna: "+tok.getColumn());
                    }
                }else{
                    System.out.println("No existe una imagen \""+tok.getLexeme()+"\",Linea: "+tok.getLine()+" ,Columna: "+tok.getColumn());
                    errores.push("No existe una imagen \""+tok.getLexeme()+"\",Linea: "+tok.getLine()+" ,Columna: "+tok.getColumn());
                }   
            }
            RESULT = e2;
        
              CUP$parserUsuario$result = parser.getSymbolFactory().newSymbol("cont",2, ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-1)), ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), RESULT);
            }
          return CUP$parserUsuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // cont ::= error 
            {
              Object RESULT =null;

              CUP$parserUsuario$result = parser.getSymbolFactory().newSymbol("cont",2, ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), RESULT);
            }
          return CUP$parserUsuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // cont2 ::= COMA cont 
            {
              Object RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()).right;
		Object e1 = (Object)((java_cup.runtime.Symbol) CUP$parserUsuario$stack.peek()).value;
		
            RESULT = e1;
        
              CUP$parserUsuario$result = parser.getSymbolFactory().newSymbol("cont2",3, ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.elementAt(CUP$parserUsuario$top-1)), ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), RESULT);
            }
          return CUP$parserUsuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // cont2 ::= 
            {
              Object RESULT =null;
		
            RESULT = new Pila();
        
              CUP$parserUsuario$result = parser.getSymbolFactory().newSymbol("cont2",3, ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), RESULT);
            }
          return CUP$parserUsuario$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // cont2 ::= error 
            {
              Object RESULT =null;

              CUP$parserUsuario$result = parser.getSymbolFactory().newSymbol("cont2",3, ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserUsuario$stack.peek()), RESULT);
            }
          return CUP$parserUsuario$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parserUsuario$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parserUsuario$do_action(
    int                        CUP$parserUsuario$act_num,
    java_cup.runtime.lr_parser CUP$parserUsuario$parser,
    java.util.Stack            CUP$parserUsuario$stack,
    int                        CUP$parserUsuario$top)
    throws java.lang.Exception
    {
              return CUP$parserUsuario$do_action_part00000000(
                               CUP$parserUsuario$act_num,
                               CUP$parserUsuario$parser,
                               CUP$parserUsuario$stack,
                               CUP$parserUsuario$top);
    }
}

}
