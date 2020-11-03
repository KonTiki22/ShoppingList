package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        ShoppingList list = new ShoppingList();
        String rec = in.nextLine();
        while(rec != "") {
            list.add(rec);
            rec = in.nextLine();
        }
        System.out.println(list);
    }
}
