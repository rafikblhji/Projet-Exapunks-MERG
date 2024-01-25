import java.util.*;  

enum Instruction{
                MAKE,
                LINK,argLINK,
                GRAB,agrGRAB,
                MULI,argMULI,
                ADDI,argADDI,
                SUBI,argSUBI,
                DROP,
                COPY,argCOPY;
}

class ParsingCommand
{  
    Instruction commande;
    public ParsingCommand(Instruction Commande) {
            this.commande=Commande;
    }

    public void order() {
        switch(commande) {
                             case LINK:
                                                System.out.println("\nC'est LINK.");
                                                break;
                             case GRAB:
                                                System.out.println("\nC'est GRAB.");
                                                break;
                             case DROP:
                                                System.out.println("\nC'est DROP.");
                                                break;
                             case COPY:
                                                System.out.println("\nC'est COPY.");
                                                break;
                             case MULI:
                                                System.out.println("\nC'est MULI.");
                                                break;
                             case ADDI:
                                                System.out.println("\nC'est ADDI.");
                                                break;
                             case SUBI:
                                                System.out.println("\nC'est SUBI.");
                                                break;
                             case MAKE:
                                                System.out.println("\nC'est MAKE.");
                                                break;
                             default:
                                                System.out.println("I don't know which one to order.");
                                                break;
                            }
      }
     
}
class ParsComm {
 public static void main(String[] args) {
   /*Test t1 = new Test(Instruction.SUBI);
   t1.order();*/
   Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
   System.out.print("Enter a string: ");  
   String str= sc.nextLine();              //reads string  
   System.out.print("You have entered: "+str.substring(0, 4)+"\n");
   System.out.print("You have entered: "+str.substring(5, str.length())+"\n");
   String toto=str.substring(0, 4);
   System.out.print("La valeur saisie est: "+toto+"\n");
   ParsingCommand t1 = new ParsingCommand(Instruction.LINK);
   t1.order();
   
 }
}
    /*public static void main(String[] args)  
    {  
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
        System.out.print("Enter a string: ");  
        String str= sc.nextLine();              //reads string  
        System.out.print("You have entered: "+str.substring(0, 4));
        System.out.print(" You have entered: "+str.substring(5, str.length()));
        String votreChaine = str.substring(0, 4);
        Test t1 = new Test(votreChaine);
        t1.order();
        String votreChaine = "Bonjour";
        String[] parties = votreChaine.split("\n");
        System.out.println(votreChaine);
       // Instruction.MULI.split(\n);
       // split('\n');
    }  
}  */
