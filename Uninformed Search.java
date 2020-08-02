Uninformed Search

a. 8 Puzzle
import java.util.*;

class Main {
 public static ArrayList<State> states = new ArrayList<>();
 public static ArrayList<Integer> visited = new ArrayList<>();
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
           System.out.println(i);
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
             System.out.println(i);
           }
           System.out.print(st.pos[j]+" ");
         }
       i++;
       System.out.println();
     }
     }
   }
   bfs();
   dfs();
   dls();
   ids();
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
       states.add(tempState);
     }
     else{
       tempPos = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
       tempState.pos = tempPos;
       states.add(tempState);
     }
   }
   else{
     int tempPos[] = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
     tempState.pos = tempPos;
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
       states.add(tempState);
     }
     else{
       tempPos = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
       tempState.pos = tempPos;
       states.add(tempState);
     }
   }
   else{
     int tempPos[] = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
     tempState.pos = tempPos;
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
       states.add(tempState);
     }
     else{
       tempPos = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
       tempState.pos = tempPos;
       states.add(tempState);
     }
   }
   else{
     int tempPos[] = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
     tempState.pos = tempPos;
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
       states.add(tempState);
     }
     else{
       tempPos = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
       tempState.pos = tempPos;
       states.add(tempState);
     }
   }
   else{
     int tempPos[] = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
     tempState.pos = tempPos;
     states.add(tempState);
   }
 }

 static void bfs(){
   int posi=0;
   int found=0;
   visited = new ArrayList<>();
   visited.add(posi);
   int top=0;
   StringBuffer sb = new StringBuffer();
   System.out.println("\nBFS");
   //System.out.print("PATH: ");
   while(found==0){
     top = visited.get(0);
     sb.append(top+" ");
     if(top<max){//!(Arrays.equals(states.get(top).pos,end.pos))&&top<max){
       if(Arrays.equals(states.get(top).pos, finalState.pos)){
         found=1;
       }
       visited.remove(0);
       posi = posi+1;
       // if(!(Arrays.equals(states.get(posi).pos,end.pos))){
           visited.add(0,posi);
       //}
       // for(int i=3;i>=0;i--){
       //   if(!(Arrays.equals(states.get(posi+i).pos,end.pos))){
       //     visited.add(0,posi+i);
       //   }
       // }
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

  static void dfs(){
   int posi=0;
   int found=0;
   visited = new ArrayList<>();
   visited.add(posi);
   int top=0;
   StringBuffer sb = new StringBuffer();
   System.out.println("\nDFS");
   //System.out.print("PATH: ");
   while(found==0){
     top = visited.get(0);
     sb.append(top+" ");
     if(!(Arrays.equals(states.get(top).pos,end.pos))&&top<max){
       if(Arrays.equals(states.get(top).pos, finalState.pos)){
         found=1;
       }
       visited.remove(0);
       posi = top*4+1;
       for(int i=3;i>=0;i--){
         if(!(Arrays.equals(states.get(posi+i).pos,end.pos))){
           visited.add(0,posi+i);
         }
       }
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

 static void dls(){
   max=0;
   int posi=0;
   int found=0;
   visited = new ArrayList();
   visited.add(posi);
   StringBuffer sb = new StringBuffer();
   int top=0;
   System.out.println("\n\nEnter the max depth allowed: ");
   Scanner sc = new Scanner(System.in);
   depth = sc.nextInt();
   for(int i=0;i<depth;i++){  
     max = max+(int)Math.pow(4,i);
   }
   System.out.println("\nDLS");
   while(found==0){
     top = visited.get(0);
     sb.append(top+" ");
     if(!(Arrays.equals(states.get(top).pos,end.pos))&&top<max){
       if(Arrays.equals(states.get(top).pos, finalState.pos)){
           found=1;
       }
       visited.remove(0);
       posi = top*4+1;
       for(int i=3;i>=0;i--){
         if(!(Arrays.equals(states.get(posi+i).pos,end.pos))){
           visited.add(0,posi+i);
         }
       }
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

 static void ids(){
   System.out.println("\nIDS");
   depth = 0;
   int top=0;
   int found=0;
   StringBuffer sb = new StringBuffer();
   while(found==0){
   max=0;
   int posi=0;
   visited = new ArrayList();
   visited.add(posi);
   sb = new StringBuffer();
   top=0;
   depth++;
   if(depth==0){
     max=1;
   }
   else{
     for(int i=0;i<depth;i++){  
       max = max+(int)Math.pow(4,i);
     }
   }
   while(found==0&&top<max){
     top = visited.get(0);
     sb.append(top+" ");
     if(!(Arrays.equals(states.get(top).pos,end.pos))&&top<max){
       if(Arrays.equals(states.get(top).pos, finalState.pos)){
           found=1;
       }
       visited.remove(0);
       posi = top*4+1;
       if(posi<max){
       for(int i=3;i>=0;i--){
         if(!(Arrays.equals(states.get(posi+i).pos,end.pos))){
           visited.add(0,posi+i);
         }
       }
       }
     }
     else{
       visited.remove(0);
     }
     if(visited.size()==0){
       break;
     }
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
}

class State{
 int pos[] = new int[9];
 int level;
 public State(int pos[]){
   this.pos = pos;
 }
 public State(int pos[], int level){
   this.pos = pos;
   this.level = level;
 }
}



b. Map Exploration

import java.util.*;

class Main {
 private static ArrayList<String> cities= new ArrayList<>();
 private static ArrayList<Distance> distances= new ArrayList<>();
 private static ArrayList<State> states= new ArrayList<>();
 private static ArrayList<State> tree= new ArrayList<>();
 static int count=0;
 static int max=8;
 static int start = 0;
 static int end = 6;
 public static void main(String[] args) {
   cities.add("Thane");
   cities.add("Mulund");
   cities.add("Borivali");
   cities.add("Nahur");
   cities.add("Dadar");
   cities.add("Ghatkopar");
   cities.add("CST");
   distances.add(new Distance(0,1,10));
   distances.add(new Distance(0,2,30));
   distances.add(new Distance(1,3,10));
   distances.add(new Distance(3,5,20));
   distances.add(new Distance(2,4,20));
   distances.add(new Distance(4,5,20));
   distances.add(new Distance(4,6,10));
   distances.add(new Distance(5,6,20));
   int l=0;
   states.add(new State(start,0,l));
   tree.add(new State(start,0,l));
   int curr;
   while(count<max){
     int flag=0,flag2=0;
     curr = states.get(0).city;
     l = states.get(0).level+1;
     //System.out.println(l);
     for(int i=0;i<distances.size();i++){
       if(distances.get(i).city1==curr){
         for(int j=0;j<tree.size();j++){
           if(tree.get(j).city==distances.get(i).city2&&tree.get(j).level<l){
             flag=1;
             break;
           }
         }
         if(flag==0||distances.get(i).city2==end){
          //if(!states.contains(distances.get(i).city2)){
           states.add(new State(distances.get(i).city2,curr,l));
           tree.add(new State(distances.get(i).city2, curr,l));
          //}
         }
       }
       else if(distances.get(i).city2==curr){
         for(int j=0;j<tree.size();j++){
           if(tree.get(j).city==distances.get(i).city1&&tree.get(j).level<l){
             flag2=1;
             break;
           }
         }
         if(flag2==0||distances.get(i).city1==end){
          //if(!states.contains(distances.get(i).city2)){
           states.add(new State(distances.get(i).city1,curr,l));
           tree.add(new State(distances.get(i).city1,curr,l));
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
       System.out.println(cities.get(tree.get(i).parent)+"-->"+cities.get(tree.get(i).city)+" ");
     }

     bfs();
     dfs();
     dls();
     ids();
 }

 static void bfs(){
   StringBuffer sb = new StringBuffer();
   int location=-1;
   int found = 0;
   System.out.println("\nBFS:");
   for(int i=0;i<tree.size();i++){
     if(tree.get(i).city==end){
       sb.append(i);
       found=1;
       location=i;
       break;
     }
     else{
       sb.append(i+" ");
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

 static void dfs(){
   int posi=0;
   ArrayList<State> dfsTree = new ArrayList<>();
   dfsTree.add(tree.get(posi));
   StringBuffer sb = new StringBuffer();
   int location=-1;
   int found = 0;
   System.out.println("\nDFS:");
   while(found==0){
     State curr =  dfsTree.get(0);
     dfsTree.remove(0);
     if(curr.city==end){
       sb.append(tree.indexOf(curr));
       location = tree.indexOf(curr);
       found=1;
       break;
     }
     else{
       sb.append(tree.indexOf(curr)+" ");
       //System.out.println(tree.indexOf(curr)+" ");
       for(int j=tree.size()-1;j>=1;j--){
         if(tree.get(j).parent==curr.city){
           dfsTree.add(0,tree.get(j));
         }
       }
     }
      if(dfsTree.size()==0){
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

 static void dls(){
   int posi=0;
   ArrayList<State> dfsTree = new ArrayList<>();
   dfsTree.add(tree.get(posi));
   StringBuffer sb = new StringBuffer();
   int location=-1;
   int found = 0;
   System.out.println("\nDLS:");
   System.out.print("Enter the maximum depth: ");
   Scanner sc = new Scanner(System.in);
   int d = sc.nextInt();
   while(found==0){
     State curr =  dfsTree.get(0);
     dfsTree.remove(0);
     if(curr.city==end){
       sb.append(tree.indexOf(curr));
       location = tree.indexOf(curr);
       found=1;
       break;
     }
     else{
       sb.append(tree.indexOf(curr)+" ");
       //System.out.println(tree.indexOf(curr)+" ");
       for(int j=tree.size()-1;j>=1;j--){
         if(tree.get(j).parent==curr.city&&tree.get(j).level<=d){
           dfsTree.add(0,tree.get(j));
         }
       }
     }
      if(dfsTree.size()==0){
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

 static void ids(){
   int posi=0;
   ArrayList<State> dfsTree = new ArrayList<>();
   dfsTree.add(tree.get(posi));
   StringBuffer sb = new StringBuffer();
   int location=-1;
   int found = 0;
   System.out.println("\nIDS:");
   int d = 1;
   while(found==0){
   d++;
   dfsTree = new ArrayList<>();
   dfsTree.add(tree.get(posi));
   sb = new StringBuffer();
   while(found==0){
     State curr =  dfsTree.get(0);
     dfsTree.remove(0);
     if(curr.city==end){
       sb.append(tree.indexOf(curr));
       location = tree.indexOf(curr);
       found=1;
       break;
     }
     else{
       sb.append(tree.indexOf(curr)+" ");
       //System.out.println(tree.indexOf(curr)+" ");
       for(int j=tree.size()-1;j>=1;j--){
         if(tree.get(j).parent==curr.city&&tree.get(j).level<=d){
           dfsTree.add(0,tree.get(j));
         }
       }
     }
     if(dfsTree.size()==0){
       break;
     }
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

class State{
 int city;
 int level;
 int parent;
 public State(int city, int parent, int level){
   this.city = city;
   this.level = level;
   this.parent = parent;
 }
}


c. Water Jug

import java.util.*;

class Main {
 private static ArrayList<State> states = new ArrayList<>();
 private static int max = 100000;
 private static int count = 0;
 public static void main(String[] args) {
   states.add(new State(0,0,0));
   expand();
   for(int i=0;i<states.size();i++){
     if(states.get(i).left!=-1){
       System.out.print("\n"+states.get(i).level+" ("+states.get(i).left+", "+states.get(i).right+")"+ " "+ states.get(i).parent);
     }
   }
   bfs();
   dfs();
   dls();
   ids();
 }

 static void expand(){
   while(count<max&&count<states.size()){
       fill(states.get(count),0);
       fill(states.get(count),1);
       empty(states.get(count),0);
       empty(states.get(count),1);
       transfer(states.get(count),0);
       transfer(states.get(count),1);
       count++;
   }
 }

 static void fill(State s,int x){
   if(s.left!=-1){
   int left=0;
   int right=0;
   if(x==0&&s.left!=5){
     left = 5;
     right = s.right;
   }
   else if(x==1&&s.right!=3){
     left = s.left;
     right = 3;
   }
   int flag=0;
   for(int i=0;i<states.size();i++){
     if((states.get(i).left==left)&&(states.get(i).right==right)){
         flag=1;
         break;
     }
   }  
   if(flag==0){
   states.add(new State(left, right,s.level+1, states.indexOf(s)));
   }
 }
}

 static void empty(State s,int x){
   if(s.left!=-1){
  int left=0;
   int right=0;
   if(x==0&&s.left!=0){
     left = 0;
     right = s.right;
   }
   else if(x==1&&s.right!=0){
     left = s.left;
     right = 0;
   }
   int flag=0;
   for(int i=0;i<states.size();i++){
     if((states.get(i).left==left)&&(states.get(i).right==right)){
         flag=1;
         break;
     }
   }  
   if(flag==0){
   states.add(new State(left, right,s.level+1,states.indexOf(s)));
   }
 }
}



 static void transfer(State s,int x){
   if(s.left!=-1){
   int left=0;
   int right=0;
   if(x==0&&s.left!=5&&s.right!=0){
     if(s.left + s.right <= 5){
       left = s.left + s.right;
       right = 0;
     }
     else{
       left = 5;
       right = 3-(5-s.left);
     }
   }
   else if(x==1&&s.right!=3&&s.left!=0){
     if(s.left + s.right <= 3){
       left = 0;
       right = s.left + s.right;
     }
     else{
       left = 5-(3-s.right);
       right = 3;
     }
   }
  int flag=0;
   for(int i=0;i<states.size();i++){
     if((states.get(i).left==left)&&(states.get(i).right==right)){
         flag=1;
         break;
     }
   }  
   if(flag==0){
  
   states.add(new State(left, right,s.level+1,states.indexOf(s)));
   }
 }
 }

 static void bfs(){
   StringBuffer sb = new StringBuffer();
   int found = 0;
   System.out.println("\n\nBFS");
   for(int i=0;i<states.size();i++){
     if(states.get(i).left==4&&states.get(i).right==0){
       sb.append(i+" ");
       found=1;
       break;
     }
     else{
       sb.append(i+" ");
     }
   }
   if(found==1){
     System.out.println("Found");
     System.out.println("Path: "+sb);
   }
   else{
     System.out.println("Not Found");
   }
 }

 static void dfs(){
   StringBuffer sb = new StringBuffer();
   ArrayList<State> visited = new ArrayList<>();
   visited.add(states.get(0));
   int found = 0;
   System.out.println("\n\nDFS");
   while(found==0){
     State curr = visited.get(0);
     visited.remove(0);
     if(curr.left==4&&curr.right==0){
       sb.append(states.indexOf(curr)+" ");
       found=1;
       break;
     }
     else{
       sb.append(states.indexOf(curr)+" ");
       for(int i=states.size()-1;i>0;i--){
         if(states.get(i).parent==states.indexOf(curr)){
           visited.add(0,states.get(i));
         }
       }
     }
   }
   if(found==1){
     System.out.println("Found");
     System.out.println("Path: "+sb);
   }
   else{
     System.out.println("Not Found");
   }
 }

 static void dls(){
   StringBuffer sb = new StringBuffer();
   ArrayList<State> visited = new ArrayList<>();
   visited.add(states.get(0));
   int found = 0;
   System.out.println("\n\nDLS");
   System.out.print("Enter the maximum depth: ");
   Scanner sc = new Scanner(System.in);
   int d = sc.nextInt();
   while(found==0){
     State curr = visited.get(0);
     visited.remove(0);
     if(curr.left==4&&curr.right==0){
       sb.append(states.indexOf(curr)+" ");
       found=1;
       break;
     }
     else{
       sb.append(states.indexOf(curr)+" ");
       for(int i=states.size()-1;i>0;i--){
         if(states.get(i).parent==states.indexOf(curr)&&states.get(i).level<=d){
           visited.add(0,states.get(i));
         }
       }
     }
     if(visited.size()==0){
       break;
     }
   }
   if(found==1){
     System.out.println("Found");
     System.out.println("Path: "+sb);
   }
   else{
     System.out.println("Not Found");
   }
 }

 static void ids(){
   StringBuffer sb = new StringBuffer();
   ArrayList<State> visited = new ArrayList<>();
   visited.add(states.get(0));
   int found = 0;
   System.out.println("\n\nIDS");
   int d = 1;
   while(found==0){
   d++;
   visited = new ArrayList<>();
   visited.add(states.get(0));
   sb = new StringBuffer();
   while(found==0){
     State curr = visited.get(0);
     visited.remove(0);
     if(curr.left==4&&curr.right==0){
       sb.append(states.indexOf(curr)+" ");
       found=1;
       break;
     }
     else{
       sb.append(states.indexOf(curr)+" ");
       for(int i=states.size()-1;i>0;i--){
         if(states.get(i).parent==states.indexOf(curr)&&states.get(i).level<=d){
           visited.add(0,states.get(i));
         }
       }
     }
     if(visited.size()==0){
       break;
     }
   }
   }
   if(found==1){
     System.out.println("Found");
     System.out.println("Path: "+sb);
   }
   else{
     System.out.println("Not Found");
   }
 }

}

class State{
 int left;
 int right;
 int level;
 int parent;
 public State(int left, int right){
   this.left = left;
   this.right = right;
 }
 public State(int left, int right, int level){
   this.left = left;
   this.right = right;
   this.level = level;
 }
 public State(int left, int right, int level, int parent){
   this.left = left;
   this.right = right;
   this.level = level;
   this.parent = parent;
 }
}

















