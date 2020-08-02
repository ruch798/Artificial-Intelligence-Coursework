Informed Search

a.  8 Puzzle

import java.util.*;

class Main {
 public static ArrayList<State> states = new ArrayList<>();
 public static ArrayList<AstarObject> visited = new ArrayList<>();
 public static ArrayList<gbfsObject> visited2 = new ArrayList<>();
 public static ArrayList<State> path = new ArrayList<>();
 public static int counter = 0;
 public static int max=21;
 public static int depth = 0;
  public static State initialState = new State(new int[]{1,2,3,4,5,6,7,8,0},0);
  public static State finalState = new State(new int[]{1,2,3,4,0,5,7,8,6});
 public static State end = new State(new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1});
 public static void main(String[] args) {   
   System.out.print("\nINITIAL STATE:");
   for(int j=0;j<9;j++){
     if(j==0||j==3||j==6){
       System.out.println();
     }
     System.out.print(initialState.pos[j]+" ");
   }
   System.out.print("\n\nGOAL STATE:");
   for(int j=0;j<9;j++){
     if(j==0||j==3||j==6){
       System.out.println();
     }
     System.out.print(finalState.pos[j]+" ");
   }
   states.add(initialState);
   expand();
   int i=0;
   while(i<states.size()){
     System.out.println("\n\nLevel "+states.get(i).level);
     if(i==0){
       State st = states.get(i);
       for(int j=0;j<9;j++){
         if(j==0||j==3||j==6){
           System.out.println();
         }
         if(j==0){
           System.out.println(i + " cost="+st.f);
         }
         System.out.print(st.pos[j]+" ");
       }
       i++;
     }
     else{
       for(int k=0;k<4;k++){
       State st = states.get(i);
         for(int j=0;j<9;j++){
           if(j==0||j==3||j==6){
             System.out.println();
           }
           if(j==0){
             System.out.println(i + " cost="+st.h);
           }
           System.out.print(st.pos[j]+" ");
         }
       i++;
       System.out.println();
     }
     }
   }
   gbfs();
   astar();
 }

 static void expand(){
   while(counter<max){
     left(states.get(counter));
     right(states.get(counter));
     up(states.get(counter));
     down(states.get(counter));
     counter++;
   }
 }

 static void left(State state){
   State tempState = new State(state.pos, state.level+1);
   int found=-1;
   int f=0;
   for(int i=0;i<9;i++){
     if(tempState.pos[i]==0){
       found = i;
       break;
     }
   }
   if(found%3!=0&&found!=-1){
     int tempPos[] = new int[9];
     for(int j=0;j<9;j++){
       tempPos[j] = tempState.pos[j];
     }
     int t = tempPos[found];
     tempPos[found] = tempPos[found-1];
     tempPos[found-1] = t;
     tempState.pos = tempPos;
     for(int k=0;k<states.size();k++){
       if(Arrays.equals(states.get(k).pos, tempState.pos)){
         f=1;
       }
     }
     if(f==0){
       tempState.h = countMisplaced(tempState);
       tempState.f = tempState.h + tempState.level;
       states.add(tempState);
     }
     else{
       tempPos = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
       tempState.pos = tempPos;
       tempState.h = 999;
       tempState.f = 999;
       states.add(tempState);
     }
   }
   else{
     int tempPos[] = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
     tempState.pos = tempPos;
     tempState.h = 999;
     tempState.f = 999;
     states.add(tempState);
   }
 }

 static void right(State state){
   State tempState = new State(state.pos, state.level+1);
   int found=-1;
   int f=0;
   for(int i=0;i<9;i++){
     if(tempState.pos[i]==0){
       found = i;
       break;
     }
   }
   if(found%3!=2&&found!=-1){
     int tempPos[] = new int[9];
     for(int j=0;j<9;j++){
       tempPos[j] = tempState.pos[j];
     }
     int t = tempPos[found];
     tempPos[found] = tempPos[found+1];
     tempPos[found+1] = t;
     tempState.pos = tempPos;
     for(int k=0;k<states.size();k++){
       if(Arrays.equals(states.get(k).pos, tempState.pos)){
         f=1;
       }
     }
     if(f==0){
       tempState.h = countMisplaced(tempState);
       tempState.f = tempState.h + tempState.level;
       states.add(tempState);
     }
     else{
       tempPos = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
       tempState.pos = tempPos;
       tempState.h = 999;
       tempState.f = 999;
       states.add(tempState);
     }
   }
   else{
     int tempPos[] = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
     tempState.pos = tempPos;
     tempState.h = 999;
     tempState.f = 999;
     states.add(tempState);
   }
 }

  static void up(State state){
   State tempState = new State(state.pos, state.level+1);
   int found=-1;
   int f=0;
   for(int i=0;i<9;i++){
     if(tempState.pos[i]==0){
       found = i;
       break;
     }
   }
   if(found>2&&found!=-1){
     int tempPos[] = new int[9];
     for(int j=0;j<9;j++){
       tempPos[j] = tempState.pos[j];
     }
     int t = tempPos[found];
     tempPos[found] = tempPos[found-3];
     tempPos[found-3] = t;
     tempState.pos = tempPos;
     for(int k=0;k<states.size();k++){
       if(Arrays.equals(states.get(k).pos, tempState.pos)){
         f=1;
       }
     }
     if(f==0){
       tempState.h = countMisplaced(tempState);
       tempState.f = tempState.h + tempState.level;
       states.add(tempState);
     }
     else{
       tempPos = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
       tempState.pos = tempPos;
       tempState.h = 999;
       tempState.f = 999;
       states.add(tempState);
     }
   }
   else{
     int tempPos[] = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
     tempState.pos = tempPos;
     tempState.h = 999;
     tempState.f = 999;
     states.add(tempState);
   }
 }

  static void down(State state){
   State tempState = new State(state.pos, state.level+1);
   int found=-1;
   int f=0;
   for(int i=0;i<9;i++){
     if(tempState.pos[i]==0){
       found = i;
       break;
     }
   }
   if(found<6&&found!=-1){
     int tempPos[] = new int[9];
     for(int j=0;j<9;j++){
       tempPos[j] = tempState.pos[j];
     }
     int t = tempPos[found];
     tempPos[found] = tempPos[found+3];
     tempPos[found+3] = t;
     tempState.pos = tempPos;
     for(int k=0;k<states.size();k++){
       if(Arrays.equals(states.get(k).pos, tempState.pos)){
         f=1;
       }
     }
     if(f==0){
       tempState.h = countMisplaced(tempState);
       tempState.f = tempState.h + tempState.level;
       states.add(tempState);
     }
     else{
       tempPos = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
       tempState.pos = tempPos;
       tempState.h = 999;
       tempState.f = 999;
       states.add(tempState);
     }
   }
   else{
     int tempPos[] = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
     tempState.pos = tempPos;
     tempState.h = 999;
     tempState.f = 999;
     states.add(tempState);
   }
 }

 static void gbfs(){    //check if it is the goal state when we expand it
   int posi=0;
   int found=0;
   visited2.add(new gbfsObject(0,states.get(0).h));
   int top=0;
   StringBuffer sb = new StringBuffer();
   System.out.println("\nGBFS");
   //System.out.print("PATH: ");
   while(found==0){
     top = visited2.get(0).index;
     sb.append(top+" ");
     if(!(Arrays.equals(states.get(top).pos,end.pos))&&top<max){
       if(Arrays.equals(states.get(top).pos, finalState.pos)){
         found=1;
         break;
       }
       visited2.remove(0);
       posi = top*4+1;
       for(int i=3;i>=0;i--){
         if(!(Arrays.equals(states.get(posi+i).pos,end.pos))){
           visited2.add(new gbfsObject(posi+i,states.get(posi+i).h));
         }
       }
       visited2.sort(Comparator.comparingInt(gbfsObject :: getCost));
     }
     else{
       visited2.remove(0);
     }
     if(visited2.size()==0){
       break;
     }
   }
   if(found==1){
     System.out.print("PATH: "+sb);
     System.out.println("\nFOUND AT: "+top);
   }
   else{
     System.out.println("No solution found!");
   }
 }

 static void astar(){    //check if it is the goal state when we expand it
   int posi=0;
   int found=0;
   visited.add(new AstarObject(0,states.get(0).f));
   int top=0;
   StringBuffer sb = new StringBuffer();
   System.out.println("\nA*");
   //System.out.print("PATH: ");
   while(found==0){
     top = visited.get(0).index;
     sb.append(top+" ");
     if(!(Arrays.equals(states.get(top).pos,end.pos))&&top<max){
       if(Arrays.equals(states.get(top).pos, finalState.pos)){
         found=1;
         break;
       }
       visited.remove(0);
       posi = top*4+1;
       for(int i=3;i>=0;i--){
         if(!(Arrays.equals(states.get(posi+i).pos,end.pos))){
           visited.add(new AstarObject(posi+i,states.get(posi+i).f));
         }
       }
       visited.sort(Comparator.comparingInt(AstarObject :: getCost));
     }
     else{
       visited.remove(0);
     }
     if(visited.size()==0){
       break;
     }
   }
   if(found==1){
     System.out.print("PATH: "+sb);
     System.out.println("\nFOUND AT: "+top);
   }
   else{
     System.out.println("No solution found!");
   }
 }

 static int countMisplaced(State st){
   int count = 0;
   for(int i=0;i<9;i++){
     if(st.pos[i]!=finalState.pos[i]){
       count++;
     }
   }
   return count;
 }
}

