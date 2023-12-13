public class BinarySearchImpl {

    public static void main(String[] args) {
        int [] numbers = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};

        int [] itzy = { 3 , 999 , 6 , 7 , 8 };

        for (int i : itzy
             ) {
            System.out.printf(binarySearch( numbers , i , 0 , numbers.length -1 ) + " ");
        }


    }

    static int binarySearch( int[] numbers , int key , int low , int high){
        int mid;

        if( low <= high ){
            mid = ( low + high ) / 2;

            if (key == numbers[mid]){
                return 1;
            }
            else if ( key < numbers[mid]){
                return binarySearch(numbers , key , low , mid - 1);
            } else {
                return binarySearch( numbers , key , mid+1 , high);
            }
        }

        return 0;
    }
}
