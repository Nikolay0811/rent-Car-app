import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyFrame extends JFrame {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet result = null;
    int registerId = -1;
    int carId = -1;
    int rentId = -1;

    Border borderRed = BorderFactory.createLineBorder(Color.RED,5);
    Border borderOrange = BorderFactory.createLineBorder(Color.ORANGE,5);
    JPanel registerPanel = new JPanel();
    JPanel registerTopPanel = new JPanel();
    JPanel registerMidPanel = new JPanel();
    JPanel registerDownPanel = new JPanel();
    JPanel homePagePanel = new JPanel();
    JPanel referencePanel = new JPanel();



    JButton addButton = new JButton("Добави");
    JButton deleteButton = new JButton("Изтрий");
    JButton updateButton = new JButton("Обнови");
    JButton searchButton = new JButton("Търси");

    JLabel helloText = new JLabel();
    JLabel emailL = new JLabel("Имейл:");
    JLabel firstNameL = new JLabel("Име:");
    JLabel lastNameL = new JLabel("Фамилия:");
    JLabel phoneL = new JLabel("Тел:");

    JTextField emailTF = new JTextField();
    JTextField firstNameTF = new JTextField();
    JTextField lastNameTF = new JTextField();
    JTextField phoneTF = new JTextField();

    JTable registerTable = new JTable();
    JScrollPane registerTableSB = new JScrollPane(registerTable);
    JTabbedPane nav = new JTabbedPane();
    //<second panel-------------------------------------------->
    JPanel carPanel = new JPanel();
    JPanel carTopPanel = new JPanel();
    JPanel carMidPanel = new JPanel();
    JPanel carDownPanel = new JPanel();

    JLabel brandL = new JLabel("Марка:");
    JLabel modelL = new JLabel("Модел:");
    JLabel horsePowerL = new JLabel("Конски сили");
    JLabel engineCapacityL = new JLabel("Обем на двигателя:");
    JLabel productionDateL = new JLabel("Година на производство:");
    JLabel category = new JLabel("Категория: ");

    JTextField brandTF = new JTextField();
    JTextField modelTF = new JTextField();
    JTextField horsePowerTF = new JTextField();
    JTextField engineCapacityTF = new JTextField();
    JTextField productionDateTF = new JTextField();
    JTextField categoryTF = new JTextField();

    JButton addCarButton = new JButton("Добави");
    JButton deleteCarButton = new JButton("Изтрий");
    JButton updateCarButton = new JButton("Обнови");
    JButton searchCarButton = new JButton("Търси");

    JTable carsTable = new JTable();
    JScrollPane carTableSB = new JScrollPane(carsTable);

    //third panel---------------------------------------------------
    JPanel rentPanel = new JPanel();
    JPanel rentTopPanel = new JPanel();
    JPanel rentDownPanel = new JPanel();

    JComboBox<String> personCombo = new JComboBox<String>();
    JComboBox<String> carCombo = new JComboBox<String>();
    JLabel tenantL = new JLabel("Наемател:");
    JLabel carChoiceL = new JLabel("Кола:");
    JLabel rentDateL = new JLabel("Дата на наемане:");
    JLabel returnDateL = new JLabel("Дата на връщане:");


    JTextField rentDateTF = new JTextField();
    JTextField returnDateTF = new JTextField();

    JButton rentAddButton = new JButton("Добави");
    JButton rentDeleteButton = new JButton("Изтрий");
    JButton rentUpdateButton = new JButton("Промени");
    JButton rentSearchButton = new JButton("Търсене");

    JTable rentTable = new JTable();
    JScrollPane rentTableSB = new JScrollPane(rentTable);

    //<===============================================================================
    JPanel referenceTopPanel = new JPanel();
    JPanel referenceDownPanel = new JPanel();

    JButton referenceSearchButton = new JButton("Търсене(тел, марка)");
    JButton referenceSearchTwoButton = new JButton("Търсене(име, дата-наем)");

    JLabel referenceTelL = new JLabel("Телефон: ");
    JLabel referenceBrandL = new JLabel("Марка: ");
    JLabel referencePersonNameL = new JLabel("Име: ");
    JLabel referenceRentDateL = new JLabel("Дата на наемане: ");

    JTextField referenceTelTF = new JTextField();
    JTextField referenceBrandTF = new JTextField();
    JTextField referencePersonNameTF = new JTextField();
    JTextField referenceRentDateTF = new JTextField();

    JTable referenceTable = new JTable();
    JScrollPane referenceTableSB = new JScrollPane(referenceTable);


    public MyFrame() {
        this.setBounds(500, 200, 600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(nav);


        nav.add(homePagePanel, "Начало");
        nav.add(registerPanel, "Регистрация");
        nav.add(rentPanel, "Наем");
        nav.add(carPanel, "Коли");
        nav.add(referencePanel, "Справка");

        homePagePanel.setLayout(new BorderLayout());
        homePagePanel.setBackground(Color.ORANGE);
        homePagePanel.add(helloText);
        homePagePanel.setBorder(borderRed);

        helloText.setFont(new Font("MV Boli", Font.PLAIN, 40));
        helloText.setHorizontalAlignment(JLabel.CENTER);
        helloText.setVerticalAlignment(JLabel.CENTER);
        helloText.setText("Rent a car!");

        //first panel (registration) -----------------------------
        registerPanel.setLayout(new GridLayout(3, 1));
        registerPanel.add(registerTopPanel);
        registerPanel.add(registerMidPanel);
        registerPanel.add(registerDownPanel);
        registerPanel.setBorder(borderOrange);


        registerTopPanel.setLayout(new GridLayout(4, 2));
        registerTopPanel.setBackground(Color.ORANGE);
        registerTopPanel.add(emailL);
        registerTopPanel.add(emailTF);
        registerTopPanel.add(firstNameL);
        registerTopPanel.add(firstNameTF);
        registerTopPanel.add(lastNameL);
        registerTopPanel.add(lastNameTF);
        registerTopPanel.add(phoneL);
        registerTopPanel.add(phoneTF);
        //registration buttons ----------------------------------------------------
        registerMidPanel.setBackground(Color.ORANGE);
        registerMidPanel.add(addButton);
        registerMidPanel.add(deleteButton);
        registerMidPanel.add(updateButton);
        registerMidPanel.add(searchButton);
        //registerActionListeners-----------------------------------------------
        addButton.addActionListener(new RegisterAddAction());
        deleteButton.addActionListener(new RegisterDeleteAction());
        searchButton.addActionListener(new RegisterSearchAction());
        updateButton.addActionListener(new RegisterUpdateTable());
        registerTable.addMouseListener(new RegisterMouseActions());
        //registration buttons ----------------------------------------------------
        registerTableSB.setPreferredSize(new Dimension(450, 160));
        registerDownPanel.add(registerTableSB);
        registerDownPanel.setBackground(Color.ORANGE);

        //second panel (cars)----------------------------------

        carPanel.setLayout(new GridLayout(3, 1));
        carPanel.add(carTopPanel);
        carPanel.add(carMidPanel);
        carPanel.add(carDownPanel);
        carPanel.setBorder(borderOrange);

        carTopPanel.setLayout(new GridLayout(6, 2));
        carTopPanel.add(brandL);
        carTopPanel.setBackground(Color.ORANGE);
        carTopPanel.add(brandTF);
        carTopPanel.add(modelL);
        carTopPanel.add(modelTF);
        carTopPanel.add(horsePowerL);
        carTopPanel.add(horsePowerTF);
        carTopPanel.add(engineCapacityL);
        carTopPanel.add(engineCapacityTF);
        carTopPanel.add(productionDateL);
        carTopPanel.add(productionDateTF);
        carTopPanel.add(category);
        carTopPanel.add(categoryTF);

        carMidPanel.setBackground(Color.ORANGE);
        carMidPanel.add(addCarButton);
        carMidPanel.add(deleteCarButton);
        carMidPanel.add(updateCarButton);
        carMidPanel.add(searchCarButton);

        //carActionListeners---------------------------------------------------------------

        addCarButton.addActionListener(new CarAddAction());
        deleteCarButton.addActionListener(new CarDeleteAction());
        updateCarButton.addActionListener(new CarUpdateTable());
        searchCarButton.addActionListener(new CarSearchAction());
        carsTable.addMouseListener(new CarMouseActions());
        //carActionListeners---------------------------------------------------------------


        carTableSB.setPreferredSize(new Dimension(350, 150));
        carDownPanel.setBackground(Color.ORANGE);
        carDownPanel.add(carTableSB);

        //third panel(rent)------------------------------------------------

        rentPanel.setLayout(new GridLayout(2, 1));
        rentPanel.add(rentTopPanel);
        rentPanel.add(rentDownPanel);
        rentPanel.setBorder(borderOrange);


        rentTopPanel.setLayout(new GridLayout(6, 2));
        rentTopPanel.setBackground(Color.ORANGE);
        rentTopPanel.add(tenantL);
        rentTopPanel.add(personCombo, BorderLayout.CENTER);
        rentTopPanel.add(carChoiceL);
        rentTopPanel.add(carCombo, BorderLayout.CENTER);
        rentTopPanel.add(rentDateL);
        rentTopPanel.add(rentDateTF);
        rentTopPanel.add(returnDateL);
        rentTopPanel.add(returnDateTF);
        rentTopPanel.add(rentAddButton);
        rentTopPanel.add(rentDeleteButton);
        rentTopPanel.add(rentUpdateButton);
        rentTopPanel.add(rentSearchButton);
        rentTable.addMouseListener(new RentMouseActions());

        rentAddButton.addActionListener(new RentAddAction());
        rentDeleteButton.addActionListener(new RentDeleteAction());
        rentSearchButton.addActionListener(new RentSearchAction());
        rentUpdateButton.addActionListener(new RentUpdateTable());

        rentTableSB.setPreferredSize(new Dimension(450, 250));
        rentDownPanel.add(rentTableSB);
        rentDownPanel.setBackground(Color.ORANGE);

        //ReferencePanel--------------------------------------------------------
        referencePanel.setLayout(new GridLayout(2,1));
        referenceTopPanel.setLayout(new GridLayout(5, 2));
        referenceTopPanel.setBackground(Color.ORANGE);
        referenceTopPanel.add(referenceTelL);
        referenceTopPanel.add(referenceTelTF);
        referenceTopPanel.add(referenceBrandL);
        referenceTopPanel.add(referenceBrandTF);
        referenceTopPanel.add(referencePersonNameL);
        referenceTopPanel.add(referencePersonNameTF);
        referenceTopPanel.add(referenceRentDateL);
        referenceTopPanel.add(referenceRentDateTF);
        referenceTopPanel.add(referenceSearchButton);
        referenceTopPanel.add(referenceSearchTwoButton);
        referencePanel.add(referenceTopPanel);
        referencePanel.add(referenceDownPanel);

        referenceSearchButton.addActionListener(new ReferenceSearchAction());
        referenceSearchTwoButton.addActionListener(new ReferenceSecondSearchAction());


        referenceTableSB.setPreferredSize(new Dimension(450, 250));
        referenceDownPanel.add(referenceTableSB);
        referenceDownPanel.setBackground(Color.ORANGE);



        carPaintTable();
        carClearTable();
        registerPaintTable();
        registerClearTable();
        rentPaintTable();
        rentClearTable();
        rentPersonCombo();
        rentCarCombo();
        this.setVisible(true);
    }
    //registerActionListeners--------------------------------------<start>
    class RegisterMouseActions implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = registerTable.getSelectedRow();
            registerId = Integer.parseInt(registerTable.getValueAt(row, 0).toString());
            firstNameTF.setText(registerTable.getValueAt(row, 1).toString());
            lastNameTF.setText(registerTable.getValueAt(row, 2).toString());
            emailTF.setText(registerTable.getValueAt(row, 3).toString());
            phoneTF.setText(registerTable.getValueAt(row, 4).toString());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


    class RegisterDeleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "delete from person where person_id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, registerId);
                state.execute();
                registerPaintTable();
                registerClearTable();
                registerId = -1;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);

            }

        }
    }
    class RegisterAddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "insert into person(EMAIL, FIRST_NAME, LAST_NAME, PHONE) values(?,?,?,?)";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, emailTF.getText());
                state.setString(2, firstNameTF.getText());
                state.setString(3, lastNameTF.getText());
                state.setInt(4, Integer.parseInt(phoneTF.getText()));
                state.execute();
                registerPaintTable();
                registerClearTable();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    class RegisterUpdateTable implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            conn= DBConnection.getConnection();
            String  sql = "update person set EMAIL=?, FIRST_NAME=?, LAST_NAME=?, PHONE=? where person_id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, emailTF.getText());
                state.setString(2, firstNameTF.getText());
                state.setString(3, lastNameTF.getText());
                state.setInt(4, Integer.parseInt(phoneTF.getText()));
                state.setInt(5,registerId);
                state.execute();
                registerPaintTable();
                registerClearTable();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class RegisterSearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "select * from person where first_name=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, firstNameTF.getText());
                result = state.executeQuery();
                registerTable.setModel(new MyModel(result));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public void registerPaintTable() {
        conn = DBConnection.getConnection();

        try {
            state = conn.prepareStatement("select * from person");
            result = state.executeQuery();
            registerTable.setModel(new MyModel(result));

        } catch (SQLException e) {

            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void registerClearTable() {
        firstNameTF.setText("");
        lastNameTF.setText("");
        emailTF.setText("");
        phoneTF.setText("");
    }
    //registerActionListeners--------------------------------------<end>


    //carActionListeners------------------------------------------<start>
    class CarMouseActions implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = carsTable.getSelectedRow();
            carId = Integer.parseInt(carsTable.getValueAt(row,0).toString());
            brandTF.setText(carsTable.getValueAt(row, 1).toString());
            modelTF.setText(carsTable.getValueAt(row, 2).toString());
            horsePowerTF.setText(carsTable.getValueAt(row, 3).toString());
            engineCapacityTF.setText(carsTable.getValueAt(row, 4).toString());
            productionDateTF.setText(carsTable.getValueAt(row, 5).toString());
            categoryTF.setText(carsTable.getValueAt(row, 6).toString());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    class CarAddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "insert into car(brand, model, horse_power,engine_capacity,production_date, category) values(?,?,?,?,?,?)";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, brandTF.getText());
                state.setString(2, modelTF.getText());
                state.setInt(3, Integer.parseInt(horsePowerTF.getText()));
                state.setInt(4, Integer.parseInt(engineCapacityTF.getText()));
                state.setInt(5, Integer.parseInt(productionDateTF.getText()));
                state.setString(6, categoryTF.getText());
                state.execute();
                carPaintTable();
                carClearTable();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    class CarDeleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "delete from car where car_id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, carId);
                state.execute();
                carPaintTable();
                carClearTable();
                carId = -1;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);

            }

        }
    }

    class CarUpdateTable implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            conn= DBConnection.getConnection();
            String  sql = "update car set brand=?, model=?, horse_power=?, engine_capacity=?, production_date=?,category=? where car_id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, brandTF.getText());
                state.setString(2, modelTF.getText());
                state.setInt(3, Integer.parseInt(horsePowerTF.getText()));
                state.setInt(4, Integer.parseInt(engineCapacityTF.getText()));
                state.setInt(5, Integer.parseInt(productionDateTF.getText()));
                state.setString(6, categoryTF.getText());
                state.setInt(7,carId);
                state.execute();
                carPaintTable();
                carClearTable();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class CarSearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "select * from car where horse_power=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, horsePowerTF.getText());
                result = state.executeQuery();
                carsTable.setModel(new MyModel(result));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void carPaintTable() {
        conn = DBConnection.getConnection();

        try {
            state = conn.prepareStatement("select * from car");
            result = state.executeQuery();
            carsTable.setModel(new MyModel(result));

        } catch (SQLException e) {

            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public void carClearTable() {
        brandTF.setText("");
        modelTF.setText("");
        horsePowerTF.setText("");
        engineCapacityTF.setText("");
        productionDateTF.setText("");
        categoryTF.setText("");
    }
    //<===========================================================================
    public void rentPersonCombo() {
        personCombo.removeAllItems();
        conn = DBConnection.getConnection();
        String sql = "select person_id,first_name,last_name from person";
        String item = "";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            while (result.next()) {
                item = result.getObject(1).toString() + ": " + result.getObject(2) + " " + result.getObject(3);
                personCombo.addItem(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void rentCarCombo() {
        carCombo.removeAllItems();
        conn = DBConnection.getConnection();
        String sql = "select car_id,brand,model from car";
        String item = "";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            while (result.next()) {
                item = result.getObject(1).toString() + ": " + result.getObject(2) + " " + result.getObject(3);
                carCombo.addItem(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    class RentAddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "insert into rent(return_date, rent_date, person_id ,car_id) values(?,?,?,?)";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, returnDateTF.getText());
                state.setString(2, rentDateTF.getText());
                String personSelection = personCombo.getSelectedItem().toString();
                String personId = personSelection.split(":")[0].trim();
                state.setInt(3, Integer.parseInt(personId));

                String carSelection = carCombo.getSelectedItem().toString();
                String carId = carSelection.split(":")[0].trim();
                state.setInt(4, Integer.parseInt(carId));
                state.execute();
                rentPaintTable();
                rentClearTable();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    class RentMouseActions implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = rentTable.getSelectedRow();
            rentId = Integer.parseInt(rentTable.getValueAt(row, 0).toString());
            returnDateTF.setText(rentTable.getValueAt(row, 1).toString());
            rentDateTF.setText(rentTable.getValueAt(row, 2).toString());

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public void rentPaintTable() {
        conn = DBConnection.getConnection();

        try {
            state = conn.prepareStatement("select first_name, brand, return_date,rent_date from rent R join person P on R.person_id = P.person_id join car C on R.car_ID = C.car_id;");
            result = state.executeQuery();
            rentTable.setModel(new MyModel(result));

        } catch (SQLException e) {

            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void rentClearTable() {
        returnDateTF.setText("");
        rentDateTF.setText("");
    }

    class RentDeleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "delete from rent where rent_id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, rentId);
                state.execute();
                rentPaintTable();
                rentClearTable();
                rentId = -1;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);

            }
        }
    }
    class RentSearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String sql = "select first_name, brand, return_date,rent_date from rent R join person P on R.person_id = P.person_id join car C on R.car_ID = C.car_id where rent_date=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, rentDateTF.getText());
                result = state.executeQuery();
                rentTable.setModel(new MyModel(result));
                rentPaintTable();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class RentUpdateTable implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            conn= DBConnection.getConnection();
            String  sql = "update rent set return_date=?, rent_date=?, person_id=?, car_id=? where rent_id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, returnDateTF.getText());
                state.setString(2, rentDateTF.getText());
                String personSelection = personCombo.getSelectedItem().toString();
                String personId = personSelection.split(":")[0].trim();
                state.setInt(3, Integer.parseInt(personId));

                String carSelection = carCombo.getSelectedItem().toString();
                String carId = carSelection.split(":")[0].trim();
                state.setInt(4, Integer.parseInt(carId));
                state.setInt(5,rentId);
                state.execute();
                rentPaintTable();
                rentClearTable();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class ReferenceSearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String phone = referenceTelTF.getText();
            String brand = referenceBrandTF.getText();

            String sql = "SELECT  P.PHONE,  C.BRAND FROM PERSON P JOIN RENT R ON P.PERSON_ID = R.PERSON_ID JOIN CAR C ON R.CAR_ID = C.CAR_ID WHERE PHONE = ? AND BRAND = ?;";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, phone);
                state.setString(2, brand);
                result = state.executeQuery();
                referenceTable.setModel(new MyModel(result));

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    class ReferenceSecondSearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();
            String name = referencePersonNameTF.getText();
            String rentDate = referenceRentDateTF.getText();

            String sql = "SELECT P.FIRST_NAME, R.RENT_DATE FROM  PERSON P JOIN RENT R ON P.PERSON_ID = R.PERSON_ID JOIN CAR C ON R.CAR_ID = C.CAR_ID where FIRST_NAME = ? and RENT_DATE = ?;";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, name);
                state.setString(2, rentDate);
                result = state.executeQuery();
                referenceTable.setModel(new MyModel(result));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
