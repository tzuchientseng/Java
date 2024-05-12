// import java.util.Scanner;

public class SudokuFindingConst {
    public static void main(String[] args) {
    //     // initialization
    //     int[][][] o = new int[10][9][9];
    //     for (int i=0; i<10; i++) {
    //         for (int j=0; j<9; j++) {
    //             for (int k=0; k<9; k++) {
    //                 o[i][j][k] = i;
    //             }
    //         }
    //     }

    //     // scan
    //     Scanner s = new Scanner(System.in);
    //     for (int row=0; row<9; row++) {
    //         String line = s.nextLine();
    //         String[] elements = line.split("\\s+");
    //         for (int j=0; j<9; j++) {
    //             o[0][row][j] = Integer.parseInt(elements[j]);
    //         }
    //     }
    //     s.close();


        int[][][] o = new int[][][] {
            {{0, 2, 0, 0, 0, 8, 5, 0, 0},
             {0, 4, 0, 0, 3, 0, 0, 0, 0},
             {5, 0, 3, 0, 0, 9, 0, 7, 0},
             {0, 0, 0, 8, 0, 0, 0, 4, 0},
             {9, 0, 5, 0, 6, 0, 8, 0, 0},
             {2, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 7, 0, 0, 1},
             {0, 3, 0, 0, 0, 0, 0, 0, 0},
             {8, 0, 6, 0, 9, 0, 4, 0, 0}},
            {{1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1}},
            {{2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2}},
            {{3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3}},
            {{4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4}},
            {{5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5}},
            {{6,6,6,6,6,6,6,6,6},{6,6,6,6,6,6,6,6,6},{6,6,6,6,6,6,6,6,6},{6,6,6,6,6,6,6,6,6},{6,6,6,6,6,6,6,6,6},{6,6,6,6,6,6,6,6,6},{6,6,6,6,6,6,6,6,6},{6,6,6,6,6,6,6,6,6},{6,6,6,6,6,6,6,6,6}},
            {{7,7,7,7,7,7,7,7,7},{7,7,7,7,7,7,7,7,7},{7,7,7,7,7,7,7,7,7},{7,7,7,7,7,7,7,7,7},{7,7,7,7,7,7,7,7,7},{7,7,7,7,7,7,7,7,7},{7,7,7,7,7,7,7,7,7},{7,7,7,7,7,7,7,7,7},{7,7,7,7,7,7,7,7,7}},
            {{8,8,8,8,8,8,8,8,8},{8,8,8,8,8,8,8,8,8},{8,8,8,8,8,8,8,8,8},{8,8,8,8,8,8,8,8,8},{8,8,8,8,8,8,8,8,8},{8,8,8,8,8,8,8,8,8},{8,8,8,8,8,8,8,8,8},{8,8,8,8,8,8,8,8,8},{8,8,8,8,8,8,8,8,8}},
            {{9,9,9,9,9,9,9,9,9},{9,9,9,9,9,9,9,9,9},{9,9,9,9,9,9,9,9,9},{9,9,9,9,9,9,9,9,9},{9,9,9,9,9,9,9,9,9},{9,9,9,9,9,9,9,9,9},{9,9,9,9,9,9,9,9,9},{9,9,9,9,9,9,9,9,9},{9,9,9,9,9,9,9,9,9}}
        };

        System.out.println("\n-------Constant value-------\n");
        int deta = 1;
        while(deta != 0){
            int sum = Sum(o);
            Record(o);
            Swap(o);
            int newSum = Sum(o);
            deta = newSum - sum; 
        }
        Print(o);

    }
    private static int Sum(int[][][] o){
        int sum = 0; 
        for (int j=0; j<9; j++) {
            for (int k=0; k<9; k++) {
                sum += o[0][j][k];
            }
        }
        return sum;
    }
    private static int[][][] Record(int[][][] o) {
        // record possible value
        for (int j=0; j<9; j++) {
            for (int k=0; k<9; k++) {
                if (o[0][j][k] != 0)
                {
                    //ans(i==0) === constantValue;
                    int constantValue = o[0][j][k];

                    for (int i = 1; i < 10; i++) {
                        o[i][j][k] = 0;
                    }
                    for(int row=0; row<9; row++){
                        o[constantValue][row][k] = 0;
                    }
                    for(int column=0; column<9; column++){
                        o[constantValue][j][column] = 0;
                    }
                    //3X3(9 areas)
                    if((j==0||j==1||j==2)&&((k==0||k==1||k==2))){
                        for(int row=0; row<3; row++){
                            for(int column=0; column<3; column++){
                             o[constantValue][row][column] = 0;
                            }
                        }
                    }
                    if((j==0||j==1||j==2)&&((k==3||k==4||k==5))){
                        for(int row=0; row<3; row++){
                            for(int column=3; column<6; column++){
                                o[constantValue][row][column] = 0;
                            }
                        }
                    }
                    if((j==0||j==1||j==2)&&((k==6||k==7||k==8))){
                        for(int row=0; row<3; row++){
                            for(int column=6; column<9; column++){
                                o[constantValue][row][column] = 0;
                            }
                        }
                    }//
                    if((j==3||j==4||j==5)&&((k==0||k==1||k==2))){
                        for(int row=3; row<6; row++){
                            for(int column=0; column<3; column++){
                             o[constantValue][row][column] = 0;
                            }
                        }
                    }
                    if((j==3||j==4||j==5)&&((k==3||k==4||k==5))){
                        for(int row=3; row<6; row++){
                            for(int column=3; column<6; column++){
                                o[constantValue][row][column] = 0;
                            }
                        }
                    }
                    if((j==3||j==4||j==5)&&((k==6||k==7||k==8))){
                        for(int row=3; row<6; row++){
                            for(int column=6; column<9; column++){
                                o[constantValue][row][column] = 0;
                            }
                        }
                    }//
                    if((j==6||j==7||j==8)&&((k==0||k==1||k==2))){
                        for(int row=6; row<9; row++){
                            for(int column=0; column<3; column++){
                             o[constantValue][row][column] = 0;
                            }
                        }
                    }
                    if((j==6||j==7||j==8)&&((k==3||k==4||k==5))){
                        for(int row=6; row<9; row++){
                            for(int column=3; column<6; column++){
                                o[constantValue][row][column] = 0;
                            }
                        }
                    }
                    if((j==6||j==7||j==8)&&((k==6||k==7||k==8))){
                        for(int row=6; row<9; row++){
                            for(int column=6; column<9; column++){
                                o[constantValue][row][column] = 0;
                            }
                        }
                    }//
                }   
            }
        }
        return o; // Just a placeholder, replace with your actual implementation
    }

