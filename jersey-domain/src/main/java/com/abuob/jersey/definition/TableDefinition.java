package com.abuob.jersey.definition;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abuob on 6/8/16.
 */

@XmlRootElement
public class TableDefinition {

    @XmlElement(name ="table_name")
    private String tableName;

    private List<TableColumnDefinition> tableColumnDefinitionList = new ArrayList<TableColumnDefinition>();

    public TableDefinition() {
    }

    public TableDefinition(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void addTableColumn(String columnName, String columnType) {
        TableColumnDefinition tableColumnDefinition = new TableColumnDefinition();
        tableColumnDefinition.setColumnName(columnName);
        tableColumnDefinition.setColumnType(columnType);
        tableColumnDefinitionList.add(tableColumnDefinition);
    }

    @XmlElement(name="column_definitions")
    public List<TableColumnDefinition> getTableColumnDefinitionList() {
        return tableColumnDefinitionList;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();

        sb.append("TableDefinition{" +
                "tableName='" + getTableName() + '\'' +
                ", tableColumnList{");

        for(TableColumnDefinition tcd: tableColumnDefinitionList){
            sb.append(tcd.toString());
        }

        sb.append("}}");

        return sb.toString();
    }
}

