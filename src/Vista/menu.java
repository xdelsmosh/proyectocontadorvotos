package Vista;
import Controlador.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Writer;





public class menu extends javax.swing.JFrame {

    Conexion connUno = new Conexion();
    private Connection connect;
    private DefaultTableModel modelo;
    private Statement st;
    private ResultSet rs;
    private int id;

    public menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        limpiarRelojBD();
        consultar();
    }

    public void consultar() {
        try {
            String sql = "select * from clientes";
            connect = connUno.getConnection();
            st = connect.createStatement();
            rs = st.executeQuery(sql);

            Object[] relojArrelglo = new Object[5];
            modelo = (DefaultTableModel) jTableRelojBD.getModel();

            while (rs.next()) {
                relojArrelglo[0] = rs.getInt("id");
                relojArrelglo[1] = rs.getString("nombre_cliente");
                relojArrelglo[2] = rs.getString("rut_clientte");
                relojArrelglo[3] = rs.getInt("ventas");
                relojArrelglo[4] = rs.getString("correo");

                modelo.addRow(relojArrelglo);
            }
            jTableRelojBD.setModel(modelo);

        } catch (Exception e) {
            System.err.println("Error" + e);
        }
    }

    public void crear() {
        String nombre_cliente =("'"+ txtNombre.getText()+"'");
        String rut_clientte =("'"+jTextFieldMinutoBD.getText()+"'");
        int ventas = Integer.parseInt(jTextFieldSegundoBD.getText());
        String correo =("'"+jTextFieldcorreo.getText()+"'");

        try {
            if (ventas >=0  ) {
                String sql = "insert into clientes (nombre_cliente, rut_clientte, ventas,correo) values (" + nombre_cliente + "," + rut_clientte + "," + ventas + ", " + correo + " )";
                connect = connUno.getConnection();
                st = connect.createStatement();
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Agregado");
                limpiarTabla();
                consultar();
            } else {
                JOptionPane.showMessageDialog(null, "opción no valida");
                limpiarTabla();
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
    }
    
    public void actualizar() {
        String nombre_cliente =("'"+txtNombre.getText()+"'");
        String rut_clientte  =("'"+jTextFieldMinutoBD.getText()+"'");
        int ventas = Integer.parseInt(jTextFieldSegundoBD.getText());
        String correo =("'"+jTextFieldcorreo.getText()+"'");
        try {
            if (ventas>0) {
                String sql = "update clientes set nombre_cliente =" + nombre_cliente + ", rut_clientte =" + rut_clientte + ",ventas =" + ventas + ",correo="+ correo +" where id = " + id;
                connect = connUno.getConnection();
                st = connect.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, " actualizado ^_^");
                limpiarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "no permitido");
                limpiarTabla();
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
    }

    public void eliminar() {
        int fila = jTableRelojBD.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, " no seleccionada ಠ_ಠ");
        } 
        else {
            try {
                String sql = "delete from clientes where id =" + id;
                connect = connUno.getConnection();
                st = connect.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, " eliminado ^_^");
                limpiarTabla();
            } catch (Exception e) {
                System.err.println("Error" + e);
            }
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i <= jTableRelojBD.getRowCount(); i++) {
            modelo.removeRow(i);
            i--;
        }
    }



    public void limpiarRelojBD() {
        txtNombre.setText("");
        jTextFieldMinutoBD.setText("");
        jTextFieldSegundoBD.setText("");
        jTextFieldcorreo.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRelojBD = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jTextFieldMinutoBD = new javax.swing.JTextField();
        jTextFieldSegundoBD = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButtonCrearBD = new javax.swing.JButton();
        jButtonActualizarBD = new javax.swing.JButton();
        jButtonEliminarBD = new javax.swing.JButton();
        jButtonLimpiarBD = new javax.swing.JButton();
        jButtonSalirBD = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldcorreo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PDF = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Datos");

        jTableRelojBD.setBackground(new java.awt.Color(204, 204, 204));
        jTableRelojBD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "nombre_cliente", "rut_clientte", "ventas", "correo"
            }
        ));
        jTableRelojBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRelojBDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRelojBD);

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tabla de clientes");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Rut");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Venta");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jTextFieldMinutoBD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jTextFieldSegundoBD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextFieldSegundoBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSegundoBDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jTextFieldSegundoBD))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jTextFieldMinutoBD)))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(73, 73, 73))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldMinutoBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldSegundoBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        jButtonCrearBD.setBackground(new java.awt.Color(255, 153, 153));
        jButtonCrearBD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonCrearBD.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCrearBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1486485587-add-create-new-maths-math-signs-plus_81172.png"))); // NOI18N
        jButtonCrearBD.setText("Crear");
        jButtonCrearBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearBDActionPerformed(evt);
            }
        });

        jButtonActualizarBD.setBackground(new java.awt.Color(102, 102, 102));
        jButtonActualizarBD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonActualizarBD.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActualizarBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/twocirclingarrows1_120592.png"))); // NOI18N
        jButtonActualizarBD.setText("Actualizar");
        jButtonActualizarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarBDActionPerformed(evt);
            }
        });

        jButtonEliminarBD.setBackground(new java.awt.Color(153, 153, 153));
        jButtonEliminarBD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonEliminarBD.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminarBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/seo-social-web-network-internet_262_icon-icons.com_61518.png"))); // NOI18N
        jButtonEliminarBD.setText("Eliminar");
        jButtonEliminarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarBDActionPerformed(evt);
            }
        });

        jButtonLimpiarBD.setBackground(new java.awt.Color(255, 204, 102));
        jButtonLimpiarBD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonLimpiarBD.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLimpiarBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_orange_ccleaner_clean_icon_134365.png"))); // NOI18N
        jButtonLimpiarBD.setText("Limpiar");
        jButtonLimpiarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarBDActionPerformed(evt);
            }
        });

        jButtonSalirBD.setBackground(new java.awt.Color(0, 153, 51));
        jButtonSalirBD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonSalirBD.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalirBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sign-emergency-code-sos_61_icon-icons.com_57216.png"))); // NOI18N
        jButtonSalirBD.setText("Salir");
        jButtonSalirBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirBDActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(204, 204, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Operaciones");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCrearBD, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonActualizarBD, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEliminarBD, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLimpiarBD, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalirBD, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel10)
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButtonSalirBD, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCrearBD)
                        .addComponent(jButtonActualizarBD, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEliminarBD, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonLimpiarBD, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTextFieldcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldcorreoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Correo");

        PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_type_pdf_icon_130274.png"))); // NOI18N
        PDF.setText("PDF");
        PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDFActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/color_wheel_16443 (2)_1.png"))); // NOI18N
        jButton1.setText("color");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(PDF)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                .addGap(30, 30, 30))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PDF, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirBDActionPerformed
        JOptionPane.showMessageDialog(null, "Adios (⌐■_■)");
        System.exit(0);

    }//GEN-LAST:event_jButtonSalirBDActionPerformed

    private void jButtonCrearBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearBDActionPerformed

        crear();
        limpiarRelojBD();
        consultar();
    }//GEN-LAST:event_jButtonCrearBDActionPerformed

    private void jButtonActualizarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarBDActionPerformed
        actualizar();
        limpiarRelojBD();
        consultar();
    }//GEN-LAST:event_jButtonActualizarBDActionPerformed

    private void jButtonLimpiarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarBDActionPerformed
        limpiarRelojBD();
    }//GEN-LAST:event_jButtonLimpiarBDActionPerformed

    private void jButtonEliminarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarBDActionPerformed
        eliminar();
        consultar();

    }//GEN-LAST:event_jButtonEliminarBDActionPerformed

    private void jTableRelojBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRelojBDMouseClicked
        int fila = jTableRelojBD.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, " no seleccionada (┬┬﹏┬┬)");
        } else {
            id = Integer.parseInt((String) jTableRelojBD.getValueAt(fila, 0).toString());
            String nombre_cliente = ((String) jTableRelojBD.getValueAt(fila, 1).toString());
            String rut_clientte = ((String) jTableRelojBD.getValueAt(fila, 2).toString());
            int ventas = Integer.parseInt((String) jTableRelojBD.getValueAt(fila, 3).toString());
            String correo = ((String) jTableRelojBD.getValueAt(fila, 4).toString());

            txtNombre.setText(String.valueOf(nombre_cliente));
            jTextFieldMinutoBD.setText(String.valueOf(rut_clientte));
            jTextFieldSegundoBD.setText(String.valueOf(ventas));
            jTextFieldcorreo.setText(String.valueOf(correo));
        }
    }//GEN-LAST:event_jTableRelojBDMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         int red, green ,blue;
        red=(int)(Math.random()*255);
        green=(int)(Math.random()*255);
        blue=(int)(Math.random()*255);
        Color c = new Color(red, green ,blue);
        jPanel8.setBackground(c);
        jPanel7.setBackground(c);
        jPanel6.setBackground(c);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldcorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldcorreoActionPerformed

    private void jTextFieldSegundoBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSegundoBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSegundoBDActionPerformed

    private void PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDFActionPerformed
     Document documento = new Document ();
     try{
         String ruta =System.getProperty("user.home");
         PdfWriter.getInstance(documento, new FileOutputStream(ruta+"/Desktop/Clientes.pdf"));
         documento.open();
         
         PdfPTable tabla = new PdfPTable(5);
          tabla.addCell("codigo");
          tabla.addCell("nombre");
          tabla.addCell("rut");
          tabla.addCell("venta");
          tabla.addCell("correo");
          
          try {
             Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/db_tiendae","root","root");
             PreparedStatement pst=cn.prepareStatement("select * from clientes");
             ResultSet rs = pst.executeQuery();
             if(rs.next()){
                 
                 do {                     
                     tabla.addCell(rs.getString(1));
                     tabla.addCell(rs.getString(2));
                     tabla.addCell(rs.getString(3));
                     tabla.addCell(rs.getString(4));
                     tabla.addCell(rs.getString(5));
                 } while (rs.next());
             }   documento.add(tabla);
                     
         } catch (DocumentException | SQLException e) {
         }
          documento.close();
          JOptionPane.showMessageDialog(null, "reporte creado.");
     }catch(DocumentException | HeadlessException | FileNotFoundException e){
         
     }
    }//GEN-LAST:event_PDFActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PDF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonActualizarBD;
    private javax.swing.JButton jButtonCrearBD;
    private javax.swing.JButton jButtonEliminarBD;
    private javax.swing.JButton jButtonLimpiarBD;
    private javax.swing.JButton jButtonSalirBD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRelojBD;
    private javax.swing.JTextField jTextFieldMinutoBD;
    private javax.swing.JTextField jTextFieldSegundoBD;
    private javax.swing.JTextField jTextFieldcorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
