public class NumberFunc {



    /*
     * Param : int n
     * return : n 의 1의 자리 수
     *
     * */
    static int ones( int n ){
        if( n < 10 ){
            return n;
        }
        return ones( n % 10 );
    }


    /*
     * Param : int n
     * return : n 의 맨 앞자리 수
     *
     * */
    static int firsts( int n ){
        if( n < 10 ){
            return n;
        }
        return ones( n / 10 );
    }
}
