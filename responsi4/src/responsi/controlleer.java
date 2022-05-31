package responsi;

import responsi.Main.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class controlleer {
    model Model;
    view View;

    public controlleer(view viewresponsi, model modelresponsi) {
        this.Model = Model;
        this.View = View;
        
        if(model.getBanyakData() != 0){
            String data[][] = model.readData();
            view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
    
    //aksi ketika menekan tombol tambah
    view.btnTambah.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String judul = view.getFnamanya().getText();
        String pertofolio = view.getFportofolio().getText();
        String microteaching = view.getFmicro().getText();
        String wawancara = view.getnilai().getText();
        if (judul.equals("") || portofolio.equals("")||microteaching.equals("")||wawancara.equals("")) {
            JOptionPane.showMessageDialog(view, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            model.tambahData(judul,portofolio, microteaching,wawancara);
            view.dispose();
            MVC mvc = new MVC();
            mvc.menuutama();
        }
        }
    });
    
    //aksi ketika menekan tombol update
    view.btnUpdate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String nama = view.nama;
        String judul = view.getnamanya().getText();
        String portofolio = view.getFportofolio().getText();
        String microteaching = view.getFmicro().getText();
        String wawancara = view.getFnilai().getText();
        if (judul.equals("") || portofolio.equals("")||microteaching.equals("")||wawancara.equals("")) {
            JOptionPane.showMessageDialog(view, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            model.updateData(nama,judul,portofolio, microteaching,wawancara);
            view.dispose();
            MVC mvc = new MVC();
            mvc.menuutama();
        }
        }
    });
    
    //aksi ketika menekan tombol delete
    view.btnDelete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String judul = view.getFnamanya().getText();

        if (judul.equals("")) {
            JOptionPane.showMessageDialog(view, "Isi Judul Buku Yang Akan Dihapus");
        }else {
            model.deleteData(judul);
            view.dispose();
            MVC mvc = new MVC();
            mvc.menuutama();
        }
        }
    });
    
    //aksi ketika menekan tombol clear
     view.btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.fnamanya.setText("");
                view.fportofolio.setText("");
                view.fmicro.setText("");
                view.fnilai.setText("");
            }
     });     
    }
}