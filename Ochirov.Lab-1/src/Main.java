

//Входные данные: целочисленная матрица размером N * M.(вариант №9)
// Результат работы алгоритма: матрица, полученная из входной,
// путем добавления в каждую строку дополнительного элемента (M + 1) – среднеарифметическое значение строки,
// а также отсортированная (по строкам) по убыванию этого значения.

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int var=0;
        Random rnd = new Random();
        int CopyM = 0;
        int CopyN = 0;
        int[][] array2= new int[CopyN][CopyM];
        int SumOfCopyM = 0;
        boolean check_1 = false;
        boolean check_2 = false;
        boolean number= false;

        while(!number){
            System.out.println("Create matrix - 1");
            System.out.println("Run the algorithm - 2");
            System.out.println("Show the result - 3");
            System.out.println("exit - 4");
            System.out.print("Your choise is: ");

            var = in.nextInt();

            if(var ==1){
                System.out.println("Enter the size of matrix N x M: ");
                System.out.print("Enter N: ");
                int N;
                N= in.nextInt();
                System.out.print("Enter M: ");
                int M;
                M= in.nextInt();
                int[][]array1 = new int[N][M];
                CopyN=N;
                CopyM=M+1;
                System.out.println("Im gonna fill it - 1");
                System.out.println("Fill it with random numbers - 2");
                int Fill=0 ;

                Fill= in.nextInt();

                do{if(Fill ==1){
                    for (int index =0; index< array1.length; index++ ){
                        for(int j =0; j<array1[index].length;j++){
                            System.out.println("Enter "+index+ "-string and "+ j+ "- column ");
                            array1[index][j] = in.nextInt();
                        }
                    }
                    array2 = new int[CopyN][CopyM];
                    for(int index =0; index <CopyN; index++){
                        for(int j =0; j<CopyM-1; j++){
                            array2[index][j] = array1[index][j];
                        }
                    }
                }else if(Fill ==2 ){
                    for(int index =0; index<array1.length; index++ ){
                        for(int j =0; j<array1[index].length;j++){
                            array1[index][j]=rnd.nextInt(10);
                        }
                    }
                    array2 = new int[CopyN][CopyM];
                    for(int index =0; index <CopyN; index++){
                        for(int j =0; j<CopyM-1; j++){
                            array2[index][j] = array1[index][j];
                        }
                    }
                }else if(Fill!=1 || Fill!=2){
                    System.out.println("You have to choose b/w two options. ");
                }
                    if(Fill==1 || Fill==2){
                        for(int index =0; index < array1.length;index++){
                            for(int j =0;j<array1[index].length; j++){
                                System.out.print(" "+ array1[index][j] + " ");
                            }
                            System.out.println();
                        }
                    }
                }while(Fill!=1&&Fill!=2);
                check_1 = true;
            }if (var==2 && check_1 == true){
                for(int index =0; index<array2.length; index++){
                    for(int j=0; j<(array2[index].length-1); j++ ){
                        SumOfCopyM = array2[index][j]+ SumOfCopyM;
                    }
                    SumOfCopyM /=(CopyM-1);
                    array2[index][CopyM-1] = SumOfCopyM;
                    SumOfCopyM =0;
                }
                for( int index = 0; index < array2.length; index++){
                    int min = array2[index][0];
                    boolean proof3 = true;
                    do{
                        proof3 =false;
                         min = array2[index][0];
                        for(int j=0;j < CopyM-2; j++){
                            if(min < array2[index][j+1]){
                                min = array2[index][j+1];
                                array2[index][j+1]=array2[index][j];
                                array2[index][j]=min;
                                proof3=true;
                            }
                        }
                   }while(proof3);
                }
                check_2=true;
            }else if(var==2 && check_1!=true){
                System.out.println("Previous option has not been defined. Define №1 option. ");
            }
            if(var == 3 && check_2==true){
                for(int index =0;index<array2.length; index++){
                    for(int j=0; j<CopyM;j++ ){
                        System.out.print(array2[index][j] + " ");
                    }
                    System.out.println();
                }
            }else if(var==3 && check_2!=true){
                System.out.println("Previous option has not been defined. Define №2 option ");
            }
            if (var == 4){
                number = true;
            }
        }

    }
    }