class State{
 int pos[] = new int[9];
 int level;
 int h;
 int f;
 public State(int pos[]){
   this.pos = pos;
 }
 public State(int pos[], int level){
   this.pos = pos;
   this.level = level;
 }
}

class AstarObject{
 int index;
 int cost;
 public AstarObject(int index, int cost){
   this.index = index;
   this.cost = cost;
 }
 int getCost(){
   return this.cost;
 }
}

class gbfsObject{
 int index;
 int cost;
 public gbfsObject(int index, int cost){
   this.index = index;
   this.cost = cost;
 }
 int getCost(){
   return this.cost;
 }
}


b. Map Exploration

import java.util.*;

class Main {
 private static ArrayList<City> cities= new ArrayList<>();
 private static ArrayList<Distance> distances= new ArrayList<>();
 private static ArrayList<State> states= new ArrayList<>();
 private static ArrayList<State> tree= new ArrayList<>();
 static int count=0;
 static int max=10;
 static int start = 0;
 static int end = 7;
 public static void main(String[] args) {
   cities.add(new City("Thane",50));
   cities.add(new City("Mulund",45));
   cities.add(new City("Borivali",30));
   cities.add(new City("Nahur",45));
   cities.add(new City("Dadar",20));
   cities.add(new City("Ghatkopar",30));
   cities.add(new City("Byculla",5));
   cities.add(new City("CST",0));
   distances.add(new Distance(0,1,10));
   distances.add(new Distance(0,2,30));
   distances.add(new Distance(1,3,10));
   distances.add(new Distance(3,5,20));
   distances.add(new Distance(2,4,20));
   distances.add(new Distance(4,5,20));
   distances.add(new Distance(4,7,10));
   //distances.add(new Distance(5,7,15));
   distances.add(new Distance(2,6,20));
   distances.add(new Distance(6,7,5));
   int l=0;
   states.add(new State(start,0,l,0));
   tree.add(new State(start,0,l,0));
   State curr;
   while(count<max){
     int flag=0,flag2=0;
     curr = states.get(0);
     l = states.get(0).level+1;
     //System.out.println(l);
     for(int i=0;i<distances.size();i++){
       if(distances.get(i).city1==curr.city){
         for(int j=0;j<tree.size();j++){
           if(tree.get(j).city==distances.get(i).city2&&tree.get(j).level<l){
             flag=1;
             break;
           }
         }
         if(flag==0||distances.get(i).city2==end){
          //if(!states.contains(distances.get(i).city2)){
           states.add(new State(distances.get(i).city2,curr.city,l,distances.get(i).cost+curr.g));
           System.out.println(i+ " " +(distances.get(i).cost+curr.g));
           tree.add(new State(distances.get(i).city2, curr.city,l,distances.get(i).cost+curr.g));
          //}
         }
       }
       else if(distances.get(i).city2==curr.city){
         for(int j=0;j<tree.size();j++){
           if(tree.get(j).city==distances.get(i).city1&&tree.get(j).level<l){
             flag2=1;
             break;
           }
         }
         if(flag2==0||distances.get(i).city1==end){
          //if(!states.contains(distances.get(i).city2)){
           states.add(new State(distances.get(i).city1,curr.city,l,distances.get(i).cost+curr.g));
           tree.add(new State(distances.get(i).city1,curr.city,l,distances.get(i).cost+curr.g));
         //}
         }
        }
     }
     //System.out.println("\ncount:"+count);
    
     states.remove(0);
     count++;
   }
   for(int i=0;i<tree.size();i++){
       if(i==0){
         System.out.println("\nLevel 0");
       }
       else if(tree.get(i-1).level!=tree.get(i).level){
         System.out.println("\nLevel "+tree.get(i).level);
       }
       System.out.println(i+" "+cities.get(tree.get(i).parent).name+"-->"+cities.get(tree.get(i).city).name+" "+tree.get(i).g);
     }
     gbfs();
     astar();
 }

