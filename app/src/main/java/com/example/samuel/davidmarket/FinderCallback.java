package com.example.samuel.davidmarket;

/**
 * Created by Samuel on 12-Feb-18.
 */

public interface FinderCallback {
    void error(String error);
    void success ();
    void notfound();

}
