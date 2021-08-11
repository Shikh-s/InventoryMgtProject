package com.capg.inventorymgmtsystem;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.inventorymgmtsystem.dto.VendorDto;

import com.capg.inventorymgmtsystem.entity.Vendor;
import com.capg.inventorymgmtsystem.exceptions.InvalidProdIdException;

import com.capg.inventorymgmtsystem.exceptions.VendorAlreadyPresentException;
import com.capg.inventorymgmtsystem.exceptions.WrongVendorTypeException;
import com.capg.inventorymgmtsystem.service.InventoryTxnService;
import com.capg.inventorymgmtsystem.service.VendorService;



@SpringBootTest
public class VendorServiceImplTests {
		@Autowired
		VendorService vendorService;
		@Autowired
		InventoryTxnService inventoryService;
		
		
		
		@Test
		public void addVendorTestOne() throws WrongVendorTypeException, VendorAlreadyPresentException {
			
			VendorDto dto=new VendorDto();
			dto.setVendorId(1088);
			dto.setCompanyName("Apple");
			dto.setAddress("555");
			dto.setContact("971123313");
			dto.setVendortype("supplier");
			dto.setArea("nagar");
			dto.setCity("hapur");
			Vendor actual=vendorService.addVendor(dto);
			Assertions.assertNotNull(actual);
			}
		
		@Test
		public void addVendorTestTwo() {
			VendorDto dto=new VendorDto();
			dto.setVendorId(1002);
			dto.setCompanyName("shikhar");
			dto.setAddress("111");
			dto.setContact("9711183127");
			dto.setVendortype("supplier");
			dto.setArea("govindpuram");
			dto.setCity("ghaziabad");
			Assertions.assertThrows(VendorAlreadyPresentException.class, ()->vendorService.addVendor(dto));
		}
		
		@Test
		public void addVendorTestThree() {
			VendorDto dto=new VendorDto();
			dto.setVendorId(2342);
			dto.setCompanyName("Keils");
			dto.setAddress("222");
			dto.setContact("971112188");
			dto.setVendortype("sfrm");
			dto.setArea("shalimar");
			dto.setCity("ghaziabad");
			Assertions.assertThrows(WrongVendorTypeException.class, ()->vendorService.addVendor(dto));
		}
		
		@Test
		public void txnOfSpecProductTestOne() {
			Assertions.assertThrows(InvalidProdIdException.class, ()->vendorService.txnOfSpecProduct(1002)); 
		}
		
			
}
