/*I have tried my best to explain what is going on throughout the program.
However my only concern is the end of the program, specifically from lines 66-83.
But if you do have the time, to properly understand what is happening please read my annotations.
Regardless, thank you very much for your time and help.*/
package travellingsalesmanproblem;
public class reducedMatrixMethodTSP{
    public static void main(String []args){
        int dim = Integer.parseInt(input("How many cities are there?"));
        /*This decides the dimensions for the matrix. The matrix will have the same 
        amount of rows and columns as it is about cities and there respective distances from each other.
        This also means that in the matrix the distance from one city to the same city will be nothing
        and hence i will be outlining this by writing "-1" in the matrix*/
        int matrix [][]= new int [dim][dim];
        int penR,penC;
        //The following code is to set the outline of the Initial Matrix, numbers being printed show how many cities:
        for(int count=0;count<dim+1;count++){
            System.out.print(count+"\t");
        }
        System.out.println("");
        for(int count=0;count<dim+1;count++){
            System.out.print("_\t");
        }
        System.out.println("");
        //Next we have the code which randomly fills in the matrix with the corresponding distances for each city:
        for(int i=0;i<dim;i++){
            System.out.print(i+1+"|\t");
            for(int j=0;j<dim;j++){
                if(i==j){
                    matrix[i][j]=-1;
                }
                else if(matrix[i][j]==0){
                    matrix[i][j]=(int)(Math.random()*15)+10;
                    matrix[j][i]=matrix[i][j];
                }
                
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("");
            //This prints out the initial matrix after I use a randomizer to fill it
        }
        /*Now we have the code for the first row and column minimization:
        This essentially means that each row will have to have at least one 0 and that each column will have 
        to have at leat one 0. To do this I scan through each row first and find the lowest element, and subtract
        it from every other element in the row. Then I do the same for each column.*/ 
        System.out.println("");
        int low;
        for(int i=0;i<dim;i++){
            low=100;
            for(int j=0;j<dim;j++){
                if(i!=j){//this if statement was added so that the "-1" values where its the same city are not included
                    if(matrix[i][j]<low){
                        low=matrix[i][j];
                        //This part of the code found the lowest element there is
                    }
                }
            }
            for(int j=0;j<dim;j++){
                if(i!=j)
                    matrix[i][j]=matrix[i][j]-low;
                //Here i subtracted the previously found "low" from the other elements in each row. Now there is a 0 per row
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("");
            //I am also printing this matrix, where the rows have been minimized(one 0 per row).
        }
        System.out.println("");
        //Now we repeat the process for all the columns to ensure that we get a 0 per column (column minimization)
        for(int i=0;i<dim;i++){
            low=100;
            for(int j=0;j<dim;j++){
                if(i!=j){
                    if(matrix[j][i]<low){
                        low=matrix[j][i];
                       //so again, we find the lowest value per column, by scanning through each column
                    }
                }
            }
            for(int j=0;j<dim;j++){
                if(i!=j){
                    matrix[j][i]=matrix[j][i]-low;
                    //I subtract the value for "low" found from every element in the column, now there is 0 per column
                }
                System.out.print(matrix[j][i]+"\t");
            }
            System.out.println("");
            //I also print this matrix. It should have the rows already minimized and now also the columns
        } 
    }
    /*Occasionally both minimizations work properly but most of the time i get an error, but only ever in the
    column minimization. The error so far seems to be nonsensical and I cannot find a cause.*/
    static String input(String prompt)
     { return javax.swing.JOptionPane.showInputDialog(null,prompt); }
    static void output(String message)
     { javax.swing.JOptionPane.showMessageDialog(null,message); }
}
