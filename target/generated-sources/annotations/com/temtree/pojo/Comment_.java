package com.temtree.pojo;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-15T10:47:50")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Bustrip> bustripId;
    public static volatile SingularAttribute<Comment, Boolean> active;
    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile SingularAttribute<Comment, User> userId;
    public static volatile SingularAttribute<Comment, String> content;

}