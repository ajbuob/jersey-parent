package com.abuob.jersey.definition;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by abuob on 6/8/16.
 */
public class TableColumnDefinition {

    @XmlElement(name="column_name")
    private String columnName;

    @XmlElement(name="column_type")
    private String columnType;

    public TableColumnDefinition() {
    }

    public TableColumnDefinition(String columnName, String columnType) {
        this.columnName = columnName;
        this.columnType = columnType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    @Override
    public String toString() {
        return "TableColumnDefinition{" +
                "columnName='" + columnName + '\'' +
                ", columnType='" + columnType + '\'' +
                '}';
    }
}

