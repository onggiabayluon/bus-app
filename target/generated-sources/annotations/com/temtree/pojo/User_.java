package com.temtree.pojo;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Comment;
import com.temtree.pojo.Receipt;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-12T20:47:07")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SetAttribute<User, Receipt> receiptSet;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SetAttribute<User, Comment> commentSet;
    public static volatile SingularAttribute<User, Boolean> active;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SetAttribute<User, Bustrip> bustripSet;

}