    private static void Swap(int[][][] o) {
        for(int i=1; i<10; i++){
            for(int j=0; j<9; j++){
                for(int k=0; k<9; k++){
                     if (o[i][j][k] != 0)
                    {//3X3(9 positions)
                        if((j==0||j==3||j==6)&&((k==0||k==3||k==6))){//1
                            if(i == o[i][j][k] + o[i][j][k+1] + o[i][j][k+2] + o[i][j+1][k] + o[i][j+1][k+1] + o[i][j+1][k+2] + o[i][j+2][k] + o[i][j+2][k+1]+ o[i][j+2][k+2]
                                || i == o[i][j][0] + o[i][j][1] + o[i][j][2] + o[i][j][3] + o[i][j][4] + o[i][j][5] + o[i][j][6] + o[i][j][7] + o[i][j][8]
                                || i == o[i][0][k] + o[i][1][k] + o[i][2][k] + o[i][3][k] + o[i][4][k] + o[i][5][k] + o[i][6][k] + o[i][7][k] + o[i][8][k])
                                {
                                    o[0][j][k] = o[i][j][k];
                                }
                            }
                            if((j==0||j==3||j==6)&&((k==1||k==4||k==7))){//2
                                if(i == o[i][j][k-1] + o[i][j][k] + o[i][j][k+1] + o[i][j+1][k-1] + o[i][j+1][k] + o[i][j+1][k+1] + o[i][j+2][k-1] + o[i][j+2][k]+ o[i][j+2][k+1]
                                || i == o[i][j][0] + o[i][j][1] + o[i][j][2] + o[i][j][3] + o[i][j][4] + o[i][j][5] + o[i][j][6] + o[i][j][7] + o[i][j][8]
                                || i == o[i][0][k] + o[i][1][k] + o[i][2][k] + o[i][3][k] + o[i][4][k] + o[i][5][k] + o[i][6][k] + o[i][7][k] + o[i][8][k])
                                {
                                    o[0][j][k] = o[i][j][k];
                                }
                            }
                            if((j==0||j==3||j==6)&&((k==2||k==5||k==8))){//3
                                if(i == o[i][j][k-2] + o[i][j][k-1] + o[i][j][k] + o[i][j+1][k-2] + o[i][j+1][k-1] + o[i][j+1][k] + o[i][j+2][k-2] + o[i][j+2][k-1]+ o[i][j+2][k]
                                || i == o[i][j][0] + o[i][j][1] + o[i][j][2] + o[i][j][3] + o[i][j][4] + o[i][j][5] + o[i][j][6] + o[i][j][7] + o[i][j][8]
                                || i == o[i][0][k] + o[i][1][k] + o[i][2][k] + o[i][3][k] + o[i][4][k] + o[i][5][k] + o[i][6][k] + o[i][7][k] + o[i][8][k])
                                {
                                    o[0][j][k] = o[i][j][k];
                                }                            
                            }
                            if((j==1||j==4||j==7)&&((k==0||k==3||k==6))){//4
                                if(i == o[i][j-1][k] + o[i][j-1][k+1] + o[i][j-1][k+2] + o[i][j][k] + o[i][j][k+1] + o[i][j][k+2] + o[i][j+1][k] + o[i][j+1][k+1]+ o[i][j+1][k+2]
                                || i == o[i][j][0] + o[i][j][1] + o[i][j][2] + o[i][j][3] + o[i][j][4] + o[i][j][5] + o[i][j][6] + o[i][j][7] + o[i][j][8]
                                || i == o[i][0][k] + o[i][1][k] + o[i][2][k] + o[i][3][k] + o[i][4][k] + o[i][5][k] + o[i][6][k] + o[i][7][k] + o[i][8][k])
                                {
                                    o[0][j][k] = o[i][j][k];
                                }                            
                            }
                            if((j==1||j==4||j==7)&&((k==1||k==4||k==7))){//5
                                if(i == o[i][j-1][k-1] + o[i][j-1][k] + o[i][j-1][k+1] + o[i][j][k-1] + o[i][j][k] + o[i][j][k+1] + o[i][j+1][k-1] + o[i][j+1][k]+ o[i][j+1][k+1]
                                || i == o[i][j][0] + o[i][j][1] + o[i][j][2] + o[i][j][3] + o[i][j][4] + o[i][j][5] + o[i][j][6] + o[i][j][7] + o[i][j][8]
                                || i == o[i][0][k] + o[i][1][k] + o[i][2][k] + o[i][3][k] + o[i][4][k] + o[i][5][k] + o[i][6][k] + o[i][7][k] + o[i][8][k])
                                {
                                    o[0][j][k] = o[i][j][k];
                                } 
                            }
                            if((j==1||j==4||j==7)&&((k==2||k==5||k==8))){//6
                                if(i == o[i][j-1][k-2] + o[i][j-1][k-1] + o[i][j-1][k] + o[i][j][k-2] + o[i][j][k-1] + o[i][j][k] + o[i][j+1][k-2] + o[i][j+1][k-1]+ o[i][j+1][k]
                                || i == o[i][j][0] + o[i][j][1] + o[i][j][2] + o[i][j][3] + o[i][j][4] + o[i][j][5] + o[i][j][6] + o[i][j][7] + o[i][j][8]
                                || i == o[i][0][k] + o[i][1][k] + o[i][2][k] + o[i][3][k] + o[i][4][k] + o[i][5][k] + o[i][6][k] + o[i][7][k] + o[i][8][k])
                                {
                                    o[0][j][k] = o[i][j][k];
                                }
                            }
                            if((j==2||j==5||j==8)&&((k==0||k==3||k==6))){//7
                                if(i == o[i][j-2][k] + o[i][j-2][k+1] + o[i][j-2][k+2] + o[i][j-1][k] + o[i][j-1][k+1] + o[i][j-1][k+2] + o[i][j][k] + o[i][j][k+1]+ o[i][j][k+2]
                                || i == o[i][j][0] + o[i][j][1] + o[i][j][2] + o[i][j][3] + o[i][j][4] + o[i][j][5] + o[i][j][6] + o[i][j][7] + o[i][j][8]
                                || i == o[i][0][k] + o[i][1][k] + o[i][2][k] + o[i][3][k] + o[i][4][k] + o[i][5][k] + o[i][6][k] + o[i][7][k] + o[i][8][k])
                                {
                                    o[0][j][k] = o[i][j][k];
                                }
                            }
                            if((j==2||j==5||j==8)&&((k==1||k==4||k==7))){//8
                                if(i == o[i][j-2][k-1] + o[i][j-2][k] + o[i][j-2][k+1] + o[i][j-1][k-1] + o[i][j-1][k] + o[i][j-1][k+1] + o[i][j][k-1] + o[i][j][k]+ o[i][j][k+1]
                                || i == o[i][j][0] + o[i][j][1] + o[i][j][2] + o[i][j][3] + o[i][j][4] + o[i][j][5] + o[i][j][6] + o[i][j][7] + o[i][j][8]
                                || i == o[i][0][k] + o[i][1][k] + o[i][2][k] + o[i][3][k] + o[i][4][k] + o[i][5][k] + o[i][6][k] + o[i][7][k] + o[i][8][k])
                                {
                                    o[0][j][k] = o[i][j][k];
                                }                             
                            }
                            if((j==2||j==5||j==8)&&((k==2||k==5||k==8))){//9
                                if(i == o[i][j-2][k-2] + o[i][j-2][k-1] + o[i][j-2][k] + o[i][j-1][k-2] + o[i][j-1][k-1] + o[i][j-1][k] + o[i][j][k-2] + o[i][j][k-1]+ o[i][j][k]
                                || i == o[i][j][0] + o[i][j][1] + o[i][j][2] + o[i][j][3] + o[i][j][4] + o[i][j][5] + o[i][j][6] + o[i][j][7] + o[i][j][8]
                                || i == o[i][0][k] + o[i][1][k] + o[i][2][k] + o[i][3][k] + o[i][4][k] + o[i][5][k] + o[i][6][k] + o[i][7][k] + o[i][8][k])
                            {
                                o[0][j][k] = o[i][j][k];
                            }  
                        }
                    }
                }   
            }
        }
    }

    public static void Print(int[][][] o) {
        for (int ans=0; ans<10; ans++) {
            for (int j=0; j<9; j++) {
                for (int k=0; k<9; k++) {
                    // System.out.print(o[0][j][k] + " ");
                    System.out.print(o[ans][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
