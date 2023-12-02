public class gugudan {

    public static void main(String[] args) {

        int I = 1;
        int J = 1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf( I * J + " ");
                J++;
            }
            J=1;
            I++;
            System.out.println();
        }

        /*
        *
        *  1*1 1*2 1*3 1*4
        *  2*1 2*2 2*3 2*4
        *  3*1 3*2 3*3 3*4
        *  4*1 4*2 4*3 4*4
        * */




    }

}
