Min Max - Tic Tac Toe

import java.util.*;

class Main {
 public static ArrayList<State> states = new ArrayList<State>();
 public static char turnval = 'X', blank = ' ';
 public static void main(String[] args) {
   Main.minmax();
   Main.backtrack();
 }

 public static void minmax(){
   states.add(new State(new char[]{'O', blank, 'X', blank, blank, 'X', 'X', 'O', 'O'}, -1, 0));
   for(int j=0;j<9;j++){
     if(j%3==0)
       System.out.println();
     System.out.print(states.get(states.size()-1).a[j]+" ");
   }
   System.out.println("\n\n");


   int l=1;
   int noOfBlanks = 3;
   int newNoOfBlanks=0;
   int count = noOfBlanks;
   for(int node=0; node<states.size(); node++){
     if(states.get(node).cost == 0){
       for(int i=0;i<9;i++){
         if(states.get(node).a[i]==blank){
           count--;
          
           char tempArray[] = new char[9];
           for(int j=0;j<9;j++){
             tempArray[j] = states.get(node).a[j];
           }

           tempArray[i] = turnval;

           State s = new State(tempArray, node, states.get(node).level+1);

           if(checkwin(s, turnval)){
             if(turnval =='X'){
               s.cost = 10;
             }
             else{
               s.cost = -10;
             }
           }
           else{
             newNoOfBlanks = newNoOfBlanks + (noOfBlanks-1);
           }
           states.add(s);

          
           System.out.print("\n"+turnval+" "+ node);
           for(int j=0;j<9;j++){
             if(j%3==0)
               System.out.println();
             System.out.print(states.get(states.size()-1).a[j]+" ");
           }
           System.out.print("\n "+states.get(states.size()-1).parent+" "+states.get(states.size()-1).level+" \n");
         }
       }
       System.out.println("\n\n");
      
     }
     if(count==0){
       if(turnval == 'X'){
           turnval = 'O';
       }
       else{
           turnval = 'X';
       }
       noOfBlanks = newNoOfBlanks;
       newNoOfBlanks = 0;
       count = noOfBlanks;
     }
   }

 }

 public static boolean checkwin(State s, char turn){
   char temp[] = s.a;
   if((temp[0]==turn && temp[3]==turn && temp[6]==turn) || (temp[1]==turn && temp[4]==turn && temp[7]==turn) || (temp[2]==turn && temp[5]==turn && temp[8]==turn) || (temp[0]==turn && temp[4]==turn && temp[8]==turn) || (temp[2]==turn && temp[4]==turn && temp[6]==turn) || (temp[0]==turn && temp[1]==turn && temp[2]==turn) || (temp[3]==turn && temp[4]==turn && temp[5]==turn) || (temp[6]==turn && temp[7]==turn && temp[8]==turn)){
     return true;
   }
   return false;
 }

 public static void backtrack(){
   int i=states.size()-1;
   while(i>0){
     int par = states.get(i).parent;
     int turn = states.get(i).level%2;
     ArrayList<Integer> tempStates = new ArrayList<>();
     while(states.get(i).parent == par){
       tempStates.add(states.get(i).cost);
       i--;
     }
     int newCost=0;
     if(turn==1){
       newCost = Collections.max(tempStates);
     }
     else{
       newCost = Collections.min(tempStates);
     }
     states.get(par).cost = newCost;
   }
   System.out.println(states.get(0).cost);
 }

}

class State{
 char a[]= new char[9];
 int parent, cost, level;
 public State(char a[], int parent, int level){
   this.a = a;
   this.parent = parent;
   this.cost = 0;
   this.level = level;
 }
}
