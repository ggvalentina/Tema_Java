import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.io.*;
import java.awt.event.ActionListener;

public class TeacherForm {
    private final JFrame owner;
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTable table1;
    private JTabbedPane tabbedPane2;
    private JTable table2;
    private JButton afiseazaStudentiButton;
    private JButton adaugaNotaButton;
    private JButton adaugaCursButton;

    public TeacherForm(JFrame owner) {
        this.owner = owner;

        afiseazaStudentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( e.getSource()==afiseazaStudentiButton){
                    System.out.println("afiseazaStudenti");
                    File file2= new File("note.csv");
                    try {
                        FileReader fread=new FileReader(file2);
                        BufferedReader bread= new BufferedReader(fread);
                        String line1= bread.readLine();
                        if(line1 != null){
                            String[] nameColumn= line1.split(",");

                            modelStudenti.setColumnIdentifiers(nameColumn);
                            Object[] lines =bread.lines().toArray();
                            modelStudenti.setRowCount(0);

                            for(int i=0;i< lines.length;i++) {
                                int indexS = table1.getSelectedRow();
                                if(indexS!=-1){
                                    String cursul =table1.getValueAt(indexS,0).toString();
                                    String[] linie= lines[i].toString().split(",");
                                    if(linie[2].toString().equals(cursul)){
                                        modelStudenti.addRow(linie);
                                    }

                                }
                            }
                        }
                    } catch (Exception exc) {
                        System.out.println(exc);
                    }
                }
            }
        });


        adaugaNotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( e.getSource()==afiseazaStudentiButton){
                    System.out.println("adaugaNotaButton");
                    File file2= new File("note.csv");
                }
            }
        });
    }

    DefaultTableModel modelCursuri= (DefaultTableModel) table1.getModel();
    DefaultTableModel modelStudenti= (DefaultTableModel) table2.getModel();
    public JPanel getPanel1(){
        File file= new File("cursuri.csv");
        try {
            FileReader fread= new FileReader(file);
            BufferedReader bread= new BufferedReader(fread);
            String line1= bread.readLine();
            if(line1 !=null) {
                String[] nameColumn= line1.split(",");
                String[] coursColumn= new String[2];

                modelCursuri.setColumnIdentifiers(nameColumn);
                Object[] linii= bread.lines().toArray();

                modelCursuri.setRowCount(0);

                modelStudenti.setColumnIdentifiers(nameColumn);
                modelStudenti.setRowCount(0);

                for( int i=0; i< linii.length; i++) {
                    String[] linie=linii[i].toString().split(",");
                    modelCursuri.addRow(linie);
                }

            }
        } catch (Exception exc){
            System.out.println(exc);
        }

        return panel1;
    }




}
