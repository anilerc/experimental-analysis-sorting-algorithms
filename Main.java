import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        /* Get the input sets. */
    	
    	List<int[]> inputs = new ArrayList<>();
    	
    	inputs.add(createRandomArray(10000,100001));
    	inputs.add(createRandomArray(10000,10001));
    	inputs.add(createSortedArray(10000));
    	inputs.add(createReverseSortedArray(10000));
    	inputs.add(createDuplicateArray(10000));
    	
        /*
        	int[] randomInput1 = createRandomArray(10000,100001);
        	int[] randomInput2 = createRandomArray(10000,10001);
        	int[] sortedInput = createSortedArray(10000);
        	int[] reverseSortedInput = createReverseSortedArray(10000);
        	int[] duplicatesInput = createDuplicateArray(10000);       
        */
    	
    	/* Store Sort Theoretic best/average/worst cases*/   	
        ArrayList<long[][]> sortTheo = new ArrayList<>();
       
        /* Store Sort Complexities  */   	
        ArrayList<long[]> sortRes = new ArrayList<>();
        
        /* Run different algorithms for them and monitor the results. */
        int k=0;
        for(int[] input : inputs){
        	// Theoretic part:        	
        	long theo[][] = Sort.theo(input);//new long[6][3]; // (best, average and worst cases)    -----> shall be [7][3]
        	sortTheo.add(theo);
        	
        	// Sorting part:
        	long [] res = new long[7];
        	int l=0;
        	res[l++] = Sort.insertionSort(input.clone());
        	res[l++] = Sort.binaryInsertionSort(input.clone());//Sort.biSort(input.clone());//
        	/*
           	res[l++] = Sort.mergeSort(input.clone(), 0, input.length-1, 0);
        	res[l++] = Sort.quickSort(input.clone(), 0, input.length-1, 0);
	        //Sort.quickSortWithMedianBLAHBLAHBLAH(input.clone(), 0, inputs.get(0).length-1);
        	res[l++] = Sort.heapSort(input.clone(), 0);
        	res[l++] = Sort.countingSort(input.clone());	
        	*/
        	sortRes.add(res);
        }
        printTable(sortTheo.get(0));System.out.println("----------");
        printTable(sortRes);
        /* Make comments about the console output... */


    }
    /* Print first 50 elements of array */
    public static void printArray(long[] arr) {      
    		for (int i = 0; i< arr.length && i < 50; i++) 
    			System.out.printf("%19d ",arr[i]);
    		System.out.println();
    }
    
    /* Print table */
    public static void printTable(List<long[]> arl) {      
    	for (long[] arr : arl) 
    		printArray(arr);    	
    }
    public static void printTable(long[][] arr) {      
    	for (int j = 0; j < arr[0].length; j++) {
    		for (int i = 0; i < arr.length; i++) 
    			System.out.printf("%19d ",arr[i][j]);
    		System.out.println();
    	}
    }

    /* Creation of some cases */
    public static int[] createSortedArray(int size) {
        int[] sortedArray = new int[size];
        for (int i = 0; i < size; i++) 
            sortedArray[i] = i;      
        return sortedArray;
    }


    public static int[] createReverseSortedArray(int size) {
        int[] reverseSortedArray = new int[size];
        for (int i = 0; i < size; i++) 
            reverseSortedArray[i] = size - i;      
        return reverseSortedArray;
    }


    public static int[] createRandomArray(int size, int maxRand) {

        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            int randomValue = new Random().nextInt(maxRand);
            randomArray[i] = randomValue;
        }
        return randomArray;

    }


    public static int[] createDuplicateArray(int size){
        int[] randomArray = new int[size];
        for(int i = 0; i<size; i++){
            int randomValue = new Random().nextInt(6);
            randomArray[i] = randomValue;
        }
        return randomArray;
    }




}