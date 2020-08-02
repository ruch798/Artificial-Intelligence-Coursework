Genetic Algorithm

a. 0/1 Knapsack

import java.util.*;

class Main {
 private static int max = 10;
 private static ArrayList<Item> items = new ArrayList<>();
 private static ArrayList<Entry> list = new ArrayList<>();
 public static void main(String[] args) {
   problem();
   initialize();
   selection();
   crossover();
   mutation();
   check();
 }

 static void print(){
   for(int i=0;i<list.size();i++){
     for(int j=0;j<5;j++){
       System.out.print(list.get(i).bin[j]+" ");
     }
     System.out.println("  Weight: "+list.get(i).weight+"  Cost: "+list.get(i).cost);
   }
   System.out.println();
 }

 static void problem(){
   items.add(new Item(2,10));
   items.add(new Item(3,20));
   items.add(new Item(4,20));
   items.add(new Item(2,15));
   items.add(new Item(4,30));
 }

 static void initialize(){
   System.out.println("INITIAL POPULATION");
   Random r = new Random();
   for(int i=0;i<6;i++){
     int temp[] = new int[5];
     int cost=0;
     int weight=0;
     for(int j=0;j<5;j++){
       temp[j] = r.nextInt(2);
       if(temp[j] == 1){
         cost = cost + items.get(j).cost;
         weight = weight + items.get(j).weight;
       }
     }
     list.add(new Entry(temp,cost,weight));
   }
   for(int i=0;i<list.size();i++){
     for(int j=0;j<5;j++){
       System.out.print(list.get(i).bin[j]+" ");
     }
     System.out.println();
   }
   System.out.println();
 }

 static void selection(){
   System.out.println("SELECTION");
   print();
   for(int i=0;i<list.size();i++){
     if(list.get(i).cost<=15){
       list.remove(i);
       i--;
     }
   }
   list.sort(Comparator.comparingInt(Entry :: getCost).reversed());
   print();
 }

 static void crossover(){
   System.out.println("CROSSOVER");
   if(list.size()>=4){
     for(int i=4;i<list.size();i++){
       list.remove(i);
       i--;
     }
     int crossoverPoint = 5/2 + 1;
     for(int i=0;i<list.size();i=i+2){
       Entry upper = list.get(i);
       Entry lower = list.get(i+1);

       for(int j=crossoverPoint;j<5;j++){
         int temp = upper.bin[j];
         upper.bin[j] = lower.bin[j];
         lower.bin[j] = temp;
       }
     }
     cost();
     print();
   }
 }

 static void mutation(){
   System.out.println("MUTATION");
   Random r = new Random();
   for(int i=0;i<list.size();i++){
     list.get(i).bin[r.nextInt(5)] = r.nextInt(2);
   }
   cost();
   print();
 }

 static void cost(){
   for(int i=0;i<list.size();i++){
     list.get(i).cost = 0;
     list.get(i).weight = 0;
     for(int j=0;j<5;j++){
       if(list.get(i).bin[j]==1){
         list.get(i).cost = list.get(i).cost + items.get(j).cost;
         list.get(i).weight = list.get(i).weight + items.get(j).weight;
       }
     }
   }
 }

 static void check(){
   int found=-1;
   list.sort(Comparator.comparingInt(Entry :: getCost).reversed());
   for(int i=0;i<list.size();i++){
     if(list.get(i).weight<=max){
       found = i;
       break;
     }
   }
   if(found!=-1){
     System.out.println("\nSolution after 1st generation is: ");
     for(int j=0;j<5;j++){
       System.out.print(list.get(found).bin[j]+" ");
     }
     System.out.println("\nWeight= "+list.get(found).weight);
     System.out.println("Cost= "+list.get(found).cost);
   }
   else{
     System.out.println("\nNo solution found after 1st generation");
   }

 }
}

class Item{
 int weight;
 int cost;
 public Item(int weight, int cost){
   this.weight = weight;
   this.cost = cost;
 }
}