 static void gbfs(){
   StringBuffer sb = new StringBuffer();
   int location=-1;
   int found = 0;
   ArrayList<State> temp = new ArrayList<>();
   ArrayList<State> visited = new ArrayList<>();
   visited.add(tree.get(0));
   System.out.println("\nGBFS:");
   for(int i=0;i<tree.size();i++){
     temp = new ArrayList<>();
     if(visited.size()==0){
         continue;
     }
     State curr = visited.get(0);
     if(i==0){
       i++;
     }
     if(curr.city==end){
      
       sb.append(i);
       found=1;
       location=i;
       break;
     }
     else{
         while(i!=0&&(tree.get(i).parent==curr.city)){
           State s = tree.get(i);
           if(s.city==end){
             sb.append(i);
             found=1;
             location=i;
             break;
           }
           s.h = cities.get(s.city).h;  
           temp.add(s);
           i++;
         }
         if(found==1){
           break;
         }
         if(temp.size()==0){
           continue;
         }
        
         sb.append(curr.city+" ");
         visited.remove(0);
       temp.sort(Comparator.comparingInt(State :: getHeuristic));
       visited.add(temp.get(0));
     }
     if(visited.size()==0){
       break;
     }
   }
   if(found==1){
     System.out.println("Found at "+location);
     System.out.println("PATH:"+sb);
   }
   else{
     System.out.println("Not found");
   }
 }

