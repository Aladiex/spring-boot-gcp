package io.aladiex.temp.controller.rest.vm.response;

import java.io.Serializable;

public class ResponseVM implements Serializable {
    private Boolean status;
    private Object data;

    public ResponseVM(Boolean status, Object data) {
        this.status = status;
        this.data = data;
    }
}
