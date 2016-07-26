import java.util.Arrays;

public class Add_1_To_Array {

    public static void add1 (int [] arr) {
        for(int i = arr.length-1; i >= 0; i--) {
            arr[i] += 1;
            if(arr[i] < 10) {
                return;
            }
            else {
                arr[i] = 0;   
            }
        }
    }   

    public static void main(String [] args) {
        int [] num = {9, 9, 9, 8};
        add1(num);
        System.out.println(Arrays.toString(num));
    }

}
