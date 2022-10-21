package com.samples.leetcode;

/**
 * 733. Flood Fill <br/>
 * https://leetcode.com/problems/flood-fill/
 * 
 * @author Kumar, Prakash
 * @category Array, Depth-First Search, Breadth-First Search, Matrix
 */
public class LeetCode733 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public static void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }

        if (image[sr][sc] != oldColor || image[sr][sc] == newColor) {
            return;
        }

        image[sr][sc] = newColor;
        fill(image, sr, sc - 1, oldColor, newColor);
        fill(image, sr, sc + 1, oldColor, newColor);
        fill(image, sr - 1, sc, oldColor, newColor);
        fill(image, sr + 1, sc, oldColor, newColor);
    }
    
    public static int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }

        int oldColor = image[sr][sc];
        image[sr][sc] = color;

        // check left;
        if (sc != 0) {
            int leftColor = image[sr][sc-1];
            if (leftColor == oldColor && leftColor != color) {
                image = floodFill(image, sr, sc-1, color);
            }            
        }

        // check right;
        if (sc < image[0].length-1) {
            int rightColor = image[sr][sc + 1];
            if (rightColor == oldColor && rightColor != color) {
                image = floodFill(image, sr, sc+1, color);
            }            
        }

        // check top
        if (sr != 0) {
            int topColor = image[sr -1][sc];
            if (topColor == oldColor &&  topColor != color) {
                image = floodFill(image, sr - 1, sc, color);
            }            
        }
        // check bottom
        if (sr < image.length-1) {
            int bottomColor = image[sr + 1][sc];
            if (bottomColor == oldColor && bottomColor != color) {
                image = floodFill(image, sr + 1, sc, color);
            }            
        }       

        return image;
    }

}
