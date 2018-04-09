package Algorithms;

public class AppendAndDelete {

    static String appendAndDelete(String s, String t, int k) {
        char [] s_ = s.toCharArray();
        char [] t_ = t.toCharArray();
        int length = 0;
        int size = s_.length < t_.length ? s_.length : t_.length;
        for (int i = 0; i < size; i++) {
            if(s_[i] == t_[i]){
                length++;
            }
        }

        if(size - length + Math.abs(s_.length - t_.length) > k){
            return "No";
        }

        return "Yes";
    }

}
