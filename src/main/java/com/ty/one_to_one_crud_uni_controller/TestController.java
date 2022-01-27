package com.ty.one_to_one_crud_uni_controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.one_to_one_crud_uni.dao.ItemInvoiceDao;
import com.ty.one_to_one_crud_uni.dto.Invoice;
import com.ty.one_to_one_crud_uni.dto.Item;

public class TestController {

	public static void main(String[] args) {

		ItemInvoiceDao dao = new ItemInvoiceDao();

		Item item = new Item();
		item.setItem_id(2);
		item.setItem_name("pencil");
		item.setItem_price(10);
		item.setQuantity(4);

		Invoice invoice = new Invoice();
		invoice.setId(12);
		invoice.setBillingAddress("bsk");
		invoice.setGstNumber("pnb-46675-7578");
		invoice.setTax(18.3);
		invoice.setName("pencil invoice");
		invoice.setItem(item);

		dao.save(invoice, item);
	}
}
