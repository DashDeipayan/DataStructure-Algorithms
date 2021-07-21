import java.util.*;

public class ClassPhotos {
    public static boolean classPhotos(ArrayList<Integer> blueShirtHeight, ArrayList<Integer> redShirtHeight) {
        Collections.sort(redShirtHeight, Collections.reverseOrder());
        Collections.sort(blueShirtHeight, Collections.reverseOrder());

        boolean blueIsBackrowColor = isBlueBackrowColor(redShirtHeight.get(0), blueShirtHeight.get(0));
        for (int i = 0; i < blueShirtHeight.size(); i++) {
            if (blueIsBackrowColor) {
                if (blueShirtHeight.get(i) < redShirtHeight.get(i)) {
                    return false;
                }
            } else {
                if (blueShirtHeight.get(i) > redShirtHeight.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBlueBackrowColor(Integer tallestRedHeight, Integer tallestBlueHeight) {
        return tallestRedHeight < tallestBlueHeight;
    }

    public static void main(String[] args) {
        ArrayList<Integer> blueShirtHeight = new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> redShirtHeight = new ArrayList<Integer>(Arrays.asList(6, 9, 2, 4, 5));
        System.out.println(classPhotos(blueShirtHeight, redShirtHeight));
    }
}
