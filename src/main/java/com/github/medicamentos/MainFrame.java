package com.github.medicamentos;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.swing.AbstractListModel;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class MainFrame extends javax.swing.JFrame {

    private Connection con;
   
    public MainFrame(Connection con) {
        this.con = con;
        setLocale(new Locale("pt_BR"));
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        painelChart = new javax.swing.JPanel();
        barChart1 = new com.github.medicamentos.components.BarChart();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel6.setBackground(new java.awt.Color(153, 153, 254));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel5.setBackground(new java.awt.Color(153, 153, 254));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 200));

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(522, 25));

        jLabel1.setText("Pesquisar Produto");
        jLabel1.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel2);

        txtProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtProduto.setMargin(new java.awt.Insets(2, 15, 2, 2));
        txtProduto.setPreferredSize(new java.awt.Dimension(2, 30));
        txtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoActionPerformed(evt);
            }
        });
        txtProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProdutoKeyReleased(evt);
            }
        });
        jPanel3.add(txtProduto);

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel3.add(jSeparator1);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(7, 250));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setPreferredSize(new java.awt.Dimension(5, 250));
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel3.add(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelChart.setBackground(new java.awt.Color(255, 255, 255));
        painelChart.setLayout(new java.awt.CardLayout());

        barChart1.setChartColor(java.awt.Color.white);
        barChart1.setChartLabelsColor(java.awt.Color.black);
        barChart1.setChartLabelsVisible(true);
        barChart1.setChartMarksColor(java.awt.Color.black);
        barChart1.setChartMarksVisible(true);
        barChart1.setChartSeriesColor(new java.awt.Color(0, 0, 51));
        barChart1.setChartTitle("<Not Set>");
        barChart1.setChartTitleColor(java.awt.Color.black);
        painelChart.add(barChart1, "card2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
            .addComponent(painelChart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelChart, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel6, "card3");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdutoKeyReleased
        procurarProduto(txtProduto.getText());
    }//GEN-LAST:event_txtProdutoKeyReleased

    private void txtProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoActionPerformed

    }//GEN-LAST:event_txtProdutoActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        generateChart(jList1.getSelectedValuesList());
    }//GEN-LAST:event_jList1ValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.medicamentos.components.BarChart barChart1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel painelChart;
    private javax.swing.JTextField txtProduto;
    // End of variables declaration//GEN-END:variables

    private void generateChart(List<String> list) {
        String query;
        if (list.size() == 1) {
            query = "SELECT "
                    + "extract(year from f.dtlancamento) as ANO,"
                    + "sum(abs(f.quantidade)) as TOTAL "
                    + " FROM ECUSCASTROLANDAFINANCEIRO f "
                    + "WHERE f.nmproduto = '" + list.get(0) + "' "
                    + "group by ANO ";
        } else {
            query = "SELECT "
                    + "extract(year from f.dtlancamento) as ANO,"
                    + "sum(abs(f.quantidade)) as TOTAL "
                    + " FROM ECUSCASTROLANDAFINANCEIRO f "
                    + "WHERE f.nmproduto = '' ";
            for (String m : list) {
                query = query.concat("or f.nmproduto = '" + m + "' ");
            }

            query = query.concat("group by ANO");

        }
        try {
            JDBCCategoryDataset dataSet = new JDBCCategoryDataset(con, query);
            barChart1.setData(dataSet);
            barChart1.setChartTitle(Arrays.toString(list.toArray()));
            barChart1.setChartTitleColor(Color.BLACK);
        } catch (Exception e) {
        }
    }

    private void procurarProduto(String text) {
        String sql = "select distinct f.nmproduto as PRODUTO from ecuscastrolandafinanceiro f "
                + "where upper(f.nmproduto) like upper('%" + text + "%')";
        try {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(sql);
            rs.first();
            List<String> produtos = new ArrayList<>();
            while (!rs.isAfterLast()) {
                String prod = rs.getString("PRODUTO");
                produtos.add(prod);
                rs.next();
            }
            setModelList(produtos);
        } catch (Exception e) {
        }

    }

    private void setModelList(List<String> list) {
        AbstractListModel<String> model = new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return list.size();
            }

            @Override
            public String getElementAt(int i) {
                return list.get(i);
            }
        };
        jList1.setModel(model);
    }

}
