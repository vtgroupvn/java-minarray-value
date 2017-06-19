/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;
import testing.sortItem;
import java.util.*;
/**
 *
 * @author cuong
 */
public class MinArray {
    int[] dataItems;
    sortItem[] sortArray; 
    int minPosition;
    
    public void _insertDatas(int[] data)
    {
        boolean seen = false;
        int found = 0;
        int j = 0;
        if (data.length > 0){
            this.dataItems = new int[data.length];
            this.sortArray = new sortItem[data.length];
            try{
                for(int i = 0; i < data.length; i++){
                    found = 0;
                    this.dataItems[i] = data[i];
                    if (j == 0){
                        this.sortArray[j] = new sortItem();
                        this.sortArray[j].mainValue = data[i];
                        this.sortArray[j].mainPosition = Integer.toString(i);
                        System.out.println("Add: " + data[i]);
                        j++;
                    }else{
                        for(int n = 0; n < j; n++){
                            if (this.sortArray[n] instanceof sortItem)
                            {
                                if (this.sortArray[n].mainValue == data[i]){
                                    seen = true;
                                    found = n;
                                    break;
                                }
                            }
                        }
                        if (seen){
                            this.sortArray[found].mainPosition += "," + Integer.toString(i);
                            seen = false;
                            System.out.println("Add & Update: " + data[i]);
                        }else{
                            this.sortArray[j] = new sortItem();
                            this.sortArray[j].mainValue = data[i];
                            this.sortArray[j].mainPosition = Integer.toString(i); 
                            System.out.println("Add: " + data[i]);
                            j++;
                        }
                        
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
            j = 0;
            for(int i = 0; i < this.sortArray.length; i++){
                if (this.sortArray[i] instanceof sortItem)
                {
                    j++;
                }
            }
            sortItem[] tmp = this.sortArray;
            this.sortArray = new sortItem[j];
            for(int i = 0; i < j; i++){
                this.sortArray[i] = tmp[i];
            }
            this._sortArrayPosition();
        }
    }
    public void _sortArrayPosition()
    {
        for(int i = 0; i < this.sortArray.length-1; i++){
            for(int j = i + 1; j < this.sortArray.length; j++){       
                if (this.sortArray[i] instanceof sortItem && this.sortArray[j] instanceof sortItem){                    
                    if (this.sortArray[i].mainValue > this.sortArray[j].mainValue){
                        sortItem tmp = this.sortArray[j];
                        this.sortArray[j] = this.sortArray[i];
                        this.sortArray[i] = tmp;
                    }
                }
            }
        }
        this.minPosition = 0;
    }
    public boolean _checkArrItemExists(sortItem[] arrCheck)
    {
        try{
            if (arrCheck[0] != null){
                return true;
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }
    public int _minValue()
    {
        if (this.sortArray.length >= this.minPosition){
            try{
                if (this._checkArrItemExists(this.sortArray)){
                    return this.sortArray[this.minPosition].mainValue;
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return -1;
    }
    public void _insert(int value)
    {
        int[] tmp = this.dataItems;
        int i;
        this.dataItems = new int[tmp.length + 1];
        for(i = 0; i < tmp.length; i++)
        {
            this.dataItems[i] = tmp[i];
        }
        this.dataItems[i] = value;
        this._addSort(value, this.dataItems.length);
        this._sortArrayPosition();
    }
    public void _addSort(int value, int index)
    {
        boolean found = false;
        int i;
        for(i = 0; i < this.sortArray.length; i++)
        {
            if (this.sortArray[i] instanceof sortItem)
            {
                if (value == this.sortArray[i].mainValue)
                {
                    found = true;
                    this.sortArray[i].mainPosition += "," + Integer.toString(index);
                    System.out.println("Insert & Update: " + value);
                    break;
                }
            }
        }
        if (!found){
            sortItem[] tmp = this.sortArray;
            this.sortArray = new sortItem[tmp.length + 1];
            for(i = 0; i < tmp.length; i++)
            {
                this.sortArray[i] = tmp[i];
            }
            this.sortArray[i] = new sortItem();
            this.sortArray[i].mainValue = value;
            this.sortArray[i].mainPosition = Integer.toString(i); 
            System.out.println("Insert: " + value);
        }
    }
    public void _delete()
    {
        if (this.dataItems.length > 1){
            this._delete_sort(this.dataItems[this.dataItems.length-1]);
            this.dataItems = this._removeLast(this.dataItems);
        }else if(this.dataItems.length == 1){
            this._delete_sort(this.dataItems[0]);
            this.dataItems = this._removeLast(this.dataItems);
        }else{
            System.out.println("Not have length for run.");
        }
    }
    public int[] _removeLast(int[] arrDelete)
    {
        int[] tmp = arrDelete;
        arrDelete = new int[arrDelete.length - 1];
        for(int i = 0; i < tmp.length - 1; i++){
            arrDelete[i] = tmp[i];
        }
        return arrDelete;
    }
    public String[] _removeLast(String[] arrDelete)
    {
        String[] newArray = new String[arrDelete.length - 1];
        for(int i = 0; i < arrDelete.length - 1; i++){
            newArray[i] = arrDelete[i];
        }
        return newArray;
    }
    public sortItem[] _removeItem(sortItem[] arrDelete, int indexDelete)
    {
        int j = 0;
        this.sortArray = new sortItem[arrDelete.length-1];
        for(int i = 0; i < arrDelete.length-1; i++){
            if (i != indexDelete){
               this.sortArray[j++] = arrDelete[i];
            }
        }
        return this.sortArray;
    }
    public void _delete_sort(int value)
    {
        for(int n = 0; n < this.sortArray.length; n++){
            if (this.sortArray[n] instanceof sortItem)
            {
                if (value == this.sortArray[n].mainValue){
                    if (!this.sortArray[n].mainPosition.isEmpty()){
                        String[] items = this.sortArray[n].mainPosition.split(",");
                        String[] tmp = this._removeLast(items);
                        if (tmp.length > 0){
                            this.sortArray[n].mainPosition = String.join(",", tmp);
                            System.out.println("Delete & Update: " + value);
                        }else{
                            this.sortArray[n].mainPosition = null;                            
                            this.sortArray = this._removeItem(this.sortArray, n);  
                            System.out.println("Delete: " + value);
                            this._sortArrayPosition();
                        }
                    }else{
                        this.sortArray = this._removeItem(this.sortArray, n);
                        this._sortArrayPosition();
                    }
                }
            }
        }
    }
}
