package com.temtree.pojo;

import com.temtree.pojo.Bustrip;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-07T17:21:31")
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, String> startRoute;
    public static volatile SingularAttribute<Route, Integer> id;
    public static volatile SingularAttribute<Route, String> endRoute;
    public static volatile SetAttribute<Route, Bustrip> bustripSet;

}