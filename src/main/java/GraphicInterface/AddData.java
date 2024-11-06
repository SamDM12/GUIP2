/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GraphicInterface;
import javax.swing.JOptionPane;
import DBProcedures.GetSetData;
/**
 *
 * @author chedr
 */
public class AddData extends javax.swing.JFrame {
    private GetSetData setElements = new GetSetData();
    /**
     * Creates new form AddData
     */
    public AddData() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        addCountryTextField = new javax.swing.JTextField();
        addCountryButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        addDisabilityTextField = new javax.swing.JTextField();
        addDisabilityButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        addGenderTextField = new javax.swing.JTextField();
        addGenderTypeButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        addPhoneTypeTextField = new javax.swing.JTextField();
        addPhoneTypeButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        addIdentificationTypeTextField = new javax.swing.JTextField();
        addIdentificationTypeButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        addMedalTypeTextField = new javax.swing.JTextField();
        addMedalTypeButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        addTeamTextField = new javax.swing.JTextField();
        addTeamButton = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        addNationalityTextField = new javax.swing.JTextField();
        addNationalityButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 51, 153), new java.awt.Color(0, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 200));

        addCountryTextField.setBackground(new java.awt.Color(228, 255, 228));
        addCountryTextField.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        addCountryTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 0), new java.awt.Color(0, 102, 0), null, null));

        addCountryButton.setBackground(new java.awt.Color(204, 255, 204));
        addCountryButton.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        addCountryButton.setForeground(new java.awt.Color(51, 0, 102));
        addCountryButton.setText("Agregar País");
        addCountryButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0), null, null));
        addCountryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCountryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCountryTextField)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(addCountryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCountryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(addCountryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 200));

        addDisabilityTextField.setBackground(new java.awt.Color(228, 255, 228));
        addDisabilityTextField.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        addDisabilityTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 0), new java.awt.Color(0, 102, 0), null, null));

        addDisabilityButton.setBackground(new java.awt.Color(204, 255, 204));
        addDisabilityButton.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        addDisabilityButton.setForeground(new java.awt.Color(51, 0, 102));
        addDisabilityButton.setText("Agregar Discapacidad");
        addDisabilityButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0), null, null));
        addDisabilityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDisabilityButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addDisabilityTextField)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(addDisabilityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addDisabilityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(addDisabilityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 200));

        addGenderTextField.setBackground(new java.awt.Color(228, 255, 228));
        addGenderTextField.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        addGenderTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 0), new java.awt.Color(0, 102, 0), null, null));

        addGenderTypeButton.setBackground(new java.awt.Color(204, 255, 204));
        addGenderTypeButton.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        addGenderTypeButton.setForeground(new java.awt.Color(51, 0, 102));
        addGenderTypeButton.setText("Agregar Género");
        addGenderTypeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0), null, null));
        addGenderTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGenderTypeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addGenderTextField)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(addGenderTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addGenderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(addGenderTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 200));

        addPhoneTypeTextField.setBackground(new java.awt.Color(228, 255, 228));
        addPhoneTypeTextField.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        addPhoneTypeTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 0), new java.awt.Color(0, 102, 0), null, null));

        addPhoneTypeButton.setBackground(new java.awt.Color(204, 255, 204));
        addPhoneTypeButton.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        addPhoneTypeButton.setForeground(new java.awt.Color(51, 0, 102));
        addPhoneTypeButton.setText("Agregar Tipo Teléfono");
        addPhoneTypeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0), null, null));
        addPhoneTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPhoneTypeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addPhoneTypeTextField)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(addPhoneTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addPhoneTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(addPhoneTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setPreferredSize(new java.awt.Dimension(300, 200));

        addIdentificationTypeTextField.setBackground(new java.awt.Color(228, 255, 228));
        addIdentificationTypeTextField.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        addIdentificationTypeTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 0), new java.awt.Color(0, 102, 0), null, null));

        addIdentificationTypeButton.setBackground(new java.awt.Color(204, 255, 204));
        addIdentificationTypeButton.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        addIdentificationTypeButton.setForeground(new java.awt.Color(51, 0, 102));
        addIdentificationTypeButton.setText("Agregar tipo Identificación");
        addIdentificationTypeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0), null, null));
        addIdentificationTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIdentificationTypeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addIdentificationTypeTextField)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(addIdentificationTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addIdentificationTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(addIdentificationTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setPreferredSize(new java.awt.Dimension(300, 200));

        addMedalTypeTextField.setBackground(new java.awt.Color(228, 255, 228));
        addMedalTypeTextField.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        addMedalTypeTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 0), new java.awt.Color(0, 102, 0), null, null));

        addMedalTypeButton.setBackground(new java.awt.Color(204, 255, 204));
        addMedalTypeButton.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        addMedalTypeButton.setForeground(new java.awt.Color(51, 0, 102));
        addMedalTypeButton.setText("Agregar Tipo Medalla");
        addMedalTypeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0), null, null));
        addMedalTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMedalTypeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addMedalTypeTextField)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(addMedalTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addMedalTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(addMedalTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setPreferredSize(new java.awt.Dimension(300, 200));

        addTeamTextField.setBackground(new java.awt.Color(228, 255, 228));
        addTeamTextField.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        addTeamTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 0), new java.awt.Color(0, 102, 0), null, null));

        addTeamButton.setBackground(new java.awt.Color(204, 255, 204));
        addTeamButton.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        addTeamButton.setForeground(new java.awt.Color(51, 0, 102));
        addTeamButton.setText("Agregar Equipo");
        addTeamButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0), null, null));
        addTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeamButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addTeamTextField)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(addTeamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addTeamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(addTeamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(0, 204, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setPreferredSize(new java.awt.Dimension(300, 200));

        addNationalityTextField.setBackground(new java.awt.Color(228, 255, 228));
        addNationalityTextField.setFont(new java.awt.Font("Segoe UI Black", 2, 12)); // NOI18N
        addNationalityTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 0), new java.awt.Color(0, 102, 0), null, null));

        addNationalityButton.setBackground(new java.awt.Color(204, 255, 204));
        addNationalityButton.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        addNationalityButton.setForeground(new java.awt.Color(51, 0, 102));
        addNationalityButton.setText("Agregar Nacionalidad");
        addNationalityButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0), null, null));
        addNationalityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNationalityButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addNationalityTextField)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(addNationalityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addNationalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(addNationalityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(0, 204, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setPreferredSize(new java.awt.Dimension(300, 200));

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jButton1)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCountryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCountryButtonActionPerformed
        String text = addCountryTextField.getText();
        if(!text.isEmpty()){
            setElements.insertCountry(text);
            showMessage("País guardado exitosamente");
        }else{
            showCautionMessage();
        }
    }//GEN-LAST:event_addCountryButtonActionPerformed

    private void addDisabilityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDisabilityButtonActionPerformed
        String text = addDisabilityTextField.getText();
        if(!text.isEmpty()){
            setElements.insertDisability(text);
            showMessage("Discapacidad guardada exitosamente");
        }else{
            showCautionMessage();
        }
    }//GEN-LAST:event_addDisabilityButtonActionPerformed

    private void addGenderTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGenderTypeButtonActionPerformed
        String text = addGenderTextField.getText();
        if(!text.isEmpty()){
            setElements.insertGenderType(text);
            showMessage("Género guardado exitosamente");
        }else{
            showCautionMessage();
        }
        
    }//GEN-LAST:event_addGenderTypeButtonActionPerformed

    private void addPhoneTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPhoneTypeButtonActionPerformed
        String text = addPhoneTypeTextField.getText();
        if(!text.isEmpty()){
            setElements.insertPhoneType(text);
            showMessage("Tipo de teléfono guardado exitosamente");        
        }else{
            showCautionMessage();
        }
        
    }//GEN-LAST:event_addPhoneTypeButtonActionPerformed

    private void addIdentificationTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIdentificationTypeButtonActionPerformed
        String text = addIdentificationTypeTextField.getText();
        if(!text.isEmpty()){
            setElements.insertIdentificationType(text);
            showMessage("Tipo de identificación guardado exitosamente");
        }else{
            showCautionMessage();
        }
    }//GEN-LAST:event_addIdentificationTypeButtonActionPerformed

    private void addMedalTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMedalTypeButtonActionPerformed
        String text = addMedalTypeTextField.getText();
        if(!text.isEmpty()){
            setElements.insertMedalType(text);
            showMessage("Tipo de medalla guardada exitosamente");        
        }else{
            showCautionMessage();
        }
    }//GEN-LAST:event_addMedalTypeButtonActionPerformed

    private void addTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeamButtonActionPerformed
        String text = addTeamTextField.getText();
        if(!text.isEmpty()){
            setElements.insertTeam(text);
            showMessage("Equipo guardado exitosamente");
        }else{
            showCautionMessage();
        }
    }//GEN-LAST:event_addTeamButtonActionPerformed

    private void addNationalityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNationalityButtonActionPerformed
        String text = addNationalityTextField.getText();
        if(!text.isEmpty()){
            setElements.insertNationality(text);
            showMessage("Nacionalidad guardada exitosamente");
        }else{
            showCautionMessage();
        }
    }//GEN-LAST:event_addNationalityButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(AddData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCountryButton;
    private javax.swing.JTextField addCountryTextField;
    private javax.swing.JButton addDisabilityButton;
    private javax.swing.JTextField addDisabilityTextField;
    private javax.swing.JTextField addGenderTextField;
    private javax.swing.JButton addGenderTypeButton;
    private javax.swing.JButton addIdentificationTypeButton;
    private javax.swing.JTextField addIdentificationTypeTextField;
    private javax.swing.JButton addMedalTypeButton;
    private javax.swing.JTextField addMedalTypeTextField;
    private javax.swing.JButton addNationalityButton;
    private javax.swing.JTextField addNationalityTextField;
    private javax.swing.JButton addPhoneTypeButton;
    private javax.swing.JTextField addPhoneTypeTextField;
    private javax.swing.JButton addTeamButton;
    private javax.swing.JTextField addTeamTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
private void showMessage(String message){
    JOptionPane.showMessageDialog(null, message,"Éxito", JOptionPane.INFORMATION_MESSAGE);
}
private void showCautionMessage(){
    JOptionPane.showMessageDialog(null, "Está intentando ingresar un campo vacío.", "Advertencia",JOptionPane.WARNING_MESSAGE);
}

}