/** Time Complexity: O(log n)[log n for binary search of pivot element and then log n for binary search in the figured array]
* Space Complexity: O(1) [No extra space is used, only variables are used]
* Did this code successfully run on Leetcode : Yes
* Any problem you faced while coding this : No
* LeetCode Problem: Search in Rotated Sorted Array
* Approach:
* 1. Find the pivot index where the array is rotated.
* 2. If the target is less than the first element, search in the right part of the pivot.
* 3. If the target is greater than or equal to the first element, search in the left part of the pivot.
* 4. Use binary search to find the target in the identified part of the array.
*/

// Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

class RotatedArraySearch {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int pivotIndex= PivotIndex(nums,start,end);
        if(nums[start]>target)
        {
            if(pivotIndex!=end)
                {
                   return BinarySearch(nums,target,pivotIndex+1,end);
                }
            else
                return -1;
        }
        if(nums[start]<=target)
        {
        
              return BinarySearch(nums,target,start,pivotIndex);
                
        }
    return -1;

        
    }

        public int PivotIndex(int[] nums,int start,int end){
        while(start<end)
        {
            int mid=start+(end-start)/2;
            if(mid!=0 && nums[mid]<nums[mid-1])
            {
                return mid-1;
            }
            if(mid!=nums.length-1 && nums[mid]>nums[mid+1])
            {
                return mid;
            }
            if(nums[mid]<nums[start])
            {
                end=mid-1;
            }
            if(nums[mid]>=nums[start])
            {
                start=mid+1;
            }

        }
        return start;

    }
    public int BinarySearch(int[] nums, int target,int start, int end)
    {
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]>target)
                end=mid-1;
            if(nums[mid]<target)
                start=mid+1;
            if(nums[mid]==target)
                return mid;
        }
        return -1;
    }
    
}