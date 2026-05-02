package com.learn.maven;

import java.util.Scanner;

public class Main
{
    public static int calculator(int a,int b){
        return a+b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Anurag It works!");
        System.out.println(calculator(5,4));
    }
}
