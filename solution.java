import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {
    // Write your code here
    long ans=0;
    for(int i=0;i<h.size();i++)
    {
        
        //left
        int count=0;long temp=0;long temp2=0;
            for(int j=i;j>=0;j--)
            {
                if(h.get(i)<=h.get(j))
                {
                    count+=1;
                }
                else
                break;
            }
        temp=count*h.get(i);

        //System.out.print("left ");
         //System.out.print(h.get(i));
        //System.out.print(" ");
            //    System.out.print(count);
        //System.out.print(" ");
        //System.out.println(count*h.get(i));

        //right
        count=0;
            for(int j=i;j<h.size();j++)
            {
                if(h.get(i)<=h.get(j))
                {
                    count+=1;
                }
                else
                break;
            }
        temp2=count*h.get(i);

        //        System.out.print("right ");
        //System.out.print(h.get(i));
        //System.out.print(" ");
        //System.out.print(count);
        //System.out.print(" ");
        //System.out.println(count*h.get(i));

    if(ans<temp+temp2-h.get(i))
    {
        ans=temp+temp2-h.get(i);
    }
    //System.out.println(ans);
    
    }
    
return(ans);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
