package com.earthgee.interview;

public class Code240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;

        for(int i=0;i<row;i++){
            if(matrix[i][0]<=target && target <= matrix[i][col-1]){
                int left=0;
                int right=col-1;
                while(left<right){
                    int mid=left+(right-left)/2;
                    if(matrix[i][mid]==target){
                        return true;
                    } else if(matrix[i][mid]>target){
                        right=mid-1;
                    } else {
                        left = mid+1;
                    }
                }
                if(matrix[i][left]==target){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Code240 code240=new Code240();
        int[][] matrix={{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        code240.searchMatrix(matrix, 5);
    }

}
