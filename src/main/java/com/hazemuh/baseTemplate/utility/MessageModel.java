package com.hazemuh.baseTemplate.utility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageModel {

    private String message;
    private boolean status;
    private Object data;


    // constructor kosong
    public MessageModel(){}

    // jika ok dan menampilkan
    public MessageModel(boolean status, String message, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    // jika error tidak menampilkan data
    public MessageModel(boolean status, String message) {
        this.message = message;
        this.status = status;
    }
}