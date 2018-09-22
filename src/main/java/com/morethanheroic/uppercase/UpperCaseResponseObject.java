package com.morethanheroic.uppercase;

import com.morethanheroic.uppercase.domain.UppercaseRequest;

import java.util.Locale;

public class UpperCaseResponseObject {
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;

    public UpperCaseResponseObject(UppercaseRequest uppercaseRequest) {
        if (uppercaseRequest != null && uppercaseRequest.getUserId() != null) {
                this.userId = uppercaseRequest.getUserId().toUpperCase(Locale.ENGLISH);
        } else {
            this.userId = "isNotKnown";
        }
    }

}
