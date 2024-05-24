import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class algorithms{
    
    public static void quicksort(int[] array, int low ,int high){
        if(low<high){
            int pivotIndex = partition(array ,low, high);
            quicksort(array, low, pivotIndex-1);
            quicksort(array, pivotIndex+1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low-1;

        for(int j = low; j <high ; j++){
            if(array[j] <= pivot){
                i++;
                int temp = array[i];
                array[i]=array[j];
                array[j]= temp;
            }
        }

        int temp =array[i+1];
        array[i+1]= array[high];
        array[high]=temp;
        return i+1;
    }

    public static void main(String[] args){
        try {
            // Provide the path to your file
            String filePath = "C:\\Users\\Shehan\\Documents\\GitHub\\sorting-algorithm\\src\\file.txt";

            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // Read the numbers from the file and store them in an ArrayList
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            reader.close();

            // Convert the string to an array of integers
            String[] numbersStr = sb.toString().split("\\s+");
            int[] array = new int[numbersStr.length];
            for (int i = 0; i < numbersStr.length; i++) {
                array[i] = Integer.parseInt(numbersStr[i]);
            }

        quicksort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));

        }catch (IOException e){
            e.printStackTrace();
        }
    

        }
    }

