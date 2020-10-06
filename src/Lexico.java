import java.util.HashMap;
import java.util.Map;

public class Lexico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> token = new HashMap<Integer,String>(); // criando hashmap 
		
		token.put(1,"Program"); //definindo codigo 1 = Program e assim sucessivamente
		token.put(2,"Label");
		token.put(3,"Const");
		token.put(4,"Var");
		token.put(5,"Procedure"); 
		token.put(6,"Begin"); 
		token.put(7,"End"); 
		token.put(8,"Integer");
		token.put(9,"Array"); 
		token.put(10,"Of"); 
		token.put(11,"Call"); 
		token.put(12,"Goto");
		token.put(13,"If"); 
		token.put(14,"Then"); 
		token.put(15,"Else"); 
		token.put(16,"While");
		token.put(17,"Do"); 
		token.put(18,"Repeat"); 
		token.put(19,"Until"); 
		token.put(20,"Readln");
		token.put(21,"Writeln"); 
		token.put(22,"Or"); 
		token.put(23,"And"); 
		token.put(24,"Not");
		token.put(25,"Identificador");
		token.put(26,"Inteiro"); 
		token.put(27,"For"); 
		token.put(28,"To");
		token.put(29,"Case"); 
		token.put(30,"+"); 
		token.put(31,"-"); 
		token.put(32,"*");
		token.put(33,"/"); 
		token.put(34,"["); 
		token.put(35,"]"); 
		token.put(36,"(");
		token.put(37,")"); 
		token.put(38,":="); 
		token.put(39,":"); 
		token.put(40,"=");
		token.put(41,">"); 
		token.put(42,">="); 
		token.put(43,"<"); 
		token.put(44,"<=");
		token.put(45,"< >"); 
		token.put(46,","); 
		token.put(47,";"); 
		token.put(48,"literal");
		token.put(49,"."); 
		token.put(50,"..");
        token.put(51,"$");
        
        String keyToSearch = ">"; //criando a variavel no qual vai ser inserido valor pesquisado
		
        if ( token.containsValue(keyToSearch) ) { //verificando se o hash token tem a variavel pesquisada
         System.out.println("Valor da chave: "+keyToSearch+" Codigo: "); //apenas mostrando o valor
           }
        else{ // se não existir executar
                  System.err.println("Chave não existe");
           }
	}

}
