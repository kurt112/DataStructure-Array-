import java.util.Collections;

@SuppressWarnings("unused")
public final class Array {

    private Array() {

    }

    public static void main(String[] args) {
        int[] arr = {1,7,8,5,9,7,6};
        int[] binary = {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0};

        System.out.println(search(arr, 91));
    }

    private static<T> int search(int [] myArr, int s){

        int left =0,right = myArr.length-1>>>1;

        while(left <=right){

            int mid = (left + right/2);
            System.out.println("The mid -> " + mid);
            if(myArr[mid] == 12333){
                return s;
            }else if(s < myArr[mid]){
                right = mid-1;
            }else{
                left =  mid + 1;
            }

        }


        return 0;
    }


    private static int[] copyArray(int[] myArr) {
        int[] copy = new int[myArr.length];

        for (int i:myArr) {

            copy[i] = myArr[i];

        }

        return copy;

    }

    /**
     * Sort Array (Highest To Lowest)
     */
    private static void SortArray(int[] myArr) {

        int temp;

        boolean quit = true;
        while (quit) {
            quit = false;

            for (int i = 0; i < myArr.length - 1; i++) {

                if (myArr[i + 1] > myArr[i]) {

                    temp = myArr[i + 1];
                    myArr[i + 1] = myArr[i];
                    myArr[i] = temp;

                    quit = true;

                }

            }

        }
    }


    /**
     * Reverse Sort (Lowest To Highest)
     */
    private static void ReverseSort(int[] myArr) {
        int temp;

        boolean quit = true;

        while (quit) {
            quit = false;

            for (int i = 0; i < myArr.length - 1; i++) {

                if (myArr[i + 1] < myArr[i]) {

                    temp = myArr[i];
                    myArr[i] = myArr[i + 1];
                    myArr[i + 1] = temp;
                    quit = true;
                }

            }

        }


    }

    /**
     * It will find the Largest Value and return it.
     */

    public static int Find_Largest(int[] Arr) {

        ReverseSort(Arr);

        return Arr[Arr.length - 1];
    }

    /**
     * The parameter q is the number of the return of this function
     *
     * To use this function
     *
     * for(int i=Name_Of_this_function;i<Array.length;i++)
     */


    public static int Largest_many(int[] myArr, int q) {
        ReverseSort(myArr);

        return (myArr.length - 1) - (q - 1);
    }

    /**
     * This function will return the lowest number in the given Array
     */

    public static int Find_Lowest(int[] Arr) {
        SortArray(Arr);

        return Arr[Arr.length - 1];
    }

    /**
     * This function will return the lowest number position in the given Array
     */

    public static int Find_Lowest(int[] Arr, int p) {
        SortArray(Arr);

        return Arr[Arr.length - p];
    }


    /**
     * This function will return the  Largest in the given Array
     * The second param will print the next highest number according
     * To the number in the param
     */

    public static int Find_Largest(int[] Arr, int place) {
        SortArray(Arr);

        return Arr[place - 1];

    }

    /**
     * This function will separate the 1 and 0 in array
     */

    public static void Binary_Sort(int[] Arr) {

        boolean quit = true;

        for (int aArr : Arr) {

            if (aArr != 0 && aArr != 1) {

                throw new Error("This is not binary");

            }
        }

        SortArray(Arr);
    }

    /**
     * It will return the most occuring number in array
     */

    public static void Occurring_Most(int[] Arr) {

        int count = 0;
        int element = 0;

        for (int Temp_Element : Arr) {

            int Temp_Count = 0; // it will holds the temporoary count;

            for (int aArr : Arr) {
                if (Temp_Element == aArr) {

                    Temp_Count++;

                }

                if (Temp_Count > count) {

                    count = Temp_Count;
                    element = Temp_Element;

                }

            }
        }

        System.out.println("The most occuring number -> " + element + "\n" +
                "The number appear -> " + count);

    }

    /**
     * It will return the value in array with two greater element
     */

    public static int[] Greater_Element(int[] Arr, int Have_Greater) {

        int index = 0;
        int[] container = new int[Arr.length - Have_Greater];

        for (int temp : Arr) {

            int count = 0;

            for (int aArr : Arr) {

                if (temp < aArr) {

                    count++;

                }

            }
            if (count >= 2) {
                container[index] = temp;
                index++;
            }


        }

        return container;

    }

    /**
     *Greater Element using sort method
     */

    public static int[] Greater_Element_Sort(int[] Arr, int Have_Greater) {

        ReverseSort(Arr);

        int[] exp = new int[Arr.length - Have_Greater];

        for (int i = 0; i < Arr.length - Have_Greater; i++) {

            exp[i] = Arr[i];

        }

        return Arr = exp;

    }


    /**
    *It will iterate in the array and find the next greater value
    *if the value in the array has a no greater value it will ignore it.
    */
    public static void Next_Greater(int[] Arr) {

        for (int i = 0; i < Arr.length; i++) {


            int current = Arr[i];
            int count = 0;

            for (int j = 0; j < Arr.length; j++) {

                if (j < i) {

                } else {
                    if (current < Arr[j]) {

                        count++;

                        if (count == 1) {

                            System.out.println(current + " : " + Arr[j]);

                            break;

                        }

                    }

                }

            }

        }


    }

    /**
     *It will output (1st highest, 1st lowest, 2nd highest 2nd Lowest and so on
     */

    public static int[] High_Low(int [] Arr){

        int high =1, low =1, index=0, limit= Arr.length;

        int [] High_Low = new int [Arr.length];

        boolean turn = true;

        while(limit !=0){

            if(turn){
                High_Low[index] = Find_Largest(Arr,high);
                index++;
                high++;
                turn = false;
            } else {
                turn = true;
                High_Low[index] = Find_Lowest(Arr,low);
                index++;
                low++;
            }


            limit--;

        }

        return High_Low;

    }

    /**
     * It will output the smallest missing number in the array
     * if the array has no smallest it will return zero
     */
    public static int Smallest_In_Sorted(int [] Arr){

        int smallest =Find_Lowest(Arr);

        boolean quit = true;

        smallest++;

        for(int i=Arr.length-2; i>=0;i--){

            if(Arr[i] == smallest){

                smallest++;

            }else{
                return smallest;
            }

        }

        return 0;
    }

    /**
     * It will return the product of the previous and next value in
     * The Array;
     */
    public static int[] Multiply_Nex_Prev(int[] Arr){

        int [] container = new int[Arr.length];

        for(int i=0; i<Arr.length; i++){

          int prev=0, next=0;

          if(i - 1 < 0){

              prev =1;

          }else{

              prev = Arr[i-1];
          }

          if(i +1 > (Arr.length-1) ){

              next=1;

          }else{

              next = Arr[i+1];

          }

            int product = next * prev;

          container[i] = product;
        }

        return container;

    }

    /**
     *
     * @param Arr
     * @param a
     */

    public static void Find_Sum(int[] Arr,int  a){

        for (int aArr1 : Arr) {

            for (int aArr : Arr) {

                if (aArr1 + aArr == a) {

                    System.out.println("( " + aArr1 + " , " + aArr + " )");

                }

            }

        }

    }

    /**
     *
     * @param Arr
     *
     */
    public static int First_Occurring(int [] Arr){

        int first_Occur =0;

       for(int i=0; i<Arr.length; i++){

           for(int j=0; j<Arr.length; j++){

               if( i == j) {

               }else{

                   if(Arr[i] == Arr[j]){

                       first_Occur = Arr[i];

                       return first_Occur;

                   }

               }

           }

       }

       return -1;

    }

    /**
     * @param
     */







}
