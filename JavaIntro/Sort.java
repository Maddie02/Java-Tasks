class Sort {
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[] numbers = new int[] { 77, 5, 2 };
        // for (int i = 0; i < numbers.length; i ++) {
        //     System.out.println(numbers[i]);
        // }
        
        Sort.selectionSort(numbers);
    
        for (var x : numbers) {
            System.out.println(x);
        }

    }
}