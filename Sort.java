import java.util.Arrays;

public class Sort {

	
	public static long[][] theo (int[] arr) {
		long n = arr.length;
		long nsqr=n*n;
		long logn = (long)Math.log(n);
		long nlogn=(long) (logn*n);
		long r = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();
		long[][] theoarr = {{n,nsqr,nsqr},{logn,nlogn,nsqr},{nlogn,nlogn,nlogn},{nlogn,nlogn,nsqr},{nlogn,nlogn,nlogn},{n+r,n+r,n+r}};
		return theoarr;
	}
	
	public int compare (long k) {
		return 1;
	}
	
	long dist (long a, long b) {
		return Math.abs(a-b);
	}
	
	
	/* ********************** INSERTION SORT *********************************** */
	
    public static long insertionSort(int[] arr) {

        long comparisons = 0;
        long swaps = 0;

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            comparisons++;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                swaps++;
            }
            arr[j + 1] = key;
        }

        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Complexity of insertionSort: " + (comparisons + swaps));
        System.out.println("----------");

        
        
        return comparisons + swaps;
    }

    /* ************* BINARY INSERTION SORT *************** */

    // Driver Code
    public long biSort(int array[])
    {
    	
        long comparisons = 0;
        long swaps = 0;
        for (int i = 1; i < array.length; i++)
        {
            int x = array[i];
 
            // Find location to insert
            // using binary search
            int j = Math.abs(
                Arrays.binarySearch(array, 0,
                                    i, x) + 1);
            //comparisons+=Math.log();
            // Shifting array to one
            // location right
            System.arraycopy(array, j,
                             array, j + 1, i - j); swaps++;
 
            // Placing element at its
            // correct location
            array[j] = x;
        }
        
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Complexity of binaryInsertionSort: " + (comparisons + swaps));
        System.out.println("----------");

        return swaps + comparisons;
    }

 
// Code contributed by Mohit Gupta_OMG
    public static long binaryInsertionSort(int[] my_arr){
    	
        long comparisons = 0;
        long swaps = 0;
        
        boolean swapped = true;
        int start = 0;
        int end = my_arr.length;
        while (swapped) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
            	comparisons++;
                if (my_arr[i] > my_arr[i + 1]) {
                    int temp = my_arr[i];
                    my_arr[i] = my_arr[i + 1];
                    my_arr[i + 1] = temp;
                    swapped = true;swaps++;
                }
            }
            if (!swapped)
                break;
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
            	comparisons++;
                if (my_arr[i] > my_arr[i + 1]) {
                    int temp = my_arr[i];
                    my_arr[i] = my_arr[i + 1];
                    my_arr[i + 1] = temp;
                    swapped = true;swaps++;
                }
            }
            start = start + 1;
        }
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Complexity of binaryInsertionSort: " + (comparisons + swaps));
        System.out.println("----------");

        return swaps + comparisons;
    }

    /* ********************** MERGE SORT *********************************** */
    private static long merge(int arr[], int l, int m, int r, long complexity) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;	complexity++;
        int n2 = r - m;	complexity++;

        /* Create temp arrays */
        int L[] = new int[n1];	complexity++;
        int R[] = new int[n2];	complexity++;

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        complexity+=n1;
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        complexity+=n2;
        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;	complexity++;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;complexity++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;complexity++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;complexity++;
        }

        return complexity;
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static long mergeSort(int arr[], int l, int r, long complexity) {
  	
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;	complexity++;
            
            // Sort first and second halves
            complexity += mergeSort(arr, l, m, complexity);
            complexity += mergeSort(arr, m + 1, r, complexity);

            // Merge the sorted halves
            complexity += merge(arr, l, m, r, complexity);
        }
        System.out.println("Complexity of mergeSort: " + complexity);
        System.out.println("----------");
        return complexity;
    }

    /* ***************** QUICK SORT ****************************** */

    public static long quickSort(int[] arr, int begin, int end, long complexity) {
    	if (begin < end) {
    		long[] p = new long[1];p[0]=0;
            int partitionIndex = partition(arr, begin, end, p); System.out.println();
            complexity += p[0];
            complexity += quickSort(arr, begin, partitionIndex-1, complexity);
            complexity += quickSort(arr, partitionIndex+1, end, complexity);
        }
        System.out.println("Complexity of quickSort: " + complexity);
        System.out.println("----------");
    	return complexity;
    }

    private static int partition(int[] arr, int begin, int end, long [] complexity) {
        int pivot = arr[end];	complexity[0]++;
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;complexity[0]++;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;complexity[0]++;

        return i+1;
    }

    /* *********** HEAP SORT *********************** */

    public static long heapSort(int[] arr, long complexity)
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
        	complexity += heapify(arr, n, i, complexity);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp; complexity++;

            // call max heapify on the reduced heap
            complexity += heapify(arr, i, 0, complexity);
        }
        System.out.println("Complexity of heapSort: " + complexity);
        System.out.println("----------");
        return complexity;
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private static long heapify(int[] arr, int n, int i, long complexity)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
        complexity++;
        
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
        complexity++;
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
        complexity++;
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap; complexity++;

            // Recursively heapify the affected sub-tree
            complexity += heapify(arr, n, largest, complexity);
        }
        
        return complexity;
    }

    /* ****************** COUNTING SORT ************************** */

    public static long countingSort(int[] arr) {
    	long complexity = 0;
    	
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;complexity++;
        int[] count = new int[range];
        int[] output = new int[arr.length];complexity++;
        for (int value : arr) {
            count[value - min]++;complexity++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];complexity++;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];complexity++;
            count[arr[i] - min]--;complexity++;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];complexity++;
        }
        System.out.println("Complexity of countingSort: " + complexity);
        System.out.println("----------");
        return complexity;
    }




}