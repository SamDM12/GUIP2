/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBProcedures;
import Connection.DataBaseConnection;
import com.mycompany.project1db.*;
import java.awt.List;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author chedr
 */
public class GetSetData {
    CallableStatement stmt = null;
    private DataBaseConnection connection = new DataBaseConnection();
    public GetSetData(){
    }
    public ArrayList<GenderType> getGenderTypes(){
        ArrayList<GenderType> List = new ArrayList<>();
        DataBaseConnection connection = new DataBaseConnection();
        try (ResultSet result = connection.getConn().prepareCall("{CALL getGener()}").executeQuery()) {
            while(result.next()){
                GenderType gender = new GenderType(result.getString("GENDERTYPE"));
                List.add(gender);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection.desconectar();
        return List;
    }
    public void insertDisability(String disabilityName){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL AddDisability(?)}");
            stmt.setString(1, disabilityName);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Country> getCountries(){
        ArrayList<Country> List = new ArrayList<>();
        DataBaseConnection connectionC = new DataBaseConnection();
        try (ResultSet result = connectionC.getConn().prepareCall("{CALL getCountry()}").executeQuery()) {
            while(result.next()){
                Country country = new Country(result.getString("COUNTRY_NAME"));
                List.add(country);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection.desconectar();
        return List;
    }
    
    public ArrayList<IdentificationType> getIdentificationType(){
        ArrayList<IdentificationType> List = new ArrayList<>();
        DataBaseConnection connection = new DataBaseConnection();
        try (ResultSet result = connection.getConn().prepareCall("{CALL getIdentificationType()}").executeQuery()) {
            while(result.next()){
                IdentificationType idType = new IdentificationType(result.getString("IdentificationType"));
                List.add(idType);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection.desconectar();
        return List;
    }
    
    public void insertPerson(int IdentificationNumber, String FirstName, 
            String SecondName, String FirstLastName, String SecondLastName, 
            LocalDate BirthDate, String CountryName, String GenderName, String IdentificationName){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL AddPerson(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            stmt.setInt(1, IdentificationNumber);
            stmt.setString(2, FirstName);
            stmt.setString(3, SecondName);
            stmt.setString(4, FirstLastName);
            stmt.setString(5, SecondLastName);
            Date sqlDate = Date.valueOf(BirthDate);
            stmt.setDate(6, sqlDate);
            stmt.setString(7, CountryName);
            stmt.setString(8, GenderName);
            stmt.setString(9, IdentificationName);
            stmt.execute();
            System.out.println("Persona añadida");
            JOptionPane.showMessageDialog(null, "La persona se ha añadido exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        // Cerrar el statement y la conexión después de la ejecución
        try {
            if (stmt != null) stmt.close();
            if (connection.getConn() != null) connection.getConn().close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión:\n" + e.getMessage(), 
                                          "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
        }
        
    }
    
    public ArrayList<Team> getTeams(){
        ArrayList<Team> List = new ArrayList<>();
        try (ResultSet result = connection.getConn().prepareCall("{CALL getTeams()}").executeQuery()) {
            while(result.next()){
                Team team = new Team(result.getString("TEAMNAME"), result.getInt("QUANTITYMEMBERS"));
                List.add(team);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection.desconectar();
        return List;
    }
    
    
    public void insertCompetitor(int IdentificationNumber, int ClasificationScore, String TeamName){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL AddCompetitor(?, ?, ?)}");
            stmt.setInt(1, IdentificationNumber);
            stmt.setInt(2, ClasificationScore);
            stmt.setString(3, TeamName);
            stmt.execute();
            System.out.println("Competidor añadido");
            JOptionPane.showMessageDialog(null, "El competidor se ha añadido exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection.getConn() != null && !connection.getConn().isClosed()) {
                    connection.getConn().close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión:\n" + e.getMessage(), 
                                              "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    public void insertCompetition(String CompetitionName, LocalDate CompetitionDate, String CompetitionDescription){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL AddCompetition(?, ?, ?)}");
            stmt.setString(1, CompetitionName);
            Date sqlDate = Date.valueOf(CompetitionDate);
            stmt.setDate(2, sqlDate);
            stmt.setString(3, CompetitionDescription);
            stmt.execute();
            System.out.println("Competición añadida");
            JOptionPane.showMessageDialog(null, "La competición se ha añadido exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        // Cerrar el statement y la conexión después de la ejecución
        try {
            if (stmt != null) stmt.close();
            if (connection.getConn() != null) connection.getConn().close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión:\n" + e.getMessage(), 
                                          "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    
    public void insertCompetitorXCompetition(int IDCompetitor,int IDCompetition, int TimeRecorded, int Score, int positionRecorded){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL AddCompetitorXCompetition(?, ?, ?, ?, ?)}");
            stmt.setInt(1, IDCompetitor);
            stmt.setInt(2, IDCompetition);
            stmt.setInt(3, TimeRecorded);
            stmt.setInt(4, Score);
            stmt.setInt(5, positionRecorded);
            stmt.execute();
            System.out.println("Competidor y competencia vinculados");
            JOptionPane.showMessageDialog(null, "La competición y el competidor se ha añadido exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        // Cerrar el statement y la conexión después de la ejecución
        try {
            if (stmt != null) stmt.close();
            if (connection.getConn() != null) connection.getConn().close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión:\n" + e.getMessage(), 
                                          "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    
    public void insertCountry(String countryName){
        try{
            stmt = connection.getConn().prepareCall("{CALL addCountry(?)}");
            stmt.setString(1, countryName);
            stmt.execute();
        }catch(SQLException ex){
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertIdentificationType(String identificationType){
        try{
            stmt = connection.getConn().prepareCall("{CALL addIdentificationType(?)}");
            stmt.setString(1, identificationType);
            stmt.execute();
        }catch(SQLException ex){
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertMedalType(String medalType){
        try{
            stmt = connection.getConn().prepareCall("{CALL addMedalType(?)}");
            stmt.setString(1, medalType);
            stmt.execute();
        }catch(SQLException ex){
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void insertNationality(String nationality){
        try{
            stmt = connection.getConn().prepareCall("{CALL addNationality(?)}");
            stmt.setString(1, nationality);
            stmt.execute();
        }catch(SQLException ex){
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertPhoneType(String PhoneType){
        try{
            stmt = connection.getConn().prepareCall("{CALL addPhoneType(?)}");
            stmt.setString(1, PhoneType);
            stmt.execute();
        }catch(SQLException ex){
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertTeam(String teamName){
        try{
            stmt = connection.getConn().prepareCall("{CALL addTeam(?)}");
            stmt.setString(1, teamName);
            stmt.execute();
        }catch(SQLException ex){
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void insertGenderType(String genderType){
        try{
            stmt = connection.getConn().prepareCall("{CALL addGender(?)}");
            stmt.setString(1, genderType);
            stmt.execute();
        }catch(SQLException ex){
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public ResultSet getPeople(ResultSet rs, String FirstName, String SecondName, String FirstLastName, String SecondLastName, Integer ID_Team){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getPeople(?, ?, ?, ?, ?)}");
            if (FirstName.isEmpty()){
                stmt.setNull(1, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(1, FirstName); 
            }
            if (SecondName.isEmpty()){
                stmt.setNull(2, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(2, SecondName); 
            }
            if (FirstLastName.isEmpty()){
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(3, FirstLastName); 
            }
            if (SecondLastName.isEmpty()){
                stmt.setNull(4, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(4, SecondLastName); 
            }
            if (ID_Team == null){
                stmt.setNull(5, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(5, ID_Team);  
            }
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
}