package com.temtree.pojo;

import com.temtree.pojo.Bus;
import com.temtree.pojo.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-22T14:51:09")
@StaticMetamodel(Seat.class)
public class Seat_ { 

    public static volatile SingularAttribute<Seat, Bus> busId;
    public static volatile SetAttribute<Seat, Ticket> ticketSet;
    public static volatile SingularAttribute<Seat, Ticket> ticket;
    public static volatile SingularAttribute<Seat, Boolean> active;
    public static volatile SingularAttribute<Seat, Integer> id;

}