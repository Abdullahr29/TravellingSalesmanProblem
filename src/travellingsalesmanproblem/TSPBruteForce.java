
package travellingsalesmanproblem;
public class TSPBruteForce {
    static int [][] distances = {   {-1,50,36,54,58,92},
                                    {50,-1,42,20,54,45},
                                    {36,42,-1,32,22,71},
                                    {54,20,32,-1,36,40},
                                    {58,54,22,36,-1,67},  
                                    {92,45,71,40,67,-1}  };//Input weighted matrix
    static int [] cities = {1,2,3,4,5,6};//array of input cities, used to calculate different permutation combinations 
    static int flag = 0;
    static int num = 0;
    static int n = factorial(cities.length);//method to calculate factorials
    public static void main(String args[]){
        int min_distance = 10000, temp_distance=0;
        int [] min_array = new int [cities.length+1];
        for(int count=0;count<n;count++){//runs for each permutation
            permute();//finds the next permutation for the cities array
            temp_distance = 0;//resets temporary distance check
            if(flag ==0){
                for(int counter=0;counter<cities.length;counter++)    
                    System.out.print(cities[counter]+"\t");
                System.out.println(cities[0]);
                //prints current perumation of cities
                for(int counte=0;counte<cities.length-1;counte++){
                    temp_distance = temp_distance+(distances[cities[counte]-1][cities[counte+1]-1]);
                }
                temp_distance=temp_distance+distances[cities[cities.length-1]-1][cities[0]-1];
                //calculates the weight of the current permutation
                if(temp_distance<min_distance){ 
                    min_distance = temp_distance;
                    for(int z=0;z<cities.length;z++){
                        min_array[z]=cities[z];
                    }
                    min_array[min_array.length-1]=cities[0];
                    num=0;
                }//checks and stores if the current permutation weight is the minimun
                else if(temp_distance == min_distance){
                    num++;
                }//checks if the current weight is equal to previous minimums and stores it to count minimum solutions
                System.out.println("Distance = "+temp_distance);
            }    
        }
        System.out.println("Minimum Distance is = "+min_distance+"\nThe path to take is: ");
        for(int count =0;count<min_array.length-1;count++){
            System.out.print(min_array[count]+"--");
        }
        System.out.println(min_array[min_array.length-1]);
        System.out.println("The number of other viable solutions is: "+num);
        //prints after minimum has been found 
    }
    public static void permute(){//using lexicogrpahic ordering
        int temp_value1 = -1;
        for(int i = 0;i<cities.length-1;i++){
            if(cities[i]<cities[i+1]){//checks if permutations are available and finds the largest value such that the next is greater
                temp_value1=i;
            }
        }
        if(temp_value1 == -1){//if no permutations available
            System.out.println(n + " Permutations Complete");
            flag = 1;
        }
        else{
            int temp_value2 =-1;
            for(int j=0;j<cities.length;j++){
                if(cities[temp_value1]<cities[j]){//finds the greatest value of j which gives a value greater than that found previously
                    temp_value2=j;
                }
            }
            swap(temp_value1, temp_value2);//swaps the two found values
            int [] temp_array = temp_array(temp_value1);//creates a small temporary array of the values from the first value found onwards
            append(temp_value1, temp_array);//takes the temporary array, reverses the order of the elements, and appends it to the end of the cities array
        }
            }
    public static void swap(int i, int j){
        int temp;
        temp=cities[i];
        cities[i]=cities[j];
        cities[j]=temp;
    }
    public static int[] temp_array(int i){
        int [] temp_array = new int [cities.length-i-1];
        int temp_count=0;
        for(int count = i+1;count<cities.length;count++){
            temp_array[temp_count]=cities[count];
            temp_count++;
        }
        return temp_array;
    }
    public static void append(int i, int [] temp_array){
        int mid = temp_array.length/2;
        int temp;
        if(temp_array.length%2==0){//appends the reversed array onto the original
            for(int count=i+1;count<cities.length-mid;count++){
                temp=cities[count];
                cities[count]=cities[temp_array.length+(i+1)-(count-(i+1))-1];
                cities[temp_array.length+(i+1)-(count-(i+1))-1]=temp;
            }
        }
        else{
            for(int count=i+1;count<(i+1)+(mid+1);count++){
                temp=cities[count];
                cities[count]=cities[temp_array.length+(i+1)-(count-(i+1))-1];
                cities[temp_array.length+(i+1)-(count-(i+1))-1]=temp;   
            }
        }
    }
    public static int factorial(int n){
        if(n<=1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }
    static String input(String prompt)
     { return javax.swing.JOptionPane.showInputDialog(null,prompt); }
    static void output(String message)
     { javax.swing.JOptionPane.showMessageDialog(null,message); }
}
