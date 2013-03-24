package com.ked.idao;

import com.ked.pojo.Kernel;

public interface SiteDao<K,T extends Kernel<K>> extends GenericDao<K,T> {

}
