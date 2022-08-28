import java.util.Scanner;

public class Main {
    public static void show (int[][]array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print (array[i][j] + "\t");
            }
            System.out.println ();
        }
    }

    public static String input() {
        Scanner in = new Scanner (System.in);
        System.out.print ("Input string: ");
        return in.nextLine();
    }

    public static int[][] calculateDelta(int[][] array, String direction) {
        //Fill delta
        int[][] delta = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (array[i][j] > 0) {
                    delta[i][j]--;
                    switch (direction) {
                        case "w":
                            if (i!=0) delta[i-1][j]++;
                            break;
                        case "a":
                            if (j!=0)
                                delta[i][j-1]++;
                            break;
                        case "s":
                            if (i!=4)
                                delta[i+1][j]++;
                            break;
                        case "d":
                            if (j!=4)
                                delta[i][j+1]++;
                            break;
                    }
                }
            }
        }

        return delta;
    }

    public static void main (String[]args) {
        int[][] water = new int[5][5];
        int[][] delta;

        //Initialization
        water[2][2] = 7;

        //Begin
        show (water);
        while (true){

            //Get user input
            String direction = input();

            if ( direction.equals("e") ){
                break;
            }

            //Get delta
            delta = calculateDelta(water, direction);

            //Calculate result
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    water[i][j] = water[i][j] + delta[i][j];
                }
            }

            show(water);

        }
    }
}