package com.rcm.dataStructure.arrays;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ReverseString {

    public static void main(String[] args) {

        Long start = System.currentTimeMillis();
        System.out.println(reverse("My name is Roopa and what is your name. I would like to know very much Danke"));
        Long fin = System.currentTimeMillis();
        System.out.println("Time for 'reverse' "+(fin - start) + "ms");

        Long start2 = System.currentTimeMillis();
        System.out.println(reverseImproved("eknaD hcum yrev wonk ot ekil dluow I .eman ruoy si tahw dna apooR si eman yM "));
        Long fin2 = System.currentTimeMillis();
        System.out.println("Time for 'reverse' "+(fin2 - start2) + "ms");
    }

    //O(a*b)
    static String reverse(String str) {
        List<String> strList = Arrays.asList(str.split(" "));
        StringBuilder sb = new StringBuilder();
        for(int x=strList.size()-1; x >=0; x--) { // O(a)
            String[] word = strList.get(x).split("");
            for(int y = word.length-1; y>=0; y--) { // O(b)
                sb.append(word[y]);
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    //O(n)
    static String reverseImproved(String str) {
        String[] ipArray = str.split("");
        StringBuilder sb = new StringBuilder();
        for(int x=ipArray.length-1; x >=0; x--) { //O(n)
            sb.append(ipArray[x]);
        }
        return sb.toString();
    }

}