 static void astar(){
   StringBuffer sb = new StringBuffer();
   int location=-1;
   int found = 0;
   ArrayList<State> temp = new ArrayList<>();
   ArrayList<State> visited = new ArrayList<>();
   visited.add(tree.get(0));
   System.out.println("\nA*:");
   for(int i=0;i<tree.size();i++){
     temp = new ArrayList<>();
     if(visited.size()==0){
         continue;
     }
     State curr = visited.get(0);
     System.out.println("Current: "+cities.get(curr.city).name);
     visited.remove(0);
     if(i==0){
       i++;
     }
     if(curr.city==end){
       sb.append(i);
       found=1;
       location=i;
       break;
     }
     else{
         while(i!=0&&(tree.get(i).parent==curr.city)){
           System.out.println("i is "+i);
           State s = tree.get(i);
           if(s.city==end){
             sb.append(i);
             found=1;
             location=i;
             break;
           }
           s.h = cities.get(s.city).h;
           s.f = s.g + s.h;
           System.out.println("City: "+cities.get(s.city).name+"Cost: "+s.f); 
           visited.add(s);
           visited.sort(Comparator.comparingInt(State :: getCost));
           i++;
         }
         i--;
         if(found==1){
           break;
         }
         if(visited.size()==0){
           continue;
         }
       sb.append(curr.city+" ");
       //System.out.println("City: "+cities.get(visited.get(0).city).name+"Cost: "+visited.get(0).f);
     }
     if(visited.size()==0){
       break;
     }
   }
   if(found==1){
     System.out.println("Found at "+location);
     System.out.println("PATH:"+sb);
   }
   else{
     System.out.println("Not found");
   }
 }
}


