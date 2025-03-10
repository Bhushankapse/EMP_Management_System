package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel tempID;
    JDateChooser tdob;
    JComboBox BoxEducation;
    JButton add,back;
    AddEmployee(){

        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        // for employee name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        //for father name

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        //for DOB
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        //for salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(salary);

        tsalary  = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        //for address
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(address);

        taddress  = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        //for phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(phone);

        tphone  = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        //for email
        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(email);

        temail  = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        //for HE
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(education);

        String items[] = {"BCA","MCA","B.Tech","M.Tech","BBA","MBA","B.COM","BA","MA","BSC","MSC","PHD"};
        BoxEducation = new JComboBox(items);
        BoxEducation.setBackground(new Color(177,252,197));
        BoxEducation.setBounds(600,300,150,30);
        add(BoxEducation);

        //for aadhar
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(aadhar);

        taadhar  = new JTextField();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        //for random EMPID
        JLabel empID = new JLabel("Employee ID");
        empID.setBounds(50,400,150,30);
        empID.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(empID);

        tempID  = new JLabel(""+number);
        tempID.setBounds(200,400,150,30);
        tempID.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        tempID.setForeground(Color.red);
        add(tempID);

        //for designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(designation);

        tdesignation  = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        //For ADD Button
        add = new JButton("ADD");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        // for Back Button
        back = new JButton("Back");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==add){
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) BoxEducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empID = tempID.getText();

            try{
               Conn c = new Conn();
               String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empID+"')";
               c.statement.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Details added successfully");
               setVisible(false);
               new Main_Class();
            }catch(Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);
            new Main_Class();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();

    }
}
