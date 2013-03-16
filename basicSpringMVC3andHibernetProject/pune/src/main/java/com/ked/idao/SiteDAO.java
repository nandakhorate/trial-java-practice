package com.ked.idao;

import com.ked.dao.GenericDAO;
import com.ked.pojo.Kernel;

public interface SiteDAO<K,T extends Kernel<K>> extends GenericDAO<K,T> {

}