class Entry{
 int bin[];
 int weight;
 int cost;
 public Entry(int bin[], int cost, int weight){
   this.bin = bin;
   this.cost = cost;
   this.weight = weight;
 }
 int getCost(){
   return this.cost;
 }
}


b. Graph Colouring

import java.util.*;

class Main {
 private static int graph[][] = new int[4][4];
 private static ArrayList<Entry> list = new ArrayList<>();
 public static void main(String[] args) {
   problem();
   initialize();
   selection();
   crossover();
   mutation();
   check();
 }

 static void problem(){
   graph[0][0] = 0;
   graph[0][1] = 1;
   graph[0][2] = 1;
   graph[0][3] = 1;
   graph[1][0] = 1;
   graph[1][1] = 0;
   graph[1][2] = 1;
   graph[1][3] = 0;
   graph[2][0] = 1;
   graph[2][1] = 1;
   graph[2][2] = 0;
   graph[2][3] = 1;
   graph[3][0] = 1;
   graph[3][1] = 0;
   graph[3][2] = 1;
   graph[3][3] = 0;
 }

 static void print(){
   for(int i=0;i<list.size();i++){
     for(int j=0;j<4;j++){
       System.out.print(list.get(i).bin[j]+" ");
     }
     System.out.println("  Cost: "+list.get(i).cost);
   }
   System.out.println();
 }

 static void initialize(){
   System.out.println("INITIAL POPULATION");
   Random r = new Random();
   for(int i=0;i<6;i++){
     int temp[] = new int[4];
     for(int j=0;j<4;j++){
       temp[j] = r.nextInt(3)+1;
     }
     list.add(new Entry(temp));
   }
   cost();
   for(int i=0;i<list.size();i++){
     for(int j=0;j<4;j++){
       System.out.print(list.get(i).bin[j]+" ");
     }
     System.out.println();
   }
   System.out.println();
 }

 static void selection(){
   System.out.println("SELECTION");
   print();
   for(int i=0;i<list.size();i++){
     if(list.get(i).cost>=4){
       list.remove(i);
       i--;
     }
   }
   list.sort(Comparator.comparingInt(Entry :: getCost));
   print();
 }

 static void crossover(){
   System.out.println("CROSSOVER");
   if(list.size()>=4){
     for(int i=4;i<list.size();i++){
       list.remove(i);
       i--;
     }
     int crossoverPoint = 4/2;
     for(int i=0;i<list.size();i=i+2){
       Entry upper = list.get(i);
       Entry lower = list.get(i+1);

       for(int j=crossoverPoint;j<4;j++){
         int temp = upper.bin[j];
         upper.bin[j] = lower.bin[j];
         lower.bin[j] = temp;
       }
     }
     cost();
     print();
   }
 }

 static void mutation(){
   System.out.println("MUTATION");
   Random r = new Random();
   for(int i=0;i<list.size();i++){
     list.get(i).bin[r.nextInt(4)] = r.nextInt(3)+1;
   }
   cost();
   print();
 }

 static void cost(){
   for(int i=0;i<list.size();i++){
     list.get(i).cost = 0;
     for(int j=0;j<4;j++){
       for(int k=j+1;k<4;k++){
         if(graph[j][k]==1&&(list.get(i).bin[j]==list.get(i).bin[k])){
           list.get(i).cost++;
       }
     }
   }
   }
 }

 static void check(){
   int found=-1;
   for(int i=0;i<list.size();i++){
     if(list.get(i).cost==0){
       found = i;
       break;
     }
   }
   if(found!=-1){
     System.out.println("\nSolution after 1st generation is: ");
     for(int j=0;j<4;j++){
       System.out.print(list.get(found).bin[j]+" ");
     }
   }
   else{
     System.out.println("\nNo solution found after 1st generation");
   }

 }
}

