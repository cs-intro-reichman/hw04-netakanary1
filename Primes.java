public class Primes {
    public static void main(String[] args) {
        final int num = Integer.parseInt(args[0]);

        int cntPrime = 0;
        boolean[] arr = new boolean[num + 1];
        if (arr.length >= 2) {
            arr[0] = false;
            arr[1] = false;

            for (int i = 2; i < arr.length; i++) {
                arr[i] = true;
            }
            int prime = 2;
            for (int i = 2; i < Math.sqrt(num); i++) {
                for (int j = prime + prime; j < arr.length; j += prime) {
                    arr[j] = false;
                }
                prime = getNextTrueIndex(arr, prime);
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == true) {
                    System.out.println(i);
                    cntPrime++;
                }
            }
            System.out.println("There are " + cntPrime + " primes between 2 and " + num + " ("
                    + (int) ((double) cntPrime / num * 100) + "% are primes) ");
        }
    }

    public static int getNextTrueIndex(boolean arr[], int fromIndex) {
        if (fromIndex == arr.length - 1)
            return fromIndex;
        for (int i = fromIndex + 1; i < arr.length; i++) {
            if (arr[i] == true)
                return i;
        }
        return arr.length - 1;
    }
}
