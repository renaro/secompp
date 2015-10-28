package com.renarosantos.secompp.business;

/**
 * Created by renarosantos on 26/10/15.
 */

public interface BusinessCallback<T> {
    public void onSucess(T result);

    public void onError();

}
