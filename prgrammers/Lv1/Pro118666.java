package Lv1;

public class Pro118666 {
    class Solution {
        // {{R , T} , { C , F } , { J , M } , { A , N }} 순으로 점수 기입
        private int [][] points = new int[4][2];

        public String solution(String[] survey, int[] choices) {
            String answer = "";
            // 설문지와 선택지 모두 point 에 점수 기입하는 함수 호출
            for( int i = 0; i < survey.length ; i++ ){
                convert( survey[i] , choices[i] );

            }

            // 점수가 모두 기입 되었을 때 성격 유형 반환하기
            // 같을 경우 사전 순으로 기입
            if(points[0][0] >= points[0][1]){
                answer += "R";
            }
            else{
                answer += "T";
            }
            if(points[1][0] >= points[1][1]){
                answer += "C";
            }
            else{
                answer += "F";
            }
            if(points[2][0] >= points[2][1]){
                answer += "J";
            }
            else{
                answer += "M";
            }
            if(points[3][0] >= points[3][1]){
                answer += "A";
            }
            else{
                answer += "N";
            }
            return answer;
        }

        private void convert( String category , int choice ){
            // switch 문으로 각 카테고리 별 점수 환산
            switch ( category ){
                case "RT" :
                    // 부정일 경우 앞쪽에 점수 부여 "R"
                    if( choice < 4 ){
                        points[0][0] += ( 4 - choice );
                    }
                    // 긍정일 경우 뒤 쪽에 점수 부여 "T"
                    else if ( choice > 4 ){
                        points[0][1] += ( choice - 4 );
                    }

                    break;
                case "TR" :
                    // 부정일 경우 앞쪽에 점수 부여 "T"
                    if( choice < 4 ){
                        points[0][1] += ( 4 - choice );
                    }
                    // 긍정일 경우 뒤 쪽에 점수 부여 "R"
                    else if ( choice > 4 ){
                        points[0][0] += ( choice - 4 );
                    }

                    break;
                case "CF" :
                    if( choice < 4 ){
                        points[1][0] += ( 4 - choice );
                    }
                    else if ( choice > 4 ){
                        points[1][1] += ( choice - 4 );
                    }

                    break;
                case "FC" :
                    if( choice < 4 ){
                        points[1][1] += ( 4 - choice );
                    }
                    else if ( choice > 4 ){
                        points[1][0] += ( choice - 4 );
                    }

                    break;
                case "JM" :
                    if( choice < 4 ){
                        points[2][0] += ( 4 - choice );
                    }
                    else if ( choice > 4 ){
                        points[2][1] += ( choice - 4 );
                    }

                    break;
                case "MJ" :
                    if( choice < 4 ){
                        points[2][1] += ( 4 - choice );
                    }
                    else if ( choice > 4 ){
                        points[2][0] += ( choice - 4 );
                    }

                    break;
                case "AN" :
                    if( choice < 4 ){
                        points[3][0] += ( 4 - choice );
                    }
                    else if ( choice > 4 ){
                        points[3][1] += ( choice - 4 );
                    }

                    break;
                case "NA" :
                    if( choice < 4 ){
                        points[3][1] += ( 4 - choice );
                    }
                    else if ( choice > 4 ){
                        points[3][0] += ( choice - 4 );
                    }

                    break;
                default :
                    break;
            }
        }
    }
}
