public class LongestPeak {
    public static int longestPeak(int []array){
        int maxPeak=0,i=1;
        int size = array.length;
        while(i<size-1){
            boolean isPeak = array[i-1]<array[i]&&array[i]>array[i+1];
            if(!isPeak){
                i++;
                continue;
            }
            int leftIdx = i-2;
            while (leftIdx >=0&&array[leftIdx]<array[leftIdx+1]){
                leftIdx--;
            }
            int rightIdx = i+2;
            while(rightIdx < size&&array[rightIdx]<array[rightIdx-1]){
                rightIdx++;
            }
            int currentPeakLength = rightIdx-leftIdx-1;
            maxPeak = Math.max(currentPeakLength,maxPeak);
            i = rightIdx;
        }
        return maxPeak;
    }
    public static void main(String[] args){
        int []array = {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
        System.out.println(longestPeak(array));
    }
}
