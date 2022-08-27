package com.temtree.pojo;

import com.temtree.pojo.Bus;
import com.temtree.pojo.Calendar;
import com.temtree.pojo.Comment;
import com.temtree.pojo.Route;
import com.temtree.pojo.Ticket;
import com.temtree.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-27T08:57:09")
@StaticMetamodel(Bustrip.class)
public class Bustrip_ { 

    public static volatile SingularAttribute<Bustrip, Bus> busId;
    public static volatile SingularAttribute<Bustrip, Date> departTime;
    public static volatile SingularAttribute<Bustrip, Route> routeId;
    public static volatile SingularAttribute<Bustrip, Calendar> calendarId;
    public static volatile SingularAttribute<Bustrip, User> driverId;
    public static volatile SetAttribute<Bustrip, Ticket> ticketSet;
    public static volatile SetAttribute<Bustrip, Comment> commentSet;
    public static volatile SingularAttribute<Bustrip, Long> price;
    public static volatile SingularAttribute<Bustrip, Boolean> active;
    public static volatile SingularAttribute<Bustrip, Integer> id;
    public static volatile SingularAttribute<Bustrip, Date> endTime;

}