import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum{

    private static int productSum(List<Object> arr) {
        return ProductSumHelper(arr,1);
    }

    private static int ProductSumHelper(List<Object> arr, int level) {
        int sum = 0;
        for(Object obj:arr){
            if (obj instanceof ArrayList){
                @SuppressWarnings("unchecked")
                ArrayList<Object> el = (ArrayList<Object>) obj;
                sum += ProductSumHelper(el, level+1);
            }
            else{
                sum +=(int) obj;
            }
        }
        return sum*level;
    }
    public static void main(String[] args) {
        List<Object> test = new ArrayList<Object>(Arrays.asList(
                5,
                2,
                new ArrayList<Object>(Arrays.asList(7, -1)),
                3,
                new ArrayList<Object>(
                    Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
        
        System.out.println(productSum(test));
    }
}
