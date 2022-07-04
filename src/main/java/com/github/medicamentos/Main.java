package com.github.medicamentos;

import com.github.medicamentos.components.BarChart;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.AbstractListModel;
import javax.swing.ListModel;
import javax.swing.UIManager;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class Main {

    private Connection con;
    private List<String> medicamentosList;

    public Main(Connection con) {
        this.con = con;
        medicamentosList = getMedicamentos();
        //initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        jPanel1 = new javax.swing.JPanel();
//        jScrollPane1 = new javax.swing.JScrollPane();
//        medicamentos = new javax.swing.JList<>();
//        jPanel3 = new javax.swing.JPanel();
//        barChart2 = new BarChart();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setUndecorated(true);
//        setResizable(true);
//
//        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
//        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
//        jPanel1.setPreferredSize(new java.awt.Dimension(74, 200));
//        jPanel1.setLayout(new java.awt.CardLayout());
//
//        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
//        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//
//        medicamentos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//        medicamentos.setModel(getMedicamentosModel());
//        medicamentos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//        medicamentos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
//            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
//                medicamentosValueChanged(evt);
//            }
//        });
//        jScrollPane1.setViewportView(medicamentos);
//
//        jPanel1.add(jScrollPane1, "card2");
//
//        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
//
//        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
//        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
//        jPanel3.setPreferredSize(new java.awt.Dimension(780, 500));
//        jPanel3.setLayout(new java.awt.CardLayout());
//
//        barChart2.setChartTitle("Gráfico de Consumo ");
//        barChart2.setChartTitleColor(java.awt.Color.white);
//        barChart2.setData(null
//        );
//        jPanel3.add(barChart2, "card2");
//
//        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);
//
//        pack();
//        setLocationRelativeTo(null);
//    }// </editor-fold>//GEN-END:initComponents

    private void medicamentosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_medicamentosValueChanged
        generateChart(medicamentos.getSelectedValuesList());
    }//GEN-LAST:event_medicamentosValueChanged

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {

            Properties p = new Properties();
            try {
                p.load(new FileInputStream("C:/db.properties"));
                Connection con1 = DriverManager.getConnection(
                        p.getProperty("url"),
                        p.getProperty("user"),
                        p.getProperty("pass"));
                //new Main(con1).setVisible(true);
                new MainFrame(con1).setVisible(true);
            } catch (Exception e) {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private BarChart barChart2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> medicamentos;
    // End of variables declaration//GEN-END:variables

    private void generateChart(List<String> list) {
        String query;
        if (list.size() == 1) {
            query = "SELECT "
                    + "extract(year from f.dtlancamento) as ANO,"
                    + "sum(abs(f.quantidade)) as QUANTIDADE "
                    + " FROM ECUSCASTROLANDAFINANCEIRO f "
                    + "WHERE f.nmproduto = '" + list.get(0) + "' "
                    + "group by ANO ";
        } else {
            query = "SELECT "
                    + "extract(year from f.dtlancamento) as ANO,"
                    + "sum(abs(f.quantidade)) as QUANTIDADE "
                    + " FROM ECUSCASTROLANDAFINANCEIRO f "
                    + "WHERE f.nmproduto = '' ";
            for (String m : list) {
                query = query.concat("or f.nmproduto = '" + m + "' ");
            }

            query = query.concat("group by ANO");

        }
        try {
            JDBCCategoryDataset dataSet = new JDBCCategoryDataset(con, query);
            barChart2.setData(dataSet);
        } catch (Exception e) {
        }
    }

    private ListModel<String> getMedicamentosModel() {
        AbstractListModel<String> model = new AbstractListModel<String>() {

            @Override
            public int getSize() {
                return medicamentosList.size();
            }

            @Override
            public String getElementAt(int i) {
                return medicamentosList.get(i);
            }

        };
        return model;
    }

    private List<String> getMedicamentos() {
        String sql = " select distinct upper(f.NMPRODUTO) as PRODUTO \n"
                + "from ECUSCASTROLANDAFINANCEIRO f \n"
                + "where f.CDCONTAFINANCEIRA = 20 or f.CDCONTAFINANCEIRA = 21 ";
        List<String> med = new ArrayList<>();
        try {

            ResultSet rs = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            rs.first();
            while (!rs.isAfterLast()) {
                med.add(rs.getString("PRODUTO"));
                rs.next();
            }
            return med;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
