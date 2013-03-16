package com.ked.generic;

public interface Kernel<K> {

	/**
	 * 
	 * @return The primary key of the entity.
	 */
	K getId();
}