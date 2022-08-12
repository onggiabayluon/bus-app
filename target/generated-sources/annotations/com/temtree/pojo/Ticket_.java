package com.temtree.pojo;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Receipt;
import com.temtree.pojo.Route;
import com.temtree.pojo.Seat;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-12T20:47:07")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Seat> seat;
    public static volatile SetAttribute<Ticket, Receipt> receiptSet;
    public static volatile SingularAttribute<Ticket, Bustrip> bustripId;
    public static volatile SingularAttribute<Ticket, Date> createdDate;
    public static volatile SingularAttribute<Ticket, Route> routeId;
    public static volatile SingularAttribute<Ticket, Long> price;
    public static volatile SingularAttribute<Ticket, Date> departDate;
    public static volatile SingularAttribute<Ticket, Boolean> active;
    public static volatile SingularAttribute<Ticket, Integer> id;

}