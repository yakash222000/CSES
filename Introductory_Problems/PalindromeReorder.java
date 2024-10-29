package Introductory_Problems;


import java.util.*;

public class PalindromeReorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean check = true;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
        }
        int odd = 0;
        for(char i : map.keySet()){
            if(map.get(i)%2==1) odd++;
        }
        if(s.length()%2==0 && odd>0) check=false;
        else if(s.length()%2==1 && odd>1){
            check=false;
        }
        if(check){
            char[] array = new char[s.length()];
            char middle='a';
            int index=0;
            for(char i : map.keySet()){
                int count = map.get(i);
                if(count%2==1) middle=i;
                while(count>1){
                    array[index]=i;
                    array[s.length()-index-1]=i;
                    index++;
                    count-=2;
                }
            }
            if(s.length()%2==1)array[index]=middle;
            System.out.println(String.valueOf(array));
        }
        else{
            System.out.println("NO SOLUTION");
        }
    }
}


