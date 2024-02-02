package com.earthgee.interview;

public class Code74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;

        //列查找
        int left=0;
        int right=row-1;
        int ans=row;
        while(left<=right){
            int mid=((right-left)>>1)+left;
            if(target<=matrix[mid][0]){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        int searchRow=-1;
        if(ans==row){
            searchRow=ans-1;
        }else if(matrix[ans][0]==target){
            return true;
        }else if(ans==0){
            return false;
        }else {
            searchRow=ans-1;
        }

        left=0;
        right=col-1;
        while(left<=right){
            int middle=((right-left)>>1)+left;
            if(matrix[searchRow][middle]== target){
                return true;
            }else if(matrix[searchRow][middle]>target){
                right=middle-1;
            }else {
                left=middle+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code74 code74=new Code74();
        int[][] input={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        code74.searchMatrix(input, 3);
    }

}
