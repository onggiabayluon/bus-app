package com.temtree.pojo;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Seat;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-11T19:15:22")
@StaticMetamodel(Bus.class)
public class Bus_ { 

    public static volatile SingularAttribute<Bus, Bustrip> bustripId;
    public static volatile SingularAttribute<Bus, Boolean> active;
    public static volatile SingularAttribute<Bus, Integer> id;
    public static volatile SetAttribute<Bus, Seat> seatSet;

}