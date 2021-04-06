public class MedianOfSortedArray {
    public static double findMedian(int[] nums1, int[] nums2){
        int size1 = nums1.length; int size2 = nums2.length;
        int size = size1 + size2;
        int []result = new int[size];
        int indexA = 0, indexB = 0,i=0;
        while(indexA < size1 && indexB < size2){
            if(nums1[indexA] < nums2[indexB]){
                result[i] = nums1[indexA];
                indexA++;
            }
            else if(nums1[indexA] > nums2[indexB]){
                result[i] = nums2[indexB];
                indexB++;
            }
            else {
                result[i] = nums2[indexB];
                indexB++;
            }
            i++;
        }
        while(i<size){
            if(indexA<size1){
                result[i] = nums1[indexA];
                indexA++;
            }
            else{
                result[i] = nums2[indexB];
                indexB++;
            }  
            i++;   
        }
        //System.out.println(Arrays.toString(result));
        if(size%2==0){
            return (result[(size/2)-1]+result[size/2])/2.0;
        }
        else{
            return result[size/2];    
        }
    }
    public static void main(String[] args){
        int[] nums1 = {2,3,5,16};
        int[] nums2 = {1,7,8,19};
        System.out.println(findMedian(nums1, nums2));
    }
}
