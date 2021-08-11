package com.capg.inventorymgmtsystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.inventorymgmtsystem.dto.InventoryTxnDto;
import com.capg.inventorymgmtsystem.entity.InventoryTxn;
import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;
import com.capg.inventorymgmtsystem.exceptions.InvalidVendorIdException;
import com.capg.inventorymgmtsystem.exceptions.WrongVendorTypeException;
import com.capg.inventorymgmtsystem.service.InventoryTxnService;



@SpringBootTest
public class InventoryManagementSystemApplicationTests {
		@Autowired
		InventoryTxnService txnService;
		
		@Test
		public void addInvTxnTestOne() {
			InventoryTxnDto dto=new InventoryTxnDto();
			dto.setProductId(102);
			dto.setVendorId(1002);
			dto.setQty(20);
			dto.setVendortype("supplier");
			InventoryTxn actual=txnService.addInvTxn(dto);
			Assertions.assertNotNull(actual);
		}
		
		@Test
		public void addInvTxnTestTwo() {
			InventoryTxnDto dto=new InventoryTxnDto();
			dto.setProductId(111);
			dto.setVendorId(1002);
			dto.setQty(20);
			dto.setVendortype("supplier");
			Assertions.assertThrows(InvalidProdIdException.class, ()->txnService.addInvTxn(dto));
		}
		
		@Test
		public void addInvTxnTestThree() {
			InventoryTxnDto dto=new InventoryTxnDto();
			dto.setProductId(102);
			dto.setVendorId(1008);
			dto.setQty(20);
			dto.setVendortype("supplier");
			Assertions.assertThrows(InvalidVendorIdException.class, ()->txnService.addInvTxn(dto));
		}
			
		@Test
		public void addInvTxnTestFour() {
			InventoryTxnDto dto=new InventoryTxnDto();
			dto.setProductId(102);
			dto.setVendorId(1002);
			dto.setQty(20);
			dto.setVendortype("yayyayyay");
			Assertions.assertThrows(WrongVendorTypeException.class, ()->txnService.addInvTxn(dto));
		}
}
