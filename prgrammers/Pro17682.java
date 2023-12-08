public class Pro17682 {



    public static void main(String[] args) {
        solution("1S*2T*3S");
    }

    static int solution ( String dartResult) {
        int answer = 0;
        dartResult = dartResult.replace("#" , "샾");
        dartResult = dartResult.replace("*" , "별");
        String [] temp = dartResult.split("");
        int[] scores = new int[3];
        String[]bo = new String[3];
        String[]op = new String[3];

        int idx = 2;

        String int_str = "";

        for (int i = temp.length - 1; i >= 0  ; i--) {
            String str = temp[i];
            if (str.equals("별") || str.equals("샾")){
                if (int_str != ""){
                    scores[idx] = Integer.parseInt(int_str);
                    idx--;
                    int_str = "";
                }
                op[idx] = str;
                continue;
            }
            if (str.equals("S") || str.equals("D") || str.equals("T")) {
                if (int_str != ""){
                    scores[idx] = Integer.parseInt(int_str);
                    idx--;
                    int_str = "";
                }
                bo[idx] = str;
                continue;
            }
            if (isInteger(str)){
                int_str = str + int_str;
            }
        }
        if (int_str != ""){
            scores[idx] = Integer.parseInt(int_str);
            int_str = "";
        }
        int [] answers = new int[3];

        for (int i = 0; i < 3; i++) {
            int bou = 0;
            if ( bo[i].equals("S")){
                bou = 1;
            }
            if ( bo[i].equals("D")){
                bou = 2;
            }
            if ( bo[i].equals("T")){
                bou = 3;
            }
            answers[i] = (int) Math.pow(scores[i] , bou);
            if (op[i] != null){
                if (op[i].equals("별")){
                    if ( i == 0 ) {
                        answers[i] = answers[i] * 2;
                    }
                    else{
                        answers[i-1] = answers[i-1] * 2;
                        answers[i] = answers[i] * 2;
                    }
                }
                if (op[i].equals("샾")){
                    answers[i] = answers[i] * -1;
                }
            }
        }

        for (int a : answers
             ) {
            answer = answer + a;
        }

        System.out.printf("" + answer);

        return answer;
    }

    static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
