package com.morethanheroic.uppercase.domain;

public class HealthFirstMemberResponse {
    private String memberId;
    private Coverage coverage;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Coverage getCoverage() {
        return coverage;
    }

    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
    }

    public enum Coverage {
        MEDICAL, DENTAL, VISION, NONE
    }
}
