package Model;

import Entity.DataKorbanEntity;
import Entity.StatusEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class DataKorbanModel implements ModelInterfaces {
    private static Scanner input = new Scanner (System.in);
    private ArrayList<DataKorbanEntity> datakorbanArrayList;
    
    public DataKorbanModel(){
    datakorbanArrayList = new ArrayList<DataKorbanEntity>();
        }
    public void insertDataDataKorban(DataKorbanEntity datakorban){
        datakorbanArrayList.add(datakorban);
    }
    public ArrayList<DataKorbanEntity> getdatakorbanArrayList(){
        return datakorbanArrayList;
    }
    
    @Override
 public void login(){
        for(DataKorbanEntity datakorban : datakorbanArrayList){
        System.out.println("===========================================");
        System.out.println(" NIK : "+datakorban.getKorban().getnik()+"\n Nama : "
         +datakorban.getKorban().getnama()+"\n Pekerjaan : "+datakorban.getKorban().getpekerjaan()+
            "\n Golongan Darah : "+datakorban.getKorban().getgoldarah()+
            "\n Agama : "+datakorban.getKorban().getagama()+"\n Jenis Kelamin : "
            +datakorban.getKorban().getjeniskelamin()+"\n No Telp : "
            +datakorban.getKorban().getnotelp()+"\n Tanggal Lahir : "
            +new SimpleDateFormat("dd-MM-yyyy").format(datakorban.getKorban().getTglLahir())+
            "\n Status : "+StatusEntity.Status[datakorban.getIndexStatus()]);
        }   
    }
  public int cekData(String nik, String nama){
        int loop = 0;
        if(datakorbanArrayList.size() ==0){
            loop = -1;
        }else{
            for(int i = 0; i <datakorbanArrayList.size(); i++){
            if(datakorbanArrayList.get(i).getKorban().getnik().equals(nik)){
                loop = i;
                break;
            }else{
                loop = -2;
                }
            }
        }   return loop;
    }
  
    public DataKorbanEntity showDataKorban(int index){
        return datakorbanArrayList.get(index);
    }   
    
    private int carinik(String nik){
        int index=-1;
        for(int i=0;i <datakorbanArrayList.size();i++) {
           if(nik.equals(datakorbanArrayList.get(i).getKorban().getnik()))
               index=i;
           break;
       }
       return index;
    }
        public int update(String nik, int statusbaru){
            int data;
        if(carinik(nik)!=-1){
            datakorbanArrayList.get(carinik(nik)).setIndexStatus(statusbaru);
            data=1;
        }
        else {
            data=0;
        }
        return data;
    }        
        
}
