package responsi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class model {
    Connector connector = new Connector(); 
    public int getBanyakData(){
        int jmlData=0;
        try{
            String query = "Select * from responsi4"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); 
            while(resultSet.next()){ 
                jmlData++; 
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        return jmlData;
    }
    
    public String[][] readData(){ 
        try{
            int jmlData = 0; 
            String data[][] = new String[getBanyakData()][5];
            String query = "Select * from `responsi4`"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            while(resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("judul"); 
                data[jmlData][1] = resultSet.getString("portofolio");
                data[jmlData][2] = resultSet.getString("microteaching"); 
                data[jmlData][3] = resultSet.getString("wawancara");
                data[jmlData][4] = resultSet.getString("nilai");
                jmlData++;       
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void tambahData(String judul,String portofolio,String microteaching,String wawancara,String nilai){
        
         try {
            String query = "INSERT INTO data_buku VALUES ('"+judul+"','"+portofolio+"','"+microteaching+"','"+wawancara+"','"+nilai+"')";  
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,"Data Sudah Ada !!");
        }
    }
    
    public void updateData(String judul,String portofolio,String microteaching,String wawancara,String nilai){
            
        try {
            String query = "update responsi4 set judul=?, "
                    + "portofolio=?, microteaching=?, wawancara=?, nilai=? where judul=?";
            PreparedStatement preparedStmt = connector.koneksi.prepareStatement(query);
            preparedStmt.setString(1, judul);
            preparedStmt.setString(2, portofolio);
            preparedStmt.setString(3, microteaching);
            preparedStmt.setString(4, wawancara);
            preparedStmt.setString(5, nilai);
            preparedStmt.execute();
            
           if(judul.compareTo(judul)==0)
            JOptionPane.showMessageDialog(null,"Update Berhasil !!");
            else
                JOptionPane.showMessageDialog(null,"Data Tidak Ada!!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteData(String judul){
        try{
            String query = "DELETE from data_buku WHERE judul = '"+judul+"'";
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
}