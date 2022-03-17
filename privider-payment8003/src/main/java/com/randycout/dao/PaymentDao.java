package com.randycout.dao;

import com.randycout.bean.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PaymentDao {
    //增
    int create(Payment payment);
    //查
    Payment getPaymentById(@Param("id")Long id);
}
