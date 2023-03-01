package com.KiranDhoke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AtmOperationImpl implements com.KiranDhoke.AtmOperationInterf {
    com.KiranDhoke.ATM atm=new com.KiranDhoke.ATM();
    Map<Double,String> ministmt=new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : " + atm.getBalance());
    }
    @Override
    public void Transfer() {
        int reciverAtmNo=12106;
        Scanner in=new Scanner(System.in);

        System.out.println("enter receviers no : ");
        int reciverAtmNO=in.nextInt();

        if(reciverAtmNo==reciverAtmNO){
            while (true){
                System.out.println("enter your amount to transfer : ");
                int TransferAmount = in.nextInt();
                System.out.println("your transfer amount is : "+ TransferAmount);
                ministmt.put((double) TransferAmount," Amount Transfered");
                break;
            }
        }
        else{
            System.out.println("Your credentials are wrong");
        }




    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount%500==0) {
            if (withdrawAmount <= atm.getBalance()) {
                ministmt.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the Cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        }
        else {
            System.out.println("Please enter the amount in multipal of 500");
        }

    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount," Amount Deposited");
        System.out.println(depositAmount+" Deposited Successfully !!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();

    }

    @Override
    public void viewMiniStatement() {
        for(Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }

    }
}