class Entry{
 int bin[];
 int cost;
 public Entry(int bin[]){
   this.bin = bin;
 }
 public Entry(int bin[], int cost){
   this.bin = bin;
   this.cost = cost;
 }
 int getCost(){
   return this.cost;
 }
}















c. 8 Queens

import java.util.*;

class Main {
 private static ArrayList<Entry> list = new ArrayList<>();
 public static void main(String[] args) {
   initialize();
   selection();
   crossover();
   mutation();
   check();
 }

 static void print(){
   for(int i=0;i<list.size();i++){
     for(int j=0;j<8;j++){
       System.out.print(list.get(i).bin[j]+" ");
     }
     System.out.println("  Cost: "+list.get(i).cost);
   }
   System.out.println();
 }

 static void initialize(){
   System.out.println("INITIAL POPULATION");
   Random r = new Random();
   for(int i=0;i<6;i++){
     int temp[] = new int[8];
     int cost=0;
     //int weight=0;
     for(int j=0;j<8;j++){
       temp[j] = r.nextInt(8);
     }
     list.add(new Entry(temp));
   }
   cost();
   for(int i=0;i<list.size();i++){
     for(int j=0;j<8;j++){
       System.out.print(list.get(i).bin[j]+" ");
     }
     System.out.println();
   }
   System.out.println();
 }

 static void selection(){
   System.out.println("SELECTION");
   print();
   for(int i=0;i<list.size();i++){
     if(list.get(i).cost>=10){
       list.remove(i);
       i--;
     }
   }
   list.sort(Comparator.comparingInt(Entry :: getCost));
   print();
 }

 static void crossover(){
   System.out.println("CROSSOVER");
   if(list.size()>=4){
     for(int i=4;i<list.size();i++){
       list.remove(i);
       i--;
     }
     int crossoverPoint = 8/2;
     for(int i=0;i<list.size();i=i+2){
       Entry upper = list.get(i);
       Entry lower = list.get(i+1);

       for(int j=crossoverPoint;j<8;j++){
         int temp = upper.bin[j];
         upper.bin[j] = lower.bin[j];
         lower.bin[j] = temp;
       }
     }
     cost();
     print();
   }
 }

 static void mutation(){
   System.out.println("MUTATION");
   Random r = new Random();
   for(int i=0;i<list.size();i++){
     list.get(i).bin[r.nextInt(8)] = r.nextInt(8);
   }
   cost();
   print();
 }

 static void cost(){
   for(int i=0;i<list.size();i++){
     list.get(i).cost = 0;
     for(int j=0;j<8;j++){
       for(int k=j+1;k<8;k++){
         if((list.get(i).bin[j]==list.get(i).bin[k])||((k-j)==Math.abs(list.get(i).bin[k]-list.get(i).bin[j]))){
           list.get(i).cost++;
       }
     }
   }
   }
 }

 static void check(){
   int found=-1;
   for(int i=0;i<list.size();i++){
     if(list.get(i).cost==0){
       found = i;
       break;
     }
   }
   if(found!=-1){
     System.out.println("\nSolution after 1st generation is: ");
     for(int j=0;j<8;j++){
       System.out.print(list.get(found).bin[j]+" ");
     }
   }
   else{
     System.out.println("\nNo solution found after 1st generation");
   }

 }
}

class Entry{
 int bin[];
 int cost;
 public Entry(int bin[]){
   this.bin = bin;
 }
 public Entry(int bin[], int cost){
   this.bin = bin;
   this.cost = cost;
 }
 int getCost(){
   return this.cost;
 }
}

















d. Travelling Salesman Problem

import java.util.*;

class Main {
 private static int graph[][] = new int[4][4];
 private static ArrayList<Entry> list = new ArrayList<>();
 public static void main(String[] args) {
   problem();
   initialize();
   selection();
   crossover();
   mutation();
   check();
 }

