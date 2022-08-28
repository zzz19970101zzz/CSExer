/**
 * @author zzz
 * @create 2022-08-19-20:47
 */
public class Solution1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if(startTime[i] <= queryTime && endTime[i] >= queryTime){
                res++;
            }
        }
        return res;
    }
}
