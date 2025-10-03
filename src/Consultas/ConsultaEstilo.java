/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Consultas;

import java.util.ArrayList;


public class ConsultaEstilo {
    String Offset;
    String Count;

    public String getOffset() {
        return Offset;
    }

    public void setOffset(String Offset) {
        this.Offset = Offset;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String Count) {
        this.Count = Count;
    }

    public String getTableNameSufix() {
        return TableNameSufix;
    }

    public void setTableNameSufix(String TableNameSufix) {
        this.TableNameSufix = TableNameSufix;
    }

    public String getFilterLower() {
        return FilterLower;
    }

    public void setFilterLower(String FilterLower) {
        this.FilterLower = FilterLower;
    }

    public String getFilterUpper() {
        return FilterUpper;
    }

    public void setFilterUpper(String FilterUpper) {
        this.FilterUpper = FilterUpper;
    }

    public ArrayList<Object> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Object> Items) {
        this.Items = Items;
    }

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String ResultCode) {
        this.ResultCode = ResultCode;
    }

    public String getResultMessage() {
        return ResultMessage;
    }

    public void setResultMessage(String ResultMessage) {
        this.ResultMessage = ResultMessage;
    }
    String TableNameSufix;
    String FilterLower;
    String FilterUpper;
    public ArrayList<Object> Items = new ArrayList<Object>();
   String ResultCode;
   String ResultMessage;
    
}
