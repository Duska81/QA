package models;

import models.Row;

import java.util.List;

public class Table {
   // private List<Row> rows;
    //umesto ovoga gore vracamo listu stringova
   private List<List<String>> rows;

    //public Table(List<Row> rows) {
       // this.rows = rows;
    //}
    public Table(List<List<String>> rows) {
        this.rows=rows;
    }

   // public List<Row> getRows() {
       // return rows;
   // }
    public List<List<String>>getRows(){
        return rows;
    }

    //public void setRows(List<Row> rows) {
        //this.rows = rows;
    //}

    public void setRows(List<List<String>>rows){
        this.rows=rows;
    }
    //argument je broj reda koji zelimo da vratimo
    //public Row returnRowAtPosition(int rowNumber){

        //return rows.get(rowNumber);
   // }
    public List<String> returnRowAtPosition(int rowNumber){

        return rows.get(rowNumber);
    }
}

