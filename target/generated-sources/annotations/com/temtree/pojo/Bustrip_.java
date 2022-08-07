package com.temtree.pojo;

import com.temtree.pojo.Bus;
import com.temtree.pojo.Comment;
import com.temtree.pojo.Route;
import com.temtree.pojo.Ticket;
import com.temtree.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-07T17:21:31")
@StaticMetamodel(Bustrip.class)
public class Bustrip_ { 

    public static volatile SingularAttribute<Bustrip, Date> departTime;
    public static volatile SetAttribute<Bustrip, Bus> busSet;
    public static volatile SingularAttribute<Bustrip, Route> routeId;
    public static volatile SingularAttribute<Bustrip, Integer> driverId;
    public static volatile SetAttribute<Bustrip, Ticket> ticketSet;
    public static volatile SetAttribute<Bustrip, Comment> commentSet;
    public static volatile SingularAttribute<Bustrip, Boolean> active;
    public static volatile SingularAttribute<Bustrip, Integer> id;
    public static volatile SingularAttribute<Bustrip, User> userId;

}