import java.util.*;

public class Pro92334 {
    public static void main(String[] args) {

    }

//    public int[] solution(String[] idList, String[] report, int k){
//        int[] answer = new int[idList.length];
//        HashMap<String, HashSet<String>> reportList = new HashMap<>(); // key : 신고한 ID   value : 신고한 사람들 ID String Set
//        HashMap<String, Integer> reportedCountMap = new HashMap<>(); // 신고 당한 횟수 count
//        HashSet<String> Set = new HashSet<>(Arrays.asList(report)); // 중복 신고 제거 , 신고 내용들
//
//        for(String reportInfo : Set){
//            String reporter = reportInfo.split(" ")[0];  // 신고 한 사람
//            String reported = reportInfo.split(" ")[1];  // 신고 당한 사람
//            // 신고당한 ID 추가
//            if (reportList.containsKey(reporter)) {
//                // reporter key 있는 데이터 처리
//                reportList.get(reporter).add(reported);
//            } else {
//                HashSet<String> hashSet = new HashSet<>();
//                hashSet.add(reported);
//                reportList.put(reporter , hashSet);
//            }
//            // 신고 당한 사람 횟수 + 하기
//            if (reportedCountMap.containsKey(reporter)){
//                reportedCountMap.put(reporter , reportedCountMap.get(reporter) + 1 );
//            }
//            else{
//                reportedCountMap.put(reporter , 1);
//            }
//
//        }
//
//        for (String reported : reportedCountMap.keySet()){  // 신고 카운트 map 의 키값 for 문
//            int reportCnt = reportedCountMap.get(reported);
//            if (reportCnt >= k ){
//                for (int i = 0; i < idList.length; i++) {
//                    if ()
//
//                }
//            }
//        }
//        return answer;
//    }

//    public int[] solution(String[] idList, String[] report, int k){
//        int[] answer = new int[idList.length];
//        HashMap<String, HashSet<String>> reportList = new HashMap<>(); // key : 신고한 ID   value : 신고한 사람들 ID String Set
//        HashMap<String, Integer> reportedCountMap = new HashMap<>(); // 신고 당한 횟수 count
//        HashSet<String> Set = new HashSet<>(Arrays.asList(report)); // 중복 신고 제거 , 신고 내용들
//
//        for(String reportInfo : Set){
//            String reporter = reportInfo.split(" ")[0];  // 신고 한 사람
//            String reported = reportInfo.split(" ")[1];  // 신고 당한 사람
//            reportList.putIfAbsent(reporter, new HashSet<String>(){{ // key가 있으면 값 반환 없으면 value 넣고 null 반환
//                add(reported); // 신고당한 ID 추가
//            }});
//            reportList.get(reporter).add(reported); // reporter key 있는 데이터 처리
//            // key 값에 맞는 value 없으면 defaultValue
//            // 있으면 value 가져옴
//            reportedCountMap.put(reported, reportedCountMap.getOrDefault(reported, 0)+1); // 신고 당한 사람 횟수 + 하기
//        }
//
//        for (String reported : reportedCountMap.keySet()){  // 신고 카운트 map 의 키값 for 문
//            int reportedCount = reportedCountMap.get(reported); // 신고 당한 횟수
//            if(reportedCount >= k){ // k 번 넘으면 key 값에 있는 사람을 신고했던 ID 한테 메일 발송
//                // 메일 발송 대상
//                for(int i=0; i<idList.length; i++){
//                    // 신고한 사람리스트 중에 k 번 넘은 ID 가 있는지
//                    if(reportList.containsKey(idList[i]) && reportList.get(idList[i]).contains(reported)) {
//                        answer[i]++; // 있으면 한 사람당 카운트
//                    }
//                }
//            }
//        }
//        return answer;
//    }



}
