/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.busstation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nhat Anh
 */
public class BusStation {
    //Hàm tìm tập các size của bus
    public static ArrayList findSizeOfBus(int[] peopleOfGroups) {
        //Khởi tạo 1 arraylist để thêm các giá trị thỏa mãn vào
        ArrayList<Integer> sizeList = new ArrayList<>();
        int totalOfPeople = 0;
        //lặp để tìm tổng số người
        for (int i = 0; i < peopleOfGroups.length; i++) {
            totalOfPeople += peopleOfGroups[i];
        }
        
        int sizeTotal = 1;
        //Lặp để duyệt từng sizeTotal
        while (sizeTotal <= totalOfPeople) {
            int size = sizeTotal;
            //Lặp để tính hiệu của size với các phần tử
            for (int i = 0; i < peopleOfGroups.length; i++) {
                size -= peopleOfGroups[i];
                //Nếu size =0 và vòng lặp chưa duyệt hết thì size = sizeTotal (gọi thêm 1 xe) để duyệt tiếp
                if (size == 0 && i != peopleOfGroups.length - 1) {
                    size = sizeTotal;
                }//Nếu size = 0 và đã duyệt hết thì giá trị sizeTotal là 1 giá trị cần tìm, ta thêm vào kết quả
                else if (size == 0 && i == peopleOfGroups.length -1) {
                    sizeList.add(sizeTotal);
                }//Nếu size <0 thì sizeTotal đó không phải số cần tìm, ta kết thúc vòng lặp 
                else if (size < 0) {
                    break;
                }
            }
            sizeTotal++;
        }

        return sizeList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of group: ");
        int numberOfGroup = sc.nextInt(); sc.nextLine();
        int[] peopleOfGroups = new int[numberOfGroup];
        
        for(int i = 0; i< numberOfGroup; i++){
            peopleOfGroups[i] = Integer.parseInt(sc.next());
        }

        System.out.println("Size of bus: "+ findSizeOfBus(peopleOfGroups).toString());
    }
}
