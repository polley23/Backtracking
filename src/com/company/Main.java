package com.company;

import com.company.NQueen.NQueen;

public class Main {

    public static void main(String[] args) {
	// write your code here
        NQueen nQueen=new NQueen(4);
        System.out.println(nQueen.backtrack());
        nQueen.show();

    }
}
