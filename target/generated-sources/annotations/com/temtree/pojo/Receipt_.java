package com.temtree.pojo;

import com.temtree.pojo.Ticket;
import com.temtree.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-11-12T19:35:59")
@StaticMetamodel(Receipt.class)
public class Receipt_ { 

    public static volatile SingularAttribute<Receipt, String> momoRequestId;
    public static volatile SingularAttribute<Receipt, Long> amount;
    public static volatile SingularAttribute<Receipt, Date> createdDate;
    public static volatile SingularAttribute<Receipt, Boolean> active;
    public static volatile SingularAttribute<Receipt, String> paymentMethod;
    public static volatile SingularAttribute<Receipt, Integer> id;
    public static volatile SingularAttribute<Receipt, User> userId;
    public static volatile SingularAttribute<Receipt, Ticket> ticketId;

}