class Distance{
 int city1;
 int city2;
 int cost;
 public Distance(int city1, int city2, int cost){
   this.city1 = city1;
   this.city2 = city2;
   this.cost = cost;
 }
}
class City{
 String name;
 int h;
 public City(String name, int h){
   this.name = name;
   this.h = h;
 }
}

class State{
 int city;
 int level;
 int parent;
 int f;
 int g;
 int h;
 public State(int city, int parent, int level){
   this.city = city;
   this.level = level;
   this.parent = parent;
 }
  public State(int city, int parent, int level, int g){
   this.city = city;
   this.level = level;
   this.parent = parent;
   this.g = g;
 }
 int getHeuristic(){
   return this.h;
 }
  int getCost(){
   return this.f;
 }
}


c. Blocks World

import java.util.*;

class Main {
 private static ArrayList<State> states = new ArrayList<>();
 private static State finalState;
 public static void main(String[] args) {
   ArrayList<Integer> temp1 = new ArrayList<>();
   temp1.add(-1);
   ArrayList<Integer> temp2 = new ArrayList<>();
   temp2.add(-1);
   temp2.add(2);
   temp2.add(1);
   temp2.add(3);
   ArrayList<Integer> temp3 = new ArrayList<>();
   temp3.add(-1);
   finalState = new State(temp1, temp2, temp3, 0, 0, 0);
   temp1 = new ArrayList<>();
   temp1.add(-1);
   temp2 = new ArrayList<>();
   temp2.add(-1);
   temp2.add(1);
   temp2.add(2);
   temp3 = new ArrayList<>();
   temp3.add(-1);
   temp3.add(3);
   states.add(new State(temp1, temp2, temp3, 0, 0, -1));
   getHeuristic(states.get(0));
   for(int i=0;i<1000;i++){
     if(states.size()>i){
       // System.out.println(i);
       // System.out.println(states.get(i).one+" "+states.get(i).two+ " " + states.get(i).three);
       // System.out.println(states.get(i).g+" "+states.get(i).h);
       // System.out.println();
       shift(states.get(i));
     }
   }

   System.out.println("DONE");
   // for(int i=0;i<states.size();i++){
   //   System.out.println(states.get(i).g+" "+states.get(i).h);
   // }
  
 }

