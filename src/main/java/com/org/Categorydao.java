package com.org;

public interface Categorydao {

	void saveCatregory(CategoryEntity entity);

	CategoryEntity fetchCategory(Integer categoryId);

	void removeCategory(Integer categoryId);

}
