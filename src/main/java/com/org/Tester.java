package com.org;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

public class Tester {

public static void main(String[] args) throws Exception {
		
	Categorydao dao = new CategoryDaoImpl();
		/*
		 * call saveCategory() method
		 */
		//create CategoryEntity instance
		
	CategoryEntity categoryEntity=new CategoryEntity();
		categoryEntity.setCategoryId(12101);
		categoryEntity.setCategoryName("ELECTRONICS");
		
		//create ProductEntity instance-1
		ProductEntity productEntity1 = new ProductEntity();
		productEntity1.setProductId(220989);
		productEntity1.setProductName("Mobile");
		//convert image file into bytes
		
		File file = new File("D:\\Images\\Mobile.jpg");
		byte[] imageBytes = new byte[(int)file.length()];
		
		FileInputStream fis = new FileInputStream(file);
		fis.read(imageBytes);
		productEntity1.setProductImage(imageBytes);
		
		//create ProductEntity instance-2
		ProductEntity productEntity2 = new ProductEntity();
		productEntity2.setProductId(670832);
		productEntity2.setProductName("Television");
		
		File file2 = new File("D:\\Images\\Tv.jpg");
		byte[] imageBytes_tv = new byte[(int)file2.length()];
		//create file input stream  to read the bytes
		FileInputStream fis2 = new FileInputStream(file2);
		fis2.read(imageBytes_tv);
		productEntity2.setProductImage(imageBytes_tv);
		
		//create ProductEntity instance-3
		ProductEntity productEntity3 = new ProductEntity();
		productEntity3.setProductId(721897);
		productEntity3.setProductName("MicroOWven");
		
		File file3 = new File("D:\\Images\\AC.jpg");
		byte[] imageBytes_moven = new byte[(int)file3.length()];
		
		FileInputStream fis3 = new FileInputStream(file3);
		fis3.read(imageBytes_moven);
		productEntity3.setProductImage(imageBytes_moven);
		
		//add ProductEntity instances to Collection.
		List<ProductEntity> lstOfProducts =
			Arrays.asList(productEntity1, productEntity2, productEntity3);
		//set the collection to CategoryEntity instance
		categoryEntity.setListOfProducts(lstOfProducts);
		
		dao.saveCatregory(categoryEntity);
		
		/*
		 * Mar 24, 2023 11:22:57 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [
	name: test
	...]
Mar 24, 2023 11:22:57 PM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate Core {5.3.1.Final}
Mar 24, 2023 11:22:57 PM org.hibernate.cfg.Environment <clinit>
INFO: HHH000206: hibernate.properties not found
Mar 24, 2023 11:22:57 PM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {5.0.3.Final}
Mar 24, 2023 11:22:57 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
Mar 24, 2023 11:22:57 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [com.mysql.cj.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/sha]
Mar 24, 2023 11:22:57 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {user=sha, password=****}
Mar 24, 2023 11:22:57 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Mar 24, 2023 11:22:57 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Mar 24, 2023 11:22:58 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
Mar 24, 2023 11:22:58 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@1917d90f] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    insert 
    into
        tbl_categories
        (category_name, category_id) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        tbl_product
        (product_image, product_name, product_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        tbl_product
        (product_image, product_name, product_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        tbl_product
        (product_image, product_name, product_id) 
    values
        (?, ?, ?)
Hibernate: 
    update
        tbl_product 
    set
        category_id_fk=? 
    where
        product_id=?
Hibernate: 
    update
        tbl_product 
    set
        category_id_fk=? 
    where
        product_id=?
Hibernate: 
    update
        tbl_product 
    set
        category_id_fk=? 
    where
        product_id=?
category with products  are persisted into database...

		 */
		/*
		 * call fetchCategory()
		 */
		/*
		CategoryEntity cEntity = dao.fetchCategory(12101);
		System.out.println("Category Name  : " + cEntity.getCategoryName());
		List<ProductEntity>  lst = cEntity.getLstOfProducts();
		//read the first element of the list
		ProductEntity pEntity = lst.get(0);
		System.out.println("Product Id : "+ pEntity.getProductId());
		System.out.println("Product Name : " + pEntity.getProductName());
		byte[] bytesOfImage = pEntity.getProductImage();
		File f1 = new File("D:\\ImageFromDB\\mobile_image_FromDB.jpg");
		FileOutputStream fos = new FileOutputStream(f1);
		fos.write(bytesOfImage);
		System.out.println("Please check the image at : "+ f1.getAbsolutePath());
		*/
		
		/*
		 * call removeCategory()
		 
		
		dao.removeCategory(12101);
		
		*/
		

	}

}
