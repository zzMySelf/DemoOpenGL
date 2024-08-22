package com.tera.scan.network.network.parser;

import com.tera.scan.network.network.exception.RemoteException;
import fe.mmm.qw.nn.de.pf.ad;
import java.io.IOException;
import org.json.JSONException;

public interface IApiResultParseable<T> {
    T qw(ad adVar) throws JSONException, RemoteException, IOException;
}
