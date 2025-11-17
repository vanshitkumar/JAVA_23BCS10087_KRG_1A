package com.esp;

public class ExceptionHandling {
    public static void validate(int num) throws Exception {
        if (num < 0) {
            throw new Exception("no. is negative");
        }
        System.out.println("No. is valid");
    }

    public static void main(String[] args) {
        try {
            validate(-5);
            System.out.println("never executed");
        }
        catch (Exception e) {
            System.out.println("Failed no. is not valid: ");
        }
        finally {
            System.out.println("Program finished");
        }
    }
}
