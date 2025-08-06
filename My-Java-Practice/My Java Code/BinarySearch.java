public class BinarySearch{

    public static int binarySearch(int[] array, int n){
        int left = 0;
        int right = array.length - 1;
        boolean found = false;
        int mid = 0;
        while(left <= right && !found){
            mid = (left + right)/2;
            if(array[mid] == n){
                found = true;
            } else if(array[mid] < n){
                left = mid + 1;
            } else if(array[mid] > n){
                right = mid - 1;
            }
            }
        if(found){
            return array[mid];
        } else{
            return -1; //Element not found
        }
        }

        public static void main(String[] args) {
            
            int[] array = {1,3,4,5,7,8,23,45,6};
            System.out.println(binarySearch(array, 7));
            System.out.println(binarySearch(array, 2));

        }

    }
