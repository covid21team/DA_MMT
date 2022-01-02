/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import static Client.Client.BUFFER;
import static Client.Client.SERVER_IP;
import static Client.Client.SERVER_PORT;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PHU
 */
public class frmClient extends javax.swing.JFrame {

    public final static String SERVER_IP = "127.0.0.1";
    public final static int SERVER_PORT = 1433; // Cổng mặc định của Echo Server
    public final static byte[] BUFFER = new byte[10000]; // Vùng đệm chứa dữ liệu cho gói tin nhận
 
    private static int q = 353;
    private static int a = 3;
    
    private DatagramSocket ds = null;
    private String str = "";
    private int key;
    private static int keyServer = 1;
    private int checkSend = 0;
    /**
     * Creates new form frmClient
     */
    public frmClient() {
        initComponents();
        
        try {
            ds = new DatagramSocket(); // Tạo DatagramSocket
            System.out.println("Client started ");
 
            InetAddress server = InetAddress.getByName(SERVER_IP);

            if(checkSend == 0){
                // Tạo gói tin gởi
                DatagramPacket khoa = new DatagramPacket("Lấy khóa".getBytes(), "Lấy khóa".getBytes().length, server, SERVER_PORT);
                ds.send(khoa); // Send gói tin sang Echo Server

                 // nhận khóa công khai từ server
                DatagramPacket incoming1 = new DatagramPacket(BUFFER, BUFFER.length);
                ds.receive(incoming1); // Chờ nhận dữ liệu từ EchoServer gởi về

                keyServer = Integer.parseInt(new String(incoming1.getData(), 0, incoming1.getLength()));
                System.out.println("Khoa cong khai server: " + new String(incoming1.getData(), 0, incoming1.getLength()));

                checkSend = 1;
            }

        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
        
//        cbb.removeAllItems();
//        
//        for(int i = 1; i < q; i ++){
//            if(checkKey(i)){
//                cbb.addItem(i+"");
//            }
//        }
    }
    
    private static boolean checkKey(int n){
        int check = (int)Math.pow(keyServer, n);
        
        if(check % q > 0 && check % q < 25){
            return true;
        }
        return false;
    }
    
    private static String encode(String str, int key){
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                char ch = (char) (((int) str.charAt(i) +
                        key - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) str.charAt(i) +
                        key - 97) % 26 + 97);
                result.append(ch);
            }
        }
        
        return result.toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtVB = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnDem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtMH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtk = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtVB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nhập văn bản");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Khóa");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Kết quả");

        btnDem.setText("Đếm");
        btnDem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("ĐỀ TÀI SỐ 13 - NHÓM RLCRAFT");

        table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        jButton1.setText("thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtMH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Mã hóa");

        txtk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMH, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(txtVB, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnDem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtVB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDem)
                    .addComponent(jButton1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemActionPerformed
        try {
            str = txtVB.getText();
//            key = Integer.parseInt(cbb.getSelectedItem().toString());
            key = Integer.parseInt(txtk.getText().toString());
            
            ds = new DatagramSocket(); // Tạo DatagramSocket
            System.out.println("Client started ");
 
            InetAddress server = InetAddress.getByName(SERVER_IP);

            //Tạo khóa công khai
            int keyPublic  = (int)Math.pow(a, key) % q;
            //Tạo khóa bí mật chung
            int keyPrivate = (int)Math.pow(keyServer, key) % q;
            int k = CalKey(keyPrivate);
            
            //mã hóa văn bản
            String text = encode(str, k);
            txtMH.setText(text);
            byte[] data = (text+"@"+keyPublic).getBytes(); // Đổi chuỗi ra mảng bytes

            // Tạo gói tin gởi
            DatagramPacket dp = new DatagramPacket(data, data.length, server, SERVER_PORT);
            ds.send(dp); // Send gói tin sang Echo Server

            // Gói tin nhận
            DatagramPacket incoming = new DatagramPacket(BUFFER, BUFFER.length);
            ds.receive(incoming); // Chờ nhận dữ liệu từ EchoServer gởi về
            String message = new String(incoming.getData(), 0, incoming.getLength());

            //tách từng kí tự
            String[] kytu_so = message.split("-");

            //tách 2 mảng
            List<String> kytu = new ArrayList<String>();
            List<String> so = new ArrayList<String>();

            for(int i = 0; i < kytu_so.length; i++){
                String[] temp = kytu_so[i].split(":");
                kytu.add(temp[0]);
                so.add(temp[1]);
            }

            //truyền data lên jTable
            Vector vctHeader = new Vector();
            Vector vctData = new Vector();

            vctHeader.add("Ký tự");
            vctHeader.add("Số lượng");

            for(int i = 0; i < kytu.size(); i ++){
                Vector vctRow = new Vector();
                vctRow.add(kytu.get(i));
                vctRow.add(so.get(i));
                vctData.add(vctRow);
            }

            table.setModel(new DefaultTableModel(vctData, vctHeader));

            // Đổi dữ liệu nhận được dạng mảng bytes ra chuỗi và in ra màn hình
            System.out.println("So luong xuat hien cua cac chu cai: " + message);

        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }//GEN-LAST:event_btnDemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClient().setVisible(true);
            }
        });
    }
    
    public static int CalKey(int n){
    while(n>26){
            for(int i=9;i>0;i--){
                if(n%i != 0){
                    continue;
                }
                n= n/i;
                break;
            }
            if(n!=26&&n!=1)
            n=n-1;
        };
        return n;
    }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtMH;
    private javax.swing.JTextField txtVB;
    private javax.swing.JTextField txtk;
    // End of variables declaration//GEN-END:variables
}
