package CodingTestBasic;

import java.util.HashMap;

public class CodingTestBasic {

    public static void main(String[] args) {

        //String to Int
        String str = "123";
        int num = Integer.parseInt(str);

        //int to String
        int num1 = 123;
        String str1 = Integer.toString(num1);

        //10진수 ->2진수
        String str2 = Integer.toBinaryString(num);
        System.out.println("2진수: "+str2);

        //10진수->8진수
        String str3 = Integer.toOctalString(num);
        System.out.println("8진수: "+str3);

        //10진수->16진수
        String str4 = Integer.toHexString(num);
        System.out.println("8진수: "+str4);

        //2진수->10진수
        int temp = Integer.parseInt(str2, 2);
        System.out.println("2진수->10진수: "+temp);

        //8진수->10진수
        System.out.println("8진수->10진수: "+Integer.parseInt(str3, 8));

        //둘 중 큰 수 반환 (min도 가능)
        System.out.println("더 큰 수 : "+ Integer.max(3, 5));

        //2진수의 1 개수
        System.out.println("2진수의 1 개수 : "+ Integer.bitCount(num1));

        // 3번째 인덱스에 있는 문자 반환
        String subject = "자바 프로그래밍";
        char charValue = subject.charAt(3);
        System.out.println(charValue);


        //해당 문자열의 index 위치 반환
        String subject1 = "자바 프로그래밍";
        int index = subject1.indexOf("프로그래밍");
        System.out.println("프로그래밍 문자열의 시작 index 는 : "+ index);

        // 해당 문자열의 문자 개수 반환
        String subject2 = "자바 프로그래밍";
        int len = subject2.length();
        System.out.println("문자열의 개수 : " +  len);

        // 해당 문자열의 문자열 치환
        String subject3 = "자바 프로그래밍";
        String newStr = subject3.replace("자바" , "JAVA");
        System.out.println(" before : " + subject3);
        System.out.println(" after : " + newStr);


        // 문자열 잘라내기
        String subject4 = "951211-1234567";
        String firstNum = subject4.substring(0 , 6);
        String secondNum = subject4.substring(7);
        System.out.println(" 처음 잘라낸 문자열 : " + firstNum);
        System.out.println(" 두번째 문자열 : " + secondNum);


        // 알파벳 소,대문자 변경
        String original = "Java Programming";
        String lowerCase = original.toLowerCase();
        String upperCase = original.toUpperCase();
        System.out.println(" 문자열 대문자 -> 소문자 : " + lowerCase );
        System.out.println(" 문자열 소문자 -> 대문자 : " + upperCase );

        // 앞뒤 공백 잘라내기
        String before1 = " 자바 프로그래밍 ";
        String after1 = before1.trim();
        System.out.println( " 앞뒤 공백 자르기 전 : " + before1);
        System.out.println( " 앞뒤 공백 자르기 후 : " + after1);

        // 문자열 변환
        boolean b = true;
        int i = 1;
        long l = 124242L;
        char c = 'c';
        double d = 0.4343;
        float f = 0.5252f;

        System.out.println(" boolean b : " + String.valueOf(b));
        System.out.println(" int i : " + String.valueOf(i));
        System.out.println(" long l : " + String.valueOf(l));
        System.out.println(" char c : " + String.valueOf(c));
        System.out.println(" double d : " + String.valueOf(d));
        System.out.println(" float f : " + String.valueOf(f));


    }



}
