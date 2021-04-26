package com.company;
import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] nameList = new String[30];
        String[] numberList = new String[30];
        String[] addressList=new String[30];
        nameList[0] = "Gina";
        numberList[0] = "(530)2001212";
        addressList[0]="Zonguldak";
        nameList[1] = "Lina";
        numberList[1] = "(530)2114545";
        addressList[1]="Bartın";
        nameList[2] = "Mina";
        numberList[2] = "(530)5556677";
        addressList[2]="Eskişehir";
        nameList[3] = "Rina";
        numberList[3] = "(530)5434343";
        addressList[3]="Ankara";
        nameList[4] = "Tina";
        numberList[4] = "(530)9000000";
        addressList[4]="Istanbul";
        nameList[5] = "Hina";
        numberList[5] = "(530)5000000";
        addressList[5]="Istanbul";
        nameList[6] = "Gigi";
        numberList[6] = "(530)2001215";
        addressList[6]="Rize";
        nameList[7] = "Tuna";
        numberList[7] = "(530)2001217";
        addressList[7]="Istanbul";
        nameList[8] = "Mila";
        numberList[8] = "(530)2001218";
        addressList[8]="Istanbul";
        nameList[9] = "Mira";
        numberList[9] = "(530)2001219";
        addressList[9]="Adapazarı";

        int size=20;
        Scanner scanner=new Scanner(System.in);
        String name;
        String address;
        while(true){
            System.out.println("Enter name or to quit write quit");
            name=scanner.nextLine();
            if(name.equals("quit")){
                break;
            }
            if(inPhoneBook(name,nameList)){
                String temp= returnNumber(name,nameList,numberList,size);
                String temp1=returnAddress(name,nameList,addressList,size);
                System.out.println(name+ "'s number: " +temp );
                System.out.println("Address: "+ temp1);
            }
            else{
                addNewItemTorray(nameList, name);
                System.out.println("Enter phone number: ");
                String tempNum=scanner.nextLine();
                addNewItemTorray(numberList, tempNum);
                System.out.println("Enter address: " );
                String tempAdr=scanner.nextLine();
                addNewItemTorray(addressList, tempAdr);
                System.out.println(name + "'s number: " + tempNum+ " Address: "+ tempAdr);
            }

            while (true){
                System.out.println("Do you want to see all list?");
                String response=scanner.nextLine();
                if(response.equals("yes")){
                    writeAllListConsole(nameList, numberList, addressList);
                }
                else{
                    System.out.println("Enter name or to quit write quit");
                    name=scanner.nextLine();
                    if(inPhoneBook(name,nameList)){
                        String temp= returnNumber(name,nameList,numberList,size);
                        String temp1=returnAddress(name,nameList,addressList,size);
                        System.out.println(name+ "'s number: " +temp );
                        System.out.println("Address: "+ temp1);
                    }
                    else
                        break;
                }
            }

            if(size==20)
                break;

        }
    }

    private static void writeAllListConsole(String[] nameList, String[] numberList, String[] addressList) {
        for(int i = 0; i< nameList.length; i++){
            if(nameList[i]!=null){
                System.out.println(nameList[i]+"'s number:  "+ numberList[i]+ " address: " + addressList[i] + "\n");
            }else{
                break;
            }

        }
    }

    private static void addNewItemTorray(String[] array, String item) {
        for(int i = 0; i < array.length; i++)
            if(array[i] == null) {
                array[i] = item;
                break;
            }
    }

    public static Boolean inPhoneBook(String name, String[] nameList){
        Boolean inList=false;
        for(String val:nameList){
            if(name.equals(val)){
                inList=true;
            }
        }
        return inList;
    }
    public static String returnNumber(String name, String[] nameList, String[] numberList,int currentsize){
        String toReturn="";
        for(int x=0;x<=currentsize;x++){
            if(name.equals(nameList[x])){
                toReturn=numberList[x];
            }
        }
        return toReturn;
    }
    public static String returnAddress(String name,String[] nameList,String[] addressList,int size){
        String toReturnn="";
        for(int x=0;x<=size;x++){
            if(name.equals(nameList[x])){
                toReturnn=addressList[x];
            }
        }
        return toReturnn;
    }


}


