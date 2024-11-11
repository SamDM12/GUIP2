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
import java.sql.Types;
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
        DataBaseConnection connectionC = new DataBaseConnection();
        ArrayList<Team> List = new ArrayList<>();
        try (ResultSet result = connectionC.getConn().prepareCall("{CALL getTeams()}").executeQuery()) {
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
    
    public void insertCoach(int IdentificationNumber, String TeamName){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL AddCoach(?, ?)}");
            stmt.setInt(1, IdentificationNumber);
            stmt.setString(2, TeamName);
            stmt.execute();
            System.out.println("Coach añadido");
            JOptionPane.showMessageDialog(null, "El coach se ha añadido exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    
    public void insertMedalXCompetitorXCompetitionXParalympic(int IDMedal, int IDCompetitor, int IDCompetition, int IDParalympic){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL InsertMedalTypeXCompetitorXCompetitionXParalympic(?, ?, ?, ?)}");
            stmt.setInt(1, IDMedal);
            stmt.setInt(2, IDCompetitor);
            stmt.setInt(3, IDCompetition);
            stmt.setInt(4, IDParalympic);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Proceso terminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void insertDisabilityXCompetidor(int IDDisability,int IDCompetitor){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL InsertCompetitorXDisability(?, ?)}");
            stmt.setInt(1, IDDisability);
            stmt.setInt(2, IDCompetitor);
            stmt.execute();
            System.out.println("Discapacidad y competidor vinculados");
            JOptionPane.showMessageDialog(null, "La discapacidad y el competidor se ha añadido exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public ResultSet getPeople(ResultSet rs, String FirstName, String SecondName, String FirstLastName, String SecondLastName, Integer ID_Team, Integer ID_Paralympic){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getPeople(?, ?, ?, ?, ?, ?)}");
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
            
            if (ID_Paralympic == null){
                stmt.setNull(6, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(6, ID_Paralympic);  
            }
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet getCountries(ResultSet rs, String CountryName, Integer ID_Paralympic){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getCountries(?, ?)}");
            if (CountryName.isEmpty()){
                stmt.setNull(1, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(1, CountryName); 
            }
            
            if (ID_Paralympic == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, ID_Paralympic);  
            }
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet getCompetitors(ResultSet rs, Integer IDCountry, Integer ID_Paralympic, String FirstName, String SecondName, String FirstLastName, String SecondLastName){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getCompetitors(?, ?, ?, ?, ?, ?)}");
            if (IDCountry == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDCountry); 
            }
            
            if (ID_Paralympic == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, ID_Paralympic);  
            }
           
            if (FirstName.isEmpty()){
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(3, FirstName);  
            }
            
            if (SecondName.isEmpty()){
                stmt.setNull(4, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(4, SecondName);  
            }
            
            if (FirstLastName.isEmpty()){
                stmt.setNull(5, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(5, FirstLastName);  
            }
            
            if (SecondLastName.isEmpty()){
                stmt.setNull(6, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(6, SecondLastName);  
            }
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet getCompetitions(ResultSet rs, String CompetitionName, Integer ID_Paralympic){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getCompetitions(?, ?)}");
            if (CompetitionName.isEmpty()){
                stmt.setNull(1, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(1, CompetitionName); 
            }
            
            if (ID_Paralympic == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, ID_Paralympic);  
            }
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet getParalympics(ResultSet rs, Integer ParalympicsYear, Integer ID_Country){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getParalympics(?, ?)}");
            if (ParalympicsYear == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, ParalympicsYear); 
            }
            
            if (ID_Country == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, ID_Country);  
            }
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    
    public ResultSet getDisabilities(ResultSet rs){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getDiscapacities()}");
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public void insertParalympic(int ParalympicYear, String HostCountry){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL AddParalympic(?, ?)}");
            stmt.setInt(1, ParalympicYear);
            stmt.setString(2, HostCountry);
            stmt.execute();
            System.out.println("Paraolímpico añadido");
            JOptionPane.showMessageDialog(null, "El paraolímpico se ha añadido exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    
    public void insertParalympicXCompetition(int IDParalympic,int IDCompetition){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL AddParalympicXCompetition(?, ?)}");
            stmt.setInt(1, IDParalympic);
            stmt.setInt(2, IDCompetition);
            stmt.execute();
            System.out.println("Paraolímpico y competencia vinculados");
            JOptionPane.showMessageDialog(null, "El paraolímpico y la competencia se ha añadido exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void insertCountryXParalympic(int IDParalympic,int IDCountry){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL addCountryXParalympic(?, ?)}");
            stmt.setInt(1, IDParalympic);
            stmt.setInt(2, IDCountry);
            stmt.execute();
            System.out.println("Paraolímpico y país vinculados");
            JOptionPane.showMessageDialog(null, "El paraolímpico y el país se han añadido exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    public ArrayList<Person> getPersonData(){
        ArrayList<Person> personList = new ArrayList<>();
        try(ResultSet result = connection.getConn().prepareCall("{CALL getIdentificationNumber()}").executeQuery()){
            while(result.next()){
                Person person = new Person(result.getInt("IDENTIFICATIONNUMBER"), result.getString("FIRSTNAME"), result.getString("FIRSTLASTNAME"));
                personList.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personList;
    }
    public boolean existUserName(String userName){
        boolean exist = true;
        ResultSet result;
        try {
            stmt = connection.getConn().prepareCall("{CALL findUser(?)}");
            stmt.setString(1, userName);
            result = stmt.executeQuery();
            exist = result.next();
    }   catch (SQLException ex) {
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;
    }
    public void addAdmin(int identificationNumber, String userName, String password){
        try{
            stmt = connection.getConn().prepareCall("{CALL addAdmin(?,?,?)}");
            stmt.setInt(1, identificationNumber);
            stmt.setString(2, userName);
            stmt.setString(3, password);
            stmt.execute();
        }catch(SQLException ex){
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public boolean login(String userName, String password){
        boolean init = false;
        try{
            stmt = connection.getConn().prepareCall("{CALL getUserPass(?)}");
            stmt.setString(1, userName);
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                if(PasswordUtils.checkPassword(password, result.getString("PASSWORD_ADMIN"))){
                    init = true;
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    return init;
    }
    public ArrayList<String> getPhoneType(){
    ArrayList<String> phoneType = new ArrayList<>();
    try{
        stmt = connection.getConn().prepareCall("{CALL getPhoneType()}");
        ResultSet result = stmt.executeQuery();
        while (result.next()){
            String phone = result.getString("PHONETYPE");
            phoneType.add(phone);
        }
    }catch(SQLException ex){
        Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
    }
    return phoneType;
    }
    public void addPhonexPerson(int identificationNumber, String phoneType, int phoneNumber){
        try{
            stmt = connection.getConn().prepareCall("{CALL addPhonexPerson(?,?,?)}");
            stmt.setInt(1, identificationNumber);
            stmt.setString(2, phoneType);
            stmt.setInt(3, phoneNumber);
            stmt.execute();
        }catch(SQLException ex){
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void addEmailxPerson(String email, int identificationNumber){
        try{
            stmt = connection.getConn().prepareCall("{CALL addEmailxPerson(?,?)}");
            stmt.setInt(1, identificationNumber);
            stmt.setString(2, email);
            stmt.execute();
        }catch(SQLException ex){
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Person> getAdministrator(int identificationNumber, String name, String lastName){
        boolean add = true;
        ArrayList<Person> admins = new ArrayList<>();
        try{
            stmt = connection.getConn().prepareCall("{CALL getAdministrators(?,?,?)}");
            if(identificationNumber == 0){
                stmt.setObject(1, null);
            }else{
                stmt.setInt(1, identificationNumber);
            }
            stmt.setString(2, name);
            stmt.setString(3, lastName);
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                Person person = new Person(result.getInt("p.IDENTIFICATIONNUMBER"), result.getString("p.FIRSTNAME"), result.getString("p.FIRSTLASTNAME"));
                person.setIdDB(result.getInt("p.ID_PERSON"));
                for (Person p : admins){
                   if(p.getId() == person.getId()){
                       add = false;
                   }
                }
                if (add) admins.add(person);
                add = true;
            }
        }catch(SQLException ex){
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admins;
    }
    
    public void deletePerson(int IDPerson){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeletePerson(?)}");
            stmt.setInt(1, IDPerson);
            stmt.execute();
            System.out.println("Persona eliminada");
            JOptionPane.showMessageDialog(null, "La persona se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void deleteCompetition(int IDCompetition){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeleteCompetition(?)}");
            stmt.setInt(1, IDCompetition);
            stmt.execute();
            System.out.println("Competición eliminada");
            JOptionPane.showMessageDialog(null, "La Competición se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void deleteParalympic(int IDParalympic){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeleteParalympic(?)}");
            stmt.setInt(1, IDParalympic);
            stmt.execute();
            System.out.println("Paraolímpico eliminada");
            JOptionPane.showMessageDialog(null, "El paraolímpico se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void deleteDisability(int IDDisability){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeleteDisability(?)}");
            stmt.setInt(1, IDDisability);
            stmt.execute();
            System.out.println("Discapacidad eliminada");
            JOptionPane.showMessageDialog(null, "La discapacidad se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void deleteCountry(int IDCountry){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeleteCountry(?)}");
            stmt.setInt(1, IDCountry);
            stmt.execute();
            System.out.println("País eliminado");
            JOptionPane.showMessageDialog(null, "El país se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void deleteCoach(int IDCoach){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeleteCoach(?)}");
            stmt.setInt(1, IDCoach);
            stmt.execute();
            System.out.println("País eliminado");
            JOptionPane.showMessageDialog(null, "El país se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void deleteMedalType(int IDMedalType){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeleteMedalType(?)}");
            stmt.setInt(1, IDMedalType);
            stmt.execute();
            System.out.println("Medalla eliminada");
            JOptionPane.showMessageDialog(null, "La medalla se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void deleteCompetitor(int IDCompetitor){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeleteCompetitor(?)}");
            stmt.setInt(1, IDCompetitor);
            stmt.execute();
            System.out.println("Competidor eliminado");
            JOptionPane.showMessageDialog(null, "El competidor se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void deleteAdmin(int IDAdministrator){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeleteAdministrator(?)}");
            stmt.setInt(1, IDAdministrator);
            stmt.execute();
            System.out.println("Admin eliminado");
            JOptionPane.showMessageDialog(null, "El admin se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void deleteGenderType(int IDGenderType){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeleteGenderType(?)}");
            stmt.setInt(1, IDGenderType);
            stmt.execute();
            System.out.println("Género eliminado");
            JOptionPane.showMessageDialog(null, "El género se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void deletePhoneType(int IDPhoneType){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeletePhoneType(?)}");
            stmt.setInt(1, IDPhoneType);
            stmt.execute();
            System.out.println("Tipo de teléfono eliminado");
            JOptionPane.showMessageDialog(null, "El tipo de teléfono se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void deleteIdentificationType(int IDIdentificationType){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeleteIdentificationType(?)}");
            stmt.setInt(1, IDIdentificationType);
            stmt.execute();
            System.out.println("Tipo de identificación eliminada");
            JOptionPane.showMessageDialog(null, "El tipo de identificación se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void deleteTeam(int IDTeam){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL DeleteTeam(?)}");
            stmt.setInt(1, IDTeam);
            stmt.execute();
            System.out.println("Equipo eliminado");
            JOptionPane.showMessageDialog(null, "El equipo se ha eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public ResultSet getAdmins(ResultSet rs, String adminName){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getAdmins(?)}");
            if (adminName.isEmpty()){
                stmt.setNull(1, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(1, adminName); 
            }
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet getCoaches(ResultSet rs, Integer IDCountry, Integer ID_Paralympic){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getCoaches(?, ?)}");
            if (IDCountry == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDCountry); 
            }
            
            if (ID_Paralympic == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, ID_Paralympic);  
            }
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet getGenders(ResultSet rs){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getGenders()}");
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet getIdentificationTypes(ResultSet rs){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getIdentificationTypes()}");
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet getMedals(ResultSet rs){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getMedals()}");
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet getPhoneTypes(ResultSet rs){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getPhoneTypes()}");
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet getTeams(ResultSet rs){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getTeamsALL()}");
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }

    public ArrayList<GenderType> gendersGraphic (int year){
        ArrayList <GenderType> geners = getGenderTypes();
        try{
            stmt = connection.getConn().prepareCall("{CALL GetCompetitorsByGender(?)}");
            stmt.setInt(1, year);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                String type = result.getString("g.GENDERTYPE");
                System.out.println(type);
                int quantity = result.getInt("cantidad_competidores");
                for(GenderType gen : geners){
                    if(type.equals(gen.getType())){
                        gen.setQuantity(quantity);
                        break;
                    }
                }
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
            return geners;

        } 
    
    public void insertWorldRecord(String RecordDescription, int IDCompetition, 
            int IDCountry, int IDParalympic, int IDPerson){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL InsertWorldRecord(?, ?, ?, ?, ?)}");
            stmt.setString(1, RecordDescription);
            stmt.setInt(2, IDCompetition);
            stmt.setInt(3, IDCountry);
            stmt.setInt(4, IDParalympic);
            stmt.setInt(5, IDPerson);
            stmt.execute();
            System.out.println("Record añadido");
            JOptionPane.showMessageDialog(null, "El record mundial se ha añadido exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public ResultSet getWorldRecords(ResultSet rs){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getWorldRecords()}");
            rs = stmt.executeQuery();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return rs;
    }
    
    public ResultSet getMedalsRanking(ResultSet rs, int ParalympicsYear){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL CountMedalsByCountry(?)}");
            stmt.setInt(1, ParalympicsYear); 
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;

    }
    public ArrayList<CompetitionType> getCompetitionGraphic(int year){
        ArrayList<CompetitionType> competitions = new ArrayList<>();
        try{
            stmt = connection.getConn().prepareCall("{CALL GetCompetitorsCountByCompetition(?)}");
            stmt.setInt(1, year);
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                CompetitionType c = new CompetitionType(result.getString("COMPETITIONNAME"), result.getInt("cantidad_competidores"));
                competitions.add(c);
                
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);

        }
        return competitions;
    }
    
    public void insertEvent(int IDCompetition, int IDParalympic, 
            int IDCompetitor, LocalDate EventDate){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL InsertEvent(?, ?, ?, ?)}");
            stmt.setInt(1, IDCompetition);
            stmt.setInt(2, IDParalympic);
            stmt.setInt(3, IDCompetitor);
            Date sqlDate = Date.valueOf(EventDate);
            stmt.setDate(4, sqlDate);
            stmt.execute();
            System.out.println("Evento añadido");
            JOptionPane.showMessageDialog(null, "El evento se ha añadido exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    
    public ResultSet getCompetitionAgenda(ResultSet rs, int IDCompetition, int ParalympicsYear){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL ShowEventAgenda(?, ?)}");
            stmt.setInt(1, IDCompetition); 
            stmt.setInt(2, ParalympicsYear);
            rs = stmt.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs;
    }
    
    public ResultSet getTop5Scores(ResultSet rs){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL GetTop5Scores()}");
            rs = stmt.executeQuery();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return rs;
    }
    public ArrayList<CompetitionType> getRangeAge(int since, int to, int year){
        ArrayList<CompetitionType> competitions = new ArrayList<>();
        try{
            stmt = connection.getConn().prepareCall("{CALL get_competitors_by_age_range(?,?,?,?,?)}");
            stmt.setInt(1, year);
            stmt.setInt(2, since);
            stmt.setInt(3, to);
            
            stmt.registerOutParameter(4, Types.INTEGER);
            stmt.registerOutParameter(5, Types.INTEGER);
            stmt.execute();
            
            int inRange = stmt.getInt(4);
            int outRange = stmt.getInt(5);
            CompetitionType g = new CompetitionType("En el rango", inRange);
            CompetitionType f = new CompetitionType("Fuera del rango", outRange);
            competitions.add(g);
            competitions.add(f);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);

        }
        return competitions;
    }
    public ArrayList<String> getPGyears(){
        ArrayList<String> years = new ArrayList<>();
        try{
            stmt = connection.getConn().prepareCall("{CALL getYears()}");
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                String y = result.getInt("PARALYMPICS_YEAR")+ "";
                years.add(y);
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento:\n" + ex.getMessage(), 
                                      "Error SQL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GetSetData.class.getName()).log(Level.SEVERE, null, ex);

        }
        return years;
    }
    
    public void updatePerson(Integer IDPerson, Integer IdentificationNumber, String FirstName, 
            String SecondName, String FirstLastName, String SecondLastName, 
            LocalDate BirthDate, Integer CountryName, Integer GenderName, Integer IdentificationName){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdatePerson(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            /*
            if (CompetitionNam.isEmpty){
                stmt.setNull(1, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(1, CompetitionName); 
            }
            
            if (ID_Paralympic == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, ID_Paralympic);  
            }
            */
            if (IDPerson == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDPerson);  
            }
            
            if (IdentificationNumber == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, IdentificationNumber);  
            }
            
            if (FirstName.isEmpty()){
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(3, FirstName); 
            }
            
            if (SecondName.isEmpty()){
                stmt.setNull(4, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(4, SecondName); 
            }
            
            if (FirstLastName.isEmpty()){
                stmt.setNull(5, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(5, FirstLastName); 
            }
            
            if (SecondLastName.isEmpty()){
                stmt.setNull(6, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(6, SecondLastName); 
            }
            
            if (BirthDate == null){
                stmt.setNull(7, java.sql.Types.DATE);
            }else{
                Date sqlDate = Date.valueOf(BirthDate);
                stmt.setDate(7, sqlDate);
            }
            
            if (CountryName == null){
                stmt.setNull(8, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(8, CountryName); 
            }
            
            if (GenderName == null){
                stmt.setNull(9, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(9, GenderName); 
            }
            
            if (IdentificationName == null){
                stmt.setNull(10, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(10, IdentificationName); 
            }
            stmt.execute();
            System.out.println("Persona actualizada");
            JOptionPane.showMessageDialog(null, "La persona se ha actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void updateEmail(Integer IDEmail, String EmailAdress, Integer IDPerson){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdateEmail(?, ?, ?)}");
      
            if (IDEmail == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDEmail);  
            }
            
            if (EmailAdress.isEmpty()){
                stmt.setNull(2, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(2, EmailAdress); 
            }
            
            if (IDPerson == null){
                stmt.setNull(3, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(3, IDPerson);  
            }
            
            stmt.execute();
            System.out.println("Email actualizado");
            JOptionPane.showMessageDialog(null, "El Email se ha actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void updatePhone(Integer IDPhone, Integer PhoneNumber, Integer IDPhoneType){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdatePhone(?, ?, ?)}");
      
            if (IDPhone == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDPhone);  
            }
            
            if (PhoneNumber == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, PhoneNumber);  
            }
            
            if (IDPhoneType == null){
                stmt.setNull(3, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(3, IDPhoneType);  
            }
            
            stmt.execute();
            System.out.println("Teléfono actualizado");
            JOptionPane.showMessageDialog(null, "El teléfono se ha actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void updatePersonXPhone(Integer IDPersonXPhone, Integer IDPerson, Integer IDPhone){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdatePersonXPhone(?, ?, ?)}");
      
            if (IDPersonXPhone == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDPersonXPhone);  
            }
            
            if (IDPerson == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, IDPerson);  
            }
            
            if (IDPhone == null){
                stmt.setNull(3, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(3, IDPhone);  
            }
            
            stmt.execute();
            System.out.println("Teléfono y persona actualizados");
            JOptionPane.showMessageDialog(null, "El teléfono de la persona se ha actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void updateCoach(Integer IDCoach, Integer IDPerson, Integer IDTeam){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdateCoach(?, ?, ?)}");
      
            if (IDCoach == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDCoach);  
            }
            
            if (IDPerson == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, IDPerson);  
            }
            
            if (IDTeam == null){
                stmt.setNull(3, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(3, IDTeam);  
            }
            
            stmt.execute();
            System.out.println("Entrenador actualizado");
            JOptionPane.showMessageDialog(null, "El entrenador se ha actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    
    public void updateCompetitor(Integer IDCompetitor, Integer ClasificationScore, Integer IDPerson, Integer IDTeam){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdateCompetitor(?, ?, ?, ?)}");
      
            if (IDCompetitor == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDCompetitor);  
            }
            
            if (ClasificationScore == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, ClasificationScore);  
            }
            
            if (IDPerson == null){
                stmt.setNull(3, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(3, IDPerson);  
            }
            
            if (IDTeam == null){
                stmt.setNull(4, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(4, IDTeam);  
            }
            
            stmt.execute();
            System.out.println("Competidor actualizado");
            JOptionPane.showMessageDialog(null, "El competidor se ha actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void updateTeam(Integer IDTeam, String TeamName, Integer QuantityMembers){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdateTeam(?, ?, ?)}");
      
            if (IDTeam == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDTeam);  
            }
            
            if (TeamName.isEmpty()){
                stmt.setNull(2, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(2, TeamName);  
            }
            
            if (QuantityMembers == null){
                stmt.setNull(3, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(3, QuantityMembers);  
            }
            
            stmt.execute();
            System.out.println("Equipo actualizado");
            JOptionPane.showMessageDialog(null, "El equipo se ha actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void updateCompetitorXDisability(Integer IDCompetitorXDisability, Integer IDCompetitor, Integer IDDisability){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdateCompetitorXDisability(?, ?, ?)}");
      
            if (IDCompetitorXDisability == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDCompetitorXDisability);  
            }
            
            if (IDCompetitor == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, IDCompetitor);  
            }
            
            if (IDDisability == null){
                stmt.setNull(3, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(3, IDDisability);  
            }
            
            stmt.execute();
            System.out.println("Competidor y Discapacidad actualizados");
            JOptionPane.showMessageDialog(null, "La discapacidad del competidor se ha actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void updateCompetitorXCompetition(Integer IDCompetitorXCompetition, Integer IDCompetitor, Integer IDCompetition, Integer TimeRecorded, Integer Score, Integer PositionRecorded){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdateCompetitorXCompetition(?, ?, ?, ?, ?, ?)}");
      
            if (IDCompetitorXCompetition == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDCompetitorXCompetition);  
            }
            
            if (IDCompetitor == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, IDCompetitor);  
            }
            
            if (IDCompetition == null){
                stmt.setNull(3, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(3, IDCompetition);  
            }
            
            if (TimeRecorded == null){
                stmt.setNull(4, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(4, TimeRecorded);  
            }
            
            if (Score == null){
                stmt.setNull(5, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(5, Score);  
            }
            
            if (PositionRecorded == null){
                stmt.setNull(6, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(6, PositionRecorded);  
            }
            
            stmt.execute();
            System.out.println("Competidor por Competición actualizado");
            JOptionPane.showMessageDialog(null, "Competidor por competición actualizada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void updateMedalType(Integer IDMedalTypeXCompetitorXCompetitionXParalympic, Integer IDMedalType, Integer IDCompetitor, Integer IDCompetition, Integer IDParalympic){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdateMedalTypeXCompetitorXCompetitionXParalympic(?, ?, ?, ?, ?)}");
      
            if (IDMedalTypeXCompetitorXCompetitionXParalympic == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDMedalTypeXCompetitorXCompetitionXParalympic);  
            }
            
            if (IDMedalType == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, IDMedalType);  
            }
            
            if (IDCompetitor == null){
                stmt.setNull(3, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(3, IDCompetitor);  
            }
            
            if (IDCompetition == null){
                stmt.setNull(4, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(4, IDCompetition);  
            }
            
            if (IDParalympic == null){
                stmt.setNull(5, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(5, IDParalympic);  
            }
            
            
            stmt.execute();
            System.out.println("Asignación de medalla actualizada");
            JOptionPane.showMessageDialog(null, "Asignación de medalla actualizada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void updateCompetition(Integer IDCompetition, String CompetitionName, LocalDate CompetitionDate, String CompetitionDescription){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdateCompetition(?, ?, ?, ?)}");
      
            if (IDCompetition == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDCompetition);  
            }
             
            if (CompetitionName.isEmpty()){
                stmt.setNull(2, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(2, CompetitionName); 
            }
            
            if (CompetitionDate == null){
                stmt.setNull(3, java.sql.Types.DATE);
            }else{
                Date sqlDate = Date.valueOf(CompetitionDate);
                stmt.setDate(3, sqlDate);
            }
            
            if (CompetitionDescription.isEmpty()){
                stmt.setNull(4, java.sql.Types.VARCHAR);
            }else{
              stmt.setString(4, CompetitionDescription); 
            }
            
            stmt.execute();
            System.out.println("Competición actualizada");
            JOptionPane.showMessageDialog(null, "La competición se ha actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void updateParalympicXCompetition(Integer IDParalympicXCompetition, Integer IDParalympic, Integer IDCompetition){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdateParalympicXCompetition(?, ?, ?)}");
      
            if (IDParalympicXCompetition == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDParalympicXCompetition);  
            }
            
            if (IDParalympic == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, IDParalympic);  
            }
            
            if (IDCompetition == null){
                stmt.setNull(3, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(3, IDCompetition);  
            }
            
            stmt.execute();
            System.out.println("Paraolímpico por competición actualizado");
            JOptionPane.showMessageDialog(null, "El paraolímpico por competición se ha actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void updateParalympic(Integer IDParalympic, Integer ParalympicYear, Integer IDCountry){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            stmt = connectionC.getConn().prepareCall("{CALL UpdateParalympic(?, ?, ?)}");
      
            if (IDParalympic == null){
                stmt.setNull(1, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(1, IDParalympic);  
            }
            
            if (ParalympicYear == null){
                stmt.setNull(2, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(2, ParalympicYear);  
            }
            
            if (IDCountry == null){
                stmt.setNull(3, java.sql.Types.INTEGER);
            }else{
              stmt.setInt(3, IDCountry);  
            }
            
            stmt.execute();
            System.out.println("Paraolímpico actualizado");
            JOptionPane.showMessageDialog(null, "El paraolímpico se ha actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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

    
    
}
