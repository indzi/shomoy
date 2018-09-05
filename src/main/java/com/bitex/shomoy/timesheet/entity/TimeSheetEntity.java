package com.bitex.shomoy.timesheet.entity;


import javax.validation.constraints.NotNull;

import javax.persistence.*;

/**
 * @author Neel Sinha (mailneelhere@gmail.com)
 * Date: 8/28/2018
 */
@Entity
@Table(name = TimeSheetEntity.TABLE_NAME)
public class TimeSheetEntity {
    public static final String TABLE_NAME = "TSHT";
    private static final String SEQUENCE_NAME = TABLE_NAME + "_SEQ";
    private static final String SEQUENCE_GENERATOR_NAME = TABLE_NAME + "_SEQUENCE";

    @Id
    @SequenceGenerator(name = SEQUENCE_GENERATOR_NAME, sequenceName = SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_GENERATOR_NAME)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "DATE")
    private String date;

    @NotNull
    @Column(name = "START_TIME")
    private String startTime;

    @NotNull
    @Column(name = "END_TIME")
    private String endTime;

    @NotNull
    @Column(name = "REASON")
    private String reason;

    @NotNull
    @Column(name = "REASON_TYPE")
    private Enum reasonType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Enum getReasonType() {
        return reasonType;
    }

    public void setReasonType(Enum reasonType) {
        this.reasonType = reasonType;
    }
}
