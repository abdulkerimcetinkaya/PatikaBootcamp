package Week6;

import java.sql.*;

public class DBConnect {
    public static final String DB_URL = "jdbc:mysql://localhost/company";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {

        // Veri ekleme
        String addDataSqlPrepared = "INSERT INTO employees (employees_name, employees_position, employees_salary) VALUES (?,?,?)";
        // Veri güncelleme
        String updatePrepared = "UPDATE employees SET employees_position = ? WHERE employees_id = ?";
        String getData = "SELECT * FROM employees";
        try {
            // Veritabanı ileağlantı kuruldu
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD);
            //PreparedStatement nesnesi tanımladık ve içerisine sorgumuzu verdik
            PreparedStatement preparedStatement = connection.prepareStatement(updatePrepared);
            // 1. indexte ki değere "Barış" değerini ata
            preparedStatement.setString(1,"CEO");
            // 2. indexte ki değere "Müdür" değerini ata
            preparedStatement.setInt(2,4);
            // 3. indexte ki değere "30000" değerini ata
            // preparedStatement.setInt(3,30000);
            // Verileri tabloya ekle
            preparedStatement.executeUpdate();


            ResultSet resultSet = preparedStatement.executeQuery(getData);
            while (resultSet.next()){
                int id = resultSet.getInt("employees_id");
                String name = resultSet.getString("employees_name");
                String position = resultSet.getString("employees_position");
                int salary = resultSet.getInt("employees_salary");

                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("Position : " + position);
                System.out.println("Salary : " + salary);
                System.out.println("-------------------------------------");
            }


            // preparedStatement nesnesini kapat
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
