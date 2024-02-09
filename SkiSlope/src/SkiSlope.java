import java.util.*;

public class SkiSlope {
	public static int countRuns(int numNodes, int[][] multiplier) {
	    int totalRuns = 0;
	    int[] tempMultiplier = new int[numNodes];

	    for (int i = 1; i < numNodes ; i++) {
	        for (int j = i + 1; j < numNodes ; j++) {
	            if (multiplier[i][j] > 0) {
	                tempMultiplier[i] = multiplier[i][j];
	                //for debugging
	                //System.out.println("temp" + tempMultiplier[i]);
	                int from = j;

	                for (int k = from + 1; k < numNodes; k++) {
	                    multiplier[from][k] *= tempMultiplier[i];
	                   //for debugging
	                    //System.out.println(from +" to " + k +multiplier[from][k]);
	                }

	                multiplier[from][0] *= tempMultiplier[i];
	               //for debugging
	               // System.out.println(multiplier[from][0]);
	                totalRuns += multiplier[from][0];
	            }
	        }
	    }

//	    for (int i = 1; i < numNodes; i++) {
//	        totalRuns += multiplier[i][0];
//	    }

	    return totalRuns;
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = 1;
        int from = 0;
        int to = 0;
        while (scanner.hasNext()) {
            int numNodes = scanner.nextInt();
            int numLegs = scanner.nextInt();
            if (numNodes == 0 && numLegs == 0) break;
            
            int[][] multiplier = new int[numNodes + 2][numNodes + 2];
            for (int i = 0; i < numLegs; i++) {
                from = scanner.nextInt();
                to = scanner.nextInt();             
            multiplier[from][to]++;
            //for debugging 
            //System.out.print(multiplier[from][to] +" " + from + " " + to +"\n");
            }
            
            int totalRuns = countRuns(numNodes + 2, multiplier);
            System.out.println("Slope " + testCase + " has " + totalRuns + " runs.");
            testCase++;

        }
        scanner.close();
    }
}