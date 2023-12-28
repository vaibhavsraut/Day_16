package com.day16;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        int n;
        System.out.print("Enter the size of list: ");
        n = scanner.nextInt();

        System.out.println("Enter the elements in list: ");
        for (int i=0;i<=n;i++){
            list.add(scanner.nextLine());
        }
        System.out.println();

        Collections.sort(list);
        list.removeFirst();
        System.out.println("List: " + list);


        System.out.print("Enter the value you want to search:");
        String key = scanner.nextLine();

        if(binarySearch(list, key)){
            System.out.println(key + " is present in list");
        }else {
            System.out.println(key + " is not present in list");
        }
    }

    static boolean binarySearch(LinkedList<String> list, String key){

        int start = 0;
        int end = list.size() - 1;

        while (start<=end){
            int mid = start + (end - start) / 2;
            if(Objects.equals(list.get(mid), key)){
                return true;
            } else if (list.indexOf(key)>mid) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return false;
    }

}