 static void problem(){
   graph[0][0] = 0;
   graph[0][1] = 10;
   graph[0][2] = 30;
   graph[0][3] = 20;
   graph[1][0] = 10;
   graph[1][1] = 0;
   graph[1][2] = 20;
   graph[1][3] = 40;
   graph[2][0] = 30;
   graph[2][1] = 20;
   graph[2][2] = 0;
   graph[2][3] = 10;
   graph[3][0] = 20;
   graph[3][1] = 40;
   graph[3][2] = 10;
   graph[3][3] = 0;
 }

 static void print(){
   for(int i=0;i<list.size();i++){
     for(int j=0;j<5;j++){
       System.out.print(list.get(i).bin[j]+" ");
     }
     System.out.println("  Cost: "+list.get(i).cost);
   }
   System.out.println();
 }

 static void initialize(){
   System.out.println("INITIAL POPULATION");
   Random r = new Random();
   for(int i=0;i<6;i++){
     int temp[] = new int[5];
     for(int j=0;j<4;j++){
       temp[j] = r.nextInt(4);
     }
     temp[4] = temp[0];
     list.add(new Entry(temp));
   }
   cost();
   for(int i=0;i<list.size();i++){
     for(int j=0;j<5;j++){
       System.out.print(list.get(i).bin[j]+" ");
     }
     System.out.println();
   }
   System.out.println();
 }

 static void selection(){
   System.out.println("SELECTION");
   print();
   for(int i=0;i<list.size();i++){
     if(list.get(i).cost>=100){
       list.remove(i);
       i--;
     }
   }
   list.sort(Comparator.comparingInt(Entry :: getCost));
   print();
 }

 static void crossover(){
   System.out.println("CROSSOVER");
   if(list.size()>=4){
     for(int i=4;i<list.size();i++){
       list.remove(i);
       i--;
     }
     int crossoverPoint = 5/2+1;
     for(int i=0;i<list.size();i=i+2){
       Entry upper = list.get(i);
       Entry lower = list.get(i+1);

       for(int j=crossoverPoint;j<5;j++){
         int temp = upper.bin[j];
         upper.bin[j] = lower.bin[j];
         lower.bin[j] = temp;
       }
     }
     cost();
     print();
   }
 }

 static void mutation(){
   System.out.println("MUTATION");
   Random r = new Random();
   for(int i=0;i<list.size();i++){
     list.get(i).bin[r.nextInt(5)] = r.nextInt(4);
   }
   cost();
   print();
 }

 static void cost(){
   for(int i=0;i<list.size();i++){
     list.get(i).cost = 0;
     for(int j=0;j<4;j++){
       int k = j+1;
       if(graph[list.get(i).bin[j]][list.get(i).bin[k]]!=0){
         list.get(i).cost = list.get(i).cost + graph[list.get(i).bin[j]][list.get(i).bin[k]];
       }
     }
   }
 }

 static void check(){
   int found=-1;
   list.sort(Comparator.comparingInt(Entry :: getCost));
   for(int i=0;i<list.size();i++){
     int temp[] = new int[4];
     int flag=0;
     for(int j=0;j<4;j++){
       if( temp[list.get(i).bin[j]]==0){
         temp[list.get(i).bin[j]]=1;
       }
       else{
         flag=1;
         break;
       }
     }
     if(flag==0 && list.get(i).bin[0]==list.get(i).bin[4]){
       found = i;
       break;
     }
   }
   if(found!=-1){
     System.out.println("\nSolution after 1st generation is: ");
     for(int j=0;j<4;j++){
       System.out.print(list.get(found).bin[j]+" ");
     }
   }
   else{
     System.out.println("\nNo solution found after 1st generation");
   }

 }
}

class Entry{
 int bin[];
 int cost;
 public Entry(int bin[]){
   this.bin = bin;
 }
 public Entry(int bin[], int cost){
   this.bin = bin;
   this.cost = cost;
 }
 int getCost(){
   return this.cost;
 }
}
