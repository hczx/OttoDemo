package baserobot;

import java.lang.reflect.GenericArrayType;
import java.net.UnknownHostException;

import model.ErrorModel;
import network.callback.GenericCallback;

/**
 * Created by 99165 on 2016/3/14.
 */
public abstract class CallbackFragment<E> extends StarterFragment implements GenericCallback<E>,EmptyAndErrorCallback{

    @Override public void errorNotFound(ErrorModel errorModel) {
        setupErrorModel(errorModel);
    }

    @Override public void errorUnProcessable(ErrorModel errorModel) {
        setupErrorModel(errorModel);
    }

    @Override public void errorUnauthorized(ErrorModel errorModel) {
        setupErrorModel(errorModel);
    }

    @Override public void errorForbidden(ErrorModel errorModel) {
        setupErrorModel(errorModel);
    }

    @Override public void eNetUnReach(Throwable t, ErrorModel errorModel) {
        setupErrorModel(errorModel);
    }

    @Override public void errorSocketTimeout(Throwable t, ErrorModel errorModel) {
        setupErrorModel(errorModel);
    }

    @Override public void errorUnknownHost(UnknownHostException e, ErrorModel errorModel) {
        setupErrorModel(errorModel);
    }

    @Override public void error(ErrorModel errorModel) {
        setupErrorModel(errorModel);
    }

    ////////////////////////////////////
    ////////////////////////////////////
    ////////////NetworkCallback/////////
    ////////////////////////////////////
    ////////////////////////////////////
    @Override public void startRequest() {
    }

    @Override public void respondSuccess(E data) {
    }

    @Override public void respondWithError(Throwable t) {
        setupErrorModel(new ErrorModel(500, t.getLocalizedMessage()));
    }

    @Override public void endRequest() {
    }

    ////////////////////////////////////
    ////////////////////////////////////
    ////////////NetworkCallback/////////
    ////////////////////////////////////
    ////////////////////////////////////

    @Override public void setupErrorModel(ErrorModel errorModel) {
        if (errorModel != null) {
            setupError(errorModel.getMessage(), null);
        }
    }

    @Override public void setupError(String title, String subtitle) {
        setupError(null, title, subtitle);
    }

    @Override public void setupEmpty(String title, String subtitle) {
        setupEmpty(null, title, subtitle);
    }

}
