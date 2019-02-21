package com.conversion.sbx.firebasepush;

import javax.annotation.Nonnull;

public class UserId {

    public  String userId;

    public <T extends UserId> T withId(@Nonnull final  String id){
      this.userId =id;
      return(T) this;
    }
}