 static void shift(State s){
   ArrayList<Integer> temp1;
   ArrayList<Integer> temp2;
   ArrayList<Integer> temp3;
   if(s.one.get(s.one.size()-1)!=-1){
     temp1 = new ArrayList<>();
     for(int j=0;j<s.one.size();j++){
       temp1.add(s.one.get(j));
     }
     temp2 = new ArrayList<>();
     for(int j=0;j<s.two.size();j++){
       temp2.add(s.two.get(j));
     }
     temp3 = new ArrayList<>();
     for(int j=0;j<s.three.size();j++){
       temp3.add(s.three.get(j));
     }
     temp2.add(s.one.get(s.one.size()-1));
     temp1.remove(s.one.get(s.one.size()-1));
     int flag=0;
     for(int i=0;i<states.size();i++){
       if((states.get(i).one.equals(temp1))&&(states.get(i).two.equals(temp2))&&(states.get(i).three.equals(temp3))){
         flag=1;
       }
     }
     if(flag==0){
       states.add(new State(temp1, temp2, temp3, (s.g+1),0, states.indexOf(s)));
       getHeuristic(states.get(states.size()-1));
       check(states.get(states.size()-1));
     }

     temp1 = new ArrayList<>();
     for(int j=0;j<s.one.size();j++){
       temp1.add(s.one.get(j));
     }
     temp2 = new ArrayList<>();
     for(int j=0;j<s.two.size();j++){
       temp2.add(s.two.get(j));
     }
     temp3 = new ArrayList<>();
     for(int j=0;j<s.three.size();j++){
       temp3.add(s.three.get(j));
     }
     temp3.add(s.one.get(s.one.size()-1));
     temp1.remove(s.one.get(s.one.size()-1));
    
     flag=0;
     for(int i=0;i<states.size();i++){
       if((states.get(i).one.equals(temp1))&&(states.get(i).two.equals(temp2))&&(states.get(i).three.equals(temp3))){
         flag=1;
       }
     }
     if(flag==0){
       states.add(new State(temp1, temp2, temp3, (s.g+1),0,states.indexOf(s)));
       getHeuristic(states.get(states.size()-1));
       check(states.get(states.size()-1));
     }
     
   }
   if(s.two.get(s.two.size()-1)!=-1){
     temp1 = new ArrayList<>();
     for(int j=0;j<s.one.size();j++){
       temp1.add(s.one.get(j));
     }
     temp2 = new ArrayList<>();
     for(int j=0;j<s.two.size();j++){
       temp2.add(s.two.get(j));
     }
     temp3 = new ArrayList<>();
     for(int j=0;j<s.three.size();j++){
       temp3.add(s.three.get(j));
     }
     temp1.add(s.two.get(s.two.size()-1));
     temp2.remove(s.two.get(s.two.size()-1));
     int flag=0;
     for(int i=0;i<states.size();i++){
       if((states.get(i).one.equals(temp1))&&(states.get(i).two.equals(temp2))&&(states.get(i).three.equals(temp3))){
         flag=1;
       }
     }
     if(flag==0){
       states.add(new State(temp1, temp2, temp3, (s.g+1),0, states.indexOf(s)));
       getHeuristic(states.get(states.size()-1));
       check(states.get(states.size()-1));
     }

     temp1 = new ArrayList<>();
     for(int j=0;j<s.one.size();j++){
       temp1.add(s.one.get(j));
     }
     temp2 = new ArrayList<>();
     for(int j=0;j<s.two.size();j++){
       temp2.add(s.two.get(j));
     }
     temp3 = new ArrayList<>();
     for(int j=0;j<s.three.size();j++){
       temp3.add(s.three.get(j));
     }
     temp3.add(s.two.get(s.two.size()-1));
     temp2.remove(s.two.get(s.two.size()-1));
    
     flag=0;
     for(int i=0;i<states.size();i++){
       if((states.get(i).one.equals(temp1))&&(states.get(i).two.equals(temp2))&&(states.get(i).three.equals(temp3))){
         flag=1;
       }
     }
     if(flag==0){
       states.add(new State(temp1, temp2, temp3, (s.g+1),0, states.indexOf(s)));
       getHeuristic(states.get(states.size()-1));
       check(states.get(states.size()-1));
     }
   }
   if(s.three.get(s.three.size()-1)!=-1){
     temp1 = new ArrayList<>();
     for(int j=0;j<s.one.size();j++){
       temp1.add(s.one.get(j));
     }
     temp2 = new ArrayList<>();
     for(int j=0;j<s.two.size();j++){
       temp2.add(s.two.get(j));
     }
     temp3 = new ArrayList<>();
     for(int j=0;j<s.three.size();j++){
       temp3.add(s.three.get(j));
     }
     temp1.add(s.three.get(s.three.size()-1));
     temp3.remove(s.three.get(s.three.size()-1));
    
     int flag=0;
     for(int i=0;i<states.size();i++){
       if((states.get(i).one.equals(temp1))&&(states.get(i).two.equals(temp2))&&(states.get(i).three.equals(temp3))){
         flag=1;
       }
     }
     if(flag==0){
       states.add(new State(temp1, temp2, temp3, (s.g+1),0, states.indexOf(s)));
       getHeuristic(states.get(states.size()-1));
       check(states.get(states.size()-1));
     }

    temp1 = new ArrayList<>();
     for(int j=0;j<s.one.size();j++){
       temp1.add(s.one.get(j));
     }
     temp2 = new ArrayList<>();
     for(int j=0;j<s.two.size();j++){
       temp2.add(s.two.get(j));
     }
     temp3 = new ArrayList<>();
     for(int j=0;j<s.three.size();j++){
       temp3.add(s.three.get(j));
     }
     temp2.add(s.three.get(s.three.size()-1));
     temp3.remove(s.three.get(s.three.size()-1));
     flag=0;
     for(int i=0;i<states.size();i++){
       if((states.get(i).one.equals(temp1))&&(states.get(i).two.equals(temp2))&&(states.get(i).three.equals(temp3))){
         flag=1;
       }
     }
     if(flag==0){
       states.add(new State(temp1, temp2, temp3, (s.g+1),0,states.indexOf(s)));
       getHeuristic(states.get(states.size()-1));
       check(states.get(states.size()-1));
     }
   }
  
  
 }

