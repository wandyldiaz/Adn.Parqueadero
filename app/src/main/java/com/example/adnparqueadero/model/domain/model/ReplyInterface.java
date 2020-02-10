package com.example.adnparqueadero.model.domain.model;

public interface ReplyInterface {
    interface CallbackHandlerReplyArray {
        void replyArray(String[] reply);
    }
    interface CallbackHandlerReplyMatriz {
        void replyMatriz(String[][] reply);
    }
    interface CallbackHandlerReplyString {
        void replyMatriz(String reply);
    }
    interface CallbackHandlerReplyBoolean {
        void replyBoolean(boolean reply);
    }
}
