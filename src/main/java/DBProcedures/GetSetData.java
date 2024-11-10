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
    
    public ResultSet getCompetitors(ResultSet rs, Integer IDCountry, Integer ID_Paralympic){
        DataBaseConnection connectionC = new DataBaseConnection();
        try {
            
            stmt = connectionC.getConn().prepareCall("{CALL getCompetitors(?, ?)}");
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
}
