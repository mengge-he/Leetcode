public class medianOfTwoSortedArrays {
    public static double findMedian(int[] nums1, int[]nums2){
        if (nums1.length > nums2.length) return findMedian(nums2, nums1);

        int m=nums1.length;
        int n=nums2.length;

        int totalLeft=(m+n+1)/2;

        //left and right are search range of nums1's split
        int left=0;
        int right=m;

        while(left<=right){
            int i = left + (right - left) / 2; // cut in nums1
            int j = totalLeft - i;            // cut in nums2

            //if i==0,there is no element on the left,otherwise,it has all the element minor than nums[i-1]
            int nums1Left  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int nums2Left  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if (((m + n) % 2) == 1) {
                    return Math.max(nums1Left, nums2Left); // odd length
                } else {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;//even length
                }
            }
            else if (nums1Left > nums2Right) {
                right = i - 1;
            }
            // i is too small, move right
            else {
                left = i + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");



        }



    }


