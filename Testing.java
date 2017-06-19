/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;
import testing.MinArray;
import java.util.*;
/**
 *
 * @author cuong
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] testData = new int[8];
        testData[0] = 2;
        testData[1] = 1;
        testData[2] = 2;
        testData[3] = 3;
        testData[4] = 3;
        testData[5] = 2;
        testData[6] = 1;
        testData[7] = 1;
        MinArray getMin = new MinArray();
        getMin._insertDatas(testData);
        getMin._insert(0);
        getMin._insert(3);
        getMin._insert(2);
        getMin._insert(3);
        getMin._insert(3);
        getMin._insert(1);
        getMin._insert(1);
        getMin._insert(1);
        getMin._delete();
        getMin._delete();
        getMin._delete();
        getMin._delete();  
        getMin._delete();
        getMin._delete(); 
        getMin._delete(); 
        getMin._delete();
        getMin._delete();
        System.out.println("=> Min currently value: "+getMin._minValue());
/*
            Map<String, String> misspeltWords = new HashMap<String, String>();
            misspeltWords.put("calender", "calendar");
            misspeltWords.put("tomatos", "tomatoes");
            misspeltWords.put("existance", "existence");
            misspeltWords.put("aquaintance", "acquaintance");
            String sentence = "Buy a calender for the year 2013";
            System.out.println("The given sentence is: " + sentence);
            for(String word : sentence.split(" ")) {
                  if(misspeltWords.containsKey(word)) {
                        System.out.println("The correct spelling for " + word
                                    + " is: " + misspeltWords.get(word));
                  }
            }

 
    }*/
    
}