 static void check(State s){
   if(s.one.equals(finalState.one)&&s.two.equals(finalState.two)&&s.three.equals(finalState.three)){
     System.out.println("FOUND");
      System.out.println(s.one+" "+s.two+ " " + s.three);
       System.out.println(s.g+" "+s.h);
       System.out.println();
     System.exit(0);
   }
 }

 static void getHeuristic(State s){
   int h=0;
   for(int i=1;i<s.one.size();i++){
     if(i<finalState.one.size()){
       if(s.one.get(i-1)!=finalState.one.get(i-1)){
         h--;
         //System.out.println("Decrement 1");
       }
       else{
         h++;
         //System.out.println("Increment 1");
       }
     }
     else{
       h--;
       //System.out.println("Decrement 1");
     }
   }
   for(int i=1;i<s.two.size();i++){
     if(i<finalState.two.size()){
       if(s.two.get(i-1)!=finalState.two.get(i-1)){
         h--;
         //System.out.println("Decrement 2");
       }
       else{
         h++;
          //System.out.println("Increment 2");
       }
     }
     else{
       h--;
       //System.out.println("Decrement 2");
     }
   }
   for(int i=1;i<s.three.size();i++){
     if(i<finalState.three.size()){
       if(s.three.get(i-1)!=finalState.three.get(i-1)){
         h--;
         //System.out.println("Decrement 3");
       }
       else{
         h++;
          //System.out.println("Increment 3");
       }
     }
     else{
       h--;
       //System.out.println("Decrement 3");
     }
   }
   s.h = h;
   s.f = s.f + s.g;
 }
}

class State{
 ArrayList<Integer> one;
 ArrayList<Integer> two;
 ArrayList<Integer> three;
 int g;
 int h;
 int f;
 int parent;
 public State(ArrayList<Integer> one, ArrayList<Integer> two, ArrayList<Integer> three, int g, int h, int parent){
   this.one = one;
   this.two = two;
   this.three = three;
   this.g = g;
   this.h = h;
   this.parent = parent;
 }
}





