class Main {
    private static int digitsCount(int number) {
        int count = 1;
        while (number >= 9) {
            count ++;
            number /= 10;
        }
        return count;
    }
}

