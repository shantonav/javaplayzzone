package com.test.solutions.helpers;

import java.util.Arrays;

public class Testtest {

    public static void main (String[] a){
        String paymentID= "000000170100002010730000100001";
        System.out.println("paymentid="+paymentID);

        String orderid = Integer.valueOf(paymentID.substring(10,20)).toString();
        String effortid = Integer.valueOf(paymentID.substring(20,25)).toString();
        String attemptid = Integer.valueOf(paymentID.substring(25,30)).toString();



        System.out.println("orderid="+orderid+", effortid="+effortid+", attemptid="+attemptid);

        int[] inputArray = {2,1,10,2,4,8,1};
        int result = maxDifference(inputArray);

        System.out.println(result);

    }

    static int maxDifference(int[] a) {
        int maximumDifference = a[1] - a[0], minimumValue = a[0];
        int index = 1;
        while(index < a.length){
            int currentDiff = a[index] - minimumValue;
            if(currentDiff > maximumDifference){
                maximumDifference = currentDiff;
            }
            if(a[index] < minimumValue){
                minimumValue = a[index];
            }
            index += 1;
        }
        return maximumDifference;
    }
}
