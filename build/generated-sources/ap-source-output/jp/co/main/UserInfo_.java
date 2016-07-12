package jp.co.main;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-12T10:06:52")
@StaticMetamodel(UserInfo.class)
public class UserInfo_ { 

    public static volatile SingularAttribute<UserInfo, String> password;
    public static volatile SingularAttribute<UserInfo, String> name;
    public static volatile SingularAttribute<UserInfo, Boolean> deleteFlg;
    public static volatile SingularAttribute<UserInfo, String> id;
    public static volatile SingularAttribute<UserInfo, Date> updateTimestamp;
    public static volatile SingularAttribute<UserInfo, Date> createTimestamp;

}