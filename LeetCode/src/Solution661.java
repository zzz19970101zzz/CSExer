/**
 * @author zzz
 * @create 2022-03-24-9:23
 */
public class Solution661 {
    public int[][] imageSmoother(int[][] img) {

        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                int m = m(img, i, j);
                res[i][j] = m ;
            }
        }
        return res;
    }

    public int m(int[][] img,int i ,int j){
        int res = img[i][j];
        int count = 1;
        if(i - 1 >= 0){
            if(j - 1 >= 0){
                res+=img[i-1][j-1];
                count++;
            }
            res+=img[i-1][j];
            count++;
            if(j + 1 < img[i].length){
                res+=img[i-1][j+1];
                count++;
            }
        }
        if(j-1>=0) {
            res+=img[i][j-1];
            count++;
        }
        if(j+1<img[i].length){
            res+=img[i][j+1];
            count++;
        }
        if(i + 1 < img.length){
            if(j - 1 >= 0){
                res+=img[i+1][j-1];
                count++;
            }
            res+=img[i+1][j];
            count++;
            if(j + 1 < img[i].length){
                res+=img[i+1][j+1];
                count++;
            }
        }
        return res/count;
    }
}
