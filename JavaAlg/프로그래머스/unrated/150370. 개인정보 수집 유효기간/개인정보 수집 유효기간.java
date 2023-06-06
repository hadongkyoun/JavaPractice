import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] sample = new int[privacies.length];
        int[] answer;
        int answerSize = 0;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate realToday = LocalDate.parse(today, df);
        LocalDate infoDay;
        long subMonth;
        termClass myTermClass = new termClass(terms);
        
        for(int i = 0; i<privacies.length; i++){
            // terms의 어떤 부분에 맞는지
            String [] info =  privacies[i].split(" ");
            //info[0]는 date, info[1]은 약관
            
            //date 일반화
            infoDay = LocalDate.parse(info[0], df);
            subMonth = Math.abs(realToday.until(infoDay, ChronoUnit.MONTHS));
            if(subMonth >= myTermClass.getCaseMonth(info[1])){
                sample[answerSize] = i+1;
                answerSize++;
            }
            
        }
        answer = new int[answerSize];
        for(int i=0; i<answerSize; i++)
            answer[i] = sample[i];
        return answer;
    }
}
class termClass{
    private int[] limitMonth;
    private String[] limitCase;
    
    termClass(String[] terms){
        limitCase = new String[terms.length];
        limitMonth = new int[terms.length];
        String[] data;
        for(int i =0; i<terms.length; i++){
            data = terms[i].split(" ");
            limitCase[i] = data[0];
            limitMonth[i] = Integer.parseInt(data[1]);
        }
    }
    
    int getCaseMonth(String caseData){
        for(int i=0; i<limitCase.length; i++){
            if(limitCase[i].equals(caseData))
                return limitMonth[i];
        }
        //Error (여기선 일어 날 일 없음)
        return -1;
    }
}