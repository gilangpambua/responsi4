package responsi;

    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    import javax.swing.JButton;
    import javax.swing.*;
    import java.awt.*;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JScrollPane;
    import javax.swing.JTable;
    import javax.swing.JTextField;
    import javax.swing.ScrollPaneConstants;
    import javax.swing.table.DefaultTableModel;

public class view extends JFrame{
    String nama;
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"Nama","Portofolio","Microteaching","Wawancara","Nilai Akhir"}; //membuat kolom dgn array tipe object;
    final JTextField fnamanya = new JTextField(50);
    final JTextField fportofolio = new JTextField(20);
    final JTextField fmicro = new JTextField(20);
    final JTextField fnilai = new JTextField(10);
    JLabel lnamanya= new JLabel("Nama");
    JLabel lportofolio = new JLabel("Nilai Portofolio");
    JLabel lmicro = new JLabel("Nilai Microteaching");
    JLabel lnilai = new JLabel("Nilai Wawancara");
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");
    
    public view(){
    tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        setLayout(null);
        setSize(800,600);
        setVisible(true);
        setResizable(false);
        setTitle("MENU");
        setDefaultCloseOperation(3);
  
        add(scrollPane);
        add(lnamanya);
        add(fnamanya);
        add(lportofolio);
        add(fportofolio);
        add(lmicro);
        add(fmicro);
        add(lnilai);
        add(fnilai);
        add(btnTambah);
        add(btnUpdate);
        add(btnDelete);
        add(btnClear);


        scrollPane.setBounds(20, 35, 500, 345);
        
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        lnamanya.setBounds(550, 35, 120, 20);
        fnamanya.setBounds(550, 60, 170, 20);
        lportofolio.setBounds(550, 90, 120, 20);
        fportofolio.setBounds(550, 115, 170, 20);
        lmicro.setBounds(550, 145, 120, 20);
        fmicro.setBounds(550, 170, 170, 20);
        lnilai.setBounds(550, 200, 120, 20);
        fnilai.setBounds(550, 225, 170, 20);
        btnTambah.setBounds(550, 315, 80, 20);
        btnUpdate.setBounds(550, 345, 80, 20);
        btnDelete.setBounds(650, 315, 80, 20);
        btnClear.setBounds(650, 345, 80, 20);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
        
        tabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                JTable target = (JTable)me.getSource();
                int baris = target.getSelectedRow(); // select a row
                nama =tabel.getValueAt(baris, 0).toString();
                fnamanya.setText(tabel.getValueAt(baris, 0).toString());
                fportofolio.setText(tabel.getValueAt(baris, 1).toString());
                fmicro.setText( tabel.getValueAt(baris, 2).toString());
                fnilai.setText(tabel.getValueAt(baris, 3).toString());
                   
            }
        });
        
}

    public JTextField getFnamanya() {
        return fnamanya;
    }

    public JTextField getFportofolio() {
        return fportofolio;
    }

    public JTextField getFmicro() {
        return fmicro;
    }

    public JTextField getFnilai() {
        return fnilai;
    }
    
}
