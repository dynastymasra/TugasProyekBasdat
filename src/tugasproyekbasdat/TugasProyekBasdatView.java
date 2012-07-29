/*
 * TugasProyekBasdatView.java
 */

package tugasproyekbasdat;

import java.awt.Color;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The application's main frame.
 */
public class TugasProyekBasdatView extends FrameView {

    
    public TugasProyekBasdatView(SingleFrameApplication app) {
        super(app);
        initComponents();
        startup();
        start();
      
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                   
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = TugasProyekBasdatApp.getApplication().getMainFrame();
            aboutBox = new TugasProyekBasdatAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        TugasProyekBasdatApp.getApplication().show(aboutBox);
    }
    @Action
    public void showAboutInput() {
        if (tugasInput == null) {
            JFrame mainFrame = TugasProyekBasdatApp.getApplication().getMainFrame();
            tugasInput = new TugasInput(mainFrame);
            tugasInput.setLocationRelativeTo(mainFrame);
        }
        TugasProyekBasdatApp.getApplication().show(tugasInput);
    }
    @Action
    public void showAboutAdd() {
        if (aboutAdd == null) {
            JFrame mainFrame = TugasProyekBasdatApp.getApplication().getMainFrame();
            aboutAdd = new TugasAddNew(mainFrame);
            aboutAdd.setLocationRelativeTo(mainFrame);
        }
        TugasProyekBasdatApp.getApplication().show(aboutAdd);
    }
    @Action
    public void showAboutChasier() {
        if (aboutChasier == null) {
            JFrame mainFrame = TugasProyekBasdatApp.getApplication().getMainFrame();
            aboutChasier = new TugasKasir(mainFrame);
            aboutChasier.setLocationRelativeTo(mainFrame);
        }
        TugasProyekBasdatApp.getApplication().show(aboutChasier);
    }
    @Action
    public void showAboutEmployees() {
        if (aboutEmployees == null) {
            JFrame mainFrame = TugasProyekBasdatApp.getApplication().getMainFrame();
            aboutEmployees = new TugasEmployees(mainFrame);
            aboutEmployees.setLocationRelativeTo(mainFrame);
        }
        TugasProyekBasdatApp.getApplication().show(aboutEmployees);
    }
    @Action
    public void showAboutSupplier() {
        if (aboutSupplier == null) {
            JFrame mainFrame = TugasProyekBasdatApp.getApplication().getMainFrame();
            aboutSupplier = new TugasSupplier(mainFrame);
            aboutSupplier.setLocationRelativeTo(mainFrame);
        }
        TugasProyekBasdatApp.getApplication().show(aboutSupplier);
    }
     @Action
    public void showAboutOrder() {
        if (aboutOrder == null) {
            JFrame mainFrame = TugasProyekBasdatApp.getApplication().getMainFrame();
            aboutOrder = new TugasOrder(mainFrame);
            aboutOrder.setLocationRelativeTo(mainFrame);
        }
        TugasProyekBasdatApp.getApplication().show(aboutOrder);
    }
    @Action
    public void showAboutRetur() {
        if (aboutRetur == null) {
            JFrame mainFrame = TugasProyekBasdatApp.getApplication().getMainFrame();
            aboutRetur = new TugasRetur(mainFrame);
            aboutRetur.setLocationRelativeTo(mainFrame);
        }
        TugasProyekBasdatApp.getApplication().show(aboutRetur);
    }
    @Action
    public void showAboutSell() {
        if (aboutSell == null) {
            JFrame mainFrame = TugasProyekBasdatApp.getApplication().getMainFrame();
            aboutSell = new TugasSell(mainFrame);
            aboutSell.setLocationRelativeTo(mainFrame);
        }
        TugasProyekBasdatApp.getApplication().show(aboutSell);
    }
    @Action
    public void showAboutBuy() {
        if (aboutBuy == null) {
            JFrame mainFrame = TugasProyekBasdatApp.getApplication().getMainFrame();
            aboutBuy = new TugasBuy(mainFrame);
            aboutBuy.setLocationRelativeTo(mainFrame);
        }
        TugasProyekBasdatApp.getApplication().show(aboutBuy);
    }
    @Action
    public void showAboutCash() {
        if (aboutKas == null) {
            JFrame mainFrame = TugasProyekBasdatApp.getApplication().getMainFrame();
            aboutKas = new ReportCash(mainFrame);
            aboutKas.setLocationRelativeTo(mainFrame);
        }
        TugasProyekBasdatApp.getApplication().show(aboutKas);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(400, 500));
        mainPanel.setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(tugasproyekbasdat.TugasProyekBasdatApp.class).getContext().getResourceMap(TugasProyekBasdatView.class);
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        mainPanel.add(jLabel3);
        jLabel3.setBounds(220, 370, 50, 14);

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setForeground(resourceMap.getColor("jLabel2.foreground")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        mainPanel.add(jLabel2);
        jLabel2.setBounds(110, 130, 70, 15);

        jLabel4.setFont(resourceMap.getFont("jLabel4.font")); // NOI18N
        jLabel4.setForeground(resourceMap.getColor("jLabel4.foreground")); // NOI18N
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        mainPanel.add(jLabel4);
        jLabel4.setBounds(110, 160, 80, 15);

        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N
        mainPanel.add(jTextField1);
        jTextField1.setBounds(210, 130, 140, 20);

        jProgressBar1.setName("jProgressBar1"); // NOI18N
        jProgressBar1.setStringPainted(true);
        mainPanel.add(jProgressBar1);
        jProgressBar1.setBounds(10, 370, 470, 17);

        jLabel5.setFont(resourceMap.getFont("jLabel5.font")); // NOI18N
        jLabel5.setForeground(resourceMap.getColor("jLabel5.foreground")); // NOI18N
        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        mainPanel.add(jLabel5);
        jLabel5.setBounds(210, 80, 70, 15);

        jPasswordField1.setText(resourceMap.getString("jPasswordField1.text")); // NOI18N
        jPasswordField1.setName("jPasswordField1"); // NOI18N
        mainPanel.add(jPasswordField1);
        jPasswordField1.setBounds(210, 160, 140, 20);

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        mainPanel.add(jButton1);
        jButton1.setBounds(210, 190, 73, 23);

        jLabel1.setIcon(resourceMap.getIcon("jLabel1.icon")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        mainPanel.add(jLabel1);
        jLabel1.setBounds(0, 0, 488, 366);

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N
        fileMenu.setRolloverEnabled(false);

        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setToolTipText(resourceMap.getString("jMenuItem1.toolTipText")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(tugasproyekbasdat.TugasProyekBasdatApp.class).getContext().getActionMap(TugasProyekBasdatView.class, this);
        jMenuItem3.setAction(actionMap.get("showAboutAdd")); // NOI18N
        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        fileMenu.add(jMenuItem3);

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItem2.setAction(actionMap.get("showAboutInput")); // NOI18N
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenu1.add(jMenuItem2);

        jMenuItem4.setAction(actionMap.get("showAboutChasier")); // NOI18N
        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAction(actionMap.get("showAboutEmployees")); // NOI18N
        jMenuItem5.setText(resourceMap.getString("jMenuItem5.text")); // NOI18N
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        jMenu1.add(jMenuItem5);

        jMenuItem6.setAction(actionMap.get("showAboutSupplier")); // NOI18N
        jMenuItem6.setText(resourceMap.getString("jMenuItem6.text")); // NOI18N
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        jMenu1.add(jMenuItem6);

        jMenuItem7.setAction(actionMap.get("showAboutOrder")); // NOI18N
        jMenuItem7.setText(resourceMap.getString("jMenuItem7.text")); // NOI18N
        jMenuItem7.setName("jMenuItem7"); // NOI18N
        jMenu1.add(jMenuItem7);

        jMenuItem8.setAction(actionMap.get("showAboutRetur")); // NOI18N
        jMenuItem8.setText(resourceMap.getString("jMenuItem8.text")); // NOI18N
        jMenuItem8.setName("jMenuItem8"); // NOI18N
        jMenu1.add(jMenuItem8);

        menuBar.add(jMenu1);

        jMenu3.setText(resourceMap.getString("jMenu3.text")); // NOI18N
        jMenu3.setName("jMenu3"); // NOI18N

        jMenuItem9.setAction(actionMap.get("showAboutSell")); // NOI18N
        jMenuItem9.setText(resourceMap.getString("jMenuItem9.text")); // NOI18N
        jMenuItem9.setName("jMenuItem9"); // NOI18N
        jMenu3.add(jMenuItem9);

        jMenuItem10.setAction(actionMap.get("showAboutBuy")); // NOI18N
        jMenuItem10.setText(resourceMap.getString("jMenuItem10.text")); // NOI18N
        jMenuItem10.setName("jMenuItem10"); // NOI18N
        jMenu3.add(jMenuItem10);

        menuBar.add(jMenu3);

        jMenu2.setText(resourceMap.getString("jMenu2.text")); // NOI18N
        jMenu2.setName("jMenu2"); // NOI18N

        jMenuItem12.setAction(actionMap.get("showAboutCash")); // NOI18N
        jMenuItem12.setText(resourceMap.getString("jMenuItem12.text")); // NOI18N
        jMenuItem12.setName("jMenuItem12"); // NOI18N
        jMenu2.add(jMenuItem12);

        menuBar.add(jMenu2);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        menu1.setLabel(resourceMap.getString("menu1.label")); // NOI18N
        menuBar1.add(menu1);

        menu2.setLabel(resourceMap.getString("menu2.label")); // NOI18N
        menuBar1.add(menu2);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
    jMenuItem1.setEnabled(false);
        jMenuItem3.setEnabled(false);
        jLabel2.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        jTextField1.setVisible(true);
        jPasswordField1.setVisible(true);
        jButton1.setVisible(true);
        jMenuItem2.setEnabled(false);
        jMenuItem4.setEnabled(false);
        jMenuItem5.setEnabled(false);
        jMenuItem6.setEnabled(false);
        jMenuItem7.setEnabled(false);
        jMenuItem8.setEnabled(false);
        jMenuItem9.setEnabled(false);
        jMenuItem10.setEnabled(false);
        jMenuItem12.setEnabled(false);
        jLabel3.setText("Welcome");
}//GEN-LAST:event_jMenuItem1ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        try{
            Class.forName("com.mysql.jdbc.Driver");
            final String username = "root";
            final String password = "";

            final Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_tepe", username, password);
            final Statement statement = koneksi.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM `user` WHERE userid =SHA1('" + jTextField1.getText() + "') AND pass =MD5('" + jPasswordField1.getText() +"')");
            while(set.next()){
                user = set.getString(1);
                pass = set.getString(2);
                akses = set.getInt(3);
                if(user != null && pass != null) {
                    if(akses == 0) {
                        managerLogin();
                        JOptionPane.showMessageDialog(null, "Login Success", "Welcome Manager", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(akses == 1) {
                        pegawaiLogin();
                        JOptionPane.showMessageDialog(null, "Login Success", "Welcome Pegawai", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(akses == 2) {
                        kasirLogin();
                        JOptionPane.showMessageDialog(null, "Login Success", "Welcome Kasir", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else if(user  == null){
                    JOptionPane.showMessageDialog(null, "Login Failed", "Wrong Username or Password", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch(final SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(final ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    
}//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainPanel;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private javax.swing.JMenuBar menuBar;
    private java.awt.MenuBar menuBar1;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private int time = 0;
    private Timer timer;
    private JDialog aboutBox;
    private JDialog tugasInput;
    private JDialog aboutChasier;
    private JDialog aboutEmployees;
    private JDialog aboutAdd;
    private JDialog aboutSupplier;
    private JDialog aboutOrder;
    private JDialog aboutRetur;
    private JDialog aboutSell;
    private JDialog aboutBuy;
    private JDialog aboutReport;
    private JDialog aboutKas;
    private String user;
    private String pass;
    private int akses;
    
    private void startup() {
        jMenuItem1.setEnabled(false);
        jLabel3.setVisible(false);
        jLabel2.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jTextField1.setVisible(false);
        jPasswordField1.setVisible(false);
        jButton1.setVisible(false);
        jMenuItem3.setEnabled(false);
        jMenuItem2.setEnabled(false);
        jMenuItem4.setEnabled(false);
        jMenuItem5.setEnabled(false);
        jMenuItem6.setEnabled(false);
        jMenuItem7.setEnabled(false);
        jMenuItem8.setEnabled(false);
        jMenuItem9.setEnabled(false);
        jMenuItem10.setEnabled(false);
        jMenuItem12.setEnabled(false);
    }
    private void first() {
        jProgressBar1.setVisible(false);
        jLabel3.setVisible(true);
        jLabel2.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        jTextField1.setVisible(true);
        jPasswordField1.setVisible(true);
        jButton1.setVisible(true);
        
    }
    private void managerLogin() {
        jMenuItem1.setEnabled(true);
        jMenuItem3.setEnabled(true);
        jLabel2.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jTextField1.setVisible(false);
        jPasswordField1.setVisible(false);
        jButton1.setVisible(false);
        jMenuItem2.setEnabled(true);
        jMenuItem4.setEnabled(true);
        jMenuItem5.setEnabled(true);
        jMenuItem6.setEnabled(true);
        jMenuItem7.setEnabled(true);
        jMenuItem8.setEnabled(true);
        jMenuItem9.setEnabled(true);
        jMenuItem10.setEnabled(true);
        jMenuItem12.setEnabled(true);
        jLabel3.setText("Manager");
    }
    private void pegawaiLogin() {
        jMenuItem1.setEnabled(true);
        jLabel2.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jTextField1.setVisible(false);
        jPasswordField1.setVisible(false);
        jButton1.setVisible(false);
        jMenuItem2.setEnabled(true);
        jMenuItem4.setEnabled(true);
        jMenuItem5.setEnabled(true);
        jMenuItem6.setEnabled(true);
        jMenuItem7.setEnabled(true);
        jMenuItem8.setEnabled(true);
        jLabel3.setText("Pegawai");
    }
    private void kasirLogin() {
        jMenuItem1.setEnabled(true);
        jLabel2.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jTextField1.setVisible(false);
        jPasswordField1.setVisible(false);
        jButton1.setVisible(false);
        jMenuItem9.setEnabled(true);
        jMenuItem10.setEnabled(true);
        jLabel3.setText("Kasir");
    }
    private void start() {
        jProgressBar1.setValue(0);
        jProgressBar1.setForeground(Color.ORANGE);
      
        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time++;
                jProgressBar1.setValue(time);
                if(jProgressBar1.getPercentComplete() == 1.0) {
                    timer.stop();
                    jProgressBar1.setValue(0);
                    first();
                }
            }
        });
        timer.start();
    }
}
