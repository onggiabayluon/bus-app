/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.repository;

import com.temtree.pojo.Receipt;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ReceiptRepository{
    Receipt getReceiptById(int id);
    
    List<Receipt> getReceipts(String receiptname);
    
    List<Receipt> getReceipts();
    
    Receipt findById(int id);

    boolean addReceipt(Receipt receipt);

    boolean deleteReceipt(int id);
}
