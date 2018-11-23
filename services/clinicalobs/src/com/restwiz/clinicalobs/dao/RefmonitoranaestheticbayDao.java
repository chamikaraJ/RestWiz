/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.clinicalobs.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.restwiz.clinicalobs.Refmonitoranaestheticbay;

/**
 * Specifies methods used to obtain and modify Refmonitoranaestheticbay related information
 * which is stored in the database.
 */
@Repository("clinicalobs.RefmonitoranaestheticbayDao")
public class RefmonitoranaestheticbayDao extends WMGenericDaoImpl<Refmonitoranaestheticbay, Integer> {

    @Autowired
    @Qualifier("clinicalobsTemplate")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}