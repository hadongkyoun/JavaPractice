
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int N = input.nextInt(), M = 0;
    double[] scores = new double[N];
    double avg = 0.0;
    
    for(int i=0; i<N; i++){
      scores[i] = input.nextInt();
      if(M < scores[i])
        M = (int)scores[i];
    }

    for(int i=0; i<N; i++){
      scores[i] = scores[i]/M*100;
      avg += (double)scores[i];
    }
    avg = avg/N;

    System.out.println(avg);

    input.close();
  }
}
