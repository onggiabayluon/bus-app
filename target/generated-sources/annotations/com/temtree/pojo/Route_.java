package com.temtree.pojo;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Location;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-22T14:51:09")
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, Date> duration;
    public static volatile SingularAttribute<Route, Location> startLocationId;
    public static volatile SingularAttribute<Route, Integer> id;
    public static volatile SetAttribute<Route, Bustrip> bustripSet;
    public static volatile SingularAttribute<Route, Location> endLocationId;

}