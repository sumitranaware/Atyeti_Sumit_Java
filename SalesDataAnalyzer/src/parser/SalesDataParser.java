package parser;

import model.Sales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SalesDataParser {
    public static void main(String[] args) {
        String filePath="C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sumit_Java\\SalesDataAnalyzer\\src\\sales_data.csv";

        ArrayList<Sales>salesArrayList=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line=br.readLine();

            while ((line=br.readLine())!=null){
                String[] fields=line.split(",");

                String date=fields[0];
                String product=fields[1];
                String category=fields[2];
                int quantity=Integer.parseInt(fields[3]);
                double unitPrice=Double.parseDouble(fields[4]);
                String region=fields[5];

                Sales sales=new Sales(date,product,category,quantity,unitPrice,region);
                salesArrayList.add(sales);
            }
            for (Sales s:salesArrayList){
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
